package leetcode;

public class LongestCommonPrefix {

    static public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        var prefix = new StringBuilder();
        String a;
        String b;

        for (int i = 0; i < strs[0].length(); i++) {
            a = strs[0].substring(i, i + 1);
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length()-1) return prefix.toString();
                b = strs[j].substring(i, i + 1);
                if (!b.equals(a)) return prefix.toString();
            }
            prefix.append(a);
        }

        return prefix.toString();
    };
}
