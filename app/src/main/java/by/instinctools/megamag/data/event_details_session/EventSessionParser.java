package by.instinctools.megamag.data.event_details_session;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

class EventSessionParser {

    private static final String DETAILS_HEADER_SELECTOR = "tableBoxArea1Contents";

    static List<EventSessionData> parseSession(@NonNull String sourceHtml) {
        Document document = Jsoup.parse(sourceHtml);

        List<EventSessionData> resultList = new ArrayList<>();
        Elements headerItems = document.getElementsByClass(DETAILS_HEADER_SELECTOR);
        Elements sessions = getSessions(headerItems);
        for (int i = 1; i < sessions.size(); i += 2) {
            String placeName = sessions.get(i).text();
            Elements hallSessions = sessions.get(i + 1)
                    .child(0)
                    .child(0)
                    .child(0)
                    .children();
            String hallName = hallSessions.get(1).text();
            for (int j = 2; j < hallSessions.size(); j++) {
                String day = hallSessions.get(j).child(0).text();
                Elements times = hallSessions.get(j).children();
                for (int k = 1; k < times.size() - 1; k++) {
                    Element time = times.get(k);
                    if (!TextUtils.equals(time.text(), "-")) {
                        EventSessionData.Builder builder = EventSessionData.builder();
                        builder.place(placeName);
                        builder.hall(hallName);
                        builder.day(day);
                        builder.time(time.text());
                        resultList.add(builder.build());
                    }
                }
            }
        }
        Timber.i(resultList.toString());
        return resultList;
    }

    private static Elements getSessions(Elements headerItems) {
        return headerItems.first()
                .parent()
                .parent()
                .parent()
                .parent()
                .parent()
                .parent()
                .child(2)
                .child(0)
                .child(0)
                .child(0)
                .children();
    }

}
