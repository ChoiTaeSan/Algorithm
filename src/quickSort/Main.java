package quickSort;

public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5}; // 정렬할 배열
        int n = arr.length;

        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        printArray(arr);
    }

    // 배열을 퀵 정렬하는 메소드
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1); // 피벗보다 작은 부분
            quickSort(arr, pi + 1, high); // 피벗보다 큰 부분
        }
    }

    // 배열을 피벗을 기준으로 분할하는 메소드
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // 작은 요소의 인덱스

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // arr[i]와 arr[j] 교환
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // arr[i+1]과 arr[high] (피벗) 교환
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // 배열 출력 메소드
    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
