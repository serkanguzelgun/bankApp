package bankappdemo.dataAccess;

import bankappdemo.entities.Customer;
import bankappdemo.entities.Person;

public interface PersonRepository{
    public void insertData(Customer customer);
    public void updateData(Person person);
}
