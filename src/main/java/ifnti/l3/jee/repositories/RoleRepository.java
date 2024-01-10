package ifnti.l3.jee.repositories;

import org.springframework.stereotype.Repository;

import ifnti.l3.jee.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
