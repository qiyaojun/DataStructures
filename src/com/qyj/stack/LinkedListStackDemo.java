package com.qyj.stack;

/**
 * @Auther YaoJun Qi
 * @Date 2021/01/26 14:08
 * @description
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(node1);
        linkedListStack.push(node2);
        linkedListStack.push(node3);
        linkedListStack.push(node4);

        linkedListStack.list();

        linkedListStack.pop();

        linkedListStack.list();
    }
}

class LinkedListStack{
    private Node head = new Node(0);

    public void push(Node node){
        Node temp = head;
        while (true){
            if(temp.next == null){
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    public int pop(){
        Node temp = head;
        while (true){
            if(temp.next.next==null){
                int no = temp.next.no;
                temp.next = null;
                return no;
            }
            temp = temp.next;
        }
    }

    public void list(){
        Node temp = head.next;
        if(head.next == null){
            return;
        }
        while (temp!=null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class Node{
    public int no; //数据
    public Node next;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
