import java.util.Stack;

public class 괄호_회전하기 {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }
    public static int solution(String s) {
        int answer = 0;
        String newS = s;
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            boolean success = true;
            newS = newS.substring(1) + newS.charAt(0);
            for (int j = 0; j < s.length(); j++) {
                char c = newS.charAt(j);
                if(c == '[' || c == '{' || c== '(') {
                    stack.push(c);
                } else {
                    if(stack.isEmpty()) {
                        success = false;
                    } else {
                        char p = stack.pop();
                        if(c ==')' && p != '(') {
                            stack.push(p);
                        }
                        if(c =='}' && p != '{') {
                            stack.push(p);
                        }
                        if(c ==']' && p != '[') {
                            stack.push(p);
                        }
                    }
                }
            }

            if(stack.isEmpty() && success) {
                answer ++;
            }
        }
        return answer;
    }
}
