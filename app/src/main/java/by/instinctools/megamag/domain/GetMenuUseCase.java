package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.common.converters.ListConverter;
import by.instinctools.megamag.data.menu.MenuCommonRepositoryImpl;
import by.instinctools.megamag.data.menu.MenuData;
import by.instinctools.megamag.data.menu.MenuRepository;
import by.instinctools.megamag.domain.common.converters.MenuConverter;
import by.instinctools.megamag.domain.models.MenuDomain;
import io.reactivex.Observable;

public class GetMenuUseCase implements UseCase<List<MenuDomain>> {

    @NonNull
    private ListConverter<MenuData, MenuDomain> converter = new MenuConverter();

    @NonNull
    private MenuRepository repository = new MenuCommonRepositoryImpl();

    @Override
    public Observable<List<MenuDomain>> execute() {
        return repository.getMenuList()
                .map(converter::convert);
    }
}
