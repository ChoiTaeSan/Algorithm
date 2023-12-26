package heapSort;
public class Main {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7}; // 정렬할 배열
        heapSort(arr);
        System.out.println("Sorted array is ");
        printArray(arr);
    }

    // 힙 정렬을 수행하는 메소드
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 배열을 최대 힙으로 구성
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // 하나씩 요소를 추출하여 정렬
        for (int i = n - 1; i > 0; i--) {
            // 현재 루트와 끝 요소 교환
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 다시 최대 힙 구성
            heapify(arr, i, 0);
        }
    }

    // 힙을 구성하는 메소드
    static void heapify(int[] arr, int n, int i) {
        int largest = i; // 가장 큰 요소는 루트로 초기화
        int l = 2 * i + 1; // 왼쪽 자식
        int r = 2 * i + 2; // 오른쪽 자식

        // 왼쪽 자식이 더 큰 경우
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // 오른쪽 자식이 더 큰 경우
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // largest가 루트가 아닌 경우, 교환하고 하위 트리에 대해 힙 구성
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    // 배열 출력 메소드
    static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }
}
