package greedy;

public class Main {
    static void minCoins(int[] coins, int m, int V) {
        // 결과를 저장할 배열
        int[] result = new int[m];

        // 각 동전을 큰 것부터 확인
        for (int i = 0; i < m; i++) {
            // 해당 동전으로 거슬러 줄 수 있는 만큼 거슬러 줌
            while (V >= coins[i]) {
                V -= coins[i];
                result[i]++;
            }
        }

        // 결과 출력
        for (int i = 0; i < m; i++) {
            if (result[i] != 0) {
                System.out.println(coins[i] + "원: " + result[i] + "개");
            }
        }
    }

    public static void main(String[] args) {
        int[] coins = {500, 100, 50, 10}; // 동전의 종류
        int m = coins.length;
        int V = 860; // 거슬러 줘야 하는 금액

        minCoins(coins, m, V);
    }
}
