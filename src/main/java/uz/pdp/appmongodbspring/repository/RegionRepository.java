package uz.pdp.appmongodbspring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appmongodbspring.collection.City;
import uz.pdp.appmongodbspring.collection.Region;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegionRepository extends MongoRepository<Region,String> {
    Optional<List<Region>> findRegionByCity(City city);
    void deleteByName(String name);
    boolean existsAllByName(String name);

}
