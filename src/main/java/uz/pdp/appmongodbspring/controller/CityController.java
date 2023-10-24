package uz.pdp.appmongodbspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import uz.pdp.appmongodbspring.service.CityService;
import uz.pdp.appmongodbspring.payload.CityDTO;
import uz.pdp.appmongodbspring.payload.CityAddDTO;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("city")
public class CityController {
    private final CityService cityService;
    @GetMapping
    public List<String> getCities(){
        return cityService.getCity();
    }

    @GetMapping("/{cityName}")
    public List<CityDTO> getCityWithRegions(@PathVariable String cityName){
        return cityService.getCityWithRegion(cityName);
    }
    @PostMapping
    public String add(@RequestBody CityAddDTO cityAddDTO){
        return cityService.save(cityAddDTO);
    }

    @DeleteMapping("/{cityName}")
    public HttpEntity<String> deleteCity(@PathVariable String cityName){
        return ResponseEntity.ok(cityService.delete(cityName));
    }

}
