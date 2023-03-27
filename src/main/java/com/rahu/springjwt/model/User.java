package com.rahu.springjwt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rahu.springjwt.enums.Position;
import com.rahu.springjwt.hibernate.PostgreSQLEnumType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.*;

@Setter
@Getter
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email") })
@TypeDef(name = "position_type", typeClass = PostgreSQLEnumType.class)
public class User extends BaseEntity {

  @Column(unique = true)
  @NotBlank(message = "username must not be blank")
  @Size(max = 20, min = 3, message = "username must be between {min} and {max} characters")
  private String username;
  @Column(unique = true)
  @NotBlank(message = "email must not be blank")
  @Size(max = 50, message = "email must be shorter than {max} characters")
  @Email
  private String email;
  private String jwtSign;

  @JsonIgnore
  @NotBlank(message = "password must not be blank")
  @Size(max = 60, min = 6, message = "password must be between {min} and {max} characters")
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();
  @Column(length = 2)
  @Nullable
  private int age;
  @Nullable
  private String name;
  @Nullable
  private String surname;
  @Column(name = "status")
  private String status = "not activated";
  @Column(nullable = true)
  private Date resetExpiry;
  @Column(nullable = true)
  private String resetToken;
  @Column(columnDefinition = "integer default 0")
  private int failedAttempt;
  private Timestamp lockTime;
  private boolean accountNonLocked;
  @Transient
  private int loginAttemptsRemaining=3;
  @OneToOne
  @JoinColumn(name = "user_status_id")
  private UserStatus user_status;
  private boolean active;
  @JsonBackReference
  @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
  @Builder.Default
  private List<UserRole> userRoles = new ArrayList<>();
  @Enumerated(EnumType.STRING)
  @Type(type = "position_type")
  private Position position;

  @Nullable
  private String address;
  @Nullable
  private String city;
  @Nullable
  private String country;
  @Nullable
  private String job;
  @Nullable
  @Size(max = 600)
  private String description;
  @Nullable
  @Column(nullable = true)
  private boolean image;
  public User() {
  }

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public User(String username, String email, String password, Set<Role> roles) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.roles = roles;
  }

}
