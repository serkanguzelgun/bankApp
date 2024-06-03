package bankappdemo.dataAccess;

import bankappdemo.entities.Customer;
import bankappdemo.entities.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminRepository implements PersonRepository {

    private DbHelper dbHelper = new DbHelper();

    public AdminRepository() {
    }

    @Override
    public void insertData(Customer customer) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbHelper.getConnection();
            String sql = "insert into customer (Name,Password,Balance,IBAN,Identity) values (?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getPassword());
            statement.setDouble(3, customer.getBalance());
            statement.setString(4, customer.getIban());
            statement.setString(5, customer.getIdentity());
            statement.executeUpdate();
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void updateData(Person person) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "update customer set Name = ?, Password = ?, Balance = ?, IBAN = ? where ID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getPassword());
            preparedStatement.setDouble(3, person.getBalance());
            preparedStatement.setString(4, person.getIban());
            preparedStatement.setInt(5, person.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
            }
        }
    }

    public void removeData(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "delete from customer where ID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
            }
        }
    }

    public ArrayList<Customer> getCustomer() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Customer> customers = null;

        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from bank.customer");
            customers = new ArrayList<Customer>();

            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getString("Identity"), resultSet.getInt("ID"), resultSet.getString("Name"), resultSet.getDouble("Balance"), resultSet.getString("IBAN")));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
            }
        }
        return customers;
    }
}
