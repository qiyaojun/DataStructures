package com.qyj.queue;

import java.util.Scanner;

/**
 * @Auther YaoJun Qi
 * @Date 2021/01/04 14:16
 * @description 使用数组实现环形列表
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(4);
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
                        circleQueue.showQueue();
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
                    circleQueue.addQueue(i);
                    break;
                case 'g':
                    System.out.println(circleQueue.getQueue());
                    break;
                case 'h':
                    System.out.println(circleQueue.headQueue());
                    break;
            }
        }
        System.out.println("退出程序~~");
    }
}

class CircleQueue{
    private int maxSize; //队列最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数据用来存储数据，模拟队列

    //创建队列的一个构造器
    public CircleQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否已满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        rear = (rear+1) % maxSize;
    }

    //数据出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！！！");
        }
        int value = arr[front];
        front = (front+1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列为空！");
            return;
        }
        for (int i=front ; i<front+size() ; i++){
            System.out.printf("arr[%d] = %d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        return arr[front];
    }
}

