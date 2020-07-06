import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int result = maxValidBracket(")()())");
        System.out.println("result=" + result);
    }


    public static boolean isLeft(char symbol) {
        return symbol == '(';
    }

    public static boolean isRight(char symbol) {
        return symbol == ')';
    }

    public static boolean isMatch(char c1, char c2) {
        return c1 == '(' && c2 == ')';
    }

    public static int maxValidBracket(String input) {
        char[] arr = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int p = 0;
        char temp;
        while (p < arr.length) {
            if (isLeft(arr[p])) {
                stack.push(arr[p]);
                p++;
            } else if (isRight(arr[p])) {
                if (stack.size() > 0) {
                    temp = stack.pop();
                    if (isMatch(temp, arr[p])) {
                        count++;
                        p++;
                    } else {
                        break;
                    }
                    break;
                }
            }
        }
        return count;
    }
}
