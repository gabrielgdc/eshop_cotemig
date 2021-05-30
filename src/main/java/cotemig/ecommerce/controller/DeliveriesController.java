package cotemig.ecommerce.controller;

import cotemig.ecommerce.commands.CreateDeliveryCommand;
import cotemig.ecommerce.model.entities.Delivery;
import cotemig.ecommerce.model.valueobjects.Address;
import cotemig.ecommerce.model.viewmodels.CreateDeliveryVm;
import cotemig.ecommerce.service.deliveryservice.DeliveryService;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/delivery")
@AllArgsConstructor
public class DeliveriesController {

    SimpleCommandBus bus;

    @Autowired
    DeliveryService deliveryService;

    @GetMapping("/{id}")
    public Optional<Delivery> getById(@PathVariable("id") Integer id) {
        return deliveryService.getDeliveryById(id);
    }

    @GetMapping()
    public List<Delivery> getAll() {
        return deliveryService.getAllDeliveries();
    }

    @PostMapping()
    public void create(@RequestBody CreateDeliveryVm newDelivery) {

        Address address = new Address(newDelivery.getStreet(), newDelivery.getZipCode(), newDelivery.getDistrict(), newDelivery.getCity(), newDelivery.getState());
        Delivery delivery = new Delivery(newDelivery.getPhone(), newDelivery.getDescription(), newDelivery.getKm(), address);

        delivery.setDeliveryPriority(newDelivery.isDamageProneDelivery());

        newDelivery.getProducts().forEach(product -> {
            try {
                delivery.addDeliveryProduct(product);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        deliveryService.insertDelivery(delivery);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        deliveryService.deleteDeliveryById(id);
    }
}
