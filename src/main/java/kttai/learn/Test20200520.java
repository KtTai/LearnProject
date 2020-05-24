package kttai.learn;

import java.util.*;

public class Test20200520 {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,1,2,3,30,40,500};
//        int[] arr = new int[]{};
//        int[] arr = new int[]{0};
//        int[] arr = null;
        int[] arr = new int[]{1,1,1,1,1,1};

        inFun2(arr);
//        Map<Integer, Integer> integerIntegerMap = inFun(arr);
//        LinkedHashSet<Integer> integers = (LinkedHashSet<Integer>) integerIntegerMap.keySet();
//        for (Integer in : integers){
//            System.out.println(in);
//
//        }
    }

    private static void inFun2(int[] arr){
        if (arr != null){

            int preInt = 0;
            for (int i=0;i< arr.length;i++){
                int ai = arr[i];
                if (i!=0 && ai == preInt){
                    continue;
                }
                System.out.println(ai);
                preInt = ai;
            }
        }
    }

    private static Map<Integer,Integer> inFun(int[] arr){
        Map<Integer,Integer> hashMap = new LinkedHashMap<>();
        for (int i : arr){
            if (hashMap.containsKey(i)){
                continue;
            }else {
                hashMap.put(i,1);
            }
        }
        return hashMap;

    }
}
