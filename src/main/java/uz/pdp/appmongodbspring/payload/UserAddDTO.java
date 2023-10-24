package uz.pdp.appmongodbspring.payload;

import lombok.Data;
import uz.pdp.appmongodbspring.collection.City;
import uz.pdp.appmongodbspring.collection.Region;
@Data
public class UserAddDTO {
    private String name;
    private String username;
    private String email;
    private City city;
    private Region region;
}
