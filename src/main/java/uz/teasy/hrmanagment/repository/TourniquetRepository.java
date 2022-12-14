package uz.teasy.hrmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.teasy.hrmanagment.entity.TourniquetCard;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TourniquetRepository extends JpaRepository<TourniquetCard, UUID> {
    Optional<TourniquetCard> findByEmployee_EmailAndStatusTrue(String employee_email);
}

