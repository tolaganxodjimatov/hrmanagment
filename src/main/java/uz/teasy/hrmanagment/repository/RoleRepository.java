package uz.teasy.hrmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.teasy.hrmanagment.entity.Role;
import uz.teasy.hrmanagment.entity.enums.RoleEnum;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleEnum(RoleEnum roleEnum);
}
