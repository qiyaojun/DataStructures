package com.qyj.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther YaoJun Qi
 * @Date 2021/01/27 13:38
 * @description
 */
public class Calculator {
    public static void main(String[] args) {
        //根据前面老师思路，完成表达式的运算
        String expression = "1+30*5-1"; // 15//如何处理多位数的问题？
        //创建两个栈，数栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的相关变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; //将每次扫描得到char保存到ch
        String keepNum = "";  //用于保存多位数
        while(true){
            ch = expression.substring(index,index+1).charAt(0);
            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        int cal = numStack.cal(num1, num2, oper);
                        numStack.push(cal);
                        operStack.push(ch);
                    }else{
                        operStack.push(ch);
                    }
                }else{
                    operStack.push(ch);
                }
            }else{
                //                    numStack.push(ch-48);

                keepNum += ch;
                if(index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }

            }
            //让index + 1, 并判断是否扫描到expression最后.
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行.
        while(true) {
            //如果符号栈为空，则计算到最后的结果, 数栈中只有一个数字【结果】
            if(operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);//入栈
        }
        //将数栈的最后数，pop出，就是结果
        int res2 = numStack.pop();
        System.out.printf("表达式 %s = %d", expression, res2);
    }
}

class ArrayStack2{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return maxSize-1==top;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("栈为空！！！");
            return -1;
        }
        return stack[top--];
    }

    public void push(int number){
        if(isFull()){
            System.out.println("栈已满！！！");
            return;
        }
        stack[++top] = number;
    }

    public void list(){
        for (int i=top ; 0<=i ; i--){
            System.out.println(stack[i]);
        }
    }

    public int peek(){
        return stack[top];
    }

    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if(oper == '+' || oper == '-'){
            return 0;
        }else{
            return -1;
        }
    }
    public boolean isOper(int oper){
        return oper == '*' || oper == '/' || oper == '+' || oper == '-';
    }

    public int cal(int num1 , int num2 , int oper){
        int res = 0;
        switch (oper){
            case '+':
                res =  num1 + num2;
                break;
            case '-':
                res =  num2 - num1;
                break;
            case '*':
                res =  num1 * num2;
                break;
            case '/':
                res =  num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
