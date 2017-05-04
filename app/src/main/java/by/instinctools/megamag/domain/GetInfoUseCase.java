package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.common.converters.ListConverter;
import by.instinctools.megamag.data.info.InfoData;
import by.instinctools.megamag.data.info.InfoRepository;
import by.instinctools.megamag.data.info.InfoRepositoryImpl;
import by.instinctools.megamag.domain.common.converters.InfoConverter;
import by.instinctools.megamag.domain.models.Info;
import hugo.weaving.DebugLog;
import io.reactivex.Observable;

public class GetInfoUseCase implements UseCase<List<Info>> {

    @NonNull
    private InfoRepository repository = new InfoRepositoryImpl();

    @NonNull
    private ListConverter<InfoData, Info> converter = new InfoConverter();

    @DebugLog
    public Observable<List<Info>> execute( int infoId) {
        return repository.getInfoList(infoId)
                .map(converter::convert);
    }

    @Override
    public Observable<List<Info>> execute() {
        throw new UnsupportedOperationException();
    }
}
