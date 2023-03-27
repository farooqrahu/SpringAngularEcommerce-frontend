package com.rahu.springjwt.repository;

import com.rahu.springjwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.username=?1")
	Optional<User> findByUsername(String username);
	@Query("select u from User u")
	List<User> findAllUsers();
    Optional<User> findByEmail(String email);

  Optional<User> findByEmailIgnoreCase(String email);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  Optional<User> findByUsernameIgnoreCase(String username);
  /**
   * the following method is used to update the jwt sign of the respective user
   *
   * @param jwtSign
   * @param id
   */
  @Modifying
  @Transactional
  @Query("update User set jwtSign = :jwt_sign where id = :id")
  void updateJwtSign(@Param("jwt_sign") String jwtSign, @Param("id") Long id);

}
