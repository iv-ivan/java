
package calculator;

import java.util.LinkedList;

public class Convert {
    public static String toPostfix(String input_string) {
        String output_string = "";
        LinkedList<Character> stack_operators = new LinkedList<>();
        int i = 0;
        while(i < input_string.length()) {
            //System.out.println(1);
            //System.out.println(input_string.length());
            char token = input_string.charAt(i);
            //System.out.println(token);
            if((token >= '0' && token <='9') || (token >= 'A' && token <= 'G') || token == ' ') {
              output_string = output_string + token;
              ++i;
              //System.out.println(i);
              continue;
            }
            if(stack_operators.isEmpty()) {
                   stack_operators.push(token);
                   ++i;
                   continue;
            }
            if(token == '(') {
                stack_operators.push(token);
                ++i;
                continue;
            }
            if(token == ')') {
                while(stack_operators.getFirst() != '(') {
                    output_string = output_string + stack_operators.getFirst();
                    stack_operators.pop();
                }
                stack_operators.pop();
                ++i;
                continue;
            }
           //System.out.println(token);
            while((stack_operators.isEmpty() != true) && (priority(stack_operators.getFirst()) >= priority(token))) {
                output_string = output_string + stack_operators.getFirst();
                //System.out.println(output_string);
                stack_operators.pop();
            }
            //System.out.println(token);
            stack_operators.push(token);
            ++i;
        }
        while(stack_operators.isEmpty() == false) {
            output_string = output_string + stack_operators.pop();
        }
        //System.out.println(2);
        return output_string;
    }
    public static int priority(char operator) {
        switch(operator) {
            case '(': return 0;
            case ')': return 1;
            case '+': return 2;
            case '-': return 2;
            case '*': return 3;
            case '/': return 3;
        }
        return 0;
    }
}
