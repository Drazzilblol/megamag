package by.instinctools.megamag.domain;

import android.support.annotation.NonNull;

import java.util.List;

import by.instinctools.megamag.common.converters.ListConverter;
import by.instinctools.megamag.data.menu.MenuAnnouncementRepositoryImpl;
import by.instinctools.megamag.data.menu.MenuData;
import by.instinctools.megamag.data.menu.MenuInfoRepositoryImpl;
import by.instinctools.megamag.data.menu.MenuRepository;
import by.instinctools.megamag.data.menu.MenuTheaterRepositoryImpl;
import by.instinctools.megamag.domain.common.converters.MenuConverter;
import by.instinctools.megamag.domain.models.MenuDomain;
import io.reactivex.Observable;

public class GetMenuUseCase implements UseCase<List<MenuDomain>> {

    @NonNull
    ListConverter<MenuData, MenuDomain> converter = new MenuConverter();

    @NonNull
    MenuRepository infoRepository = new MenuInfoRepositoryImpl();

    @NonNull
    MenuRepository announcementRepository = new MenuAnnouncementRepositoryImpl();

    @NonNull
    MenuRepository theaterRepository = new MenuTheaterRepositoryImpl();

    @Override
    public Observable<List<MenuDomain>> execute() {
        return announcementRepository.getMenuList()
                .concatWith(theaterRepository.getMenuList())
                .concatWith(infoRepository.getMenuList())
                .map(converter::convert);
    }
}
