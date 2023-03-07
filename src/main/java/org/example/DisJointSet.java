package org.example;

public class DisJointSet {
    private final int[] parent;
    private final int[] rank;

    public DisJointSet(int size){
        this.parent = new int[size];
        this.rank = new int[size];

        for (int i = 0; i < size; i++){
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    public int find(int x){
        if(x != this.parent[x]){
            return find(parent[x]);
        }
        return parent[x];
    }

    public void print(){
        for(int i = 0; i < parent.length; i++){
            System.out.println(parent[i]);
        }
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY) {
        }
        else{
            if(this.rank[rootX] > this.rank[rootY]){
                this.parent[rootY] = rootX;
            }else{
                this.parent[rootX] = rootY;
                if(this.rank[rootX] == this.rank[rootY]) ++this.rank[rootY];
            }
        }
    }

    public static void main(String args[]){
        DisJointSet disJointSet = new DisJointSet(10);
        disJointSet.union(1, 4);
        disJointSet.union(1, 6);
        System.out.println(disJointSet.find(1));
        System.out.println(disJointSet.find(4));
        System.out.println(disJointSet.find(6));
    }
}
