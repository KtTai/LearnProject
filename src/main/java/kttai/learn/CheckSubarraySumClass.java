package kttai.learn;

import org.junit.Test;

import java.util.Stack;

/** 523
 * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 *
 * 示例 1:
 *
 * 输入: [23,2,4,6,7], k = 6
 * 输出: True
 * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
 * 示例 2:
 *
 * 输入: [23,2,6,4,7], k = 6
 * 输出: True
 * 解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 * 说明:
 *
 * 数组的长度不会超过10,000。
 * 你可以认为所有数字总和在 32 位有符号整数范围内
 */
public class CheckSubarraySumClass {

    @Test
    public void testMain(){
        System.out.println(this.checkSubarraySum(new int[]{0,1,0},0));

    }
    public boolean checkSubarraySum(int[] nums, int k) {
//        Stack<Integer> stack = new Stack<>(); 栈
        if(nums == null || nums.length<2) return false;
        if(k==-1) return true;
        out : for(int i=0; i<nums.length; i++){
            int pointNum = nums[i];
            int sumNum = pointNum;
            for(int j=i+1; j<nums.length; j++){
                int sumPointNum = nums[j];
                sumNum = sumNum+sumPointNum;
                if(k==0){
                    if(sumNum == 0) return true;
                    else continue out ;
                }
                if( (sumNum)%k == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
