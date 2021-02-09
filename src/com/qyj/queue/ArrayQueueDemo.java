package com.qyj.queue;

import java.util.Scanner;

/**
 * @Auther YaoJun Qi
 * @Date 2021/01/04 09:48
 * @description 数组实现队列queue
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        System.out.println("请选择：");
        while (flag){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出");
            System.out.println("a(add):添加");
            System.out.println("g(get):获取");
            System.out.println("h(head):获取队列头数据");
            System.out.println("请输入：");
            char c = scanner.next().charAt(0);
            switch (c)
            {
                case 's':
                    try {
                        arrayQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    flag = false;
                    break;
                case 'a':
                    System.out.println("请输入数据：");
                    int i = scanner.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case 'g':
                    System.out.println(arrayQueue.getQueue());
                    break;
                case 'h':
                    System.out.println(arrayQueue.headQueue());
                    break;
            }
        }
        System.out.println("退出程序~~");
    }
}

class ArrayQueue{
    private int maxSize; //队列最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数据用来存储数据，模拟队列

    //创建队列的一个构造器
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        this.front = -1; //指向队列头部，指向队列头的前一个位置
        this.rear = -1; //指向队列尾部，指向队列尾具体位置
    }

    //判断队列是否已满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满！");
            return;
        }
        rear++; //让rear后移
        arr[rear] = n;
    }

    //数据出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！！！");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列为空！");
            return;
        }
        for (int i=0 ; i<arr.length ; i++){
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }

    //显示队列头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        return arr[front+1];
    }
}
