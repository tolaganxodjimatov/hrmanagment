package uz.teasy.hrmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.teasy.hrmanagment.config.KimYozganBilish;
import uz.teasy.hrmanagment.entity.UserEmployee;

import java.util.Optional;
import java.util.UUID;

//@RepositoryRestResource(path = "user", collectionResourceRel = "userList")
public interface UserEmployeeRepository extends JpaRepository<UserEmployee, UUID> {
    boolean existsByEmail(String email);

    Optional<UserEmployee> findByEmailAndEmailCode(String email, String emailCode);

    Optional<UserEmployee> findByEmail(String email);

    boolean existsById(UUID uuid);
}
