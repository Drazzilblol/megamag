package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.common.converters.ListConverter;
import by.instinctools.megamag.data.menu.MenuData;
import by.instinctools.megamag.data.menu.MenuRepository;
import by.instinctools.megamag.data.menu.MenuRepositoryImpl;
import by.instinctools.megamag.domain.common.converters.MenuConverter;
import by.instinctools.megamag.domain.models.MenuV;
import io.reactivex.Observable;

public class GetMenuUseCase implements UseCase<List<MenuV>> {

    @NonNull
    ListConverter<MenuData, MenuV> converter = new MenuConverter();

    @NonNull
    MenuRepository repository = new MenuRepositoryImpl();

    @Override
    public Observable<List<MenuV>> execute() {
        return repository.getMenuList()
                .map(converter::convert);
    }
}
