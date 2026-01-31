import java.util.HashMap;
import java.util.HashSet;

public class 방문_길이_답지 {

    public static void main(String[] args) {
//        System.out.println(solution("ULURRDLLU"));
//        System.out.println(solution("LULLLLLLU"));
        System.out.println(solution("UDUDUD"));
//        System.out.println(solution("UUUUUDDDDD")); 
    }

    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }

    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static void initLocation(){
        location.put('U',  new int[]{0, 1});
        location.put('D',  new int[]{0, -1});
        location.put('L',   new int[]{-1, 0});
        location.put('R',  new int[]{1, 0});
    }

    public static int solution(String dirs) {
        initLocation();
        int x = 5, y = 5; // 음수 좌표 없애기 위해 0,0에서 5,5로 변경
        HashSet<String> answer = new HashSet<>(); // 겹치는 좌표는 1개만 처리하기 위함

        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];
            if (!isValidMove(nx, ny)) { // 벗어난 좌표는 인정하지 않음
                continue;
            }
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);

            x = nx;
            y = ny;
        }

        return answer.size() / 2;
    }
}
