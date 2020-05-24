package kttai.learn;

import org.junit.Test;

import java.util.*;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeClass {

    @Test
    public void testMain(){
        System.out.println(this.merge(new int[][]{{1,4},{0,4}}));

    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length<1) return new int[0][0];

       /* int[][] newArrInts = new int[intervals.length][2];
        for (int i=0; i<intervals.length; i++){
            int[] interval = intervals[i];
//            newArrList.add(interval[0],interval);
            newArrInts[interval[0]] = interval;
        }*/
        List<int[]> returnArrList = new ArrayList<>();

        Arrays.sort(intervals,(v1,v2) -> v1[0] - v2[0]);
        List<int[]> newArrList = Arrays.asList(intervals);
        for (int i=0; i<newArrList.size(); i++){
            int[] pointInterval = newArrList.get(i);
            if (pointInterval == null) continue;
            i = nextArrIsContains(newArrList,i,pointInterval[0],pointInterval[1],returnArrList);
        }
        int[][] returnArrS = new int[returnArrList.size()][];
        for (int i =0; i<returnArrList.size(); i++){
            int[] returnArr = returnArrList.get(i);
            returnArrS[i] = returnArr;
        }
        return returnArrS;
    }

    private int nextArrIsContains(List<int[]> newArrList, int index, int minNum,int maxNum, List<int[]> returnArrList) {
        if (index < newArrList.size())
        {
            int[] nextInterval = newArrList.get(index);
            if (maxNum < nextInterval[0]){
                returnArrList.add(new int[]{minNum,maxNum});
                index--;
            }else if(maxNum >= nextInterval[0] && maxNum < nextInterval[1] ){
                index = this.nextArrIsContains(newArrList,index+1,minNum,nextInterval[1],returnArrList);
            }else if(maxNum >= nextInterval[1]){
                index = this.nextArrIsContains(newArrList,index+1,minNum,maxNum,returnArrList);
            }
        }else {
            returnArrList.add(new int[]{minNum,maxNum});
            index--;
        }
        return index;
    }
}
