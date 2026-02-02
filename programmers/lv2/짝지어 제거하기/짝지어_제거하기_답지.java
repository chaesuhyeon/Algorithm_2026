import java.util.ArrayDeque;

public class 짝지어_제거하기_답지 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("baaabaaa"));
        System.out.println(solution("cdcd"));
    }

    public static int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;

    }
}
