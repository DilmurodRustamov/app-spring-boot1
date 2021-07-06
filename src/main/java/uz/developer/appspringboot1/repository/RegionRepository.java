package uz.developer.appspringboot1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developer.appspringboot1.entity.Region;

public interface RegionRepository extends JpaRepository<Region,Integer> {
    boolean existsByNameUzEqualsIgnoreCaseAndCountryIdOrNameRuEqualsIgnoreCaseAndCountryIdOrNameEnEqualsIgnoreCaseAndCountryId(String nameUz, Integer country_id, String nameRu, Integer country_id2, String nameEn, Integer country_id3);

}
