package uz.pdp.appspringboot1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appspringboot1.entity.Country;
import uz.pdp.appspringboot1.payload.ReqCountry;
import uz.pdp.appspringboot1.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public boolean addCountry(ReqCountry reqCountry) {
        boolean existsCountry = countryRepository.existsByNameUzEqualsIgnoreCaseOrNameRuEqualsIgnoreCaseOrNameEnEqualsIgnoreCase(reqCountry.getNameUz(), reqCountry.getNameRu(), reqCountry.getNameEn());
        if (!existsCountry){
            Country country = new Country();
            country.setNameUz(reqCountry.getNameUz());
            country.setNameRu(reqCountry.getNameRu());
            country.setNameEn(reqCountry.getNameEn());
            countryRepository.save(country);
            return true;
        }
        return false;
    }

    public List<Country> getCountries() {
        List<Country> all = countryRepository.findAll();
        return all;
    }

    public boolean editCountry(Integer id, ReqCountry reqCountry) {
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if (optionalCountry.isPresent()){
            boolean exists = countryRepository.existsByNameUzEqualsIgnoreCaseAndIdNotOrNameRuIgnoreCaseAndIdNotOrNameEnIgnoreCaseAndIdNot(
                    reqCountry.getNameUz(),id,
                    reqCountry.getNameRu(),id,
                    reqCountry.getNameEn(),id
            );
            if (!exists){
                Country country = optionalCountry.get();
                country.setNameUz(reqCountry.getNameUz());
                country.setNameRu(reqCountry.getNameRu());
                country.setNameEn(reqCountry.getNameEn());
                countryRepository.save(country);
                return true;
            }
        }
        return false;
    }
}
