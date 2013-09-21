package calculator;
import java.util.Scanner;

import java.util.LinkedList;

public class Calculator {
    public static int calculate(String convert_string) {
        int result = 0;
        LinkedList<Integer> numbers = new LinkedList<>();
        int i = 0;
        while(i < convert_string.length()) {
            char token = convert_string.charAt(i);
            //System.out.println(token);
            if((token >= '0' && token <='9') || (token >= 'A' && token <= 'G')) {
                int temp = getNumber(convert_string,i);
                //System.out.println(numbers.getFirst());
                numbers.push(temp);
                //System.out.println(numbers.getFirst());
                //System.out.println(numbers.getLast());
                ++i;
                continue;
            }
            if(token == '+') {
                //System.out.println(result);
                //System.out.println(numbers.getLast());
                int temp = numbers.pop()+ numbers.pop();
                //System.out.println(temp);
                //System.out.println(temp);
                //numbers.pop();
                numbers.push(temp);
                //System.out.println(numbers.getLast());
                ++i;
                continue;
            }
            if(token == '/') {
                int temp = numbers.pop() / numbers.pop();
                numbers.push(temp);
                ++i;
                continue;
            }
            if(token == '-') {
                int temp = numbers.pop() - numbers.pop();
                numbers.push(temp);
                ++i;
                continue;
            }
            if(token == '*') {
                int temp = numbers.pop() * numbers.pop();
                //System.out.println(temp);
                numbers.push(temp);
                ++i;
                continue;
            }
            if(token == ' ') {
                //System.out.println("-");
                ++i;
            }
        }
        return numbers.getLast();
    }
    public static void main(String[] args) {
        String input_string;
        Scanner in;
        in = new Scanner(System.in);
        input_string = in.nextLine();
        while(!(input_string.equals("end"))) {
            //System.out.println(input_string);
            String convert_string;
            int result;
            convert_string = Convert.toPostfix(input_string);
            //System.out.println(convert_string);
            result = calculate(convert_string);
            System.out.println(result);
            input_string = in.nextLine();
        }
    }
    public static int getNumber(String convert_string, int i) {
        int num = 0;
        while(i < convert_string.length()-1 && convert_string.charAt(i) != ' ') {
            if(convert_string.charAt(i) >= '0' && convert_string.charAt(i) <= '9')
                num = num * 17 + convert_string.charAt(i) - '0';
            else
                num = num * 17 + convert_string.charAt(i) - 'A' + 10;
            ++i;
            //System.out.println(num);
        }
        return num;
    }
}
