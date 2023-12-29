package radixSort;

public class Main {
    // 메인 메소드
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;

        // 기수 정렬 수행
        radixSort(arr, n);
        print(arr, n);
    }
    // 배열의 최대값 찾기
    static int getMax(int[] arr, int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // exp 자릿수에 따라 정렬 (exp는 1, 10, 100, ...)
    static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; // 출력 배열
        int[] count = new int[10];
        java.util.Arrays.fill(count, 0);

        // exp 자릿수의 개수를 센다
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // 누적 카운트를 계산한다
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // 누적 카운트를 사용하여 정렬된 배열을 생성한다
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // 정렬된 배열을 원래 배열에 복사한다
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // 기수 정렬 메소드
    static void radixSort(int[] arr, int n) {
        // 최대값을 찾아 최대 자릿수를 구한다
        int m = getMax(arr, n);

        // 모든 자릿수에 대해 정렬을 수행한다
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    // 배열 출력 메소드
    static void print(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
