package cotemig.ecommerce.model.enumerations;

import javax.persistence.Embeddable;

@Embeddable
public abstract class Enumeration {
    public final int id;
    public final String name;

    public Enumeration(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
