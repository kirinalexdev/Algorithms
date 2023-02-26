
// https://habr.com/ru/company/skillbox/blog/689226/
// написать код, который выводит числа от 0 до 1000, которые
// делятся на 3,
// но не делятся на 5,
// и сумма цифр в которых меньше десяти.

public class DivideOn10 {

    static boolean digitSumIsCorrec(int n) {
        int result = 0;
        while (n > 0 && result < 10) {
            result += n % 10;
            n = n / 10;
        }
        return result < 10;
    }

    public static void main(String[] args) {

        // цикл шагом 3
        for (int i = 0; i <= 1000 ; i+=3) {
            if (i % 3 == 0 &&
              i % 5 != 0 &&
              digitSumIsCorrec(i)) {
                System.out.println(i);
            }
        }
    }

}
