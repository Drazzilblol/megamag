package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.Application;
import by.instinctools.megamag.common.errors.ErrorException;
import by.instinctools.megamag.common.errors.NoDataError;
import by.instinctools.megamag.data.info.items.InfoImage;
import by.instinctools.megamag.data.info.items.InfoItem;
import by.instinctools.megamag.data.info.items.InfoText;
import by.instinctools.megamag.data.type.factory.ItemTypeFactory;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

class RemoteInfoDataSource extends InfoDataSource {

    @DebugLog
    @NonNull
    @Override
    public Observable<List<InfoData>> getAll(int infoId) {
        if (infoId == ItemTypeFactory.getHowPayType().getId()) {
            return getHowToPayInfo(infoId);
        } else if (infoId == ItemTypeFactory.getHowBookType().getId()) {
            return Observable.just(getStubBookInfo(infoId));
        } else if (infoId == ItemTypeFactory.getRulesType().getId()) {
            return getRulesInfo(infoId);
        }
        return Observable.error(new ErrorException(new NoDataError()));
    }

    @NonNull
    private Observable<List<InfoData>> getRulesInfo(int infoId) {
        return Application.getApi()
                .getRulesInfo()
                .map(document -> InfoParser.parseRules(infoId, document));
    }

    @NonNull
    private Observable<List<InfoData>> getHowToPayInfo(int infoId) {
        return Application.getApi()
                .getHowToPayInfo()
                .map(document -> InfoParser.parseHowToPay(infoId, document));
    }

    @NonNull
    private List<InfoData> getStubBookInfo(int infoId) {
        List<InfoData> infoList = new ArrayList<>();

        List<InfoItem> items1 = new ArrayList<>();
        items1.add(InfoText.builder()
                .data("Бронирование билетов доступно ТОЛЬКО зарегистрированным клиентам системы Мегамаг, поэтому первым шагом является регистрация на сайте.\n")
                .build());
        items1.add(InfoImage.builder()
                .data("http://kinoteatr.megamag.by/templates/Cinema-new/images/howbronned/step0_1.jpg")
                .build());
        items1.add(InfoText.builder()
                .data("Если регистрация прошла успешно, то в правой верхней части сайта появится надпись – ваше имя.\n")
                .build());
        items1.add(InfoImage.builder()
                .data("http://kinoteatr.megamag.by/templates/Cinema-new/images/howbronned/step0_2.jpg")
                .build());
        items1.add(InfoText.builder()
                .data("После регистрации или авторизации на сайте (для зарегистрированных ранее) можно переходить к бронированию билетов.")
                .build());

        InfoData group1 = InfoData.builder()
                .title("Регистрация. Если зарегистрированы, то пункт пропустить.")
                .infoId(infoId)
                .infoList(new ArrayList<>())
                .itemList(items1)
                .build();

        List<InfoItem> items2 = new ArrayList<>();
        items2.add(InfoText.builder()
                .data(replaceNToBr("1.1. Выбор по дате, по объекту через вспомогательную область сеансов.\n"
                        + "Вспомогательная область сеансов находится в верхней части сайта.\n"))
                .build());
        items2.add(InfoImage.builder()
                .data("http://kinoteatr.megamag.by/templates/Cinema-new/images/howbronned/step1_1_1.jpg")
                .build());
        items2.add(InfoText.builder()
                .data(replaceNToBr("После выбора времени (нажатия на выбранное время) отобразиться план зала, где будет проходить выбранное мероприятие.\n"))
                .build());
        items2.add(InfoImage.builder()
                .data("http://kinoteatr.megamag.by/templates/Cinema-new/images/howbronned/step1_1_2.jpg")
                .build());
        items2.add(InfoText.builder()
                .data(replaceNToBr("На этом изображении необходимо выбрать места. Выбранные места на плане зала окрашиваются в фиолетовый цвет. После выбора мест можно переходить в следующий этап."))
                .build());

        List<InfoData> groups = new ArrayList<>();
        groups.add(InfoData.builder()
                .title(replaceNToBr("1.1. Выбор по дате, по объекту через вспомогательную область сеансов.\t"))
                .infoId(infoId)
                .infoList(new ArrayList<>())
                .itemList(items2)
                .build());

        List<InfoItem> items3 = new ArrayList<>();
        items3.add(InfoText.builder()
                .data(replaceNToBr("Меню \"Кино и театры региона\" находится в левой части сайта, под главным меню.\n"))
                .build());
        items3.add(InfoImage.builder()
                .data("http://kinoteatr.megamag.by/templates/Cinema-new/images/howbronned/step1_2_1.jpg")
                .build());
        items3.add(InfoText.builder()
                .data(replaceNToBr("Выбрать (нажать на название) необходимый объект из списка\n"
                        + "После выбора кино или мероприятия, ниже выбираем время (нажатие на выбранное время). Отобразиться план зала, где будет проходить выбранное мероприятие.\n"))
                .build());
        items3.add(InfoImage.builder()
                .data("http://kinoteatr.megamag.by/templates/Cinema-new/images/howbronned/step1_2_2.jpg")
                .build());
        items3.add(InfoText.builder()
                .data(replaceNToBr("На этом изображении необходимо выбрать места. Выбранные места на плане зала окрашиваются в фиолетовый цвет. После выбора мест можно переходить в следующий этап."))
                .build());

        groups.add(InfoData.builder()
                .title(replaceNToBr("1.2. Выбор по объекту из левого меню \"Кино и театры региона\".\t"))
                .infoId(infoId)
                .itemList(items3)
                .infoList(new ArrayList<>())
                .build());

        InfoData group2 = InfoData.builder()
                .title(replaceNToBr("1. Выбор даты, места и время мероприятия."))
                .infoList(groups)
                .itemList(new ArrayList<>())
                .infoId(infoId)
                .build();

        infoList.add(group1);
        infoList.add(group2);
        return infoList;
    }

    @NonNull
    private String replaceNToBr(String str) {
        return str.replaceAll("\n", "<br>");
    }
}
