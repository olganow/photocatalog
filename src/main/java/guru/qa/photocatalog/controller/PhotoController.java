package guru.qa.photocatalog.controller;

import guru.qa.photocatalog.domain.Photo;
import guru.qa.photocatalog.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Это бин
@RequestMapping("api/photo")
public class PhotoController {
    private final PhotoService photoService;

    @Autowired
    public  PhotoController (PhotoService photoService){
        this.photoService = photoService;
    }

    //http://127.0.0.1:8282/api/photo/all
    @GetMapping("/all")
    public List<Photo> all(){
        return photoService.allPhotos();
    }

}
