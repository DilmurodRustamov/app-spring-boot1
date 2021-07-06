package uz.developer.appspringboot1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developer.appspringboot1.entity.Country;
import uz.developer.appspringboot1.entity.Region;
import uz.developer.appspringboot1.payload.ReqRegion;
import uz.developer.appspringboot1.repository.CountryRepository;
import uz.developer.appspringboot1.repository.RegionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    CountryRepository countryRepository;

    public boolean addRegion(ReqRegion reqRegion) {
        boolean exists = regionRepository.existsByNameUzEqualsIgnoreCaseAndCountryIdOrNameRuEqualsIgnoreCaseAndCountryIdOrNameEnEqualsIgnoreCaseAndCountryId(
                reqRegion.getNameUz(), reqRegion.getCountryId(),
                reqRegion.getNameRu(), reqRegion.getCountryId(),
                reqRegion.getNameEn(), reqRegion.getCountryId()
        );
        if (!exists){
            Optional<Country> optionalCountry = countryRepository.findById(reqRegion.getCountryId());
            if (optionalCountry.isPresent()) {
                Region region = new Region();
                region.setNameUz(reqRegion.getNameUz());
                region.setNameRu(reqRegion.getNameRu());
                region.setNameEn(reqRegion.getNameEn());
                region.setCountry(optionalCountry.get());
                regionRepository.save(region);
                return true;
            }
        }
        return false;
    }

    public List<Region> getRegions() {
        List<Region> all = regionRepository.findAll();
        return all;
    }

    public boolean editRegion(Integer id, ReqRegion reqRegion) {
        Optional<Region> optionalRegion= regionRepository.findById(id);
        if (optionalRegion.isPresent()){
            boolean exists = regionRepository.existsByNameUzEqualsIgnoreCaseAndCountryIdOrNameRuEqualsIgnoreCaseAndCountryIdOrNameEnEqualsIgnoreCaseAndCountryId(
                    reqRegion.getNameUz(), reqRegion.getCountryId(),
                    reqRegion.getNameRu(), reqRegion.getCountryId(),
                    reqRegion.getNameEn(), reqRegion.getCountryId()
            );
            if (!exists){
                Region region = optionalRegion.get();
                region.setNameUz(reqRegion.getNameUz());
                region.setNameRu(reqRegion.getNameRu());
                region.setNameEn(reqRegion.getNameEn());
//                region.setCountry(optionalRegion.get());
                regionRepository.save(region);
                return true;
            }
        }
        return false;
    }
}
