package by.instinctools.megamag.common.factory;

import by.instinctools.megamag.data.type.GroupType;

public class GroupTypeFactory {

    private static final int INFO_GROUP_ID = 1000;
    private static final int ANNOUNCEMENT_GROUP_ID = 1001;
    private static final int THEATER_GROUP_ID = 1002;
    private static final int SETTINGS_GROUP_ID = 1004;
    private static final int PROFILE_GROUP_ID = 1005;

    public static GroupType getAnnouncementGroupId() {
        return new GroupType(ANNOUNCEMENT_GROUP_ID);
    }

    public static GroupType getInfoGroupId() {
        return new GroupType(INFO_GROUP_ID);
    }

    public static GroupType getProfileGroupId() {
        return new GroupType(PROFILE_GROUP_ID);
    }

    public static GroupType getSettingsGroupId() {
        return new GroupType(SETTINGS_GROUP_ID);
    }

    public static GroupType getTheaterGroupId() {
        return new GroupType(THEATER_GROUP_ID);
    }

}
