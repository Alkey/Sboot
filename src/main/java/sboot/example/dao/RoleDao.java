package sboot.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sboot.example.model.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
}
