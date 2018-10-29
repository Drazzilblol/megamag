package by.instinctools.megamag.data.announcements;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.TextUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.BuildConfig;
import by.instinctools.megamag.common.api.pojo.PageResponse;

class AnnouncementParser {

    private static final String YEAR = "Год";
    private static final String COUNTRY = "Страна";
    private static final String GENRE = "Жанр";
    private static final String AUTHOR = "Автор";
    private static final String ANNOUNCEMENT_ITEM_SELECTOR = "film_item";
    private static final String ANNOUNCEMET_HEADER_SELECTOR = "tableBoxArea1Contents";
    private static final String ANNOUNCEMENT_BODY_SELECTOR = "smallText";
    private static final String IMAGE_URL_SELECTOR = "href";

    static List<AnnouncementData> parseAnnouncements(@NonNull PageResponse response) {
        List<AnnouncementData> announcementList = new ArrayList<>();

        String body = getNormalizeBody(response);

        Document document = Jsoup.parse(body);
        document.setBaseUri(BuildConfig.BASE_URL);

        Elements announcements = document.getElementsByClass(ANNOUNCEMENT_ITEM_SELECTOR);

        for (Element announcement : announcements) {
            AnnouncementData.Builder builder = AnnouncementData.builder();
            Elements headerItems = announcement.getElementsByClass(ANNOUNCEMET_HEADER_SELECTOR);

            String eventUrl = headerItems.first()
                    .child(0)
                    .child(0)
                    .absUrl("href");
            Uri uri = Uri.parse(eventUrl);
            builder.eventId(uri.getQueryParameter("newsdesk_id"));

            String header = headerItems.text();
            String[] headerText = header.split(" / ");
            if (headerText.length < 2) {
                builder.place("");
                builder.title(header.split(" / ")[0]);
            } else {
                builder.place(header.split(" / ")[0]);
                builder.title(header.split(" / ")[1]);
            }

            Element bodyItem = announcement.getElementsByClass(ANNOUNCEMENT_BODY_SELECTOR).first();

            Element child = bodyItem.child(0);
            builder.coverUrl(child.absUrl(IMAGE_URL_SELECTOR));
            if (bodyItem.child(1).children().size() > 1) {
                builder.description(bodyItem.child(1)
                        .child(1)
                        .text());
            }

            String year = "";
            String county = "";
            String genre = "";
            String author = "";

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

    private static String getNormalizeBody(@NonNull PageResponse response) {
        return response.js.get("result_str").toString().replace("\\\"", "").replace("\\t", "").replace("\\n", "");
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
