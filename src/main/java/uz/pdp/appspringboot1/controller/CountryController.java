package uz.pdp.appspringboot1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appspringboot1.entity.Country;
import uz.pdp.appspringboot1.entity.Region;
import uz.pdp.appspringboot1.payload.ReqCountry;
import uz.pdp.appspringboot1.payload.ReqRegion;
import uz.pdp.appspringboot1.repository.CountryRepository;
import uz.pdp.appspringboot1.service.CountryService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @Autowired
    CountryRepository countryRepository;

    @PostMapping("/add")
    @ResponseBody
    public HttpEntity<Boolean> addCountry(@RequestBody ReqCountry reqCountry){
        boolean addCountry = countryService.addCountry(reqCountry);
        return ResponseEntity.status(addCountry? HttpStatus.CREATED:HttpStatus.CONFLICT).body(addCountry);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Country> getCountry(){
        return countryService.getCountries();
    }

    @GetMapping("{id}")
    @ResponseBody
    public Country country(@PathVariable Integer id){
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if (optionalCountry.isPresent()){
            return optionalCountry.get();
        }
        return new Country();
    }

    @PutMapping("/edit/{id}")
    @ResponseBody
    public boolean editCountry(@PathVariable Integer id, @RequestBody ReqCountry reqCountry){
        return countryService.editCountry(id, reqCountry);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public boolean deleteCountry(@PathVariable Integer id){
        countryRepository.deleteById(id);
        return true;
    }
}
