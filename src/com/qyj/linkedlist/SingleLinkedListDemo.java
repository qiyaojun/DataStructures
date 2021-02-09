package com.qyj.linkedlist;

import com.sun.media.sound.SoftTuning;

import java.util.Stack;

/**
 * @Auther YaoJun Qi
 * @Date 2021/01/06 15:20
 * @description 带头节点的单链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //初始化单链表
        HeroNode node1 = new HeroNode(1,"test1","test11");
        HeroNode node2 = new HeroNode(2,"test2","test22");
//        HeroNode node3 = new HeroNode(3,"test3","test33");
//        HeroNode node4 = new HeroNode(4,"test4","test44");
        HeroNode node5 = new HeroNode(6,"test5","test55");


        HeroNode node10 = new HeroNode(5,"test10","test10");
        HeroNode node11 = new HeroNode(11,"test11","test11");

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.addByOrder(node10);
        singleLinkedList1.addByOrder(node11);
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(node1);
//        singleLinkedList.add(node2);
//        singleLinkedList.add(node3);
//        singleLinkedList.add(node5);
//        singleLinkedList.list();

        System.out.println("-----单链表按no从小到大插入-----");

        singleLinkedList.addByOrder(node1);
//        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node5);
//        singleLinkedList.addByOrder(node4);

        singleLinkedList.list();

        singleLinkedList1.list();

//        System.out.println("-----单链表的修改-----");
//
//        HeroNode node6 = new HeroNode(4,"444","444444");
//        singleLinkedList.update(node6);
//
//        singleLinkedList.list();
//
//        System.out.println("-----单链表的删除-----");
//
//        HeroNode node7 = new HeroNode(4,"444","444444");
//        singleLinkedList.delete(node7);
//
//        singleLinkedList.list();
//
//        System.out.println("-----单链表有效数据个数-----");
//
//        System.out.println(length(singleLinkedList.getHead()));
//
//        System.out.println("-----取单链表倒数第k个值-----");
//
//        System.out.println(get(singleLinkedList.getHead(),1));
//
//        System.out.println("-----单链表反转-----");
//
//        reverse(singleLinkedList.getHead());
//        singleLinkedList.list();
//
//        System.out.println("-----单链表倒叙-----");
//
//        reverseOrder(singleLinkedList.getHead());

        System.out.println("-----单链表合并-----");

        HeroNode list = merge(singleLinkedList.getHead().next, singleLinkedList1.getHead().next);

        while (list != null){
            System.out.println(list);
            list = list.next;
        }


    }

    /**
     * 获取链表有效数据个数
     * @param head 头节点
     * @return int
     */
    public static int length(HeroNode head){
        if(head.next == null){
            System.out.println("链表为空！");
            return 0;
        }
        int num = 0;
        while (head.next != null){
            num++;
            head = head.next;
        }
        return num;
    }

    /**
     * 获取数组倒数第n个元素（新浪面试题）
     * @param head 头节点
     * @param count 倒数第几个
     * @return
     */
    public static HeroNode get(HeroNode head,int count){
        if(head.next == null){
            System.out.println("链表为空！");
            return null;
        }
        if(count<=0){
            System.out.println("输入的数不能是小于等于0");
            return null;
        }
        if(length(head)<count){
            System.out.println("输入数值大于链表总个数！！！");
            return null;
        }
        int size = length(head)-count;
        int num = 1;
        HeroNode temp = head.next;
        for (int i=0 ; i<size ; i++){
            temp=temp.next;
        }
        return temp;

//        while (true){
//            if(size==num){
//                return temp;
//            }
//            num++;
//            if(temp.next == null){
//                return null;
//            }
//            temp=temp.next;
//        }

    }

    public static void reverse(HeroNode head){
        if(head.next == null){
            System.out.println("链表为空！！！");
            return;
        }
        HeroNode cur = head.next; //当前节点
        HeroNode next = null; //指向下一个节点，给cur赋值。取出当前节点后，cur会为空！
        HeroNode newHeroNode = new HeroNode(0,"","");
        while (cur != null){
            next = cur.next;
            cur.next = newHeroNode.next;
            newHeroNode.next = cur;
            cur = next;
        }
        head.next = newHeroNode.next;
    }

    public static void reverseOrder(HeroNode head){
        if(head.next == null){
            System.out.println("链表为空！！！");
            return;
        }
        HeroNode temp = head.next;
        Stack<HeroNode> stack = new Stack<>();
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }

    }


    public static HeroNode merge(HeroNode head1 , HeroNode head2){
        if(head1 == null)return head2;
        if(head2 == null)return head1;
        if(head1.no > head2.no){
            head2.next = merge(head1,head2.next);
            return head2;
        }else{
            head1.next = merge(head1.next,head2);
            return head1;
        }
    }
}

//创建SingleLinkedList管理英雄
class SingleLinkedList{
    //初始化一个头节点，头节点不要动，不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    //不带排序
    //初始化头节点，只要是temp.next为空就插入
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            //temp.next不为空，移到下一位
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            //判断temp.next元素的编号是否大于要插入数据heroNode的no 如果大于说明插入位置为temp.next
            if(temp.next.no > heroNode.no){
                break;
            }else if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //flag为true说明已存在此节点
        if(flag){
            System.out.println("已经存在此节点，不能重复加入！");
        }else {
            /*
            先把temp.next赋值给heroNode.next 分两种情况 如果temp.next == null 则默认插入到最后。
            如果temp.next.no > heroNode.no 说明待插入值的编号小于下一个值的编号
            先把下一个值指向待插入值的.next 再把temp.next指向待插入值
             */
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void list(){
        if(head.next == null){
            System.out.println("链表为空！！！");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }


    public void update(HeroNode newHeroNode){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                System.out.println("修改失败，链表中不存在该英雄！");
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }
    }

    public void delete(HeroNode newHeroNode){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空！");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == newHeroNode.no){
                flag=true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("删除失败，未找到该元素！！！");
        }
    }
}

//每个HeroNode都是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\''+"}";
    }
}
