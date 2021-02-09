package com.qyj.linkedlist;

/**
 * @Auther YaoJun Qi
 * @Date 2021/01/25 13:55
 * @description 环形链表
 */
public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode3 list1 = new HeroNode3(1);
        HeroNode3 list2 = new HeroNode3(2);
        HeroNode3 list3 = new HeroNode3(3);
        HeroNode3 list4 = new HeroNode3(4);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list1;

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.get(3,4,4,list1);

    }
}

class CircleSingleLinkedList{

    /**
     *
     * @param m 数几个
     * @param k 从第几个开始
     * @param n 总数
     * @param heroNode3 环形链表
     */
    public void get(int m,int k,int n,HeroNode3 heroNode3){
        //满足约定1<=k<=n
        if(!(k<=n&&1<=k)){
            System.out.println("1<=k<=n ~~");
            return;
        }
        HeroNode3 temp = heroNode3;
        if(temp.next == null){
            System.out.println("当前链表为空！");
        }

        //从第k个开始数，所以把HeroNode3移到第k个位置
        int i = 1;
        while (true){
            if(k==i)break;
            temp = temp.next;
            i++;
        }

        int num = 1;
        while (true){
            //数到第num个与约定的m相同时取出
            if(num == m){
                System.out.println("取出编号为："+temp.no);
                delete(temp.no,temp);
                num = 1;
                temp = temp.next;
                //链表为最后一个时直接弹出
                if(temp.no == temp.next.no){
                    System.out.println("取出编号为："+temp.next.no);
                    break;
                }
                continue;
            }
            temp = temp.next;
            num++;
        }
    }

    //删除当前节点的下一个节点
    public void delete(int no,HeroNode3 heroNode3){
        HeroNode3 temp = heroNode3;
        while (true){
            if(temp.next.no == no){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }
}

class HeroNode3{
    public int no;
    public HeroNode3 next;

    public HeroNode3(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "HeroNode3{" +
                "no=" + no +
                '}';
    }
}
