package com.qyj.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Auther YaoJun Qi
 * @Date 2021/02/07 09:54
 * @description 中缀表达式转前缀（波兰表达式）、后缀（逆波兰表达式）
 */
public class AgainstPolandNotation {
    public static void main(String[] args) {
        //中缀表达式
        String expression = "1 + ( ( 2 + 3 ) * 4 ) - 5";

        Stack<String> symbolStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();

        String[] s = expression.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(s));
        /**
        * 1.判断是否为数字，为数字直接入结果栈
        * 2.不是数字判断运算符栈是否为空，为空直接入栈。(直接入栈，遇到)把所有(之前所有的结果入结果栈
        * 3.判断符号优先级，如果栈内符号大于等于待入栈符号，则把栈内符号添加到结果栈，并把待入栈符号入运算符栈
        * 4.把运算符栈所有剩余的入结果栈
        */
        for(String element : list){
            if(element.matches("\\d+")){
                resultStack.push(element);
            }else{
                if(symbolStack.isEmpty()){
                    symbolStack.push(element);
                    continue;
                }
                if("(".equals(element)){
                    symbolStack.push(element);
                    continue;
                }
                if(")".equals(element)){
                    while (true){
                        if("(".equals(symbolStack.peek())){
                            symbolStack.pop();
                            break;
                        }
                        resultStack.push(symbolStack.pop());
                    }
                    continue;
                }
                if("(".equals(symbolStack.peek())){
                    symbolStack.push(element);
                }else {
                    if(priority(symbolStack.peek())>=priority(element)){
                        resultStack.push(symbolStack.pop());
                        symbolStack.push(element);
                    }else {
                        symbolStack.push(element);
                    }
                }
                continue;
            }
        }

        for (int i=0 ; i<symbolStack.size() ; i++){
            resultStack.push(symbolStack.pop());
        }

        Stack<String> polandExpression = new Stack<>();
        Stack<String> inversePolandExpression = new Stack<>();

        System.out.println("-------------------波兰表达式-------------------");

        while (!resultStack.isEmpty()){
            String pop = resultStack.pop();
            polandExpression.push(pop);
            System.out.print(pop);
        }

        System.out.println("\n------------------逆波兰表达式-------------------");

        while (!polandExpression.isEmpty()){
            String pop = polandExpression.pop();
            inversePolandExpression.push(pop);
            System.out.print(pop);
        }

        System.out.printf("\n逆波兰表达式结果为：%d",calculate(inversePolandExpression));

    }

    public static int priority(String operator){
        if("*".equals(operator)||"/".equals(operator)){
            return 1;
        }else if("+".equals(operator)||"-".equals(operator)){
            return 0;
        }else{
            throw new RuntimeException("-------------------不是运算符-------------------");
        }
    }

    //123+4*+5-
    public static int calculate(Stack<String> resultStack){
        Stack<String> result = new Stack<>();
        int res = 0;
        for (String s : resultStack){
            if(s.matches("\\d+")){
                result.push(s);
            }else {
                int num2 = Integer.parseInt(result.pop());
                int num1 = Integer.parseInt(result.pop());
                if("*".equals(s)){
                    res = num1*num2;
                }else if("/".equals(s)){
                    res = num1/num2;
                }else if("-".equals(s)){
                    res = num1-num2;
                }else if("+".equals(s)){
                    res = num1+num2;
                }
                result.push(res+"");
            }
        }
        return res;
    }

}
