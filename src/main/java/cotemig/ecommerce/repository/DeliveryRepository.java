package cotemig.ecommerce.repository;

import cotemig.ecommerce.model.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("deliveryRepository")
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

}
