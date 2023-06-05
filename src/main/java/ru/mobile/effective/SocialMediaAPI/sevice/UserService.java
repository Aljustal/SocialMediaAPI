package ru.mobile.effective.SocialMediaAPI.sevice;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mobile.effective.SocialMediaAPI.component.JwtUtil;
import ru.mobile.effective.SocialMediaAPI.model.Post;
import ru.mobile.effective.SocialMediaAPI.model.User;
import ru.mobile.effective.SocialMediaAPI.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final FriendshipRequestService  friendshipRequestService;
    private final PostService  postService;

    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder, JwtUtil jwtUtil, FriendshipRequestService friendshipRequestService, PostService postService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.friendshipRequestService = friendshipRequestService;
        this.postService = postService;
    }

    public void registerUser(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    public String login(String username, String password) {
        UserDetails userDetails = loadUserByUsername(username);
        return jwtUtil.generateToken(userDetails);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

}


