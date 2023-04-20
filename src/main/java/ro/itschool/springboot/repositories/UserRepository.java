package ro.itschool.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.itschool.springboot.models.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}