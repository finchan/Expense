package com.xavier.expense.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Xavier on 2016-06-26.
 */
public class Utilities {

    /**
     * Date Format - toString based on assigned Date Pattern
     */
    public static String getDateYYYYMMDD( String datePattern, Date date) {
        SimpleDateFormat df = new SimpleDateFormat( datePattern );
        return df.format(date);
    }
}
