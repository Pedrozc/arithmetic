package Stack;

public class leetcodeSolution {

    public boolean isValid(String s){
        char[] chars = s.toCharArray();
        //也可以用java.util.Stack来使用
        ArrayStack<Character> stack = new ArrayStack<Character>();

        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(c =='(' || c== '[' || c == '{'){
                stack.push(c);
            }else {
                char topchar = stack.pop();
                if(c == ')' && topchar != '('){
                    return false;
                }
                if(c == '}' && topchar != '{'){
                    return false;
                }
                if(c == ']' && topchar != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((new leetcodeSolution()).isValid("()[]{}"));
        System.out.println((new leetcodeSolution()).isValid("([)]"));
        System.out.println((new leetcodeSolution()).isValid("(([{}])"));

    }
}
