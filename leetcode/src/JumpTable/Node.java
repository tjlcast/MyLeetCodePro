package JumpTable;

import lombok.ToString;

/**
 * @author by tangjialiang
 *         时间 2020/4/3.
 *         说明 ...
 */
public class Node<K, V> {

    public K key;

    public V value;

    public long level;

    public Node next;

    public Node down;

    public Node(K k, V v, long lev, Node n, Node d) {
        this.key = k;
        this.value = v;
        this.level = lev;
        this.next = n;
        this.down = d;
    }
}
