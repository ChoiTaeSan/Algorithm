package DFS;

import java.util.*;

public class Main {
    // 그래프를 표현하기 위한 인접 리스트
    private LinkedList<Integer>[] adj;

    // 생성자
    @SuppressWarnings("unchecked")
    Main(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // 간선 추가 메소드
    void addEdge(int v, int w) {
        adj[v].add(w); // 노드 v에서 w로 가는 경로 추가
    }

    // DFS 실행 메소드
    void DFS(int v) {
        // 노드 방문 여부를 기록하기 위한 boolean 배열
        boolean[] visited = new boolean[adj.length];
        // DFS 재귀 함수 호출
        DFSUtil(v, visited);
    }

    // DFS 재귀 함수
    void DFSUtil(int v, boolean[] visited) {
        // 현재 노드를 방문 처리
        visited[v] = true;
        System.out.print(v + " ");

        // 현재 노드와 인접한 모든 노드에 대해
        for (int n : adj[v]) {
            if (!visited[n]) // 아직 방문하지 않았다면
                DFSUtil(n, visited); // 재귀적으로 DFS 실행
        }
    }

    // 메인 메소드
    public static void main(String[] args) {
        Main g = new Main(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("DFS (starting from vertex 2):");
        g.DFS(2);
    }
}
