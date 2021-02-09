package com.qyj.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Auther YaoJun Qi
 * @Date 2021/02/03 15:20
 * @description
 */
public class PolandNotation {
    public static void main(String[] args) {
        //原表达式(3+4)*5-6
        String suffixExpression = "300 4 + 5 * 6 -";
        List<String> listString = getListString(suffixExpression);
        int calculate = calculate(listString);
        System.out.printf("后缀表达式结果为(逆波兰表达式)：%d",calculate);
    }

    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(split));
        return list;
    }

    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String element : list){
            if(element.matches("\\d+")){
                stack.push(element);
            }else{
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(element.equals("+")){
                    res = num1 + num2;
                }else if(element.equals("-")){
                    res = num1 - num2;
                }else if(element.equals("/")){
                    res = num1 / num2;
                }else if(element.equals("*")){
                    res = num1 * num2;
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
