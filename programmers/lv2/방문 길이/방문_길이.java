import java.util.HashMap;
import java.util.HashSet;

/**
 * 못풀었어서 다시 풀어 봄
 */
public class 방문_길이 {

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
        System.out.println(solution("UDUDUD"));
    }


    public static int solution(String dirs) {

        HashMap<Character, int[]> location = new HashMap();
        location.put('U',  new int[]{0, 1});
        location.put('D',  new int[]{0, -1});
        location.put('L',   new int[]{-1, 0});
        location.put('R',  new int[]{1, 0});

        HashSet<String> answer = new HashSet<>();
        int x = 5, y = 5;

        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            int[] point = location.get(c);

            int nx = x + point[0];
            int ny = y + point[1];

            if((nx >= 0 && nx <= 10) && (ny >= 0 && ny <= 10)) {
                answer.add("" + x + y + " " + nx + ny);
                answer.add("" + nx + ny + " " + x + y);
                x = nx;
                y = ny;
            }
        }

        return answer.size()/2;
    }
}
