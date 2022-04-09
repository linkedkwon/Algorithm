package baekjoon.implementation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class P10699 {

    public static void main(String[] args){
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        df.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        System.out.format(df.format(date));
    }

}