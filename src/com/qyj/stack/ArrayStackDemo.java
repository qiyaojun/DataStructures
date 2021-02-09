package com.qyj.stack;

/**
 * @Auther YaoJun Qi
 * @Date 2021/01/26 09:43
 * @description
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);

        arrayStack.list();

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
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
}
