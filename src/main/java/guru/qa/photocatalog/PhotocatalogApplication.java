package guru.qa.photocatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Аннотация @SpringBootApplication - комбинированная аннотация Spring Boot
// Включает в себя:
// 1. @Configuration - класс содержит конфигурацию Spring
// 2. @EnableAutoConfiguration - включает автоконфигурацию Spring Boot
// 3. @ComponentScan - включает сканирование компонентов в текущем пакете и подпакетах
@SpringBootApplication
public class PhotocatalogApplication {

    // Главный метод приложения - точка входа в программу
    // public - доступен извне класса
    // static - метод принадлежит классу, а не экземпляру
    // void - метод не возвращает значение
    // main - имя метода
    // String[] args - массив аргументов командной строки
    public static void main(String[] args) {
        // Запуск Spring Boot приложения
        // SpringApplication.run() инициализирует Spring контекст, настраивает сервер и т.д.
        // PhotocatalogApplication.class - класс с аннотацией @SpringBootApplication
        // args - аргументы командной строки
        SpringApplication.run(PhotocatalogApplication.class, args);
    }

}