package com.rahu.springjwt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rahu.springjwt.model.Role;
import com.rahu.springjwt.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bnv on 2/10/2017.
 */
@Getter
@Setter
@Builder
@Data
public class UserDto {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String phoneNo;
    private String employeeId;
    private String designation;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private Set<Role> roles = new HashSet<>();
    private String role;
    private Boolean resetPassword;
    private Boolean isActive;
    private String changPwd;
    private Boolean closed;
    private String branch;
    private String totalPurchase;
    private String totalBranchSale;
    private String totalCustomerSale;
    private String totalIncome;

    public Long getId() {
        return id;
    }


    public static UserDto factoryUserDto(User user) {
        return UserDto.builder().id(user.getId()).username(user.getUsername()).build();
    }
}
