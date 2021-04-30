package cotemig.ecommerce.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Integer id;
    private final String cpfCnpj;
    private final String name;

    public Buyer(Integer id, String cpfCnpj, String name) {
        this.id = id;
        this.cpfCnpj = cpfCnpj;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getName() {
        return name;
    }
}
