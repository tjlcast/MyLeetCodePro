package com.tjlcast.Interview_Code.wangyi;

import java.util.HashMap;

/**
 * @author by tangjialiang
 *         时间 2018/8/21.
 *         说明 ...
 */
public class LRUCache<K, V> {

    public static void main(String[] args) {

    }

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> front;
        Node<K, V> back;

        public Node() {}

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V> head = new Node<K, V>();
    private Node<K, V> tail = new Node<K, V>();
    private HashMap<K, Node<K, V>> reocrder = new HashMap<>(16);
    private int capacity ;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.back = tail;
        tail.front = head;
    }

    public V get(K key) throws Exception {
        if (!reocrder.containsKey(key)) {
            throw new Exception("there is no key");
        }

        Node<K, V> kvNode = reocrder.get(key);
        hit(kvNode);
        return kvNode.value;
    }

    public void put(K key, V value) {
        if (reocrder.containsKey(key)) {
            Node<K, V> kvNode = reocrder.get(key);
            kvNode.value = value;
            hit(kvNode);
        } else {
            Node<K, V> kvNode = new Node<>(key, value);
            if (this.reocrder.keySet().size()==this.capacity) {
                Node node = this.removeTail();
                this.reocrder.remove(node.key);
            }
            addHead(kvNode);
            reocrder.put(key, kvNode);
        }
    }

    private void hit(Node<K, V> node) {
        // remove the node;
        this.removeNode(node);
        // add the node to head
        this.addHead(node);
    }

    private void addHead(Node<K, V> node) {
        if (node == null) {
            return ;
        }

        node.front = head;
        node.back = head.back;

        head.back.front = node;
        head.back = node;
    }

    private Node getFirstNode() {
        if (head.back == this.tail) {
            return null;
        }
        return head.back;
    }

    private Node getLastNode() {
        if (tail.front == this.head) {
            return null;
        }
        return tail.front;
    }

    private void addTail(Node<K, V> node) {
        if (node == null) {
            return ;
        }
        node.back = tail;
        node.front = tail.front;

        tail.front.back = node;
        tail.front = node;
    }

    private Node removeHead() {
        if (head.back == tail) {
            return null;
        }

        return this.removeNode(head.back);
    }

    private Node removeTail() {
        if (tail.front == head) {
            return null;
        }

        return this.removeNode(tail.front);
    }

    private Node removeNode(Node<K, V> node) {
        if (node==null || node==head || node==tail) {
            return null ;
        }

        Node<K, V> frontNode = node.front;
        Node<K, V> backNode = node.back;

        frontNode.back = backNode;
        backNode.front = frontNode;

        node.front = null;
        node.back = null;

        return node;
    }
}
