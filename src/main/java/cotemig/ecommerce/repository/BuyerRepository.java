package cotemig.ecommerce.repository;

import cotemig.ecommerce.model.entities.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("buyerRepository")
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

}
