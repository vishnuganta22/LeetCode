package org.example;

import java.util.*;

public class Maze {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n, m;
        System.out.println("Please enter n value : ");
        n = scanner.nextInt();
        System.out.println("Please enter m value : ");
        m = scanner.nextInt();
        scanner.close();

        Cell[][] maze = initMaze(n, m);
        generateMaze(maze, n, m);
        printMaze(maze, n, m);
        ArrayList<Integer> dfs = dfsForMaze(maze, n, m);
        System.out.println(dfs);
        ArrayList<String> path = getPath(dfs, m);
        System.out.println(path);
        HashMap<Integer, String> map = mergeDFSAndPath(dfs, path);
        mapPathToMaze(maze, map, n, m);
        printMazeWithPath(maze, n, m);
    }

    private static void generateMaze(Cell[][] maze, int n, int m) {
        int totalCells = n * m;
        DisjSets set = new DisjSets(totalCells);
        Random random = new Random();
        int end = (n * m) - 1;
        do {
            int row = random.nextInt(n); // 4
            int col = random.nextInt(m); // 3

            Cell currentCell = maze[row][col];

            int randomX = currentCell.getIndex();
            int randomY;

            if (randomX == end) continue;

            Cell cellToBreakTheWall;
            boolean isRightWall = false;
            if (row == n - 1) {
                cellToBreakTheWall = currentCell;
                isRightWall = true;
                randomY = randomX + 1;
            } else if (col == m - 1) {
                cellToBreakTheWall = currentCell;
                randomY = randomX + m;
            } else {
                ArrayList<Integer> neighbours = getNeighbours(randomX, n, m);
                Collections.shuffle(neighbours);
                int neighbourPosition = neighbours.get(neighbours.size() - 1);
                // 0 -> left, 1 -> right, 2 -> top, 3 -> bottom
                switch (neighbourPosition) {
                    case 0 -> {
                        randomY = randomX - 1;
                        cellToBreakTheWall = maze[row][col - 1];
                        isRightWall = true;
                    }
                    case 1 -> {
                        randomY = randomX + 1;
                        cellToBreakTheWall = currentCell;
                        isRightWall = true;
                    }
                    case 2 -> {
                        randomY = randomX - m;
                        cellToBreakTheWall = maze[row - 1][col];
                    }
                    default -> {
                        randomY = randomX + m;
                        cellToBreakTheWall = currentCell;
                    }
                }

            }

            if (set.find(randomX) != set.find(randomY)) {
                set.union(set.find(randomX), set.find(randomY));
                if (isRightWall) {
                    cellToBreakTheWall.rWall = false;
                } else {
                    cellToBreakTheWall.bWall = false;
                }
            }
        } while (set.find(0) != set.find(totalCells - 1));
    }

    private static ArrayList<Integer> getNeighbours(int index, int n, int m) {
        int row = (index / m); // 4
        int col = (index % m); // 3

        ArrayList<Integer> neighbours = new ArrayList<>();
        // 0 -> left, 1 -> right, 2 -> top, 3 -> bottom
        if (row == 0) {
            if (col != m - 1) neighbours.add(1);
            if (row != n - 1) neighbours.add(3);
            if (col != 0) neighbours.add(0);
        } else if (col == 0) {
            if (col != m - 1) neighbours.add(1);
            if (row != n - 1) neighbours.add(3);
            neighbours.add(2);
        } else if (row == n - 1) {
            if (col != m - 1) neighbours.add(1);
            neighbours.add(2);
            neighbours.add(0);
        } else if (col == m - 1) {
            neighbours.add(3);
            neighbours.add(2);
            neighbours.add(0);
        } else {
            neighbours.add(1);
            neighbours.add(3);
            neighbours.add(2);
            neighbours.add(0);
        }
        return neighbours;
    }

    private static void printMaze(Cell[][] maze, int n, int m) {
        maze[n - 1][m - 1].rWall = false;
        for (int j = 0; j < m; j++) {
            System.out.print(" __");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.print(" ");
            } else {
                System.out.print("|");
            }

            for (int j = 0; j < m; j++) {

                if (maze[i][j].bWall) {
                    System.out.print("__");
                } else {
                    System.out.print("  ");
                }

                if (maze[i][j].rWall) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static Cell[][] initMaze(int rows, int cols) {
        Cell[][] maze = new Cell[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = new Cell(count);
                count++;
            }
        }
        return maze;
    }

    private static ArrayList<Integer> dfsForMaze(Cell[][] maze, int n, int m) {
        HashMap<Integer, Integer> reversePath = new HashMap<>();
        Stack<Cell> cellStack = new Stack<>();
        ArrayList<Integer> exploredList = new ArrayList<>();
        cellStack.push(maze[0][0]);
        exploredList.add(maze[0][0].getIndex());
        while (cellStack.size() > 0) {
            Cell currentCell = cellStack.pop();
            if (currentCell.getIndex() == ((n * m) - 1)) break;
            ArrayList<Integer> neighbours = getNeighbours(currentCell.getIndex(), n, m);
            Collections.reverse(neighbours);
            for (int neighbourPosition : neighbours) {
                int neighbourIndex;
                switch (neighbourPosition) {
                    case 0 -> neighbourIndex = currentCell.getIndex() - 1;
                    case 1 -> neighbourIndex = currentCell.getIndex() + 1;
                    case 2 -> neighbourIndex = currentCell.getIndex() - m;
                    default -> neighbourIndex = currentCell.getIndex() + m;
                }
                Cell neighbourCell = maze[neighbourIndex / m][neighbourIndex % m];
                if (canMove(currentCell, neighbourCell, neighbourPosition) && !exploredList.contains(neighbourIndex)) {
                    cellStack.push(neighbourCell);
                    exploredList.add(neighbourIndex);
                    reversePath.put(neighbourIndex, currentCell.getIndex());
                }
            }
        }
        HashMap<Integer, Integer> forwardPath = new HashMap<>();
        int cell = n * m - 1;
        while (cell != 0) {
            forwardPath.put(reversePath.get(cell), cell);
            cell = reversePath.get(cell);
        }

        int c = 0;
        ArrayList<Integer> dfs = new ArrayList<>();
        dfs.add(0);
        while (c != ((n * m) - 1)) {
            dfs.add(forwardPath.get(c));
            c = forwardPath.get(c);
        }
        return dfs;
    }

    private static ArrayList<String> getPath(ArrayList<Integer> dfs, int m) {
        ArrayList<String> path = new ArrayList<>();
        for (int i = 0; i < dfs.size(); i++) {
            if (i == dfs.size() - 1) {
                path.add("E");
            } else {
                int current = dfs.get(i);
                int next = dfs.get(i + 1);
                int diff = current - next;
                if (diff == -1) {
                    path.add("E");
                } else if (diff == 1) {
                    path.add("W");
                } else if (diff == m) {
                    path.add("N");
                } else {
                    path.add("S");
                }
            }
        }
        return path;
    }

    private static boolean canMove(Cell from, Cell to, int neighbourPosition) {
        // 0 -> left, 1 -> right, 2 -> top, 3 -> bottom
        return switch (neighbourPosition) {
            case 0 -> !to.rWall;
            case 1 -> !from.rWall;
            case 2 -> !to.bWall;
            default -> !from.bWall;
        };
    }

    private static HashMap<Integer, String> mergeDFSAndPath(ArrayList<Integer> dfs, ArrayList<String> path) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < dfs.size(); i++) {
            map.put(dfs.get(i), path.get(i));
        }
        return map;
    }

    private static void mapPathToMaze(Cell[][] maze, HashMap<Integer, String> map, int n, int m) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map.containsKey(count)) {
                    maze[i][j].direction = map.get(count);
                }
                count++;
            }
        }
    }

    private static void printMazeWithPath(Cell[][] maze, int n, int m) {
        maze[n - 1][m - 1].rWall = false;
        for (int j = 0; j < m; j++) {
            System.out.print(" __");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.print(" ");
            } else {
                System.out.print("|");
            }

            for (int j = 0; j < m; j++) {
                if (maze[i][j].bWall) {
                    if (maze[i][j].direction != null) {
                        System.out.print("\033[43m__");
                        System.out.print("\033[0m");
                    } else {
                        System.out.print("__");
                    }
                } else {
                    if (maze[i][j].direction != null) {
                        System.out.print("\033[43m  ");
                        System.out.print("\033[0m");
                    } else {
                        System.out.print("  ");
                    }
                }

                if (maze[i][j].rWall) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
