package com.hami.learningenglishtabasom.controller;

import com.hami.learningenglishtabasom.auth.AuthRequest;
import com.hami.learningenglishtabasom.auth.AuthResponse;
import com.hami.learningenglishtabasom.entity.User;
import com.hami.learningenglishtabasom.jwt.JwtTokenUtil;
import com.hami.learningenglishtabasom.repository.UserRepository;
import com.hami.learningenglishtabasom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    private AuthResponse authResponse;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private JwtTokenUtil jwtTokenUtil;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {

        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);

        User newUser = userService.addUser(user);

        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);

        User updateUser = userService.addUser(user);

        return new ResponseEntity<>(updateUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAllUser() {

        List<User> user =  userService.findAllUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
        Optional<User> user =  userService.findById(id);
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid  AuthRequest request) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

                    User user = (User) authentication.getPrincipal();

                    String accessToken = jwtTokenUtil.generateAccessToken(user);

            AuthResponse response = new AuthResponse(user.getEmail(), accessToken, user.getRoles().toString());

            return ResponseEntity.ok(response);

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
