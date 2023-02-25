package leetcode;

public class LongestCommonPrefix {

    static public String longestCommonPrefix(String[] strs) {


        // Наивный алгоритм 1:
        // - найти самое короткое слово
        // - проверять каждое все слова, подходит ли это короткое слово как префикс
        // - удалять символы слева от короткого слова, пока не будет найдено
        //
        // Сложность: КолвоСлов + ДлинаКороткого * КолвоСлов

        // Наивный алгоритм 2
        // - перебирать все слова по первым буквам
        //   пока не кончится одно из слов или очередная буква НЕ будет во всех словах
        //
        // Сложность:  ДлинаКороткого * КолвоСлов

        var pref = new StringBuilder();
        boolean end = false;
        String a;
        String b;

        //!!! учесть что массив может быть из одной строки
        for (int i = 0; i < strs[0].length(); i++) {
            a = strs[0].substring(i, i + 1);
            for (int j = 1; j < strs.length; j++) {
                b = strs[j].substring(i, i + 1);
                if (b == "" || !b.equals(a)) {
                    end = true;
                    break;
                }
            }
            if (end) break;
            pref.append(a);
        }

        return pref.toString();
    };

    public static void main(String[] args) {
//        Input: strs = ["flower","flow","flight"]
//        Output: "fl"
        var res1 = longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(res1);

        var res2 = longestCommonPrefix(new String[]{"dog","racecar","car"});
        System.out.println(res2);
//
//        Input: strs = []
//        Output: ""
//        Explanation: There is no common prefix among the input strings.
    }
}
