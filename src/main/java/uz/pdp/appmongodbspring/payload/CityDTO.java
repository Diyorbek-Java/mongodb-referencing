package uz.pdp.appmongodbspring.payload;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CityDTO {
    private  String name;
    private List<RegionDTO> regions;
}
