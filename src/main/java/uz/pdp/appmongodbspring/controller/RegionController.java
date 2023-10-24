package uz.pdp.appmongodbspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import uz.pdp.appmongodbspring.payload.RegionAddDTO;
import uz.pdp.appmongodbspring.service.RegionService;
import uz.pdp.appmongodbspring.payload.RegionDTO;
import java.util.List;


@RestController
@RequestMapping("region")
@RequiredArgsConstructor
public class RegionController {
    private final RegionService regionService;

    @GetMapping
    public  HttpEntity<List<RegionDTO>> getAllRegions(){
        return ResponseEntity.ok(regionService.getAllRegions());
    }
    @GetMapping("/{cityName}")
    public HttpEntity<List<RegionDTO>> getAllRegionsWithCity(@PathVariable String cityName){
        return ResponseEntity.ok(regionService.getAllByCity(cityName));
    }
    @PostMapping
    public HttpEntity<String> add(@RequestBody RegionAddDTO regionAddDTO){
        return ResponseEntity.ok(regionService.addRegion(regionAddDTO));
    }
    @DeleteMapping("/{regionName}")
    public HttpEntity<String> delete(@PathVariable String regionName){
        return ResponseEntity.ok(regionService.delete(regionName));
    }
}
