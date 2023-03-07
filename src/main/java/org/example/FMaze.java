package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The class takes as input number of rows and columns and generates a random maze of the same rows and columns
 * @author Colton Parham
 *
 */
public class FMaze {

    /**
     * Initializes the maze with all the nodes disconnected, resulting in all the sets being disjoint from one another
     * @param rows total rows
     * @param cols total columns
     * @param maze maze to be initialized
     * @return initialized maze
     */
    private List<List<Node>> initializeMaze(int rows, int cols, List<List<Node>> maze) {

        int count = 0;
        for(int i=0; i<rows; i++) {
            List<Node> row = new ArrayList<>();
            for(int j=0; j<cols; j++) {
                row.add(new Node(count++, true, true)); //Stores current index as value of the node
            }
            maze.add(row);
        }

        return maze;
    }

    /**
     * Prints the maze
     * @param rows total rows
     * @param cols total columns
     * @param maze maze to be printed
     */
    private void printMaze(int rows, int cols, List<List<Node>> maze) {

        System.out.print("   "); //Leave the top left corner open
        for(int j=1; j<cols; j++) {
            System.out.print(" __"); //Print the topmost line
        }

        System.out.println();

        for(int i=0; i<rows; i++) {

            if(i == 0) {
                System.out.print(" "); //Leave the top left corner open
            } else {
                System.out.print("|"); //Print the leftmost line
            }

            for(int j=0; j<cols; j++) {

                if(maze.get(i).get(j).horizontal) {
                    System.out.print("__"); //Horizontal maze wall not broken
                } else {
                    System.out.print("  "); //Horizontal maze wall broken
                }

                if(maze.get(i).get(j).vertical) {
                    System.out.print("|"); //Vertical maze wall not broken
                } else {
                    System.out.print(" "); //Vertical maze wall broken
                }
            }

            System.out.println();
        }

    }

    /**
     * Creates the maze using disjoint set
     * @param rows total rows
     * @param cols total columns
     */
    public void createMaze(int rows, int cols) {

        int total = rows*cols;
        DisjSets ds = new DisjSets(total); //Create an object of the disjoint set class

        List<List<Node>> maze = new ArrayList<List<Node>>();

        maze = initializeMaze(rows, cols, maze); //Initialize the maze

        Random rand = new Random();

        while(ds.find(0) != ds.find(total - 1)) {

            int currRow = rand.nextInt(rows); //Random row number
            int currCol = rand.nextInt(cols); //Random column number
            Node currNode = maze.get(currRow).get(currCol); //Current node(cell)
            int currValue = currNode.value;

            int root1 = ds.find(currValue); //Find on current node(cell)
            int root2;
            boolean removeHorizontal = false;

            if(currValue == total - 1) {
                continue; //Don't do anything if the current cell is the bottom-rightmost cell
            }

            if(currRow == rows - 1) {
                //Last row -- can only break the right wall, can't break the wall to the bottom
                root2 = ds.find(currValue + 1);
            } else if(currCol == cols - 1) {
                //Last column -- can only break the wall to the bottom, can't break the right wall
                root2 = ds.find(currValue + cols);
                removeHorizontal = true;
            } else {
                //Neither last row nor last column
                //Randomly select either right wall or wall to the bottom to break
                boolean selectRight;
                selectRight = rand.nextBoolean();

                if(selectRight) {
                    root2 = ds.find(currValue + 1);
                } else {
                    root2 = ds.find(currValue + cols);
                    removeHorizontal = true;
                }
            }

            //Finds resulted in different sets
            if(root1 != root2) {

                ds.union(root1, root2); //Take union of the two sets

                if(removeHorizontal) {
                    currNode.horizontal = false; //Break the horizontal wall
                } else {
                    currNode.vertical = false; //Break the vertical wall
                }
            }
        }

        //Leave the bottom right corner open
        Node destination = maze.get(rows - 1).get(cols - 1);
        destination.horizontal = false;
        destination.vertical = false;

        printMaze(rows, cols, maze); //Print the final maze
    }

    /**
     * Private class to store a particular node (cell) of the maze
     * @author Anshul Pardhi
     *
     */
    private class Node {
        int value;
        boolean horizontal;
        boolean vertical;

        Node(int value, boolean horizontal, boolean vertical) {
            this.value = value;
            this.horizontal = horizontal;
            this.vertical = vertical;
        }
    }

    // main to generate the random mazes..
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter total rows of the maze: ");
        int rows = sc.nextInt();

        System.out.println("Enter total columns of the maze: ");
        int cols = sc.nextInt();

        // maze generation part one..
        System.out.println("Initial Randomly generated Maze: ");
        FMaze m = new FMaze();
        m.createMaze(rows, cols);

        sc.close();
    }

}