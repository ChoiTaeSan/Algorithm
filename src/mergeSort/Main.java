package mergeSort;

public class Main {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7}; // 정렬할 배열
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array:");
        printArray(arr);
    }

    // 주어진 범위 내에서 배열을 병합 정렬하는 메소드
    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            // 중간 지점 찾기
            int m = (l + r) / 2;

            // 두 부분으로 나누어 각각 정렬
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // 병합
            merge(arr, l, m, r);
        }
    }

    // 두 부분 배열을 병합하는 메소드
    static void merge(int[] arr, int l, int m, int r) {
        // 부분 배열의 크기 계산
        int n1 = m - l + 1;
        int n2 = r - m;

        // 임시 배열 생성
        int[] L = new int[n1];
        int[] R = new int[n2];

        // 데이터 복사
        System.arraycopy(arr, l, L, 0, n1);
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // 병합
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // 나머지 요소들을 복사
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // 배열 출력 메소드
    static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }
}
