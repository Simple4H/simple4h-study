package com.simple4h.sample.lru.entity;

/**
 * 节点
 *
 * @author Simple4H
 */
public class Node {

    public int key, val;

    public Node next, pre;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
