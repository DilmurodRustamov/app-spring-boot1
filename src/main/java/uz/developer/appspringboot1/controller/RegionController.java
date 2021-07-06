package uz.developer.appspringboot1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.developer.appspringboot1.entity.Region;
import uz.developer.appspringboot1.payload.ReqRegion;
import uz.developer.appspringboot1.repository.RegionRepository;
import uz.developer.appspringboot1.service.RegionService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/region")
public class RegionController {
    @Autowired
    RegionService regionService;

    @Autowired
    RegionRepository regionRepository;

    @PostMapping("/add")
    @ResponseBody
    public HttpEntity<Boolean> addRegion(@Valid @RequestBody ReqRegion reqRegion){
        boolean addRegion = regionService.addRegion(reqRegion);
        return ResponseEntity.status(addRegion?HttpStatus.CREATED:HttpStatus.CONFLICT).body(addRegion);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Region> regions() {
        return regionService.getRegions();
    }

    @GetMapping("{id}")
    @ResponseBody
    public Region getRegion(@PathVariable Integer id){
        Optional<Region> optionalRegion = regionRepository.findById(id);
        return optionalRegion.orElseGet(Region::new);
    }

    @PutMapping("/edit/{id}")
    @ResponseBody
    public boolean editRegion(@PathVariable Integer id, @RequestBody ReqRegion reqRegion){
        return regionService.editRegion(id, reqRegion);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public boolean deleteRegion(@PathVariable Integer id){
        regionRepository.deleteById(id);
        return true;
    }
}
