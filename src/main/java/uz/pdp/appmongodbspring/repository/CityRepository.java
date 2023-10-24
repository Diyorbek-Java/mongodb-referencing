package uz.pdp.appmongodbspring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appmongodbspring.collection.City;

import java.util.Optional;

@Repository
public interface CityRepository extends MongoRepository<City,String> {
    boolean existsAllByName( String name);

    void deleteByName(String name);
    Optional<City> findByName(String name);
}