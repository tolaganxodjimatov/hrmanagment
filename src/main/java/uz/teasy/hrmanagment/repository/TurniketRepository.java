package uz.teasy.hrmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import uz.teasy.hrmanagment.entity.Turniket;

@RepositoryRestResource(path = "turniket", collectionResourceRel = "turniketList")
public interface TurniketRepository extends JpaRepository<Turniket,Integer> {

}
