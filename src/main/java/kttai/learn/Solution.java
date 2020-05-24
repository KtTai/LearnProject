package kttai.learn;

import org.junit.Test;

public class Solution {
    @Test
    public void testMain(){
        System.out.println(this.countSubstrings("aaa"));

    }
    int lengthI = 0;
    public int countSubstrings(String s) {

        for(int i=0; i<s.length();i++){
            char sc = s.charAt(i);
            if (i+1 < s.length()){
                if (sc == s.charAt(i+1)){
                    //                   String a = (s.charAt(i+1)+"") + this.getNextS(s,i-1,i+2,sc+"") + (s.charAt(i+1)+"");
                    this.getNextS(s,i-1,i+2,sc+"");
                    lengthI ++;
                }
            }
            this.getNextS(s,i-1,i+1,sc+"");
            lengthI ++;
        }
        return lengthI;
    }

    private String getNextS(String oldS, int startIndex, int endIndex, String pointS){
        if (startIndex>=0 && endIndex < oldS.length()&& oldS.charAt(startIndex) == oldS.charAt(endIndex))
        {
            lengthI ++;
            pointS = oldS.charAt(startIndex) + pointS + oldS.charAt(startIndex);
            return getNextS(oldS,startIndex-1,endIndex+1,pointS);
        }
        return pointS+"";
    }
}
