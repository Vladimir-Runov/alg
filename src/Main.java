import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
/*
            1. Написать программу по возведению числа в степень с помощью рекурсии.
            2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
*/

        private static final int MAX_NUMBER = 4;
        private static final int MAX_WEIGHT = 100;//вес, который хотим получить

    public static void main(String[] args) {
// 1
        System.out.println("2^3=" + mult(2,3));
// 2
        Random random = new Random();
        float[] weights = new float[MAX_NUMBER];
        float[] scopes = new float[MAX_NUMBER];
        Set<Integer> availableNumbers = new HashSet<>(0);
        for (int i = 0; i < MAX_NUMBER; i++) {
            availableNumbers.add(i);
            weights[i] = random.nextInt(60)/1f + random.nextInt(20)/10f;
            scopes[i] = random.nextInt(100)/100f;
        }
        System.out.println(Arrays.toString(weights)); //выводим массив весов
        System.out.println(Arrays.toString(scopes)); //выводим массив цен

        ArrayList<Float> results = new ArrayList<>();

        List<Integer[]> variants = generateIndexes_int_recursive(availableNumbers);
        for (Integer[] permutation : variants) {
            System.out.print(Arrays.toString(permutation) );
            float scope = 0, weight = 0; String log = "  ";
            System.out.print(log);
            for (Integer x : permutation) {
                if (weight+weights[x] < MAX_WEIGHT) {
                    weight += weights[x];
                    scope += scopes[x];
                    log = log + "+" + x.toString();
                } else {
                        log = log + "]";
                        break;
                }
            }
            results.add(scope);

            System.out.print(log);
            System.out.print(".  -> w="+weight);
            System.out.println(" sc=" + scope);

            float fMaxRez = 0;
            for (Float f : results) {
                if (f > fMaxRez)
                    fMaxRez = f;
            }
            System.out.println(" * * * max scope " + fMaxRez);

        }
    }


    public static int mult(int val, int n) {
        if (n == 0) {
            return 1;
        }
        return mult(val,n-1) * val;
    }

    public static List<Integer[]> generateIndexes_int_recursive(Set<Integer> availableNumbers) {
        List<Integer[]> permutations = new LinkedList<>();

        for (Integer number : availableNumbers) {
            Set<Integer> numbers = new HashSet<>(availableNumbers);
            numbers.remove(number);

            if (!numbers.isEmpty()) {
                List<Integer[]> childPermutations = generateIndexes_int_recursive(numbers);
                for (Integer[] childPermutation : childPermutations) {
                    Integer[] permutation = new Integer[MAX_NUMBER];
                    for (int g = 1; g < MAX_NUMBER; g++)
                        permutation[g] = -1;
                    permutation[0] = number;
                    for (int g = 0, k0 = 1; g < childPermutation.length; g++)  {// number + childPermutation;
                        if (childPermutation[g] != -1 ){
                            permutation[k0++] = childPermutation[g];
                        }
                    }
                    permutations.add(permutation);
                }
            } else {
                Integer[] permutation = new Integer[MAX_NUMBER];
                for (int g = 0; g < MAX_NUMBER; g++ )
                    permutation[g] = -1;
                permutation[0] = number;
                permutations.add(permutation);
            }
        }
        return permutations;
    }
}
