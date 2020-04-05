package JumpTable;

import java.util.Random;

/**
 * @author by tangjialiang
 *         时间 2020/4/4.
 *         说明 https://cloud.tencent.com/developer/article/1422115
 */
public class SkipTable<K extends Comparable<K>, V extends Comparable<V>> {

    /**
     *
     */
    private class Node {
        public K key;
        public V value;
        public long level;
        public Node next;
        public Node down;

        public Node(K key, V val, long lev, Node next, Node down) {
            this.key = key;
            this.value = val;
            this.level = lev;
            this.next = next;
            this.down = down;
        }
    }

    /**
     *
     */
    private Node _head;

    /**
     *
     */
    private Random _random;

    /**
     *
     */
    private long _size;

    /**
     *
     */
    private double _p;

    /**
     *
     */
    public SkipTable() {
        _head = new Node(null, null, 0, null, null);

        // to choose the head level node randomly.
        _random = new Random(40);

        _size = 0;

        _p = 0.5;
    }

    /**
     * @Desc Add node into Skip Table.
     *
     * pro.1 如果哨兵节点在初始的时候就在很高层上，会不会导致跳表的分层很低.
     *
     * pro.2 在创建节点时，down节点有相同的key.
     *
     * pro.3 有相同key节点，val不同。如果Add时，把这个节点升级.
     *
     * pro.4 有相同key节点，val不同。如果Add时，把这个节点降级.
     *
     * tip.1 假设每个key所在的层是不变的, 由key创建的链表层级结构不变.
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        long toLevel = _leve();

        if (toLevel > _head.level) {
            /**
             * this node is structure node, and doesn't contains any data info.
             */
            _head = new Node(null, null, toLevel, null, _head);
        }

        Node cur = _head;
        Node last = null;

        while (cur != null) {
            if (cur.next == null || cur.next.key.compareTo(key) > 0) {
                if (toLevel >= cur.level) {

                    // create and join the new node in a row.
                    Node newNode = new Node(key, value, cur.level, cur.next, null);
                    cur.next = newNode;

                    // join the new node in a col.
                    if (last != null) {
                        last.down = newNode;
                    }

                    last = newNode;

                    // completed.
                    _size++;
                }

                cur = cur.down;
            }
            else if (cur.next.key.compareTo(key) == 0) {
                // todo ? should change the values in below down nodes.
                cur.next.value = value;
                return;
            }
            else {
                cur = cur.next;
            }
        }
    }

    /**
     * @Desc remove a key in the Skip table.
     * @param key
     * @return
     */
    public V remove(K key) {
        V value = null;

        Node curNode = _head;
        while (curNode != null) {
            // todo >= 包含了两种情况，特殊处理==的情况.
            if (curNode.next == null || curNode.next.key.compareTo(key) >= 0) {
                if (curNode.next != null && curNode.next.key.equals(key)) {
                    // hit
                    value = curNode.next.value;
                    curNode.next = curNode.next.next;
                    _size--;
                }
                curNode = curNode.down;
            }
            else {
                curNode = curNode.next;
            }
        }

        return value;
    }

    /**
     * @Desc removes all nodes containing the value
     * @param value
     * @return
     */
    public long removeValue(V value) {
        Node curNode = this._getButtonLine();
        long count = 0L;

        if (curNode == null) {
            return count;
        }
        curNode = curNode.next;

        while(curNode != null) {
            if (curNode.value.compareTo(value) == 0) {
                K targetKey = curNode.key;
                this.remove(targetKey);
                count++;
            }
        }

        return count;
    }

    /**
     * @Desc Get a value by key.
     * @param key
     * @return
     */
    public V get(K key) {
        if (key == null) {
            return null;
        }

        Node curNode = _head;
        while (curNode != null) {
            if (curNode.next == null || curNode.next.key.compareTo(key) >= 0) {
                if (curNode.next != null && curNode.next.key.equals(key)) {
                    return curNode.next.value;
                }
                curNode = curNode.down;
            }
            else {
                curNode = curNode.next;
            }
        }

        return null;
    }

    /**
     * @Desc check whether there is the key.
     * @param key
     * @return
     */
    public boolean contains(K key) {
        return this.get(key) != null;
    }

    /**
     * @Desc return the minimum element from the skipTable.
     * @return
     */
    public V findMin() {
        Node curNode = this._getButtonLine();

        if (curNode == null) {
            return null;
        }

        if (curNode != null && curNode.next != null) {
            return curNode.next.value;
        }
        return null;
    }

    /**
     * @Desc return the maximum element from the skipTable.
     * @return
     */
    public V findMax() {
        Node curNode = this._getButtonLine();

        if (curNode == null || curNode.next == null) {
            return null;
        }

        curNode = curNode.next;
        while (curNode.next != null) {
            curNode = curNode.next;
        }

        return curNode.value;
    }

    /**
     * @Desc return the size of skipTable.
     * @return
     */
    public long size() {
        Node curNode = this._getButtonLine();
        long sizeCount = 0L;

        if (curNode == null || curNode.next == null) {
            return 0L;
        }

        curNode = curNode.next;
        while (curNode != null) {
            sizeCount++;
            curNode = curNode.next;
        }

        return sizeCount;
    }

    private Node _getButtonLine() {
        Node curNode = _head;

        if (curNode == null) {
            return null;
        }

        while(curNode.down != null) {
            curNode = curNode.down;
        }

        return curNode;
    }

    /**
     * @Desc get level according to random.
     * @return
     */
    private long _leve() {
        long level = 0;
        while (level < _size && _random.nextDouble() < _p) {
            level++;
        }
        return level;
    }
}
