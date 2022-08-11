package com.simple4h.sample.lru;

import com.simple4h.sample.lru.entity.Node;

/**
 * TODO:
 *
 * @author Simple4H
 */
public class DoubleList {

    /**
     * 头尾节点
     */
    private Node head, tail;

    /**
     * 大小
     */
    private int size;

    /**
     * 初始化
     */
    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    // 在链表尾部添加节点 x，时间 O(1)
    public void addLast(Node node) {
        node.pre = tail.pre;
        node.next = tail;
        tail.pre.next = node;
        tail.pre = node;
        size++;
    }

    // 删除链表中的 node 节点（node 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }

    // 删除链表中第一个节点，并返回该节点，时间 O(1)
    public Node removeFirst() {
        if (head.next == tail)
            return null;
        Node first = head.next;
        remove(first);
        return first;
    }

    // 返回链表长度，时间 O(1)
    public int size() {
        return size;
    }
}
