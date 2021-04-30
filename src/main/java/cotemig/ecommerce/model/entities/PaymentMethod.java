package cotemig.ecommerce.model.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final String id;
    private final String alias;
    private final String cardNumber;
    private final String securityNumber;
    private final String cardHolderName;
    private final Date expirationDate;

    public PaymentMethod(String id, String alias, String cardNumber, String securityNumber, String cardHolderName, Date expirationDate) {
        this.id = id;
        this.alias = alias;
        this.cardNumber = cardNumber;
        this.securityNumber = securityNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
    }

    public String getId() {
        return id;
    }

    public String getAlias() {
        return alias;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
