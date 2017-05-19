package by.instinctools.megamag.data.event_details_info;

import android.support.annotation.NonNull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class EventInfoParser {

    private static final String DETAILS_IMAGE_SELECTOR = "image-popup-fit-width";
    private static final String VIDEO_URL_SELECTOR = "href";

    static EventInfoData parseEventInfo(@NonNull Document document) {
        Element infoItem = document.getElementsByClass(DETAILS_IMAGE_SELECTOR).first().parent();

        EventInfoData.Builder builder = EventInfoData.builder();

        Elements textItems = infoItem.select("p");

        String details = getText(textItems.get(0));
        builder.details(details);

        StringBuilder description = new StringBuilder();
        for (int i = 1; i < textItems.size(); i++) {
            if (textItems.get(i).hasText()) {
                description.append(getText(textItems.get(i)));
                description.append("\n");
            }
        }
        builder.description(description.toString());

        Elements videoItem = document.select("strong:contains(Кликните по иконке(ам) для просмотра видеофайлов:)");
        if (videoItem.size() != 0) {
            builder.trailerUrl(videoItem.last()
                    .parent()
                    .children()
                    .last()
                    .child(0)
                    .absUrl(VIDEO_URL_SELECTOR));
        }

        return builder.build();
    }

    private static String getText(Element textItem) {
        return textItem.html().replace("<br>", "\n")
                .replace("<strong>", "")
                .replace("</strong>", "")
                .replace("<span>", "")
                .replace("</span>", "")
                .replace("&nbsp;", "");
    }
}
