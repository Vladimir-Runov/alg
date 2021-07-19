import java.util.Random;

/* Урок 8. Хеш-таблицы
        1. Создать реализацию удаления в методе цепочек. (Добавить метод delete(K key) в ChainingHashMap() )
*/
public class Less_8_Hashe {
    public static void go() {
        ChainingHashMap<Integer, String> chm = new ChainingHashMap<>(16);

        chm.put(1,  "one");
        chm.put(2,  "one+");
        chm.put(222, "222e");
        System.out.println(chm);
        chm.delete(2);
        System.out.println(chm);
     //   chm.put(4545, "4545e");
     //   System.out.println(chm.get(1));

    //    Random random = new Random();
    //    for (int i = 0; i < 12; i++) {
    //        chm.put(random.nextInt(1000), "");
    //    }

    }
}
