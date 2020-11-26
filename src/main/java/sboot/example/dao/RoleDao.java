package sboot.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sboot.example.model.Role;
import sboot.example.model.RoleName;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    Role findByRoleName(RoleName name);
}
