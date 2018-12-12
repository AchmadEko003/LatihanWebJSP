/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.services;

import controllers.GeneralController;
import controllers.InterfaceController;
import models.Department;
import models.Employee;
import models.Job;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ignatius
 */
public class EmployeeService {
    private final InterfaceController<Employee> iController;

    public EmployeeService(SessionFactory sessionFactory) {
        this.iController = new GeneralController(sessionFactory, Employee.class);
    }
    
    public boolean saveOrUpdate(String employeeId, String firstName, String lastName, 
            String email, String phoneNumber, String hireDate, String salary, 
            String commissionPct, String departmentId, String managerId, String jobId){
        Department department = new Department(new Short(departmentId));
        Employee e = new Employee(new Integer(managerId));
        Job job = new Job(jobId);
        Employee employee = new Employee(new Integer(employeeId), firstName, lastName,
                email, phoneNumber, new Date(hireDate)
                , new BigDecimal(salary), new BigDecimal(commissionPct), department, e, job);
        return iController.doDDL(employee, true);
    }
    
    public boolean delete(String employeeId){
        Employee employee = new Employee(new Integer(employeeId));
        return iController.doDDL(employee, false);
    }
    
    public List<Employee> getAll(){
        return iController.doDML(false, null, null);
    }
    
    public List<Employee> search(String category, String key){
        return iController.doDML(true, category, key);
    } 
    
    public Employee getById(String employeeId){
        return iController.getById(new Integer(employeeId));
    }
    
    public List<Object[]> getAllData(List<Employee> employees){
        List<Object[]> datas = new ArrayList<>();
        int i = 1;
        for (Employee employee : employees) {
            Object[] data = new Object[11];
            data[0]=i;
            data[1]=employee.getEmployeeId();
            data[2]=employee.getLastName()+","+employee.getFirstName();
            data[3]=employee.getEmail();
            data[4]=employee.getEmployeeId();
            data[5]=employee.getEmployeeId();
            data[6]=employee.getEmployeeId();
            data[7]=employee.getEmployeeId();
            data[8]=employee.getEmployeeId();
            data[9]=employee.getEmployeeId();
            data[10]=employee.getEmployeeId();
            i++;
            datas.add(data);
        }
        return datas;
    }  
    
}
