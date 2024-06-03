package bankappdemo.entities;

public class Person {
    private int id;
    private String name;
    private String password;
    private double balance;
    private String iban;

    public Person(int id, String name, String password, double balance, String iban) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.iban = iban;
    }

    public Person(int id, String name, double balance, String iban) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.iban = iban;
    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
