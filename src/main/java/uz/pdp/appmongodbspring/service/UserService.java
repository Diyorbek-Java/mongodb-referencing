package uz.pdp.appmongodbspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.appmongodbspring.collection.Region;
import uz.pdp.appmongodbspring.collection.User;
import uz.pdp.appmongodbspring.payload.Address;
import uz.pdp.appmongodbspring.payload.UserAddDTO;
import uz.pdp.appmongodbspring.payload.UserDTO;
import uz.pdp.appmongodbspring.repository.CityRepository;
import uz.pdp.appmongodbspring.repository.RegionRepository;
import uz.pdp.appmongodbspring.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RegionRepository regionRepository;
    private final CityRepository cityRepository;
    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDTO> result=new ArrayList<>();
        users.forEach(user -> {
            Region region = user.getRegion();
            result.add(
                    UserDTO.builder().address(Address.builder().cityName(region.getCity().getName()).regionName(region.getName()).build())
                            .name(user.getName()).username(user.getUsername()).build());
        });
        return result;
    }
    public UserDTO findById(String id){
        return null;
    }

    public UserDTO updateUser(String id, User updatingUser) {
        return null;
    }

    public void deleteById(String id) {

    }

    public Page<UserDTO> findAll(Pageable pageable) {
        return null;
    }

    public UserDTO saveUser(UserAddDTO user) {




        return null;
    }
}
