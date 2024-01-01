package hashTable;

import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        // Hashtable 생성
        Hashtable<Integer, String> ht = new Hashtable<>();

        // 데이터 삽입
        ht.put(3, "Three");
        ht.put(1, "One");
        ht.put(4, "Four");
        ht.put(2, "Two");

        // 키를 리스트로 추출
        List<Integer> keys = new ArrayList<>();
        Enumeration<Integer> e = ht.keys();
        while (e.hasMoreElements()) {
            keys.add(e.nextElement());
        }

        // 키 리스트 정렬
        Collections.sort(keys);

        // 정렬된 키를 사용하여 값 출력
        for (Integer key : keys) {
            System.out.println(key + ": " + ht.get(key));
        }
    }
}
