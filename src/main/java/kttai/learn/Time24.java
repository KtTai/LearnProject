package kttai.learn;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 *
 * 示例 1：
 *
 * 输入: ["23:59","00:00"]
 * 输出: 1
 *
 * 备注:
 *
 * 列表中时间数在 2~20000 之间。
 * 每个时间取值在 00:00~23:59 之间。
 */
public class Time24 {
    public int findMinDifference(List<String> timePoints) {
        LocalTime maxTime = null;
        LocalTime minTime = null;
        for(String thisTime : timePoints){
            LocalTime parse = LocalTime.parse(thisTime);

//            Duration.between()
        }
        Deque<int[]> stack = new LinkedList<>();

        return 0;
    }
}
