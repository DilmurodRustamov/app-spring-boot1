package uz.pdp.appspringboot1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appspringboot1.entity.District;

public interface DistrictRepository extends JpaRepository<District,Integer> {
    boolean existsByNameUzEqualsIgnoreCaseAndRegionIdOrNameRuEqualsIgnoreCaseAndRegionIdOrNameEnEqualsIgnoreCaseAndRegionId(String nameUz, Integer region_id, String nameRu, Integer region_id2, String nameEn, Integer region_id3);
}
