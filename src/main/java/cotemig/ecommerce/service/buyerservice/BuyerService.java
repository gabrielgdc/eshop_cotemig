package cotemig.ecommerce.service.buyerservice;

import cotemig.ecommerce.model.entities.Buyer;

import java.util.List;
import java.util.Optional;

public interface BuyerService {
    Optional<Buyer> getBuyerById(Integer id);

    List<Buyer> getAllBuyers();

    void deleteAllBuyers();

    void deleteBuyerById(Integer id);

    void insertBuyer(Buyer buyer);
}
