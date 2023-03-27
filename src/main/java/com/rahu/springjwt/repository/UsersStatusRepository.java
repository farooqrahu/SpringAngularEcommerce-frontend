/**
 * @author Junaid Butt
 * @email junaid.butt@ideatolife.me
 * @create date 2020-05-07 05:44:46
 * @modify date 2020-05-07 05:44:46
 * @desc [description]
 */
package com.rahu.springjwt.repository;

import com.rahu.springjwt.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersStatusRepository extends JpaRepository<UserStatus, Long> {

    /**
     * the following is used to get the respective status by name
     *
     * @param status
     * @return
     */
    Optional<UserStatus> findByStatus(String status);

}
