package dto;

import entities.BankCustomer;

/**
 *
 * @author ibenk
 */
public class CustomerDTO {

    private long customerID;
    private String firstName;
    private String lastName;
    private String accountNumber;
    private double balance;

    public CustomerDTO() {
    }

    public CustomerDTO(BankCustomer customer) {
        this.customerID = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.accountNumber = customer.getAccountNumber();
        this.balance = customer.getBalance();
    }

    @Override
    public String toString() {
        return "Id: " + customerID + ", name: " + firstName + " " + lastName + ", accountNumber: " + accountNumber + ", balance: " + balance;
    }
}
