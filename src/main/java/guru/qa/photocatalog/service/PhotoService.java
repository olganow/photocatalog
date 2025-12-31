package guru.qa.photocatalog.service;

import guru.qa.photocatalog.domain.Photo;

import java.util.List;
// Объявление интерфейса PhotoService
// public - доступен из любого пакета
// interface - ключевое слово для создания интерфейса
public interface PhotoService {
    // Объявление метода allPhotos() без реализации
    // Возвращает список объектов Photo
    List<Photo> allPhotos();
    // Объявление метода photoByDescription() без реализации
    // Принимает строку description и возвращает один объект Photo
    Photo photoByDescription(String description);
}