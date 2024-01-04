package TS;

import java.util.*;

public class Main {
    private int V; // 정점의 개수
    private ArrayList<ArrayList<Integer>> adj; // 인접 리스트

    Main(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    // 유향 간선 추가 메소드
    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // 위상 정렬 메소드
    void topologicalSort() {
        int[] inDegree = new int[V];
        Arrays.fill(inDegree, 0);

        // 모든 정점에 대한 진입 차수 계산
        for (int i = 0; i < V; i++) {
            for (int node : adj.get(i)) {
                inDegree[node]++;
            }
        }

        // 진입 차수가 0인 모든 정점을 큐에 추가
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 위상 정렬 수행
        int cnt = 0;
        Vector<Integer> result = new Vector<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);

            // 인접 정점들의 진입 차수 감소
            for (int node : adj.get(u)) {
                if (--inDegree[node] == 0)
                    queue.add(node);
            }
            cnt++;
        }

        // DAG가 아니면 순환 의존성이 있다는 것을 체크
        if (cnt != V) {
            System.out.println("Cycle found in the graph");
            return;
        }

        // 위상 정렬된 정점 출력
        for (int i : result)
            System.out.print(i + " ");
        System.out.println();
    }

    // 메인 메소드
    public static void main(String[] args) {
        Main g = new Main(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological sort of the given graph:");
        g.topologicalSort();
    }
}
