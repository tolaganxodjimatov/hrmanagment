package uz.teasy.hrmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.teasy.hrmanagment.entity.Task;
import uz.teasy.hrmanagment.entity.UserEmployee;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(path = "task", collectionResourceRel = "taskList")
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByTaskCode(String taskCode);

    List<Task> findAllByCompletedAtBetweenAndEmployee_Email(Timestamp completedAt, Timestamp completedAt2, String employee_email);

    List<Task> findAllByDeadlineBeforeAndEmployee_EmailAndStatus(Date deadline, String employee_email, Integer status);

    List<Task> findAllByCreatedAtBetweenAndStatusAndEmployee_Email(Timestamp createdAt, Timestamp createdAt2, Integer status, String employee_email);
}