package uz.pdp.appmongodbspring.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uz.pdp.appmongodbspring.collection.User;

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByEmail(String email);

    boolean existsByObjIdNotAndEmail(String objId, String email);
}
