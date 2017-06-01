package by.instinctools.megamag.data.tickets;

import android.support.annotation.NonNull;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

class TicketParser {

    private static final String IMAGE_URL_SELECTOR = "src";
    private static final String TICKET_ITEM_SELECTOR = "cinema_today_event";
    private static final String TICKET_IMAGE_SELECTOR = "cinema_today_image";
    private static final String TICKET_TITLE_SELECTOR = "cinema_today_title";
    private static final String TICKET_DATE_SELECTOR = "cinema_today_date";

    static List<TicketData> parseTickets(@NonNull Document document) {
        List<TicketData> ticketList = new ArrayList<>();
        Elements tickets = document.getElementsByClass(TICKET_ITEM_SELECTOR);
        for (Element ticket : tickets) {
            String imgUrl = getHQCover(ticket.getElementsByClass(TICKET_IMAGE_SELECTOR)
                    .first()
                    .child(0)
                    .child(0)
                    .absUrl(IMAGE_URL_SELECTOR));

            ticketList.add(TicketData.builder()
                    .title(ticket.getElementsByClass(TICKET_TITLE_SELECTOR).text())
                    .beginsWith(ticket.getElementsByClass(TICKET_DATE_SELECTOR).text())
                    .coverUrl(imgUrl)
                    .build());
        }
        return ticketList;
    }

    private static String getHQCover(@NonNull String url) {
        return url.replace("categories_sec", "newsdesk_img")
                .replace("_6", "_b1");
    }
}
