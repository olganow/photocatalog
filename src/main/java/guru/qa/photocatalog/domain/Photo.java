package guru.qa.photocatalog.domain;

import java.util.Date;
/*record - это новый тип класса в Java (начиная с Java 14 как preview, стабильно с Java 16),
 который предназначен для создания неизменяемых (immutable) классов данных.
Преимущества record:
✅ Короткий синтаксис
✅ Неизменяемость по умолчанию - Все поля final, сеттеров нет
✅ Прозрачность данных - Отличные equals(), hashCode(), toString() "из коробки"
✅ Идеален для DTO, Value Objects
Ограничения record:
❌ Нельзя наследоваться (все records - final)
❌ Нельзя наследовать другие классы (кроме Record)
❌ Все поля - final (нельзя изменить после создания)*/

// Объявление record (записи) в Java - специальный тип класса для данных
// public - модификатор доступа, класс доступен из любого пакета
// record - ключевое слово для создания записи
// Photo - имя класса записи
// (String description, Date LastModifyDate, String content) - список компонентов записи
// Эти компоненты автоматически становятся final полями класса
public record Photo (String description, Date LastModifyDate, String content){
    // Тело записи может быть пустым - компилятор автоматически создаст:
    // 1. Приватные final поля для каждого компонента
    // 2. Канонический конструктор с параметрами в порядке объявления
    // 3. Геттеры с именами description(), LastModifyDate(), content()
    // 4. Методы equals(), hashCode(), toString()
    // 5. Все поля immutable (неизменяемые)
}