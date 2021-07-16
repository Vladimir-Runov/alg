import java.util.Random;

/* Урок 6. Деревья
        1. Создать и запустить программу для построения двоичного дерева.
        В цикле построить двадцать деревьев с глубиной в 6 уровней.
        Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int. Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
        2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
*/
public class Less_6 {

    public static void go() {
        Random random = new Random();
        for (int nStep =0; nStep < 20; nStep++) {
            Node root = new Node(100 - random.nextInt(201));
            Node.PrintRecursie(root);  System.out.println("");
            while (6 > Node.getHeight(root)) {
                Node.insert(root, 100 - random.nextInt(201));
                Node.PrintRecursie(root);
                System.out.println("  h= " + Node.getHeight(root));
            }
            Node.BalancedResult b = Node.isBalancedRecursive(root, 0);
            System.out.println(b.toString());
            root = null;
        }
    }
}
