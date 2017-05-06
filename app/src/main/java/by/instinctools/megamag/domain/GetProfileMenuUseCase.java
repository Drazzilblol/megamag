package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.common.converters.ListConverter;
import by.instinctools.megamag.data.menu.MenuAnnouncementRepositoryImpl;
import by.instinctools.megamag.data.menu.MenuData;
import by.instinctools.megamag.data.menu.MenuInfoRepositoryImpl;
import by.instinctools.megamag.data.menu.MenuProfileRepositoryImpl;
import by.instinctools.megamag.data.menu.MenuRepository;
import by.instinctools.megamag.data.menu.MenuTheaterRepositoryImpl;
import by.instinctools.megamag.domain.common.converters.MenuConverter;
import by.instinctools.megamag.domain.models.MenuDomain;
import io.reactivex.Observable;

public class GetProfileMenuUseCase implements UseCase<List<MenuDomain>> {

    @NonNull
    ListConverter<MenuData, MenuDomain> converter = new MenuConverter();

    @NonNull
    MenuRepository profileRepository = new MenuProfileRepositoryImpl();

    @Override
    public Observable<List<MenuDomain>> execute() {
        return profileRepository.getMenuList()
                .map(converter::convert);
    }
}
