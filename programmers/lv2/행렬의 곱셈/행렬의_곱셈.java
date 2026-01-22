import java.util.ArrayList;
import java.util.Arrays;

public class 행렬의_곱셈 {

    public static void main(String[] args) {
        int[][] result1 = solution(new int[][]{{1,4},{3,2},{4,1}}, new int[][]{{3,3},{3,3}});
        int[][] result2 = solution(new int[][]{{2,3,2},{4,2,4},{3,1,4}}, new int[][]{{5,4,3},{2,4,1},{3,1,1}});
        int[][] result3 = solution(new int[][]{{1,2,3},{4,5,6}}, new int[][]{{7,8},{9,10},{11,12}}); // 테스트 케이스 추가

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr2.length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
