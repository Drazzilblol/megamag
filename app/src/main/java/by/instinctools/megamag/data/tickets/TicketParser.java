package by.instinctools.megamag.data.tickets;

import android.support.annotation.NonNull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

class TicketParser {

    static List<TicketData> parseTickets(@NonNull String sourceHtml) {
        Document document = Jsoup.parse(sourceHtml);
        List<TicketData> ticketList = new ArrayList<>();
        Elements tickets = document.getElementsByClass("cinema_today_event");
        for (Element ticket : tickets) {
            String imgUrl = getHQCover(ticket.getElementsByClass("cinema_today_image").first().child(0).child(0).absUrl("src"));

            ticketList.add(TicketData.builder()
                    .title(ticket.getElementsByClass("cinema_today_title").text())
                    .beginsWith(ticket.getElementsByClass("cinema_today_date").text())
                    .coverUrl(imgUrl)
                    .build());
        }
        return ticketList;
    }

    private static String getHQCover(String url) {
        return url.replace("categories_sec", "newsdesk_img").replace("_6", "_b1");
    }
}
