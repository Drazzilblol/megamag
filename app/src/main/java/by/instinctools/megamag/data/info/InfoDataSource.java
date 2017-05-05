package by.instinctools.megamag.data.info;

import by.instinctools.megamag.data.DataSource;

public interface InfoDataSource extends DataSource<String, InfoData> {

    public static final int HOW_PAY = 100;
    public static final int HOW_BOOK = 101;
    public static final int RULES = 102;

    public static final int INFO_GROUP_ID = 1000;
}
