package com.uniyaz.note.service;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Kübra VARICI
 */
public class DateService {
    /**
     * Günün tarihini saatsiz olarak döndürür.
     */
    public static Date getTodayDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }
}
