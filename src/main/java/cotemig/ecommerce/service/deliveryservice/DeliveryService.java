package cotemig.ecommerce.service.deliveryservice;

import cotemig.ecommerce.model.entities.Delivery;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {
    Optional<Delivery> getDeliveryById(Integer id);

    List<Delivery> getAllDeliveries();

    void deleteAllDeliveries();

    void deleteDeliveryById(Integer id);

    void insertDelivery(Delivery delivery);
}
