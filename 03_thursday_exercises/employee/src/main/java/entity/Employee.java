package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String address;
    private int salary;

    public Employee() { }

    public Employee(String name, String address, int salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee: " + name + ", address: " + address + ", salary: " + salary;
    }
    
    
    
}
