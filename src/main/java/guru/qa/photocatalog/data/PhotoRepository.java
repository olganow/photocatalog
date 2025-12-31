package guru.qa.photocatalog.data;

import org.springframework.data.jpa.repository.JpaRepository;

// Импорт класса UUID из пакета java.util
import java.util.UUID;
//Это тоже бин

// Объявление интерфейса репозитория для работы с сущностью PhotoEntity
// extends JpaRepository<PhotoEntity, UUID> - наследует все стандартные методы JPA
// JpaRepository - интерфейс Spring Data JPA с готовыми CRUD операциями
// PhotoEntity - тип сущности, с которой работает репозиторий
// UUID - тип первичного ключа сущности
public interface PhotoRepository extends JpaRepository<PhotoEntity, UUID> {
    // Пустое тело интерфейса - Spring Data JPA автоматически создаст реализацию
    // с такими методами как: save(), findById(), findAll(), deleteById(), count() и др.
}
