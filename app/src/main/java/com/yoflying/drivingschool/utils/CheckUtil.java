package com.yoflying.drivingschool.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**信息校验工具类
 * Created by yaojiulong on 2016/12/28.
 */

public class CheckUtil {

    //验证身份证号码
    public static boolean idCardNumber(String number) {
        String rgx = "^\\d{15}|^\\d{17}([0-9]|X|x)$";

        return isCorrect(rgx, number);
    }

    //正则验证
    private static boolean isCorrect(String rgx, String res) {
        Pattern p = Pattern.compile(rgx);

        Matcher m = p.matcher(res);

        return m.matches();
    }


}