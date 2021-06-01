package cotemig.ecommerce.controller;

import cotemig.ecommerce.model.dtos.UpdateDeliveryDto;
import cotemig.ecommerce.model.entities.Delivery;
import cotemig.ecommerce.model.entities.Product;
import cotemig.ecommerce.model.exceptions.DomainException;
import cotemig.ecommerce.model.valueobjects.Address;
import cotemig.ecommerce.model.dtos.CreateDeliveryDto;
import cotemig.ecommerce.service.deliveryservice.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deliveries")
public class DeliveriesController {

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
    public void create(@RequestBody CreateDeliveryDto newDelivery) {

        Address address = new Address(newDelivery.getStreet(), newDelivery.getZipCode(), newDelivery.getDistrict(), newDelivery.getCity(), newDelivery.getState());
        Delivery delivery = new Delivery(newDelivery.getPhone(), newDelivery.getDescription(), newDelivery.getKm(), address);

        delivery.setDeliveryPriority(newDelivery.isDamageProneDelivery());

        newDelivery.getProducts().forEach(product -> {
            try {
                var productEntity = new Product(product.getProductName(), product.getProductUnits(), product.getUnitWeight());
                delivery.addDeliveryProduct(productEntity);
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

    @PutMapping("/{id}")
    public void updateById(@PathVariable("id") Integer id, @RequestBody UpdateDeliveryDto updatedDelivery) throws DomainException {
        Delivery delivery = deliveryService.getDeliveryById(id).orElse(null);

        if (delivery == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado nenhuma entrega com este Id");

        delivery.updateDelivery(
                updatedDelivery.getDistanceKm(),
                updatedDelivery.getDescription(),
                updatedDelivery.getPhone(),
                updatedDelivery.getPriorityDelivery(),
                updatedDelivery.getAddress()
        );

        deliveryService.insertDelivery(delivery);

    }
}
