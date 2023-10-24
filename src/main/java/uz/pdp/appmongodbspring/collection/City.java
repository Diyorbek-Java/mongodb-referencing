package uz.pdp.appmongodbspring.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class City {
    @Id
    private String objId;

    private String name;
}
