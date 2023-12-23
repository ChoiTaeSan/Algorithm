package selectionSort;

public class Main {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11}; // 정렬할 배열
        selectionSort(arr);
        System.out.println("Sorted array: ");
        printArray(arr);
    }

    // 배열을 선택 정렬하는 메소드
    static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // 가장 작은 요소와 현재 위치의 요소 교환
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // 배열 출력 메소드
    static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}
