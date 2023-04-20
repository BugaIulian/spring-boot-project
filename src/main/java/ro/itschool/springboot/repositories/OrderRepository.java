package ro.itschool.springboot.repositories;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.springboot.models.entities.OrderEntity;

@Entity
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
