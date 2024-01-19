/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ifnti.l3.jee.repositories;

import ifnti.l3.jee.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author loyal
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u Where u.username=:username OR" + " u.email=:username")

    public User findByUsername(@Param("username") String username);

    // User findByUsernameOrEmail(String username);

    User findByEmail(String email);

    // User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    Boolean existsByEmail(String email);

}
