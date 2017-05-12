package by.instinctools.megamag.data.announcements;

import android.support.annotation.NonNull;
import android.text.Html;
import android.text.TextUtils;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

class AnnouncementParser {

    private static final String YEAR = "Год";
    private static final String COUNTRY = "Страна";
    private static final String GENRE = "Жанр";
    private static final String AUTHOR = "Автор";
    private static final String ANNOUNCEMENTS_LIST_SELECTOR = "newsdesk_sticky";
    private static final String ANNOUNCEMENT_ITEM_SELECTOR = "film_item";
    private static final String ANNOUNCEMET_HEADER_SELECTOR = "tableBoxArea1Contents";
    private static final String ANNOUNCEMENT_BODY_SELECTOR = "smallText";
    private static final String IMAGE_URL_SELECTOR = "href";

    static List<AnnouncementData> parseAnnouncements(@NonNull Document document) {
        List<AnnouncementData> announcementList = new ArrayList<>();

        Element announcementsRoot = document.getElementById(ANNOUNCEMENTS_LIST_SELECTOR);
        Elements announcements = announcementsRoot.getElementsByClass(ANNOUNCEMENT_ITEM_SELECTOR);

        for (Element announcement : announcements) {
            AnnouncementData.Builder builder = AnnouncementData.builder();
            Elements headerItems = announcement.getElementsByClass(ANNOUNCEMET_HEADER_SELECTOR);
            String header = headerItems.text();
            builder.place(header.split(" / ")[0]);
            builder.title(header.split(" / ")[1]);

            Element bodyItem = announcement.getElementsByClass(ANNOUNCEMENT_BODY_SELECTOR).first();
            builder.coverUrl(bodyItem.child(0).absUrl(IMAGE_URL_SELECTOR));
            if (bodyItem.child(1).children().size() > 1) {
                builder.description(bodyItem.child(1)
                        .child(1)
                        .text());
            }

            String year = null;
            String county = null;
            String genre = null;
            String author = null;

            String[] detailsItem = bodyItem.child(1)
                    .child(0)
                    .html()
                    .split("<br>");
            for (String aDetailsItem : detailsItem) {
                if (aDetailsItem.contains(YEAR)) {
                    year = aDetailsItem.substring(aDetailsItem.lastIndexOf("> ") + 2);
                }
                if (aDetailsItem.contains(COUNTRY)) {
                    county = aDetailsItem.substring(aDetailsItem.lastIndexOf("> ") + 2);
                }
                if (aDetailsItem.contains(GENRE)) {
                    genre = aDetailsItem.substring(aDetailsItem.lastIndexOf("> ") + 2);
                }
                if (aDetailsItem.contains(AUTHOR)) {
                    author = aDetailsItem.substring(aDetailsItem.lastIndexOf("> ") + 2);
                }
            }

            builder.details(buildDetails(year, county, genre, author));

            announcementList.add(builder.build());
        }
        return announcementList;
    }

    private static String buildDetails(String year, String country, String genre, String author) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(author)) {
            stringBuilder.append(author + " /");
        }
        stringBuilder.append(country);
        if (!TextUtils.isEmpty(year)) {
            stringBuilder.append("(" + year + ")");
        }
        stringBuilder.append(genre);
        return Html.fromHtml(stringBuilder.toString()).toString();
    }
}
