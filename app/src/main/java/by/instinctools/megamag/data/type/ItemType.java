package by.instinctools.megamag.data.type;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ItemType {

    public abstract int getId();

    public static ItemType create(int id) {
        return new AutoValue_ItemType(id);
    }
}
