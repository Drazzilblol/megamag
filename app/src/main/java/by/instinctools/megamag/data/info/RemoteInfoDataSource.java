package by.instinctools.megamag.data.info;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class RemoteInfoDataSource implements InfoDataSource {

    public static final String HOW_PAY = "how_pay";
    public static final String HOW_BOOK = "how_book";
    public static final String RULES = "rules";

    @NonNull
    @Override
    public Observable<InfoData> getValue(@NonNull String key) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<InfoData> saveValue(@NonNull String key, @NonNull InfoData value) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @Override
    public Observable<List<InfoData>> getAll() {

        throw new UnsupportedOperationException();
    }

    @NonNull
    public Observable<List<InfoData>> getAll(@NonNull String infoId) {
        if (TextUtils.equals(infoId, HOW_PAY)) {
            return Observable.just(getStubPayInfo(infoId));
        } else if (TextUtils.equals(infoId, HOW_BOOK)) {
            return Observable.just(getStubBookInfo(infoId));
        } else {
            return Observable.just(getStubRulesInfo(infoId));
        }
    }

    @NonNull
    @Override
    public Observable<List<InfoData>> saveAll(List<InfoData> collection) {
        throw new UnsupportedOperationException();
    }

    private List<InfoData> getStubPayInfo(@NonNull String infoId) {
        List<InfoData> infoList = new ArrayList<>();
        List<InfoData> list1 = new ArrayList<>();
        list1.add(InfoData.builder()
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
                .infoList(new ArrayList<InfoData>())
                .infoId(infoId)
                .build());

        InfoData g1 = InfoData.builder()
                .title("Метод оплаты \"ЕРИП\". Вариант оплаты с использованием Интернет-банкинга.")
                .infoId(infoId)
                .infoList(list1)
                .build();

        List<InfoData> list2 = new ArrayList<>();
        list2.add(InfoData.builder()
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
                .infoId(infoId)
                .infoList(new ArrayList<InfoData>())
                .build());

        InfoData g2 = InfoData.builder()
                .title("Метод оплаты \"ЕРИП\". Вариант оплаты с банкомата или инфокиоска.")
                .infoId(infoId)
                .infoList(list2)
                .build();

        infoList.add(g1);
        infoList.add(g2);
        return infoList;
    }

    private List<InfoData> getStubBookInfo(@NonNull String infoId) {
        List<InfoData> infoList = new ArrayList<>();
        List<InfoData> list1 = new ArrayList<>();
        list1.add(
                InfoData.builder()
                        .text("Бронирование билетов доступно ТОЛЬКО зарегистрированным клиентам системы Мегамаг, поэтому первым шагом является регистрация на сайте.\n" +
                                "\n" +
                                "Если регистрация прошла успешно, то в правой верхней части сайта появится надпись – ваше имя.\n" +
                                "\n" +
                                "После регистрации или авторизации на сайте (для зарегистрированных ранее) можно переходить к бронированию билетов.")
                        .infoId(infoId)
                        .infoList(new ArrayList<InfoData>())
                        .build()
        );

        InfoData g1 = InfoData.builder()
                .title("Регистрация. Если зарегистрированы, то пункт пропустить.")
                .infoId(infoId)
                .infoList(list1)
                .build();
        infoList.add(g1);

        List<InfoData> list2 = new ArrayList<>();
        list2.add(InfoData.builder()
                .title("1.1. Выбор по дате, по объекту через вспомогательную область сеансов.\t")
                .text("1.1. Выбор по дате, по объекту через вспомогательную область сеансов.\n" +
                        "Вспомогательная область сеансов находится в верхней части сайта.\n" +
                        "\n" +
                        "После выбора времени (нажатия на выбранное время) отобразиться план зала, где будет проходить выбранное мероприятие.\n" +
                        "\n" +
                        "На этом изображении необходимо выбрать места. Выбранные места на плане зала окрашиваются в фиолетовый цвет. После выбора мест можно переходить в следующий этап.")
                .infoId(infoId)
                .infoList(new ArrayList<InfoData>())
                .build());
        list2.add(InfoData.builder()
                .title("1.2. Выбор по объекту из левого меню \"Кино и театры региона\".\t")
                .text("Меню \"Кино и театры региона\" находится в левой части сайта, под главным меню.\n" +
                        "\n" +
                        "Выбрать (нажать на название) необходимый объект из списка\n" +
                        "После выбора кино или мероприятия, ниже выбираем время (нажатие на выбранное время). Отобразиться план зала, где будет проходить выбранное мероприятие.\n" +
                        "\n" +
                        "На этом изображении необходимо выбрать места. Выбранные места на плане зала окрашиваются в фиолетовый цвет. После выбора мест можно переходить в следующий этап.")
                .infoId(infoId)
                .infoList(new ArrayList<InfoData>())
                .build());

        InfoData g2 = InfoData.builder()
                .title("1. Выбор даты, места и время мероприятия.")
                .infoList(list2)
                .infoId(infoId)
                .build();
        infoList.add(g2);

        List<InfoData> list3 = new ArrayList<>();
        list3.add(
                InfoData.builder()
                        .text("На открывшейся странице нужно ознакомиться с условиями и правилами работы системы и поставить соответствующие отметки об ознакомлении с правилами бронирования\n" +
                                "\n" +
                                "и о принятии/непринятии условий договора.\n" +
                                "\n" +
                                "В случае, если Вы согласны с правилами и условиями, можно переходить в следующий этап.")
                        .infoId(infoId)
                        .infoList(new ArrayList<InfoData>())
                        .build()
        );

        InfoData g3 = InfoData.builder()
                .title("2. Условия и правила")
                .infoId(infoId)
                .infoList(list3)
                .build();
        infoList.add(g3);

        return infoList;
    }

    private List<InfoData> getStubRulesInfo(@NonNull String infoId) {
        List<InfoData> infoList = new ArrayList<>();

        infoList.add(
                InfoData.builder()
                        .text("Правила киновидеообслуживания населения\n" +
                                "Договор на оказание услуг между пользователем и ООО «МагСоюз»\n" +
                                "Термины и определения.\n" +
                                "МагСоюз — Общество с ограниченной ответственностью «МагСоюз».\n" +
                                "Пользователь — дееспособное физическое лицо, достигшее 18 летнего возраста, имеющее законное право вступать в договорные отношения , в том числе размещать заказ или бронировать услуги на сайте kinoteatr.megamag.by, либо указанное в качестве получателя услуги, либо иным образом пользующееся услугами, оформленными на сайте kinoteatr.megamag.by , исключительно для личных, домашних и иных нужд, не связанных с осуществлением предпринимательской деятельности.\n" +
                                "Сайт — веб-сайт МагСоюза в сети интернет, расположенный по адресу kinoteatr.megamag.by, на котором осуществляется оформление заказа Пользователем.\n" +
                                "Заказ — должным образом оформленный запрос Пользователя на получение услуг, выбранных на сайте.\n" +
                                "Услуги – размещенные на сайте услуги третьих лиц (Исполнителей).\n" +
                                "Исполнитель – третье лицо, услуги которого доступны на сайте, заключившее договор с МагСоюзом о предоставлении (оказании) соответствующих услуг.\n" +
                                "Система бронирования – информационная система, содержащая сведения о расписании мероприятий( предоставляется Исполнителем услуг) , наличии мест , стоимости билетов и другие условия оказания предлагаемых услуг, также сведения о заказах Пользователя. Указанная информация размещается на сайте kinoteatr.megamag.by в полном соответствии с тем, как она представлена в системе бронирования Исполнителями или их полномочными представителями. Информация в системе бронирования может в любой момент быть изменена или дополнена, в связи с этим Пользователю предлагается использовать систему бронирования в режиме «как есть».\n" +
                                "Оператор — сотрудник МагСоюза, обрабатывающий заказы Пользователей, требующие индивидуальной «ручной» обработки.\n" +
                                "1. Общие положения\n" +
                                "1.1. Настоящий Договор, а также информация об услугах, представленная на сайте, являются публичной офертой в соответствии со ст.407 Гражданского Кодекса РБ . Заказывая услуги через сайт, Пользователь соглашается с условиями Договора публичной оферты (далее — Договор), изложенными ниже.\n" +
                                "1.2. МагСоюз оказывает Пользователю услуги по бронированию и оплате билетов на мероприятия Исполнителей услуг, действуя при этом от имени и по поручению Исполнителей. В свою очередь Пользователь обязуется оплатить услуги МагСоюза в соответствии с установленными тарифами .\n" +
                                "1.3. В соответствии с условиями настоящего договора , Пользователь поручает МагСоюзу осуществить действия направленные на предоставление Пользователю заказанных им в системе бронирования услуг исполнителей. При этом МагСоюз действует от имени и за счет Пользователя. В свою очередь Пользователь обязуется выплатить МагСоюзу вознаграждение в соответствии с установленными МагСоюзом расценками путем внесения соответствующей платы.\n" +
                                "1.4. Услуги МагСоюза считаются исполненными после исполнения следующих процедур: подбор и предоставление Пользователю информации об услуге на сайте; получение от Пользователя надлежащим образом оформленного заказа на сайте на получение выбранной им услуги; предоставления возможности Пользователю произвести оплату выбранной им услуги путем принятия денежных средств от Пользователя выбранным им способом оплаты и последующее перечисление полученных от Пользователя денежных средств в пользу Исполнителя, выразившего готовность оказать указанную в заявке Пользователя услугу.\n" +
                                "1.5. К отношениям между Пользователем и МагСоюзом применяется действующее законодательство РБ.\n" +
                                "1.6. Сторонами договоров об оказании услуг, информация о которых размещена на сайте, во всех случаях будут Пользователь и лицо, предоставляющее соответствующую услугу (исполнитель). МагСоюз не отвечает за исполнение этими лицами своих обязательств по оказанию услуг.\n" +
                                "1.7. Пользователь соглашается с настоящим Договором путем проставления отметки в виде «галочки» в графе «С правилами и условиями применения тарифов ознакомлен и согласен» на этапе просмотра деталей заказа, перед началом ввода данных и бронирования. Соглашаясь с условиями настоящего Договора, Пользователь подтверждает свое право- и дееспособность, финансовую состоятельность, а также сознаёт ответственность за обязательства, возложенные на него в результате заключения настоящего Договора. Пользователь подтверждает достоверность своих личных данных, а также принимает на себя всю ответственность за их точность, полноту и достоверность.\n" +
                                "1.8. Пользователь принимает на себя все возможные финансовые риски (оформление нового заказа, изменение тарифа, возврат денег и проч.), связанные с неправильным заполнением заказа.\n" +
                                "2. Порядок взаимоотношений сторон, электронная подпись, регистрация на сайте\n" +
                                "2.1. Все взаимоотношения между Пользователем и МагСоюзом по настоящему Договору осуществляются исключительно путем обмена информацией Пользователем при регистрации, а также действиями Пользователя на сайте. В связи с этим, Пользователь при необходимости обращается за информацией к МагСоюзу по телефону, указанному на сайте или по электронной почте: megamagby.info@gmail.com\n" +
                                "2.2. Для оформления заказа Пользователю необходимо зарегистрироваться на сайте, заполнив все данные достоверной информацией.\n" +
                                "2.3. После регистрации Пользователя все последующие действия в отношении заказа (-ов) Пользователя осуществляются только при условии указания им его логина и пароля на сайте. При этом логин и пароль Пользователя становятся ключом простой электронной подписи Пользователя , то есть аналогом собственноручной подписи Пользователя.\n" +
                                "2.4. Пользователь и МагСоюз обязаны сохранять в тайне логин и пароль Пользователя. В случае компрометации (раскрытия неуполномоченным лицам) логина и/или пароля Пользователя, сторона, которой стало известно об этом, обязана незамедлительно принять меры, направленные на замену логина и пароля Пользователя – уведомить другую сторону по электронной почте. При этом если смена логина и пароля Пользователя происходит по инициативе МагСоюза, на электронный адрес почты Пользователя отправляются новые логин и пароль Пользователя.\n" +
                                "2.5. МагСоюз не несет ответственности за точность и правильность информации, предоставляемой Пользователем при регистрации.\n" +
                                "2.6. Весь обмен информацией между Сторонами относительно заказа Пользователя и выполнения прочих своих обязательств по настоящему договору осуществляется через электронную почту, адрес которой был указан Пользователем при регистрации. В связи с этим, Пользователь обязуется регулярно, вплоть до момента использования приобретенного на сайте билета, самостоятельно отслеживать состояние своего заказа, в том числе проверять свою электронную почту на предмет получения информации о возможных изменениях, а при необходимости обращаться за информацией к МагСоюзу по телефону, указанному на сайте.\n" +
                                "Ответственность за любые последствия, возникающие в связи с отсутствием у Пользователя информации об изменениях в заказе, произошедших по независящим от МагСоюза причинам (отмена или перенос сеанса, задержка банком Пользователя оплаты заказа, изменение тарифов и т.д.), несет Пользователь, при условии соблюдения МагСоюзом порядка уведомления Пользователя о любых изменениях в заказе.\n" +
                                "3. Оформление и сроки подтверждения заказа\n" +
                                "3.1. Заказ оформляется Пользователем самостоятельно на сайте.\n" +
                                "3.2. Со всеми условиями заказа Пользователь знакомится в процессе бронирования. В случае если Пользователю не понятны какие-либо условия заказа, в том числе условия отказа, возврата, внесение любых изменений, в оформленный заказ, Пользователь должен уточнить необходимую ему информацию у оператора по телефону или по электронной почте: megamagby.info@gmail.com\n" +
                                "3.3. Заказы, оформленные Пользователем, носят окончательный характер и подлежат обработке в системе бронирования МагСоюза. После поступления от Пользователя в систему бронирования МагСоюза оформленного заказа и оплаты , забронированные услуги оформляются оператором . В случае несвоевременного поступления в МагСоюз информации об оплате заказа Пользователем, отказ от бронирования услуг исполнителем или по иным независящим от МагСоюза причинам, заказ Пользователя аннулируется .\n" +
                                "4. Оплата заказа. Сервисный сбор МагСоюза.\n" +
                                "4.1. Стоимость заказа указывается на сайте в режиме он-лайн (т.е. непосредственно при оформлении заказа).\n" +
                                "4.2. Срок оплаты заказа указывается на сайте при оформлении заказа. В случае просрочки указанного срока оплаты Пользователем, оформленный Пользователем заказ аннулируется.\n" +
                                "4.3. Пользователь осуществляет оплату в безналичном порядке путем перечисления денежных средств на счет МагСоюза одним из способов, предусмотренных на сайте в разделе «Информация\\Способы оплаты», при этом услуги приема оплаты от Пользователя и перечисления денежных средств МагСоюзу оказываются третьими лицами и на условиях установленных этими лицами. МагСоюз не несет ответственности перед Пользователем за неперечисление денежных средств Пользователя третьими лицами.\n" +
                                "4.4. МагСоюз имеет право взимать с Пользователя дополнительные сервисные сборы - за бронирование и оформление услуг. Сервисный сбор МагСоюза включается в стоимость заказа, и в случае добровольного возврата услуг Пользователем, после перечисления денег Исполнителю услуги, возврату не подлежит.\n" +
                                "4.5. В случае совершения платежа с помощью банковской карты Покупатель обязан использовать банковскую карту, выпущенную на соответствующее имя Покупателя. Одновременно с этим Исполнитель услуг вправе потребовать предоставления Покупателем оригиналов документов, удостоверяющих личность Покупателя и Карточки клиента. Платеж не принимается, а Заказ аннулируется при нарушении Покупателем условий платежа, установленных законодательством РБ.\n" +
                                "4.6. При соблюдении всех условий настоящей Оферты и после оплаты Заказ считается проданным и у Покупателя возникает право посетить Мероприятие.\n" +
                                "4.7. При неоплате в течение периода действия брони Заказ считается непроданным и аннулируется.\n" +
                                "5. Изменение заказа. Отказ от услуги.\n" +
                                "5.1. Собственником билетов на Мероприятия является Исполнитель услуги.\n" +
                                "5.2. Проданные билеты на мероприятия, проводимые Исполнителями услуг, возвращаются Пользователям по их требованию до начала Мероприятия Исполнителем услуг в соответствии с утвержденным Исполнителем услуг порядком.\n" +
                                "5.3. После зачисление денег на счет Исполнителя услуги, возврат платежа производится за вычетом сервисного сбора Системы Бронирования.\n" +
                                "5.4. Возврат платежа в полном объеме может быть осуществлен до момента выполнения обязанности по перечислению платежа Исполнителю услуг.\n" +
                                "6. Ответственность сторон\n" +
                                "6.1. В случае неисполнения или ненадлежащего исполнения своих обязательств по Оферте Стороны несут ответственность в соответствии с законодательством РБ и условий настоящей Оферты.\n" +
                                "6.2. Ответственность МагСоюза в процессе оказания Услуг Покупателю ограничивается функцией организации и осуществления взаимодействия между Исполнителем услуги и Покупателем с целью реализации Билета.\n" +
                                "6.3. Покупатель принимает на себя все возможные коммерческие риски, связанные с его действиями по допущению ошибок и неточностей в предоставленных им своих данных.\n" +
                                "6.4. МагСоюз не несет ответственности за любые убытки и моральный вред, понесенные Покупателем в результате ошибочного понимания или непонимания им информации о порядке оформления/оплаты Заказа, а также получения и использования Услуг.\n" +
                                "6.5. Стороны освобождаются от ответственности за полное или частичное неисполнение своих обязательств по Оферте, если такое неисполнение явилось следствием обстоятельств непреодолимой силы, то есть чрезвычайных и непредотвратимых при данных условиях обстоятельств. К обстоятельствам непреодолимой силы, в частности, относятся: стихийные бедствия, военные действия, забастовки, действия и решения государственных органов власти, сбои, возникающие в телекоммуникационных и энергетических сетях.\n" +
                                "6.6. Ни при каких обстоятельствах МагСоюз, его сотрудники, директора, должностные лица или другие связанные стороны, спонсоры, посредники, представители, партнеры или любые другие лица, в том числе действующие от имени МагСоюза , не несут ответственности за любые прямые или косвенные убытки, возникшие в результате продажи Билета или получения Услуг, а также в результате несанкционированного доступа к персональным данным Покупателя, включая упущенную выгоду.\n" +
                                "6.7. Стороны освобождаются от ответственности за ненадлежащее исполнение или неисполнение обязательств по настоящему Договору в случае наступления обстоятельств непреодолимой силы, к таковым стороны относят следующие обстоятельства: пожар, эпидемия, землетрясение, террористический акт, наводнение, ураган, шторм, цунами, оползень, другие стихийные бедствия и катаклизмы, военные действия любого характера, забастовки, введение чрезвычайного или военного положения, эмбарго, изменения законодательства РБ, повлекших невозможность надлежащего исполнения Сторонами своих обязательств и прочие обстоятельства, на которые стороны не могут повлиять и предотвратить.\n" +
                                "7. Интеллектуальная собственность.\n" +
                                "7.1. Текстовые и графические материалы, а также программные решения, размещённые на Сайте, являются интеллектуальной собственностью МагСоюза.\n" +
                                "7.2. Изменение информации на сайте производится МагСоюзом периодически.")
                        .infoId(infoId)
                        .infoList(new ArrayList<InfoData>())
                        .build()
        );

        return infoList;
    }
}
