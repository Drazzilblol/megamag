package by.instinctools.megamag.data.info.parsers;

import android.support.annotation.NonNull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.data.info.InfoData;
import by.instinctools.megamag.data.info.items.InfoImage;
import by.instinctools.megamag.data.info.items.InfoItem;
import by.instinctools.megamag.data.info.items.InfoText;

public class InfoParser {

    public static List<InfoData> parseRules(int infoId, @NonNull String sourceHtml) {
        Document document = Jsoup.parse(sourceHtml);
        Elements rulesElement = document.select("tbody:contains(Правила киновидеообслуживания населения)");
        ArrayList<InfoItem> items = new ArrayList<>();
        List<InfoData> infoList = new ArrayList<>();

        items.add(InfoText.builder()
                .data(rulesElement.last().html())
                .build());

        infoList.add(
                InfoData.builder()
                        .infoId(infoId)
                        .infoList(new ArrayList<>())
                        .itemList(items)
                        .build());
        return infoList;
    }

    public static List<InfoData> parseHowToTay(int infoId, @NonNull String sourceHtml) {
        Document document = Jsoup.parse(sourceHtml);

        List<InfoData> infoList = new ArrayList<>();

        for (int i = 1; i < 6; i++) {
            ArrayList<InfoItem> items = new ArrayList<>();
            Element firstMethod = document.getElementById("steps_var" + i);
            Elements steps = firstMethod.children();
            for (Element element : steps) {
                if (element.hasText()) {
                    items.add(InfoText.builder()
                            .data(element.html())
                            .build());
                } else {
                    items.add(InfoImage.builder()
                            .data(element.children().first().absUrl("src"))
                            .build());
                }
            }

            infoList.add(
                    InfoData.builder()
                            .title(firstMethod.parent().child(0).child(i).text())
                            .infoId(infoId)
                            .infoList(new ArrayList<>())
                            .itemList(items)
                            .build());
        }

        return infoList;
    }
}
