package uz.pdp.appmongodbspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.appmongodbspring.collection.City;
import uz.pdp.appmongodbspring.payload.CityAddDTO;
import uz.pdp.appmongodbspring.payload.CityDTO;
import uz.pdp.appmongodbspring.repository.CityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final RegionService regionService;

    public List<String> getCity(){
        List<String> all = new ArrayList<>();
        cityRepository.findAll().forEach(city -> {
            all.add(city.getName());
        });
        return all;
    }
    public List<CityDTO> getCityWithRegion(String cityName){
        return cityDTOMaker(cityRepository.findAll(),cityName);
    }

    private List<CityDTO> cityDTOMaker(List<City>cities){
        List<CityDTO> result=new ArrayList<>();
        cities.forEach(city -> {
            result.add(CityDTO.builder().name(city.getName()).regions(regionService.getAllByCity(city.getName())).build());
        });
        return result;
    }
    private List<CityDTO> cityDTOMaker(List<City>cities,String cityName){
        if (cityName==null)
            throw  new RuntimeException();
        List<CityDTO> result=new ArrayList<>();
        cities.forEach(city -> {
            if (cityName.equals(city.getName())){
                result.add(CityDTO.builder().name(city.getName()).regions(regionService.getAllByCity(city.getName())).build());
            }
        });
        return result;
    }

    public String save(CityAddDTO cityAddDTO) {
        String name = cityAddDTO.getName();
        if (!cityRepository.existsAllByName(name)) {
            City city = new City();
            city.setName(name);
            cityRepository.save(city);
            return name+"successfully added";
        }
        return "the city already exist";
    }

    public String delete(String cityName) {
        cityRepository.deleteByName(cityName);
        return "successfully removed";
    }
}
