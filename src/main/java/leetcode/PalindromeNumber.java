package leetcode;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        if (x < 0 ||
                x % 10 == 0 && x != 0)
        return false;

        int invertedNum = 0;
        int copyX = x;

        while (copyX != 0) {
            invertedNum = invertedNum * 10 + copyX % 10;
            copyX = copyX / 10;
        }

        return invertedNum == x;
    };

    public static void main(String[] args) {

//
//            //!!! см случаи если цифр четное/нечетное количество
//            boolean result = true;
//            for (int c1 = 1; c1 <= half ; c1++) {
//
//                // первая цифра
//                num1 = Math.floor(num / Math.pow(10, length - c1));
//
//                // последняя цифра
//                num2 = Math.floor(num % Math.pow(10, c1));
//
//                if (num1 != num2 ) {
//                    result = false;
//                    break;
//                };
//
//            }
//
////            System.out.println(num);
////            System.out.println();
////            System.out.println();
//        }
//
//        //System.out.println(Math.floor(Math.log10(98)));
//
    }
}
