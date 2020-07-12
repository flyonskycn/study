package com.flyonsky.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @author luowengang
 * @date 2020/7/12 17:17
 */
public class MathUtils {

    public static Double add(Double d1,Double d2,int precision){
        MathContext mathContext = new MathContext(precision, RoundingMode.HALF_UP);
        BigDecimal bd1 = null;

        BigDecimal bd2 = null;
        if(Objects.isNull(d1)){
            bd1 = new BigDecimal(0.0D);
        }else{
            bd1 = new BigDecimal(d1);
        }

        if(Objects.isNull(d2)){
            bd2 = new BigDecimal(0.0D);
        }else{
            bd2 = new BigDecimal(d2);
        }

        return bd1.add(bd2, mathContext).doubleValue();
    }

    public static Double add(Double d1,Double d2){
        return MathUtils.add(d1, d2, 2);
    }
}
