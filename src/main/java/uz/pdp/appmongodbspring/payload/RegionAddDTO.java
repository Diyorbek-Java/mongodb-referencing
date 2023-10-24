package uz.pdp.appmongodbspring.payload;

import lombok.Data;
import uz.pdp.appmongodbspring.collection.City;

@Data
public class RegionAddDTO {
    private String name;
    private String street;
    private String city_name;
}
