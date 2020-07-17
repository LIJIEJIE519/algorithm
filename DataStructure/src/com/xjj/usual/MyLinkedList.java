package com.xjj.usual;

/**
 * Created by XJJ on 2020/5/27.
 */
public class MyLinkedList {
    private Node head;
    private Node last;
    private int size;   //链表长度

    /*
    * 查询元素
    * */
    public Node get(Node head, int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表范围");
        }
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /*
    * 链表长度
    * */
    public int size(Node head){
        int size=  0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    /*
    * 插入节点
    * */
    public Node insert(Node head,int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表范围");
        }
        Node temp = new Node(data);
        int size = size(head);
        if (size == 0){     // 空
            head = temp;
        }else if (index == 0){  //头
            temp.next = head;
            head = temp;
        }else if (size == index){//尾
            Node last = get(head, index - 1);
            last.next = temp;
            last = temp;
        }else { //中间
            Node preNode = get(head, index - 1);
            temp.next = preNode.next;
            preNode.next = temp;
        }
        return head;
    }
    /*
    * 删除节点
    * */
    public Node remove(Node head, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表范围");
        }
        Node removeNode = null;
        int size = size(head);
        if (index == 0) {
            removeNode = head;
            head = head.next;
        }else if (index == size-1) {
            Node pre = get(head, index-1);
            removeNode = pre.next;
            pre.next = null;
        }else {
            Node pre = get(head, index-1);
            removeNode = pre.next;
            pre.next = pre.next.next;
        }
        return removeNode;
    }
}
