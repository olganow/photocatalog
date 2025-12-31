package guru.qa.photocatalog.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
//Это тоже бин
public interface PhotoRepository extends JpaRepository<PhotoEntity, UUID> {
}
