package com.company.Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private static LinkedList<Integer> nextToVisit = new LinkedList<>();
    private static int[] visited = new int[10];
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(7);
        for(int i = 0; i < 7; i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 2, 6);
        dfs(1,adj);

    }

    private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for(int i = 0; i < 5; i++){
            System.out.println("vertex : "+ i);
            System.out.print("connected nodes : ");
            for(int k = 0; k < adj.get(i).size(); k++){
                System.out.print(adj.get(i).get(k)+", ");
            }
            System.out.println();
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    private static void bfs(int node,ArrayList<ArrayList<Integer>> graph){
        visited[node] = 1;
        nextToVisit.addFirst(node);
        while(!nextToVisit.isEmpty()){
            int current = nextToVisit.getFirst();
            visited[current] = 1;
            nextToVisit.removeFirst();
            System.out.println(current);
            for(int i =0; i < graph.get(current).size(); i++){
               if(visited[graph.get(current).get(i)] != 1){
                   visited[graph.get(current).get(i)] = 1;
                   nextToVisit.addLast(graph.get(current).get(i));
               }
            }
        }
    }
    private static void dfs(int node,ArrayList<ArrayList<Integer>> adj){
        visited[node] = 1;
        System.out.println(node);
        for(int i = 0; i < adj.get(node).size();i++){
            if(visited[adj.get(node).get(i)] != 1){
                visited[adj.get(node).get(i)] = 1;
                dfs(adj.get(node).get(i),adj);
            }
        }
    }
}
