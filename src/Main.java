import java.io.SyncFailedException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
 /*   Урок 4.
        Урок 4. Связанные списки
        1. Реализовать класс Stack используя класс MyLinkedList
        2. Добавить итератор для класса MyLinkedList
   */
    public static Random rand = new Random(10);

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(4);
        st.push(12);
        st.push(23);
        System.out.println(st.pop());
        System.out.println(st.pop());

        MyLinkedList<Integer>.Iter itr = st.getList().getIter();
        itr.insertAfter( 20);
        itr.insertBefore(10);

    }

}