package kttai.learn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 */
public class NextGreaterElementsClass {

    @Test
    public void testMain(){
        System.out.println(this.nextGreaterElements(new int[]{1,2,1}));

    }

    public int[] nextGreaterElements(int[] nums) {
        if (nums ==null || nums.length<1) return new int[0];
        Map<Integer,Integer> numAndNextNumMap = new HashMap<>();
        int[] newArr = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int pointNum = nums[i];
            if(numAndNextNumMap.containsKey(pointNum)){
                newArr[i] = numAndNextNumMap.get(pointNum);
            }else{
                int findNumIndex = i+1;
                int findNum =-1;
                while(true){

                    int inFindNumIndex = (findNumIndex)%(nums.length);

                    if(inFindNumIndex <nums.length && nums[inFindNumIndex] > pointNum ){
                        findNum = nums[inFindNumIndex];
                        break;
                    }
                    //        findNumIndex = (findNumIndex+1) & (nums.length-1);
                    if(inFindNumIndex == i)break;
                    findNumIndex++;

                }
                newArr[i] = findNum;
            }
        }
        return newArr;
    }
}
