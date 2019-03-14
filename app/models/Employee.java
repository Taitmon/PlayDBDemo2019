package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String firstName;
    private String lastName;
    private int titleId;
    private int titleOfCourtesyId;
    private Integer hobbyId;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private String address;
    private String city;
    private String stateId;
    private String zipCode;
    private String personalPhone;
    private String extension;
    private byte[] picture;
    private String notes;
    private Integer reportsToEmployeeId;
    private BigDecimal salary;

    public int getEmployeeId()
    {
        return employeeId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {

        return lastName;
    }

    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    public int getTitleId()
    {
        return titleId;
    }

    public int getTitleOfCourtesyId()
    {
        return titleOfCourtesyId;
    }

    public Integer getHobbyId()
    {
        return hobbyId;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public LocalDate getHireDate()
    {
        return hireDate;
    }

    public String getAddress()
    {
        return address;
    }

    public String getCity()
    {
        return city;
    }

    public String getStateId()
    {
        return stateId;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public String getPersonalPhone()
    {
        return personalPhone;
    }

    public String getExtension()
    {
        return extension;
    }

    public byte[] getPicture()
    {
        return picture;
    }

    public String getNotes()
    {
        return notes;
    }

    public Integer getReportsToEmployeeId()
    {
        return reportsToEmployeeId;
    }

    public BigDecimal getSalary()
    {
        return salary;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setEmployeeId(int employeeId)
    {
        this.employeeId = employeeId;
    }

    public void setTitleId(int titleId)
    {
        this.titleId = titleId;
    }

    public void setTitleOfCourtesyId(int titleOfCourtesyId)
    {
        this.titleOfCourtesyId = titleOfCourtesyId;
    }

    public void setHobbyId(Integer hobbyId)
    {
        this.hobbyId = hobbyId;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    public void setHireDate(LocalDate hireDate)
    {
        this.hireDate = hireDate;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setStateId(String stateId)
    {
        this.stateId = stateId;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public void setPersonalPhone(String personalPhone)
    {
        this.personalPhone = personalPhone;
    }

    public void setExtension(String extension)
    {
        this.extension = extension;
    }

    public void setPicture(byte[] picture)
    {
        this.picture = picture;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public void setReportsToEmployeeId(Integer reportsToEmployeeId)
    {
        this.reportsToEmployeeId = reportsToEmployeeId;
    }

    public void setSalary(BigDecimal salary)
    {
        this.salary = salary;
    }
}
