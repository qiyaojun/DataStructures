package com.qyj.linkedlist;

/**
 * @Auther YaoJun Qi
 * @Date 2021/01/25 09:53
 * @description 双向链表
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 list1 = new HeroNode2(1,"111","111");
        HeroNode2 list2 = new HeroNode2(2,"222","222");
        HeroNode2 list3 = new HeroNode2(4,"444","444");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        System.out.println("---双向链表添加---");

        doubleLinkedList.add(list1);
        doubleLinkedList.add(list2);
        doubleLinkedList.add(list3);

        doubleLinkedList.list();

        System.out.println("---双向链表删除---");
        doubleLinkedList.delete(new HeroNode2(2,"",""));
        doubleLinkedList.list();

        System.out.println("---双向链表修改---");
        doubleLinkedList.update(new HeroNode2(1,"1","1"));
        doubleLinkedList.list();

        System.out.println("---双向链表按no从小到大添加---");
        doubleLinkedList.addByNo(new HeroNode2(6,"666","666"));
        doubleLinkedList.list();


    }
}

class DoubleLinkedList
{
    private HeroNode2 head = new HeroNode2(0,"","");


    public void add(HeroNode2 heroNode2){
        HeroNode2 temp = head;
        while (true){
            if(temp.next == null){
                temp.next = heroNode2;
                heroNode2.pre =temp;
                break;
            }
            temp = temp.next;
        }
    }

    public void addByNo(HeroNode2 heroNode2){
        HeroNode2 temp = head.next;
        boolean flag = false;
        if(temp == null){
            System.out.println("链表为空！！！");
            return;
        }

        while (true){
            if(temp.no > heroNode2.no){
                break;
            }else if(temp.no == heroNode2.no){
                System.out.println("已存在该元素！");
                break;
            }
            if(temp.next == null){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.next = heroNode2;
            heroNode2.pre = temp;
        }else {
            heroNode2.pre = temp.pre;
            temp.pre.next = heroNode2;
            heroNode2.next = temp;
            temp.pre = heroNode2;
        }
    }

    public void delete(HeroNode2 heroNode2){
        if(head.next == null){
            System.out.println("链表为空！！！");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;

        while (true){
            if(temp.no == heroNode2.no){
                temp.pre.next = temp.next;
                if(temp.next != null) {
                    temp.next.pre = temp.pre;
                }
                flag = true;
                break;
            }
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }

        if(!flag){
            System.out.println("删除失败，未找到该节点！");
        }
    }

    public void update(HeroNode2 heroNode2){
        if(head.next ==null){
            System.out.println("链表为空！！！");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if(temp.no == heroNode2.no){
                temp.name = heroNode2.name;
                temp.nickname = heroNode2.nickname;
                flag = true;
                break;
            }
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        if(!flag){
            System.out.println("修改失败，未找到该节点！！！");
        }
    }

    public void list(){
        HeroNode2 temp = head.next;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 pre;
    public HeroNode2 next;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", pre=" + pre +
                '}';
    }
}




