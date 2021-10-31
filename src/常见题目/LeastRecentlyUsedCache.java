package 常见题目;

import java.util.HashMap;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: MyCache
 * @description: LRU算法（内存替换算法） 双向链表加map
 * @date 2021-10-31
 */
public class LeastRecentlyUsedCache {
    public static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;
        private Node<K, V> last;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class NodeDoubleLinkedList<K, V> {
        private Node<K, V> head;
        private Node<K, V> tail;

        public NodeDoubleLinkedList() {
            head = null;
            tail = null;
        }

        public void add(Node<K, V> node) {
            if (node == null) {
                return;
            }
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
                node.last = tail;
            }
            tail = node;
        }

        public void remove(Node<K, V> node) {
            if (head == node) {
                head = head.last;
                head.next = null;
            } else if (tail == node) {
                tail = tail.next;
                tail.last = null;
            } else {
                node.next.last = node.last;
                node.last.next = node.next;
            }
        }

    }

    public static class MyCache<K, V> {
        private HashMap<K, Node<K, V>> map;
        private NodeDoubleLinkedList<K, V> doubleLinkedList;
        private final Integer size;

        public MyCache(Integer size) {
            this.size = size;
            this.doubleLinkedList = new NodeDoubleLinkedList<K, V>();
            this.map = new HashMap<K, Node<K, V>>();
        }

        public void set(K key, V value) {
            if (map.containsKey(key)) {
                Node<K, V> res = map.get(key);
                doubleLinkedList.remove(res);
                doubleLinkedList.add(res);
            } else {
                Node<K, V> node = new Node(key, value);
                map.put(key, node);
                doubleLinkedList.add(node);
                if (map.size() > size) {
                    doubleLinkedList.remove(doubleLinkedList.head);
                }
            }
        }

        public V get(K k) {
            V res = null;
            if (map.containsKey(k)) {
                Node<K, V> node = map.get(k);
                res = node.value;
                doubleLinkedList.remove(node);
                doubleLinkedList.add(node);
            }
            return res;
        }
    }
}
