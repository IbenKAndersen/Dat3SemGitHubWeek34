package dto;

import entity.Employee;

/**
 *
 * @author ibenk
 */
public class EmployeeDTO {

    private long id;
    private String name;
    private String address;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.address = employee.getAddress();
    }

    @Override
    public String toString() {
        return "Id: " + id + ", name: " + name + ", address: " + address;
    }
    
}