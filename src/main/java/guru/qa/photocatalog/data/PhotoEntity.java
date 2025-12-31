package guru.qa.photocatalog.data;

import jakarta.persistence.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

// Аннотация @Entity - указывает, что этот класс является JPA сущностью
// Объекты этого класса будут отображаться на записи в таблице БД
@Entity
// Аннотация @Table - задает имя таблицы в БД, соответствующей этой сущности
// name = "photos" - таблица будет называться "photos"
@Table (name = "photos")
public class PhotoEntity {

    // Аннотация @Id - указывает, что это поле является первичным ключом
    @Id
    // Аннотация @GeneratedValue - определяет стратегию генерации значений для первичного ключа
    // strategy = GenerationType.AUTO - стратегия выбирается автоматически в зависимости от БД
    @GeneratedValue(strategy = GenerationType.AUTO)
    // Аннотация @Column - настройки отображения поля на колонку таблицы
    // name = "id" - имя колонки в таблице
    // nullable = false - колонка не может содержать NULL значения
    // columnDefinition = "UUID default gen_random_uuid()" - SQL определение колонки
    // UUID тип с генерацией случайного UUID по умолчанию
    @Column(name = "id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID id;  // Поле для хранения уникального идентификатора

    // Аннотация @Column без имени - имя колонки будет совпадать с именем поля ("description")
    // nullable = false - колонка не может содержать NULL
    @Column(nullable = false)
    private String description;  // Поле для описания фотографии

    // Аннотация @Column с явным указанием имени колонки "last_modify_date"
    // nullable = false - колонка не может содержать NULL
    // columnDefinition = "DATE" - тип колонки DATE в БД
    @Column(name = "last_modify_date", nullable = false, columnDefinition = "DATE")
    private Date lastModifyDate ;  // Поле для даты последнего изменения

    // Поле без аннотаций @Column - JPA будет использовать настройки по умолчанию
    // Имя колонки будет "content", тип будет определен автоматически
    private byte[] content;  // Поле для хранения бинарных данных фотографии

    // Геттер для поля id - возвращает значение id
    public UUID getId() {
        return id;
    }

    // Сеттер для поля id - устанавливает значение id
    public void setId(UUID id) {
        this.id = id;
    }

    // Геттер для поля description
    public String getDescription() {
        return description;
    }

    // Сеттер для поля description
    public void setDescription(String description) {
        this.description = description;
    }

    // Геттер для поля lastModifyDate
    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    // Сеттер для поля lastModifyDate
    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    // Геттер для поля content
    public byte[] getContent() {
        return content;
    }

    // Сеттер для поля content
    public void setContent(byte[] content) {
        this.content = content;
    }

    // Переопределение метода equals для сравнения объектов PhotoEntity
    @Override
    public final boolean equals(Object o) {
        // Проверка: если это один и тот же объект в памяти, возвращаем true
        if (this == o) {
            return true;
        }
        // Проверка: если сравниваем с null, возвращаем false
        if (o == null) {
            return false;
        }
        // Определение реального класса объекта o с учетом Hibernate прокси
        // HibernateProxy - это специальный прокси-класс, который Hibernate использует для ленивой загрузки
        Class<?> objectEffectiveClass = o instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        // Определение реального класса текущего объекта с учетом Hibernate прокси
        Class<?> thisEffectiveClass = this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        // Проверка: если классы разные, объекты не равны
        if (thisEffectiveClass != objectEffectiveClass) {
            return false;
        }
        // Приведение объекта o к типу PhotoEntity
        PhotoEntity that = (PhotoEntity) o;
        // Два объекта равны, если их id не null и равны друг другу
        return id != null && Objects.equals(id, that.id);
    }

    // Переопределение метода hashCode
    @Override
    public final int hashCode() {
        // Возвращает hashCode класса с учетом Hibernate прокси
        // Если это прокси, возвращает hashCode реального класса, иначе hashCode текущего класса
        return this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}