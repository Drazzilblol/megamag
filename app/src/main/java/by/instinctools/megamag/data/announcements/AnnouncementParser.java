package by.instinctools.megamag.data.announcements;

import android.support.annotation.NonNull;
import android.text.Html;
import android.text.TextUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

class AnnouncementParser {

    static List<AnnouncementData> parseAnnouncements(@NonNull String sourceHtml) {
        Document document = Jsoup.parse(sourceHtml);
        List<AnnouncementData> announcementList = new ArrayList<>();

        Element announcementsRoot = document.getElementById("newsdesk_sticky");
        Elements announcements = announcementsRoot.getElementsByClass("film_item");

        for (Element announcement : announcements) {
            AnnouncementData.Builder builder = AnnouncementData.builder();
            Elements headerItems = announcement.getElementsByClass("tableBoxArea1Contents");
            String header = headerItems.text();
            builder.place(header.split(" / ")[0]);
            builder.title(header.split(" / ")[1]);

            Element bodyItem = announcement.getElementsByClass("smallText").first();
            builder.coverUrl(bodyItem.child(0).absUrl("href"));
            if (bodyItem.child(1).children().size() > 1) {
                builder.description(bodyItem.child(1).child(1).text());
            }

            String year = null;
            String county = null;
            String genre = null;
            String author = null;

            String[] detailsItem = bodyItem.child(1).child(0).html().split("<br>");
            for (int i = 0; i < detailsItem.length; i++) {
                if (detailsItem[i].contains("Год")) {
                    year = detailsItem[i].substring(detailsItem[i].lastIndexOf("> ") + 2);
                }
                if (detailsItem[i].contains("Страна")) {
                    county = detailsItem[i].substring(detailsItem[i].lastIndexOf("> ") + 2);
                }
                if (detailsItem[i].contains("Жанр")) {
                    genre = detailsItem[i].substring(detailsItem[i].lastIndexOf("> ") + 2);
                }
                if (detailsItem[i].contains("Автор")) {
                    author = detailsItem[i].substring(detailsItem[i].lastIndexOf("> ") + 2);
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
