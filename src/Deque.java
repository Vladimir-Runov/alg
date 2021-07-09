/* Дек (deque) представляет собой двустороннюю очередь.
И вставка, и удаление элементов могут производиться с обоих концов.
Соответствующие методы могут называться insertLeft()/insertRight() и removeLeft()/removeRight().
 */

import java.util.NoSuchElementException;

public class Deque<T> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        private T item;
        private Node prev;
        private Node next;
        private Node(T itm) {
            this.item = itm;
            this.next = null;
            this.prev = null;
        }
    }

    public Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

    public void insertLeft(T item) {
        if (item == null)
            throw new NullPointerException("Null item added");
        if (size == 0) {
            this.first = new Node(item);
            this.last = this.first;
        } else {
            Node oldFirst = first;
            first = new Node(item);
            first.item = item;
            first.next = oldFirst;

            oldFirst.prev = first;
        }
        size++;
    }
    public void insertRight(T item) {
        if (item == null)
            throw new NullPointerException("Null item added");
        if (size == 0) {
            this.last = new Node(item);
            this.first = this.last;
        } else {
            Node oldLast = last;
            last = new Node(item);
            last.prev = oldLast;
            oldLast.next = last;
        }
        size++;
    }

    public T removeLeft() {
        if (isEmpty())
            throw new NoSuchElementException("Deque underflow");

        T item = first.item; // item to be removed

        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        size--;
        return item;
    }

    public T removeRight() {
        if (isEmpty())
            throw new NoSuchElementException("Deque underflow");

        T item = last.item;

        if (size == 1) {
            last = null;
            first = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        size--;
        return item;
    }
}
