package guru.qa.photocatalog.service;

import guru.qa.photocatalog.data.PhotoRepository;
import guru.qa.photocatalog.domain.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

// Аннотация @Component - указывает Spring, что этот класс является компонентом
// Spring создаст бин этого класса и добавит его в контекст приложения
@Component
// Объявление класса DbPhotoService, который реализует интерфейс PhotoService
// "implements" означает, что класс обязан реализовать все методы интерфейса
public class DbPhotoService implements PhotoService {

    // Приватное финальное поле для хранения репозитория
    // final гарантирует, что поле будет инициализировано в конструкторе и не изменится
    private final PhotoRepository photoRepository;

    // Аннотация @Autowired - указывает Spring внедрить зависимость (Dependency Injection)
    // Spring найдет бин типа PhotoRepository и передаст его в конструктор
    @Autowired
    // Конструктор класса с одним параметром - PhotoRepository
    // Это предпочтительный способ внедрения зависимостей (constructor injection)
    public DbPhotoService(PhotoRepository photoRepository) {
        // Присваивание переданного репозитория полю класса
        // this.photoRepository ссылается на поле класса, photoRepository - параметр конструктора
        this.photoRepository = photoRepository;
        // Отладочный вывод в консоль - показывает реальный класс репозитория
        // Полезно для диагностики (прокси-класс Hibernate или реальная реализация)
        System.out.println("Repository class: " + photoRepository.getClass());
        // Отладочный вывод количества записей в БД
        // Метод count() наследуется от JpaRepository
        System.out.println("Total photos in DB: " + photoRepository.count());
    }

    // Аннотация @Override - указывает, что метод переопределяет метод интерфейса
    // Реализация метода allPhotos() из интерфейса PhotoService
    @Override
    public List<Photo> allPhotos() {
        // Вызов метода findAll() репозитория для получения всех сущностей из БД
        return photoRepository.findAll()
                // Преобразование List<PhotoEntity> в Stream<PhotoEntity>
                // Stream API позволяет выполнять функциональные операции над коллекциями
                .stream()
                // Операция map - преобразует каждый элемент потока
                // fe - параметр лямбда-выражения (PhotoEntity)
                .map(fe -> {
                    // Создание нового объекта Photo на основе PhotoEntity
                    return new Photo(
                            // Получение описания из сущности
                            fe.getDescription(),
                            // Получение даты последнего изменения из сущности
                            fe.getLastModifyDate(),
                            // Тернарный оператор: проверка content на null
                            // Если content не null - создаем String из байтового массива
                            // Если null - возвращаем пустую строку
                            fe.getContent() != null ? new String(fe.getContent()) : ""
                    );
                    // Преобразование Stream<Photo> обратно в List<Photo>
                }).toList();
    }

    // Реализация метода photoByDescription() из интерфейса PhotoService
    // В текущей реализации всегда возвращает null (заглушка)
    @Override
    public Photo photoByDescription(String description) {
        return null;
    }
}