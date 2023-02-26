package leetcode;

import org.junit.jupiter.api.Test;
import static leetcode.LongestCommonPrefix.longestCommonPrefix;

class LongestCommonPrefixTest {

    @Test
    void longestCommonPrefixTest() {
        assert "fl".equals(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        assert "".equals(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        assert "".equals(longestCommonPrefix(new String[]{}));
        assert "abc".equals(longestCommonPrefix(new String[]{"abc"}));
        assert "".equals(longestCommonPrefix(new String[]{""}));
    }
}