package uz.developer.appspringboot1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.developer.appspringboot1.entity.District;
import uz.developer.appspringboot1.payload.ReqDistrict;
import uz.developer.appspringboot1.repository.DistrictRepository;
import uz.developer.appspringboot1.service.DistrictService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    DistrictService districtService;

    @PostMapping("/add")
    public HttpEntity<Boolean> addDistrict(@Valid @RequestBody ReqDistrict reqDistrict){
        boolean addDistrict = districtService.addDistrict(reqDistrict);
        return ResponseEntity.status(addDistrict? HttpStatus.CREATED:HttpStatus.CONFLICT).body(addDistrict);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<District> getDistrict(){
        return districtService.getDistrict();
    }

//    @PutMapping("/edit/{id}")
//    @ResponseBody
//    public boolean editDistrict(@PathVariable Integer id, @RequestBody ReqDistrict reqDistrict){
//
//    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public boolean deleteDistrict(@PathVariable Integer id){
        districtRepository.deleteById(id);
        return true;
    }

}
