package com.rahu.springjwt.service;

//import com.rahu.springjwt.dto.PasswordForgotRequestDto;
import com.rahu.springjwt.dto.PasswordForgotRequestDto;
import com.rahu.springjwt.dto.PasswordRequestDto;
import com.rahu.springjwt.dto.UserDto;
import com.rahu.springjwt.enums.Position;
import com.rahu.springjwt.exception.InvalidUserException;
import com.rahu.springjwt.model.RolePermission;
import com.rahu.springjwt.model.User;
import com.rahu.springjwt.model.UserRole;
import com.rahu.springjwt.model.UserStatus;
import com.rahu.springjwt.repository.RolePermissionRepository;
import com.rahu.springjwt.repository.RoleRepository;
import com.rahu.springjwt.repository.UserRepository;
import com.rahu.springjwt.repository.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    protected final MessageSource messageSource;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RolePermissionRepository rolePermissionRepository;
    private final UserRoleRepository userRoleRepository;

    /**
     * the following is used as email template URL
     */
//    @Value("${email.templates.reset-password}")
//    private String resetEmailTemplate;
    /**
     * the following is used as email template URL
     */
//    @Value("${dashboard.reset-password-url}")
//    private String passwordResetUrl;

    public AuthenticationService(UserRepository userRepository, MessageSource messageSource, RoleRepository roleRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RolePermissionRepository rolePermissionRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.messageSource = messageSource;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.rolePermissionRepository = rolePermissionRepository;
        this.userRoleRepository = userRoleRepository;
    }


    /**
     * the following method is used to trigger
     *
     * @param passwordForgotRequestDto
     */
    public void requestPasswordReset(PasswordForgotRequestDto passwordForgotRequestDto) {
        // now check if the user is found or not
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(passwordForgotRequestDto.getEmail()).orElseThrow(InvalidUserException::new));
        // the following stores the token against the respective user, valid for 2 hours
        // i.e. 120 mins
//        userRepository.save(user.setResetToken(UUID.randomUUID().toString()).setResetExpiry(120));
        // generating a map/struct to be used in the email for handling data in the
        // email template
//        Map<String, Object> model = new HashMap<>();
//        model.put("resetUrl", passwordResetUrl + "?token=" + user.getResetToken() + "&email=" + user.getEmail());
//        model.put("firstName", user.getFirstName());
//        model.put("lastName", user.getLastName());
        // sending out email to the respective user
//        emailService.sendEmail(
//                MailDto.factoryMailDto(user.getEmail(),
//                        messageSource.getMessage("reset_password.email.subject", null, Locale.getDefault()), model),
//                resetEmailTemplate);

    }

    /**
     * the following method is used to update respective user's password if the
     * token is valid
     *
     * @param passwordRequestDto
     * @return
     */
    public UserDto resetPassword(PasswordRequestDto passwordRequestDto) {

        // if the password is present update it before passing it onto the service
        if (Optional.ofNullable(passwordRequestDto.getPassword()).isPresent()) {
            passwordRequestDto.setPassword(passwordEncoder.encode(passwordRequestDto.getPassword()));
        }

        // now check if the user is found or not
        User user = userRepository.findByEmail(passwordRequestDto.getEmail()).orElseThrow(InvalidUserException::new);
        // if an invalid token is found, return an exception
        // or the token has expired, return an exception
//        if (!user.getResetToken().equals(passwordRequestDto.getResetToken()) || user.isResetTokenExpired()) {
//            throw new InvalidResetTokenException();
//        }
        // while saving the password, we empty the reset token and set expiry date to
        // null as well
//        return UserDto.factoryUserDto(userRepository.save(user.setResetToken(null).setResetExpiry(null)
//                .setPassword(Optional.ofNullable(passwordRequestDto.getPassword()).orElse(user.getPassword()))));
        return null;
    }

    public UserDto createUser(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new UsernameNotFoundException("Username already exist");
        }
        User userMapper = modelMapper.map(userDto, User.class);
        userMapper.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userMapper.setActive(Boolean.TRUE);
        userMapper.setUser_status(UserStatus.builder().build());
        userMapper.setPosition(Position.admin);
        userMapper = userRepository.save(userMapper);
        this.addUpdateRolePermissionForUser(userMapper);
        return UserDto.factoryUserDto(userMapper);
    }

    /**
     * @param user
     */
    public void addUpdateRolePermissionForUser(User user) {

        Long roleId = null;
        // remove all previous roles if exists
        if (user.getUserRoles() != null) {
            user.getUserRoles().removeAll(user.getUserRoles());
        }

        roleId = this.getRoleIdByPositionTitle(user.getPosition().positionTitle);

        // getting all permission against role
        List<RolePermission> rolePermission = rolePermissionRepository.findAllByRoleId(roleId);

        rolePermission.stream().map(rolePermission1 -> {
            userRoleRepository.save(
                    UserRole.builder().rolePermission(rolePermission1)
                            .user(user).build()
            );
            return true;
        }).collect(Collectors.toList());
    }

    /**
     * @param title
     * @return
     */
    public Long getRoleIdByPositionTitle(String title) {

        Long roleId = null;
        if (title.equalsIgnoreCase("purpl_admin")) {
            roleId = roleRepository.findBySlug("purpl_admin").getId();
        }
        if (title.equalsIgnoreCase("brand_manager")) {
            roleId = roleRepository.findBySlug("brand_manager").getId();
        }
        if (title.equalsIgnoreCase("app_user")) {
            roleId = roleRepository.findBySlug("app_user").getId();
        }

        return roleId;
    }
}
