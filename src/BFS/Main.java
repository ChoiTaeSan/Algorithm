package BFS;

import java.util.*;

public class Main {
    private LinkedList<Integer>[] adj; // 그래프의 인접 리스트

    // 생성자
    @SuppressWarnings("unchecked")
    Main(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // 간선 추가 메소드
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS 실행 메소드
    void BFS(int s) {
        // 모든 노드의 방문 여부를 추적하는 배열
        boolean[] visited = new boolean[adj.length];

        // BFS 구현을 위한 큐
        LinkedList<Integer> queue = new LinkedList<>();

        // 시작 노드 방문 처리 및 큐에 추가
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // 큐에서 하나의 원소를 꺼내 방문
            s = queue.poll();
            System.out.print(s + " ");

            // 모든 인접한 노드들을 검사하고 방문하지 않은 노드를 큐에 추가
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
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

        System.out.println("BFS (starting from vertex 2):");
        g.BFS(2);
    }
}
