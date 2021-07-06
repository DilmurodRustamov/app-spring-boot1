package uz.developer.appspringboot1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developer.appspringboot1.entity.District;
import uz.developer.appspringboot1.entity.Region;
import uz.developer.appspringboot1.payload.ReqDistrict;
import uz.developer.appspringboot1.repository.DistrictRepository;
import uz.developer.appspringboot1.repository.RegionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {
    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    RegionRepository regionRepository;
    public boolean addDistrict(ReqDistrict reqDistrict) {
        boolean exists = districtRepository.existsByNameUzEqualsIgnoreCaseAndRegionIdOrNameRuEqualsIgnoreCaseAndRegionIdOrNameEnEqualsIgnoreCaseAndRegionId(
                reqDistrict.getNameUz(), reqDistrict.getRegionId(),
                reqDistrict.getNameRu(), reqDistrict.getRegionId(),
                reqDistrict.getNameEn(), reqDistrict.getRegionId()
        );
        if (!exists){
            Optional<Region> optionalRegion = regionRepository.findById(reqDistrict.getRegionId());
            if (optionalRegion.isPresent()){
                District district = new District();
                district.setNameUz(reqDistrict.getNameUz());
                district.setNameRu(reqDistrict.getNameRu());
                district.setNameEn(reqDistrict.getNameEn());
                district.setRegion(optionalRegion.get());
                districtRepository.save(district);
                return true;
            }
        }
        return false;
    }

    public List<District> getDistrict() {
        return districtRepository.findAll();
    }
}
