package cotemig.ecommerce.model.enumerations;

public abstract class Enumeration {
    public final int id;
    public final String name;

    public Enumeration(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
