package sboot.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sboot.example.dao.RoleDao;
import sboot.example.model.Role;
import sboot.example.model.RoleName;
import sboot.example.service.RoleService;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao dao;

    @Override
    public Role findByName(String roleName) {
        return dao.findByRoleName(RoleName.valueOf(roleName));
    }

    @Override
    public Role save(Role role) {
        return dao.save(role);
    }
}
