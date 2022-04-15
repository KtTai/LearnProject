package kttai.house;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.YearMonth;

public class CalcHM {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("calcHM");
        String allMStr = "540000";// 总额
        int allYear = 10;
        String startY = "2020";
        String startM = "01";
        String interestStr = "0.00449";// 利息
        String everyMonthCutStr = "5943.99";//每月扣
        BigDecimal allM = new BigDecimal(allMStr);
        BigDecimal interest = new BigDecimal(interestStr);
        BigDecimal everyMonthCut = new BigDecimal(everyMonthCutStr);
        BigDecimal allInterest = new BigDecimal(0);//总利息

        BigDecimal restM = allM;// 余额

        YearMonth startYM = YearMonth.of(Integer.parseInt(startY), Integer.parseInt(startM));
        YearMonth thisYM = startYM;
        YearMonth endYM = startYM.plusYears(allYear);

        int passMonth = 0;//经过月数

        for (;thisYM.isBefore(endYM);thisYM = thisYM.plusMonths(1)){
            BigDecimal thisMonthInterest = restM.multiply(interest);// 当月利息
            allInterest = allInterest.add(thisMonthInterest);
            BigDecimal divide = everyMonthCut.subtract(thisMonthInterest);// 当月还款
            restM = restM.subtract(divide);
            if (restM.compareTo(BigDecimal.ZERO) <= 0 ) {
                logger.info("end {}年{}月; 利息:{}; 还款:{};剩余:{};已扣总利息:{}",
                        thisYM.getYear(),
                        thisYM.getMonth().getValue(),
                        thisMonthInterest.setScale(2,BigDecimal.ROUND_HALF_UP).toString(),
                        divide.setScale(2,BigDecimal.ROUND_HALF_UP).toString(),
                        restM.setScale(2,BigDecimal.ROUND_HALF_UP).toString(),
                        allInterest.setScale(2,BigDecimal.ROUND_HALF_UP).toString()
                );
                break;
            }
            passMonth++;
            logger.info("{}年{}月;    利息:{};  还款:{};  剩余:{};  已扣总利息:{}",
                    thisYM.getYear(),
                    thisYM.getMonth().getValue(),
                    thisMonthInterest.setScale(2,BigDecimal.ROUND_HALF_UP).toString(),
                    divide.setScale(2,BigDecimal.ROUND_HALF_UP).toString(),
                    restM.setScale(2,BigDecimal.ROUND_HALF_UP).toString(),
                    allInterest.setScale(2,BigDecimal.ROUND_HALF_UP).toString()
                    );
        }

    }
}
