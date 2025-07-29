package Level1;
import java.util.*;

public class Level1_4 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 각 필드의 인덱스 정의
        Map<String, Integer> fieldIndex = new HashMap<>();
        fieldIndex.put("code", 0);
        fieldIndex.put("date", 1);
        fieldIndex.put("maximum", 2);
        fieldIndex.put("remain", 3);

        int extIdx = fieldIndex.get(ext);
        int sortIdx = fieldIndex.get(sort_by);

        List<int[]> filtered = new ArrayList<>();

        // 조건에 맞는 데이터만 뽑기
        for (int[] row : data) {
            if (row[extIdx] < val_ext) {
                filtered.add(row);
            }
        }

        // 정렬
        filtered.sort(Comparator.comparingInt(a -> a[sortIdx]));

        // List -> int[][] 로 변환
        int[][] answer = new int[filtered.size()][];
        for (int i = 0; i < filtered.size(); i++) {
            answer[i] = filtered.get(i);
        }

        return answer;
    }
}
