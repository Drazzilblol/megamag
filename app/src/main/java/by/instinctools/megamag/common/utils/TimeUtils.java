package by.instinctools.megamag.common.utils;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.instinctools.megamag.domain.models.EventSession;

public final class TimeUtils {

    public static boolean isSessionBegin(EventSession session) {
        String time = session.getTime();
        String day = session.getDay();
        String[] russianMonths = {
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

        String[] russianDays = {
                "Суббота",
                "Воскресенье",
                "Понедельник",
                "Вторник",
                "Среда",
                "Четверг",
                "Пятница"
        };
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
            e.printStackTrace();
        }

        return isSessionBegin;
    }
}
