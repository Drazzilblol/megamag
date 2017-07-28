package by.instinctools.megamag.common.utils;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import timber.log.Timber;

public final class TimeUtils {

    private static String[] russianMonths = {
            "Январь",
            "Февраль",
            "Март",
            "Апрель",
            "Май",
            "Июнь",
            "Июль",
            "Август",
            "Сентябрь",
            "Октябрь",
            "Ноябрь",
            "Декабрь"
    };

    private static String[] russianDays = {
            "Суббота",
            "Воскресенье",
            "Понедельник",
            "Вторник",
            "Среда",
            "Четверг",
            "Пятница"
    };

    public static boolean isSessionBegin(String time, String day) {
        DateFormatSymbols russSymbol = new DateFormatSymbols();
        russSymbol.setMonths(russianMonths);
        russSymbol.setWeekdays(russianDays);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm d MMMM, EEEE", russSymbol);

        String currentTime = sdf.format(new Date());
        boolean isSessionBegin = false;

        try {
            Date current = sdf.parse(currentTime);
            Date sessionTime = sdf.parse(time + " " + day);
            isSessionBegin = current.after(sessionTime);
        } catch (ParseException e) {
            Timber.e(e);
        }

        return isSessionBegin;
    }
}
