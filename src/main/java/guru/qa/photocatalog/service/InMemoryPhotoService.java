package guru.qa.photocatalog.service;

import guru.qa.photocatalog.domain.Photo;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
//имплементировать два его метода и над ним поставим собака компонент тем самым
//30:56
//мы говорим о том что мыли Spring bein который должен жить в Application контексте Это значит что мы
//31:02
//можем его доставать с помощью аннотации собака aut там где он нам понадобится используя его тип интерфейса OS и это
//31:11
//значит что за счёт того что мы используем Spring Boot Application вот эта аннотация будет прочитана
/*
@Component
public class InMemoryPhotoService implements PhotoService {


    @Override
    public List<Photo> allPhotos() {
        return List.of(
                new Photo("Фото1", new Date(), ""),
                new Photo("Фото2", new Date(), "")
        );
    }

    @Override
    public Photo photoByDescription(String description) {
        return null;
    }
}
*/
