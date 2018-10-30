package edu.salle.examen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.salle.examen.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
