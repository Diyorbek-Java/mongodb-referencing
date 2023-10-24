package uz.pdp.appmongodbspring.collection;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;

@Data
@Document
public class User {

    @Id
    private String objId;

    private String name;

    private String username;

    @Indexed(unique = true)
    private String email;

    @DBRef
    private Region region;
}
