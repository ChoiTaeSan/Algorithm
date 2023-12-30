package countingSort;

public class Main {
    // 카운팅 정렬 수행 메소드
    static void countSort(int[] arr) {
        int n = arr.length;

        // 배열의 최대값 찾기
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 카운트 배열 생성 및 초기화
        int[] count = new int[max + 1];

        // 원소의 빈도수 세기
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // 정렬된 배열 생성
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    // 배열 출력 메소드
    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 메인 메소드
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countSort(arr);
        printArray(arr);
    }
}
