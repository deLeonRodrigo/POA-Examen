package edu.salle.examen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.salle.examen.Model.Task;

@Repository
public interface taskRepository extends JpaRepository<Task, Long> {

}
