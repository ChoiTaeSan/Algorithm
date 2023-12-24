package insertionSort;

public class Main {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6}; // 정렬할 배열
        insertionSort(arr);
        printArray(arr);
    }

    // 배열을 삽입 정렬하는 메소드
    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // key보다 큰 요소들을 한 칸씩 뒤로 이동
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // 배열 출력 메소드
    static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");

        System.out.println();
    }
}
