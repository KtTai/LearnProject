package kttai.learn;

import org.junit.Test;

/**
 * 最长回文串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromicSubstring {

    @Test
    public void testMain(){
        System.out.println(this.longestPalindrome("ddd"));

    }

    public String longestPalindrome(String s) {
        if (!(s != null && !"".equals(s)))
            return "";
        String endStr = s.charAt(0)+"";
        for (int i=0; i<s.length(); i++)
        {
            String thisLongStr = "";
            char sc = s.charAt(i);
            String thisLongStr2 = "";
            if (i +1<s.length())
            {
                char scNext = s.charAt(i+1);
                if (scNext == sc)
                {
                    thisLongStr2 = nextStr(s,i-1,i+2,sc+""+sc);
                }
            }
            String thisLongStr1 = nextStr(s,i-1,i+1,sc+"");
            thisLongStr = thisLongStr2.length()>thisLongStr1.length()?thisLongStr2:thisLongStr1;

            if (thisLongStr.length()>=endStr.length()) {
                endStr = thisLongStr;
            }
        }
        return endStr;
    }

    private String nextStr(String s ,int startIndex, int endIndex,String hasStr){
        if (startIndex>=0&& endIndex<s.length() && s.charAt(startIndex) == s.charAt(endIndex))
        {
            hasStr = s.charAt(startIndex) + hasStr + s.charAt(startIndex);
            return nextStr(s, startIndex - 1, endIndex + 1, hasStr);
        }
        return hasStr;
    }
}
