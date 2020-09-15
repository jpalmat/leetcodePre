package leetcode.array.BasicCalculatorII;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(calculate("42"));
    }

    /*
    calculator
    operation order
    *, /
    +, -

    Time complexity: O(n)
    Space Complexity: O(n)
     */
    public static int calculate(String s) {
        // if the input string is empty or null return 0
        if(s==null || s.length()==0) return 0;

        //define a stack to store the values
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<s.length();i++){
            //if character is digit, it gets converted to int
            if(Character.isDigit(s.charAt(i))){
                num = num* 10 + Integer.valueOf(String.valueOf(s.charAt(i)));
            }
            // validate if the character is an operational sign
            //the first character is digit, therefore the sign = +
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==s.length()-1){
                // if the operation is -, the number is inserted with opposite sign
                if(sign=='-'){
                    stack.push(-num);
                }
                // if the operation is +, the number is inserted with same sign
                if(sign=='+'){
                    stack.push(num);
                }
                //if the operation is *, extract the last character in the stack and multiply with the current number
                // and the result is inserted in the stack
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                //if the operation is /, extract the last character in the stack and divide with the current number
                // and the result is inserted in the stack
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int result = 0;
        //in the stack there will be only the numbers with the sign of the operation
        //loop the stack and sum the numbers
        for(int i = 0; i<stack.size(); i++){
            result += stack.get(i);
        }
        return result;
    }
}
