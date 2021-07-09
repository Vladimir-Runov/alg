public class Main {
/*
            1. Написать программу по возведению числа в степень с помощью рекурсии.
            2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
            Пожалуйста, пройдите короткий опрос, чтобы оценить время выполнения домашнего задания:
           https://forms.gle/cBoYMPvbABa36jb7A
*/

    public static void main(String[] args) {
        System.out.println("2^3=" + mult(2,3));
    }

    public static int mult(int val, int n) {
        if (n == 0) {
            return 1;
        }
        return mult(val,n-1) * val;
    }
}
