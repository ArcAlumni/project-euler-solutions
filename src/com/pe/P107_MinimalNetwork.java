package com.pe;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class P107_MinimalNetwork implements Solution {

    class Edge {

        String from;
        String to;
        int weight;

        Edge(String from, String to, int weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to + "=" + weight;
        }

    }

    class UnionFind {

        private Map<String, String> parentMap = new HashMap<>();
        private Map<String, Integer> sizeMap = new HashMap<>();

        UnionFind(List<String> nodes) {
            for (String node : nodes) {
                parentMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        boolean union(String n1, String n2) {
            String p1 = find(n1);
            String p2 = find(n2);
            if (p1.equals(p2)) {
                return false;
            }
            if (sizeMap.get(p1) > sizeMap.get(p2)) {
                parentMap.put(p2, p1);
                sizeMap.put(p1, sizeMap.get(p1) + sizeMap.get(p2));
            } else {
                parentMap.put(p1, p2);
                sizeMap.put(p2, sizeMap.get(p1) + sizeMap.get(p2));
            }
            return true;
        }

        String find(String node) {
            String parent = node;
            while (parent != parentMap.get(parent)) {
                parent = parentMap.get(parent);
            }
            String root = parent;
            parent = node;
            while (parent != parentMap.get(parent)) {
                String p = parentMap.get(parent);
                parentMap.put(parent, root);
                parent = p;
            }
            return root;
        }

    }

    @Override
    public String solve() throws IOException {
        List<List<Edge>> graph = new ArrayList<>();
        List<String> lines = Files.readAllLines(Util.getFile("p107_network.txt"));

        int node = 0;
        for (String line : lines) {
            List<Edge> edges = new ArrayList<>();
            int eNode = 0;
            for (String weight : line.split(",")) {
                if (!weight.equals("-")) {
                    Edge edge = new Edge(String.valueOf(node), String.valueOf(eNode), Integer.parseInt(weight));
                    edges.add(edge);
                }
                eNode++;
            }
            graph.add(edges);
            node++;
        }

        PriorityQueue<Edge> q = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        for (List<Edge> edges : graph) {
            q.addAll(edges);
        }

        UnionFind unionFind = new UnionFind(
                graph.stream().flatMap(e -> e.stream().map(x -> x.from)).distinct().collect(Collectors.toList()));
        int cost = 0, totalCost = 0;

        while (!q.isEmpty()) {
            Edge minEdge = q.poll();
            totalCost += minEdge.weight;
            if (unionFind.union(minEdge.from, minEdge.to))
                cost += minEdge.weight;
        }

        return String.valueOf((totalCost / 2) - cost);
    }

}
