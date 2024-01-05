package prim;

import java.util.*;
import java.lang.*;

class Main {
    // 정점의 개수
    private static final int V = 5;

    // 그래프에서 최소 가중치 간선 찾기
    int minKey(int[] key, Boolean[] mstSet) {
        // 초기 최소값 설정
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // 프림 알고리즘 구현
    void primMST(int[][] graph) {
        // 신장 트리에 포함된 정점 저장
        int[] parent = new int[V];

        // 최소 가중치 저장
        int[] key = new int[V];

        // 신장 트리 집합
        Boolean[] mstSet = new Boolean[V];

        // 모든 키 값을 무한대로 초기화
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // 첫 번째 정점을 시작점으로 선택
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);

            // 선택된 정점을 신장 트리 집합에 추가
            mstSet[u] = true;

            for (int v = 0; v < V; v++)

                // graph[u][v]가 0보다 크면 간선이 존재
                // mstSet[v]가 false면 정점이 아직 처리되지 않음
                // key[v]가 graph[u][v]보다 크면 갱신
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        // 결과 출력
        printMST(parent, graph);
    }

    // 신장 트리 출력
    void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    public static void main(String[] args) {
        /* 예시 그래프 */
        Main t = new Main();
        int[][] graph = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        // 프림 알고리즘 실행
        t.primMST(graph);
    }
}
