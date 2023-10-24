package uz.pdp.appmongodbspring.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appmongodbspring.collection.User;
import uz.pdp.appmongodbspring.payload.UserAddDTO;
import uz.pdp.appmongodbspring.payload.UserDTO;
import uz.pdp.appmongodbspring.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public HttpEntity<Page<UserDTO>> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sort,
            @RequestParam(defaultValue = "ASC") Sort.Direction sortType,
            @RequestParam(defaultValue = "") String search) {

        Pageable pageable = PageRequest.of(page, size, sortType, sort);

        Page<UserDTO> all = userService.findAll(pageable);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<UserDTO> one(@PathVariable String id) {
        UserDTO user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public HttpEntity<UserDTO> add(@RequestBody UserAddDTO user) {
        UserDTO userDTO = userService.saveUser(user);
        return ResponseEntity.ok(userDTO);
    }
    @PutMapping("/{id}")
    public HttpEntity<UserDTO> edit(@PathVariable String id,
                                 @RequestBody User updatingUser) {
        UserDTO user= userService.updateUser(id,updatingUser);

        return ResponseEntity.ok(user);
    }


    @DeleteMapping("/{id}")
    public HttpEntity<Boolean> delete(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
