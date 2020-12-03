package sboot.example.service;

import sboot.example.model.Role;

public interface RoleService {
    Role findByName(String roleName);

    Role save(Role role);

}
