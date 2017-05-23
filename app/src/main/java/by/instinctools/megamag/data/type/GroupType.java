package by.instinctools.megamag.data.type;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class GroupType {

    public abstract int getId();

    public static GroupType create(int id) {
        return new AutoValue_GroupType(id);
    }
}
