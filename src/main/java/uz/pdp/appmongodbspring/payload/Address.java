package uz.pdp.appmongodbspring.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private String cityName;

    private String regionName;

    private String zipcode;

}
