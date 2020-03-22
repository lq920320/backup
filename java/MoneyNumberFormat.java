import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author liuqian
 * @date 2019/9/4 12:55
 */
public class MoneyNumberFormat {

    @Test
    public void formatTest() {
        String s1 = "15.0";
        String s2 = "12.02";
        String s3 = "0.0";
        Double a = Double.valueOf(s1);
        Double b = Double.valueOf(s2);
        Double c = Double.valueOf(s3);
        BigDecimal x = new BigDecimal(s1);
        BigDecimal y = new BigDecimal(s2);
        BigDecimal z = new BigDecimal(s3);

        String pattern1 = "#.00";
        DecimalFormat df1 = new DecimalFormat(pattern1);
        String pattern2 = "#0.00";
        DecimalFormat df2 = new DecimalFormat(pattern2);
        //15.00
        //12.02
        //.00
        //************************
        //15.00
        //12.02
        //0.00
        //------------------------------------
        //15.00
        //12.02
        //.00
        //************************
        //15.00
        //12.02
        //0.00
        System.out.println(df1.format(a));
        System.out.println(df1.format(b));
        System.out.println(df1.format(c));
        System.out.println("************************");
        System.out.println(df2.format(a));
        System.out.println(df2.format(b));
        System.out.println(df2.format(c));
        System.out.println("------------------------------------");
        System.out.println(df1.format(x));
        System.out.println(df1.format(y));
        System.out.println(df1.format(z));
        System.out.println("************************");
        System.out.println(df2.format(x));
        System.out.println(df2.format(y));
        System.out.println(df2.format(z));
    }
}
