import java.util.Stack;

public class 올바른_괄호 {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }

    public static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '('){
                stack.push(c);
            } else {
                if(stack.isEmpty() && c ==')') {
                    return false;
                } else if(!stack.isEmpty() && c == ')') {
                    stack.pop();
                }
            }
        }


        if(!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}
