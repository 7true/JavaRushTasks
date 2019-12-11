package com.javarush.task.testCode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class B {
    static List<Integer>[] graph = readGraph();
    static boolean[] used = new boolean[graph.length];

    public static void main(String[] args) throws Exception {
        dfs(4);
    }


    public static void dfs(int pos) {
        used[pos] = true;
        System.out.println(pos);
        for (int next : graph[pos]){
            if (!used[next]){
                dfs(next);
            }
        }
    }

    static void bfs(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[graph.length];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = graph[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    private static List<Integer>[] readGraph() {
        List<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList<?>[6];
        graph[0] = new ArrayList<>();
        graph[1] = new ArrayList<>();
        graph[2] = new ArrayList<>();
        graph[3] = new ArrayList<>();
        graph[4] = new ArrayList<>();
        graph[5] = new ArrayList<>();
        graph[0].add(1);
        graph[0].add(3);
        graph[1].add(0);
        graph[1].add(3);
        graph[1].add(4);
        graph[1].add(5);
        graph[2].add(4);
        graph[2].add(5);
        graph[3].add(0);
        graph[3].add(1);
        graph[3].add(5);
        graph[4].add(1);
        graph[4].add(2);
        graph[5].add(1);
        graph[5].add(2);
        graph[5].add(3);
        for (int i = 0; i < graph.length; i++) {
            System.out.println(graph[i]);
        }
        return graph;
    }
}