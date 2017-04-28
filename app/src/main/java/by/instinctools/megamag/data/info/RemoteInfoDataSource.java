package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class RemoteInfoDataSource implements InfoDataSource {

    @Override
    public Observable<InfoData> getValue(@NonNull String key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Observable<InfoData> saveValue(@NonNull String key, @NonNull InfoData value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Observable<List<InfoData>> getAll() {
        return Observable.just(getStubInfo());
    }

    public Observable<List<InfoData>> getAll(String infoId) {
        return Observable.just(getStubInfo());
    }

    @Override
    public Observable<List<InfoData>> saveAll(List<InfoData> collection) {
        throw new UnsupportedOperationException();
    }

    private List<InfoData> getStubInfo() {
        List<InfoData> infoList = new ArrayList<>();
        infoList.add(
                InfoData.builder()
                        .title("Метод оплаты \"ЕРИП\". Вариант оплаты с использованием Интернет-банкинга.")
                        .text("Пункт 1. Зайти на сайт Интернет-Банка\n" +
                                "Оплата ЕРИП поддерживается интернет-банкингом более 20 банков. Выберите свой банк из списка и нажмите для перехода на страницу авторизации):\n" +
                                "- ОАО «БПС-Сбербанк»\n" +
                                "- ОАО «Белагропромбанк»\n" +
                                "- ОАО «Хоум Кредит Банк»\n" +
                                "- ОАО «Паритетбанк»\n" +
                                "- ЗАО «Альфа-Банк»\n" +
                                "- ЗАО «БелСвиссБанк»\n" +
                                "- «Приорбанк» ОАО\n" +
                                "- «Франсабанк» ОАО\n" +
                                "- ЗАО «Трастбанк»\n" +
                                "- ОАО «АСБ Беларусбанк»\n" +
                                "- ЗАО «МТБанк»\n" +
                                "- ЗАО «Дельта Банк»\n" +
                                "- ОАО «Белгазпромбанк»\n" +
                                "- ЗАО «БТА Банк»\n" +
                                "- ОАО «Белорусский банк развития и реконструкции «Белинвестбанк»\n" +
                                "- ОАО «БНБ-Банк»\n" +
                                "- ОАО \"Банк БелВЭБ»\n" +
                                "- ОАО \"Технобанк\"\n" +
                                "- ОАО \"Банк Москва-Минск\"\n" +
                                "- ЗАО \"РРБ-Банк\"\n" +
                                "Изображение с примером (ниже текста) относится к интернет-банкингу от ОАО \"Банк БелВЭБ», ЗАО \"Альфа-Банк\", ОАО \"Банк Москва-Минск\", ЗАО \"БелСвиссБанк\", ЗАО \"РРБ-Банк\".\n" +
                                "Для остальных интернет-банкингов делать все по аналогии.\n" +
                                "\n" +
                                "Пункт 2. Выбрать в Платежах \"Билеты kinoteatr.megamag.by\"\n" +
                                "Найдите в меню платежей \"Платежи Расчет\",\"Система Расчет\", \"Оплата ЕРИП\" или т.п.\n" +
                                "Появится список категорий платежей, в котором нужно выбрать \"Оплата билетов\".\n" +
                                "Далее выбираем \"ООО МагСоюз\", а затем \"Билеты kinoteatr.megamag.by\"\n" +
                                "Изображение с примером (ниже текста) относится к интернет-банкингу от ОАО \"Технобанк\", ОАО \"Банк БелВЭБ», ЗАО \"Альфа-Банк\", ОАО \"Банк Москва-Минск\", ЗАО \"БелСвиссБанк\", ЗАО \"РРБ-Банк\".\n" +
                                "Для остальных интернет-банкингов делать все по аналогии.\n" +
                                "\n" +
                                "Пункт 3. Ввести номер заказа\n" +
                                "Введите номер Вашего заказа и нажмите кнопку \"Далее\". Номер заказа можно увидеть в Кабинете пользователя, в Истории заказов, а также в письме, которое автоматически отправляется на электронную почту после оформления заказа.\n" +
                                "\n" +
                                "Пункт 4. Подтвердить оплату\n" +
                                "В следующем окне будет отображена информация по заказу: содержание и стоимость. Проверьте информацию о билетах, которые собираетесь оплачивать, и нажмите кнопку \"Далее\".\n" +
                                "\n" +
                                "Пункт 5. Завершить оплату\n" +
                                "Завершите платеж путем ввода срока действия карточки и персонального пароля.")
                        .build()
        );

        infoList.add(
                InfoData.builder()
                        .title("Метод оплаты \"ЕРИП\". Вариант оплаты с банкомата или инфокиоска.")
                        .text("Пункт 1. Выбрать в Платежах \"Билеты kinoteatr.megamag.by\".\n" +
                                "Оплата возможна с использованием следующих типов терминалов - скачать\n" +
                                "У каждого банкомата и инфокиоска свои особенности выбора пункта платежа \"Билеты kinoteatr.megamag.by\".\n" +
                                "Для банков ОАО \"Технобанк\", ОАО \"Банк БелВЭБ», ЗАО \"Альфа-Банк\", ОАО \"Банк Москва-Минск\", ЗАО \"БелСвиссБанк\", ЗАО \"РРБ-Банк\" в банкоматах и инфокиосках установлена одинаковая система работы с покупателем. Опишем для них способ выбора услуги, для других он будет схож. Выбрать пункт \"ОПЛАТА УСЛУГ\". Далее пункт меню \"СИСТЕМА \"РАСЧЕТ\" (ЕРИП)\". Следующим выбрать \"Оплата билетов\". Отобразится страница с списком поставщиков услуг. На первой странице не будет нужного пункта меню. Нажимаем кнопку \"Вперед\", пока не появится ООО \"МагСоюз\". Выбираем этот пункт меню и затем выбираем \"Билеты kinoteatr.megamag.by\"\n" +
                                "\n" +
                                "Пункт 2. Ввести номер заказа\n" +
                                "Введите номер Вашего заказа и нажмите кнопку \"Далее\". Номер заказа можно увидеть в Кабинете пользователя, в Истории заказов, а также в письме, которое автоматически отправляется на электронную почту после оформления заказа.\n" +
                                "\n" +
                                "Пункт 3. Подтвердить оплату\n" +
                                "В следующем окне будет отображена информация по заказу: содержание и стоимость. Проверьте информацию о билетах, которые собираетесь оплачивать и нажмите кнопку \"Далее\".\n" +
                                "\n" +
                                "Пункт 4. Завершить оплату\n" +
                                "Завершите платеж путем ввода персонального пин кода пластиковой банковской карточки.")
                        .build()
        );


        return infoList;
    }
}
