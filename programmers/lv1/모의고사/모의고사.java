import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {
    public static void main(String[] args) {
        int[] result1 = solution(new int[]{1,2,3,4,5});
        int[] result2 = solution(new int[]{1,3,2,4,2});

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }

    public static int[] solution(int[] answers) {
        int[] one = new int[]{1, 2, 3, 4, 5};
        int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i % one.length]) {
                scores[0] ++;
            }

            if(answers[i] == two[i % two.length]) {
                scores[1] ++;
            }

            if(answers[i] == three[i % three.length]) {
                scores[2] ++;
            }
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i <scores.length; i++) {
            if (scores[i] == maxScore) {
                result.add(i + 1);
            }
        };

        int[] resultArr = result.stream().mapToInt(Integer::intValue).toArray();
        return resultArr;
    }
}
