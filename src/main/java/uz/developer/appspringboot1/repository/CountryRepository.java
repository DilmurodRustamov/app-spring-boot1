package uz.developer.appspringboot1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developer.appspringboot1.entity.Country;

public interface CountryRepository extends JpaRepository<Country,Integer> {
    boolean existsByNameUzEqualsIgnoreCaseOrNameRuEqualsIgnoreCaseOrNameEnEqualsIgnoreCase(String nameUz, String nameRu, String nameEn);

    boolean existsByNameUzEqualsIgnoreCaseAndIdNotOrNameRuIgnoreCaseAndIdNotOrNameEnIgnoreCaseAndIdNot(String nameUz, Integer id, String nameRu, Integer id2, String nameEn, Integer id3);
}
