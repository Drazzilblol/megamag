package by.instinctools.megamag.domain.common.converters;

import android.support.annotation.NonNull;

import by.instinctools.megamag.common.converters.BaseConverter;
import by.instinctools.megamag.data.info.InfoData;
import by.instinctools.megamag.domain.models.Info;

public class InfoConverter extends BaseConverter<InfoData, Info> {

    @NonNull
    @Override
    public Info convert(@NonNull InfoData infoData) {
        Info info = Info.builder()
                .title(infoData.getTitle())
                .text(infoData.getText())
                .infoId(infoData.getInfoId())
                .build();
        for (InfoData infoD : infoData.getInfoList()) {
            info.addToInfoList(convert(infoD));
        }
        return info;
    }
}
