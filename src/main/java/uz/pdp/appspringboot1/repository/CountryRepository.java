package uz.pdp.appspringboot1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appspringboot1.entity.Country;
import uz.pdp.appspringboot1.entity.Region;

public interface CountryRepository extends JpaRepository<Country,Integer> {
    boolean existsByNameUzEqualsIgnoreCaseOrNameRuEqualsIgnoreCaseOrNameEnEqualsIgnoreCase(String nameUz, String nameRu, String nameEn);

    boolean existsByNameUzEqualsIgnoreCaseAndIdNotOrNameRuIgnoreCaseAndIdNotOrNameEnIgnoreCaseAndIdNot(String nameUz, Integer id, String nameRu, Integer id2, String nameEn, Integer id3);
}
