package by.instinctools.megamag.data.event_details_main;

import android.support.annotation.NonNull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

class EventParser {

    private static final String DETAILS_HEADER_SELECTOR = "tableBoxArea1Contents";
    private static final String DETAILS_IMAGE_SELECTOR = "image-popup-fit-width";
    private static final String IMAGE_URL_SELECTOR = "href";

    static List<EventData> parseEvent(@NonNull Document document) {
        List<EventData> events = new ArrayList<>();

        EventData.Builder builder = EventData.builder();
        Elements headerItems = document.getElementsByClass(DETAILS_HEADER_SELECTOR);
        String header = headerItems.text();
        builder.title(header.split(" / ")[1]);

        Elements imageHQ = document.getElementsByClass(DETAILS_IMAGE_SELECTOR);

        builder.coverUrl(imageHQ.first().absUrl(IMAGE_URL_SELECTOR));

        events.add(builder.build());

        return events;
    }
}
