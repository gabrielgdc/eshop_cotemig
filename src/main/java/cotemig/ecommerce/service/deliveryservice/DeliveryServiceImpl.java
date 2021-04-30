package cotemig.ecommerce.service.deliveryservice;

import cotemig.ecommerce.model.entities.Delivery;
import cotemig.ecommerce.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("deliveryService")
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Override
    public Optional<Delivery> getDeliveryById(Integer id) {
        return deliveryRepository.findById(id);
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public void deleteAllDeliveries() {
        deliveryRepository.deleteAll();
    }

    @Override
    public void deleteDeliveryById(Integer id) {
        deliveryRepository.deleteById(id);
    }

    @Override
    public void insertDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }
}
