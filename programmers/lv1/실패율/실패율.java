import java.util.*;
import java.util.stream.Collectors;

public class 실패율 {
    public static void main(String[] args) {
        int[] result1 = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        int[] result2 = solution(4, new int[]{4,4,4,4,4});

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }

    public static int[] solution(int N, int[] stages) {
        int[] person = new int[N+1];
        int total = stages.length;
        HashMap<Integer, Double> map =new HashMap<>();

        for (int stage : stages) {
            if (stage != N+1) {
                person[stage] ++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (total == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double) person[i] / total);
                total -= person[i];
            }
        }

        List<Map.Entry<Integer, Double>> sorted =
                map.entrySet().stream()
                        .sorted((e1, e2) -> {
                            int cmp = Double.compare(e2.getValue(), e1.getValue());
                            if (cmp != 0) return cmp;
                            return Integer.compare(e1.getKey(), e2.getKey());
                        }).collect(Collectors.toList());

        int[] answer = sorted.stream()
                .mapToInt(Map.Entry::getKey)
                .toArray();



        return answer;
    }
}
