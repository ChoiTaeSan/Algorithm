package dijkstra;

import java.util.*;

public class Main {
    // 정점의 최대 개수
    private static final int V = 9;

    // 최소 거리를 가진 정점 찾기
    int minDistance(int[] dist, Boolean[] sptSet) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // 다익스트라 알고리즘
    void dijkstra(int[][] graph, int src) {
        int[] dist = new int[V]; // 최단 거리를 저장할 배열
        Boolean[] sptSet = new Boolean[V]; // 최단 경로 트리 집합

        // 모든 거리를 무한대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(sptSet, false);

        // 시작 정점의 거리는 0
        dist[src] = 0;

        // 모든 정점에 대해
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            // 인접한 모든 정점 업데이트
            for (int v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        // 결과 출력
        printSolution(dist);
    }

    // 결과 출력 메소드
    void printSolution(int[] dist) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    // 메인 메소드
    public static void main(String[] args) {
        // 그래프 예시
        int[][] graph = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Main t = new Main();
        t.dijkstra(graph, 0);
    }
}
