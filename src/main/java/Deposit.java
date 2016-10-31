import java.math.BigDecimal;


/**
 * Created by Yasi on 10/31/2016.
 */
public class Deposit {
    private String customer;
    private String id;
    private Integer initialBalance;
    private BigDecimal upperBound;

    public Deposit(String customer, String id, Integer initialBalance, BigDecimal upperBound) {
        this.customer = customer;
        this.id = id;
        this.initialBalance = initialBalance;
        this.upperBound = upperBound;
    }

    public String getCustomer() {
        return customer;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getUpperBound() {
        return upperBound;
    }

    public Integer getInitialBalance() {
        return initialBalance;
    }
    public void withdraw(Integer amount)throws BalanceException {
        if (amount <= initialBalance){
            initialBalance = initialBalance - amount;
        }
        else throw new BalanceException("There is not enough balance.");
        System.out.println("withdraw "+initialBalance);
    }
    public void deposit(Integer amount) throws BalanceException {
        Integer temp = amount + initialBalance;
        if (temp <= upperBound.intValue()){
            initialBalance = temp;
        }
        else throw new BalanceException("Transaction is more than amount that allowed.");
        System.out.println("Deposit "+initialBalance);
    }
}