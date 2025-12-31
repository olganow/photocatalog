package guru.qa.photocatalog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import tools.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

@Configuration
public class AppConfig {

    @Bean //Конфигурация
    //видео 37 минута
    public ObjectMapper objectMapper() {
        ObjectMapper om = new ObjectMapper();
        om.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));

        return om;
    }
}
