package kttai.test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public String testFun (String a) {
        System.out.println(a);
        return a;
    }
    public static void main(String[] args) {
        /*String a = "a,b,c,";
        String[] split = a.split(",");
        for (String s : split) {
            System.out.println(s);
        }
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("","");
        for (int i=0;i<7;++i) {
            System.out.println(i);
        }*/

//        String s = a.replaceAll("[\\s\\u00A0]+", "");
//        System.out.println(s);

//        MethodHandles.Lookup lookup = MethodHandles.lookup();

      /*  String day = "2021-10-11 10:11:12";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse(day);
            System.out.println("成功");
        } catch (ParseException e) {
            System.out.println("错误");
        }*/

//        BigDecimal bigDecimal = new BigDecimal("1.542");
//        BigDecimal bigDecimal1 = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP);
//        System.out.println(bigDecimal1.toString());

        /*Set<String> objects = new HashSet<>();
        objects.add("a");
        objects.add("b");
        objects.add("c");
        Object[] objects1 = objects.toArray();

        String[] arr = {"a","d","e"};
        boolean b = objects.retainAll(Arrays.asList(arr));
        System.out.println(objects);
        Arrays.stream(arr).forEach(a -> {
            System.out.println(a);
        });
        System.out.println("============");
        Arrays.stream(objects1).forEach(a -> {
            System.out.println(a);
        });*/
//        Random random = new Random();
//
//        System.out.println(LocalTime.now());
//        for (int i = 0; i < 10; i++) {
//            int i1 = random.nextInt(10);
//            try {
//                System.out.println(i1);
//                TimeUnit.SECONDS.sleep(i1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(LocalTime.now());
        String[] a = new String[1];
        String[] strings = Arrays.copyOf(a, 2);
//        String b = "aa";
//        String[] split = b.split(",");
        System.out.println(strings);
    }
    public enum CouponType {
        DISCOUNT(1,"折扣券",1),
        CASH(2,"代金券",1),
        FREE_ROOM(3,"免房券",1),
        MEAL(4,"餐券",1),
        DEDUCTION(5,"抵扣券",1),
        HOUR(6,"小时券",1),
        DELAY(7,"延时券",2),
        UPGRADE_ROOM(8,"房型升级券",2),
        EXPERIENCE_ROOM(9,"体验券",1),
        GENERAL_ROOM(10,"通用券",2);
        private int couponTypeKey;
        private String couponTypeName;
        private int bigType;// 1 金额类 2 权益类

        public static final int BIG_TYPE_MONEY = 1;
        public static final int BIG_TYPE_EQUITY = 2;

        CouponType(int key,String name,int bigType){
            couponTypeKey = key;
            couponTypeName = name;
            this.bigType = bigType;
        }

        public int getCouponTypeKey() {
            return this.couponTypeKey;
        }

        public String getCouponTypeName() {
            return this.couponTypeName;
        }
        public int getBigType() {
            return this.bigType;
        }

        public static int getBigTypeByKey(int couponTypeKey){
            int result = 0;
            for (CouponType value : values()) {
                System.out.println(value.getCouponTypeKey());
                System.out.println(value.getCouponTypeKey() == couponTypeKey);
                System.out.println(value.getBigType());
                if (value.getCouponTypeKey() == couponTypeKey) {
                    result = value.getBigType();
                    break;
                }
            }
            System.out.println(result);
            return result;
        }
    }
}
