package com.example.demogradleagain.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "emp_dtls")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    @Size(min = 3, message = "Get bigger")
    private String firstName;
    @Size(min = 3, message = "Get bigger. Further.")
    private String lastName;
    private Integer deptId;
    @Min(value = 50000, message = "Can't work")
    @Max(value = 7000000, message = "Exceeds max pay.")
    @NotNull(message = "u dnt wana wrk 4 ntng, do ya?")
    private Double salary;
    @Email(message = "Pls gibh bhalid email")
    private String email;
    @Transient
    private String deptLongDesc;

    public String getDeptLongDesc() {
        return deptLongDesc;
    }

    public void setDeptLongDesc(String deptLongDesc) {
        this.deptLongDesc = deptLongDesc;
    }

    public Employee() {

    }

    public Employee(Integer empId, String firstName, String lastName, Integer deptId, Double salary, String email) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deptId = deptId;
        this.salary = salary;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", deptId='" + deptId + '\'' +
                ", salary=" + salary +
                '}';
    }
}
