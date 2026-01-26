import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 실패율_코드개선 {
    public static void main(String[] args) {
        int[] result1 = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        int[] result2 = solution(4, new int[]{4,4,4,4,4});

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }

    public static int[] solution(int N, int[] stages) {
        // 스테이지별 도전자 수를 구함
        int[] challenger = new int[N+2];
        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1;
        }

        // 스테이지별 실패한 사용자 수 계산
        HashMap<Integer, Double> fails =new HashMap<>();
        double total = stages.length;

        // 각 스테이지를 순회하며, 실패율 계산
        for (int i = 1; i <= N; i++) {
            if(challenger[i] == 0) {
                fails.put(i, 0.); // 도전한 사람이 없는 경우, 실패율 0
            } else {
                fails.put(i, challenger[i] / total); // 실패율 구함
                total -= challenger[i]; // 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺌
            }
        }

        // 실패율이 높은 스테이지부터 내림 차순으로 정렬
        return fails.entrySet().stream()
                .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(Map.Entry::getKey).toArray();
    }
}
