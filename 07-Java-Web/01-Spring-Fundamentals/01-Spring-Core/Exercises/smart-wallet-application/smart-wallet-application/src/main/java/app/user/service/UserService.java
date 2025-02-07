package app.user.service;

import app.exception.DomainException;
import app.subscription.model.Subscription;
import app.subscription.service.SubscriptionService;
import app.user.model.User;
import app.user.model.UserRole;
import app.user.repository.UserRepository;
import app.wallet.model.Wallet;
import app.wallet.service.WalletService;
import app.web.dto.LoginRequest;
import app.web.dto.RegisterRequest;
import app.web.dto.UserEditRequest;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SubscriptionService subscriptionService;
    private final WalletService walletService;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, SubscriptionService subscriptionService, WalletService walletService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.subscriptionService = subscriptionService;
        this.walletService = walletService;
    }

    @Transactional
    public User register(RegisterRequest registerRequest) {
        Optional<User> optionalUser = userRepository.findByUsername(registerRequest.getUsername());

        if (optionalUser.isPresent()) {
            throw new DomainException("User [%s] already exist!".formatted(registerRequest.getUsername()));
        }

        User user = userRepository.save(initializeUser(registerRequest));

        Subscription defaultSubscription = subscriptionService.createDefaultSubscription(user);
        user.setSubscriptions(List.of(defaultSubscription));

        Wallet newWallet = walletService.createNewWallet(user);
        user.setWallets(List.of(newWallet));

        log.info("User [%s] has been created!".formatted(user.getUsername()));

        return user;
    }

    public User login(LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByUsername(loginRequest.getUsername());

        if (optionalUser.isEmpty()) {
            throw new DomainException("Username or password are incorrect!");
        }

        User user = optionalUser.get();

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new DomainException("Username or password are incorrect!");
        }

        return user;
    }

    public void editUserDetails(UUID userId, UserEditRequest userEditRequest) {
        User user = getById(userId);

        user.setFirstName(userEditRequest.getFirstName());
        user.setLastName(userEditRequest.getLastName());
        user.setEmail(userEditRequest.getEmail());
        user.setProfilePicture(userEditRequest.getProfilePicture());

        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new DomainException("User with id [%s] does not exist!".formatted(id)));
    }

    private User initializeUser(RegisterRequest registerRequest) {
        return User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .country(registerRequest.getCountry())
                .role(UserRole.USER)
                .isActive(true)
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();
    }

    public void switchStatus(UUID id) {
        User user = getById(id);

        user.setActive(!user.isActive());
        userRepository.save(user);
    }

    public void switchRole(UUID id) {
        User user = getById(id);

        if (user.getRole() == UserRole.USER) {
            user.setRole(UserRole.ADMIN);
        } else {
            user.setRole(UserRole.USER);
        }

        userRepository.save(user);
    }
}
