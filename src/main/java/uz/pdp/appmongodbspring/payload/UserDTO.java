package uz.pdp.appmongodbspring.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private String name;

    private String username;

    private Address address;
}
