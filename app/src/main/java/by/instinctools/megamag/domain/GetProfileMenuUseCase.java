package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.common.converters.ListConverter;
import by.instinctools.megamag.data.menu.MenuData;
import by.instinctools.megamag.data.menu.MenuProfileRepositoryImpl;
import by.instinctools.megamag.data.menu.MenuRepository;
import by.instinctools.megamag.domain.common.converters.MenuConverter;
import by.instinctools.megamag.domain.models.Menu;
import io.reactivex.Observable;

public class GetProfileMenuUseCase implements UseCase<List<Menu>> {

    @NonNull
    private ListConverter<MenuData, Menu> converter = new MenuConverter();

    @NonNull
    private MenuRepository profileRepository = new MenuProfileRepositoryImpl();

    @Override
    public Observable<List<Menu>> execute() {
        return profileRepository.getMenuList()
                .map(converter::convert);
    }
}
