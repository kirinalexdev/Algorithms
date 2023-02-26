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

        if (strs.length == 0) {
            return "";
        }

        var pref = new StringBuilder();
        boolean end = false;
        String a;
        String b;

        for (int i = 0; i < strs[0].length(); i++) {
            a = strs[0].substring(i, i + 1);
            for (int j = 1; j < strs.length; j++) {
                b = strs[j].substring(i, i + 1);
                if (!b.equals(a)) {
                    return pref.toString();
                }
            }
            pref.append(a);
        }

        return pref.toString();
    };
}
