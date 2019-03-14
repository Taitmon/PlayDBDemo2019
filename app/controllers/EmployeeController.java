package controllers;

import models.Employee;
import models.State;
import play.Logger;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public class EmployeeController extends Controller
{
    private JPAApi db;

    private FormFactory formFactory;

    @Inject
    public EmployeeController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;
    }

    @Transactional(readOnly = true)
    public Result getEmployee(int employeeId )
    {
        Employee reportsTo = null;

        TypedQuery<Employee> query = db.em().createQuery("SELECT e FROM Employee e WHERE employeeId = :employeeId", Employee.class);
        query.setParameter("employeeId", employeeId);
        Employee employee = query.getSingleResult();

        if(employee.getReportsToEmployeeId() != null)
        {
            query.setParameter("employeeId", employee.getReportsToEmployeeId());
            reportsTo = query.getSingleResult();
        }

        TypedQuery<State> statesQuery = db.em().createQuery("Select s FROM State s WHERE StateId = :stateId", State.class);
        statesQuery.setParameter("stateId", employee.getStateId());
        State state = statesQuery.getSingleResult();

        TypedQuery<Employee> reportsQuery = db.em().createQuery("SELECT e FROM Employee e WHERE reportsToEmployeeId = :employeeId", Employee.class);
        reportsQuery.setParameter("employeeId", employeeId);
        List<Employee> reports = reportsQuery.getResultList();


        return ok(views.html.employee.render(employee, reports, reportsTo, state));
    }

    @Transactional(readOnly = true)
    public Result getPicture(int employeeId)
    {
        TypedQuery<Employee> query = db.em().createQuery("SELECT e FROM Employee e WHERE employeeId = :employeeId", Employee.class);
        query.setParameter("employeeId", employeeId);
        Employee employee = query.getSingleResult();

        return ok(employee.getPicture());
    }

    @Transactional(readOnly = true)
    public Result getEmployeeEdit(int employeeId )
    {
        TypedQuery<Employee> query = db.em().createQuery("SELECT e FROM Employee e WHERE employeeId = :employeeId", Employee.class);
        query.setParameter("employeeId", employeeId);
        Employee employee = query.getSingleResult();

        return ok(views.html.employeeedit.render(employee));
    }


    public Result getEmployeeAdd()
    {
        return ok(views.html.employeeadd.render());
    }

    @Transactional
    public Result postEmployeeEdit(int employeeId )
    {
        TypedQuery<Employee> query = db.em().createQuery("SELECT e FROM Employee e WHERE employeeId = :employeeId", Employee.class);
        query.setParameter("employeeId", employeeId);
        Employee employee = query.getSingleResult();

        DynamicForm form = formFactory.form().bindFromRequest();
        String firstName = form.get("firstName");
        String lastName = form.get("lastName");
        Logger.debug(firstName);

        employee.setFirstName(firstName);
        db.em().persist(employee);
        employee.setLastName(lastName);
        db.em().persist(employee);

        return ok("saved");
    }

    @Transactional
    public Result postEmployeeAdd()
    {

        Employee employee = new Employee();

        DynamicForm form = formFactory.form().bindFromRequest();

        int employeeId = Integer.parseInt(form.get("employeeId"));
        String firstName = form.get("firstName");
        String lastName = form.get("lastName");
        int titleId = Integer.parseInt(form.get("titleId"));
        int titleOfCourtesyId = Integer.parseInt(form.get("titleOfCourtesyId"));
        int hobbyId = Integer.parseInt(form.get("hobbyId"));
        LocalDate birthDate = LocalDate.parse("birthDate");
        LocalDate hireDate = LocalDate.parse("hireDate");
        String address = form.get("address");
        String city = form.get("city");
        String stateId = form.get("stateId");
        String zipCode = form.get("zipCode");
        String personalPhone = form.get("personalPhone");
        String extension = form.get("extension");
//        byte[] picture = form.get("picture");
        String notes = form.get("notes");
        Integer reportsToEmployeeId = Integer.parseInt(form.get("reportsToEmployeeId"));
        BigDecimal salary = new BigDecimal(form.get("salary"));


        employee.setFirstName(firstName);
        //db.em().persist(employee);
        employee.setLastName(lastName);
        //db.em().persist(employee);
        employee.setTitleId(titleId);
        employee.setTitleOfCourtesyId(titleOfCourtesyId);
        employee.setHobbyId(hobbyId);
        employee.setAddress(address);
        employee.setCity(city);
        employee.setStateId(stateId);
        employee.setEmployeeId(employeeId);
        employee.setBirthDate(birthDate);
        employee.setHireDate(hireDate);
        employee.setZipCode(zipCode);
        employee.setPersonalPhone(personalPhone);
        employee.setExtension(extension);
//        employee.setPicture(picture);
        employee.setNotes(notes);
        employee.setReportsToEmployeeId(reportsToEmployeeId);
        employee.setSalary(salary);


        return ok("saved");
    }
}
