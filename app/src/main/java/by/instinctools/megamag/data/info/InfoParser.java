package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.data.info.items.InfoImage;
import by.instinctools.megamag.data.info.items.InfoItem;
import by.instinctools.megamag.data.info.items.InfoText;

class InfoParser {

    private static final String INFO_RULES_SELECTOR = "tbody:contains(Правила киновидеообслуживания населения)";
    private static final String IMAGE_URL_SELECTOR = "src";
    private static final String PAY_STEPS_SELECTOR = "steps_var";
    private static final int STEPS_COUNT = 6;

    static List<InfoData> parseRules(int infoId, @NonNull Document document) {
        Elements rulesElement = document.select(INFO_RULES_SELECTOR);
        ArrayList<InfoItem> items = new ArrayList<>();
        List<InfoData> infoList = new ArrayList<>();

        items.add(InfoText.builder()
                .data(rulesElement.last()
                        .html())
                .build());

        infoList.add(
                InfoData.builder()
                        .infoId(infoId)
                        .infoList(new ArrayList<>())
                        .itemList(items)
                        .build());
        return infoList;
    }

    static List<InfoData> parseHowToPay(int infoId, @NonNull Document document) {
        List<InfoData> infoList = new ArrayList<>();

        for (int i = 1; i < STEPS_COUNT; i++) {
            ArrayList<InfoItem> items = new ArrayList<>();
            Element infoItem = document.getElementById(PAY_STEPS_SELECTOR + i);
            Elements steps = infoItem.children();
            for (Element element : steps) {
                if (element.hasText()) {
                    items.add(InfoText.builder()
                            .data(element.html())
                            .build());
                } else {
                    items.add(InfoImage.builder()
                            .data(element.children()
                                    .first()
                                    .absUrl(IMAGE_URL_SELECTOR))
                            .build());
                }
            }

            infoList.add(
                    InfoData.builder()
                            .title(infoItem.parent()
                                    .child(0)
                                    .child(i)
                                    .text())
                            .infoId(infoId)
                            .infoList(new ArrayList<>())
                            .itemList(items)
                            .build());
        }

        return infoList;
    }
}
