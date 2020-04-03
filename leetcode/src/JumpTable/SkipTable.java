package JumpTable;

import lombok.experimental.var;

import java.util.Random;

/**
 * @author by tangjialiang
 *         时间 2020/4/4.
 *         说明 ...
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

        public static
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
    public SkipTable() {
        _head = new Node(null, null, 0, null, null);

        // to choose the head level node randomly.
        _random = new Random(40);

        _size = 0;

        _p = 0.5;
    }

    public void add(K key, V val) {
        var toLevel = _leve();

        if (toLevel > _head.level) {
            _head = new Node(null, null, toLevel, null, _head);
        }
    }

    private long _size;
    private double _p;

    private long _leve() {
        long level = 0;
        while (level < _size && _random.nextDouble() < _p) {
            level++;
        }
        return level;
    }


}
