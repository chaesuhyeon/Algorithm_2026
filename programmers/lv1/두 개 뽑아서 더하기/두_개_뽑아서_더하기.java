import java.util.Arrays;
import java.util.HashSet;

public class 두_개_뽑아서_더하기 {
    public static void main(String[] args) {
        int[] result1 = solution(new int[]{2, 1, 3, 4, 1});
        int[] result2 = solution(new int[]{5, 0, 2, 7});

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }

    public static int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int num = numbers[i] + numbers[j];
                set.add(num);
            }
        }
        int[] answer = set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

