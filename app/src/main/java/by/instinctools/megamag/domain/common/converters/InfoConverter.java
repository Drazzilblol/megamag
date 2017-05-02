package by.instinctools.megamag.domain.common.converters;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import by.instinctools.megamag.common.converters.BaseConverter;
import by.instinctools.megamag.data.info.InfoData;
import by.instinctools.megamag.domain.models.Info;

public class InfoConverter extends BaseConverter<InfoData, Info> {

    @NonNull
    @Override
    public Info convert(@NonNull InfoData infoData) {
        List<Info> infoList = new ArrayList<>();
        if (infoData.getInfoList() != null) {
            for (InfoData infoD : infoData.getInfoList()) {
                infoList.add(convert(infoD));
            }
        }
        return Info.builder()
                .title(infoData.getTitle())
                .text(infoData.getText())
                .infoList(infoList)
                .infoId(infoData.getInfoId())
                .build();
    }
}
