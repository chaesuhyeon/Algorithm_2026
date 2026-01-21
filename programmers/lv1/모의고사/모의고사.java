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

        int oneResult = 0;
        int twoResult = 0;
        int threeResult = 0;

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i % one.length]) {
                oneResult ++;
            }

            if(answers[i] == two[i % two.length]) {
                twoResult ++;
            }

            if(answers[i] == three[i % three.length]) {
                threeResult ++;
            }
        }

        int max = Math.max(oneResult, Math.max(twoResult, threeResult));

        ArrayList<Integer> result = new ArrayList<>();

        if (oneResult == max) {
            result.add(1);
        }

        if (twoResult == max) {
            result.add(2);
        }

        if (threeResult == max){
            result.add(3);
        }

        int[] resultArr = result.stream().mapToInt(Integer::intValue).sorted().toArray();
        return resultArr;
    }
}
