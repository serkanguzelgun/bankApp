package bankappdemo.entities;

public class Customer extends Person{
    private String identity;

    public Customer(String identity, int id, String name, String password, double balance, String iban) {
        super(id, name, password, balance, iban);
        this.identity = identity;
    }

    public Customer(String identity, int id, String name, double balance, String iban) {
        super(id, name, balance, iban);
        this.identity = identity;
    }

    public Customer(String identity) {
        this.identity = identity;
    }
    
    public Customer(){
        
    }   

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
