package uz.pdp.appmongodbspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.appmongodbspring.collection.City;
import uz.pdp.appmongodbspring.collection.Region;
import uz.pdp.appmongodbspring.payload.RegionAddDTO;
import uz.pdp.appmongodbspring.repository.CityRepository;
import uz.pdp.appmongodbspring.payload.RegionDTO;
import uz.pdp.appmongodbspring.repository.RegionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;
    private final CityRepository cityRepository;

    public List<RegionDTO> getAllRegions(){
        return regionDTOMaker(regionRepository.findAll());
    }
    public  List<RegionDTO> getAllByCity(String cityName) {
        City city = cityRepository.findByName(cityName).orElseThrow(RuntimeException::new);
        return regionDTOMaker(regionRepository.findRegionByCity(city).orElseThrow(RuntimeException::new));
    }


    public String addRegion(RegionAddDTO regionAddDTO) {
        String cityName = regionAddDTO.getCity_name();
        String dtoName = regionAddDTO.getName();
        if (!(cityRepository.existsAllByName(cityName) && regionRepository.existsAllByName(dtoName))) {
            City city = cityRepository.findByName(cityName).orElseThrow(RuntimeException::new);
            Region region =new Region();
            region.setCity(city);
            region.setName(dtoName);
            region.setStreet(regionAddDTO.getStreet());
            regionRepository.save(region);
            return dtoName+" successfully added";
        }
        return dtoName+" already exisit";
    }
    public String delete(String regionName) {
        regionRepository.deleteByName(regionName);
        return "successfully removed";
    }
    private List<RegionDTO> regionDTOMaker(List<Region> regions){
        List<RegionDTO> regionDTOS=new ArrayList<>();
        regions.forEach(region ->
                regionDTOS.add(RegionDTO.builder().name(region.getName()).street(region.getStreet()).build())
        );
        return regionDTOS;
    }
}
