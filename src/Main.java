import java.io.SyncFailedException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
 /*   Урок 2. Массивы и сортировка
            1. Создать массив большого размера (100000 элементов).
            2. Заполнить массив случайными числами.
            3. Написать методы, реализующие рассмотренные виды сортировок,
               и проверить скорость выполнения каждой.
            4* . Доработать код с урока добавив проверки в места с комментариями в классе MyArrayList

        1. Создать программу, которая переворачивает вводимые строки (читает справа налево).
        2. Создать класс для реализации дека.
        Дек (deque) представляет собой двустороннюю очередь. И вставка, и удаление элементов могут производиться с обоих концов. Соответствующие методы могут называться insertLeft()/insertRight() и removeLeft()/removeRight().

        3. Реализовать расширение массива в стеке при заполнении стека.
        4 ***. Реализовать расширение массива в очереди при заполнении очереди.

   */
    public static Random rand = new Random(10);

    public static void main(String[] args) {
    // TODO
        Scanner in = new Scanner(System.in);
        while ( true ) {
            System.out.print("Enter some str: ");
            String str = in.nextLine();
            if ("".equals(str))
                break;
            Deque<Character> d = new Deque<Character>();
            char[] buf = str.toCharArray();
            for (int i = 0; i < buf.length; i++) {
                d.insertRight(buf[i]);
            }

            do {
                try {

                    Character g = d.removeRight();
                    System.out.print(g);
                } catch (NoSuchElementException e) {
                    System.out.println("");
                    break;
                }
            } while (true);

        }
    }


    ////////////////////
    private static void Less_2() {
        int[] arr = new int[100000/2];

        for (int ver = 0; ver < 3; ver++) {

            for (int i = 0; i < arr.length; i++) {
                arr[i] = rand.nextInt(arr.length * 100);
            }
            long start = System.currentTimeMillis();
            if (ver == 0) {
                System.out.print(" selectionSort ");
                selectionSort(arr);
            } else if (ver == 1) {
                System.out.print(" bubbleSort    ");
                bubbleSort(arr);
            } else if (ver == 2) {
                System.out.print(" Arrays.sort   ");
                Arrays.sort(arr);// где arr это имя массива
                //Arrays.sort(arr, Collections.reverseOrder());
            }
            long finish = System.currentTimeMillis();  //nanoTime();
            long elapsed = finish - start;
            System.out.println("  Прошло времени, нс: " + elapsed/1000);
        }

    }

    public static void bubbleSort(int[] arr) {
    /*Внешний цикл каждый раз сокращает фрагмент массива,
      так как внутренний цикл каждый раз ставит в конец
      фрагмента максимальный элемент*/
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
    /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
        for (int i = 0; i < arr.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            int min = arr[i];
            int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i + 1; j < arr.length; j++) {
                //Если находим, запоминаем его индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }

}