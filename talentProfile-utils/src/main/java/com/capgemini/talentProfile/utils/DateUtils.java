package com.capgemini.talentProfile.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

    /**
     * Convert a date to a string.
     * @param date
     * @param format
     * @return
     */
    public static String dateToString (Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * Convert a String (if is a date) to a Date.
     * @param inDate
     * @return
     */
    public static Date stringToDate(String inDate) {
        Date date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        try {
            date = dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return null;
        }
        return date;
    }

    /**
     *
     * @param birthday
     * @return
     */
    public static int getAgeFromBirthday(String birthday) {
        Date toDay = new Date();
        LocalDate currentDate = toDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate birthDate = LocalDate.parse(birthday);

        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

}
