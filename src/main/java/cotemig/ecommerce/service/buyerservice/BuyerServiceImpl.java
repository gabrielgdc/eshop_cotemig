package cotemig.ecommerce.service.buyerservice;

import cotemig.ecommerce.model.entities.Buyer;
import cotemig.ecommerce.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("buyerService")
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerRepository buyerRepository;

    @Override
    public Optional<Buyer> getBuyerById(Integer id) {
        return buyerRepository.findById(id);
    }

    @Override
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    @Override
    public void deleteAllBuyers() {
        buyerRepository.deleteAll();
    }

    @Override
    public void deleteBuyerById(Integer id) {
        buyerRepository.deleteById(id);
    }

    @Override
    public void insertBuyer(Buyer buyer) {
        buyerRepository.save(buyer);
    }
}
