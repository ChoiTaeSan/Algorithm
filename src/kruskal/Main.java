package kruskal;

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    // Comparator 함수
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Subset {
    int parent, rank;
}

public class Main {
    int V, E; // 정점과 간선의 개수
    Edge[] edge; // 간선의 집합

    Main(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    // 부모 노드 찾기 함수
    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    // 두 집합 합치기 함수
    void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // 크루스칼 알고리즘 메인 함수
    void KruskalMST() {
        Edge[] result = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        // 간선을 가중치 순으로 정렬
        Arrays.sort(edge);

        Subset[] subsets = new Subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new Subset();

        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0; // 정렬된 간선 집합을 인덱싱하기 위한 변수

        while (e < V - 1) {
            Edge next_edge = new Edge();
            next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // 사이클이 발생하지 않으면 결과 집합에 추가
            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }

        // 결과 출력
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
    }

    // 메인 메소드
    public static void main(String[] args) {
        int V = 4; // 정점 개수
        int E = 5; // 간선 개수
        Main graph = new Main(V, E);

        // 간선 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // 간선 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // 간선 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // 간선 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // 간선 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.KruskalMST();
    }
}
