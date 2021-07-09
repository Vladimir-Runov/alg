// Стек — это структура данных, в которой элементы, входящие последними, выходят первыми.
public class Stack<E> {

    private MyLinkedList<E> list = new MyLinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }



    public E pop(){
        return list.removeFirst();
    }

    public void push(E i) {
        list.insertFirst(i);
    }

    MyLinkedList<E> getList() { return list; }
}
