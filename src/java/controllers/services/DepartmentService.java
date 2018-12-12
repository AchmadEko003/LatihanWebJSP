/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.services;

import controllers.GeneralController;
import controllers.InterfaceController;
import java.util.ArrayList;
import models.Department;
import models.Employee;
import models.Location;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ignatius
 */
public class DepartmentService {
    private final InterfaceController<Department> iController;

    public DepartmentService(SessionFactory sessionFactory) {
        this.iController = new GeneralController(sessionFactory, Department.class);
    }
    
    public boolean saveOrUpdate(String departmentId, String departmentName, String managerId, String locationId){
        Employee employee = new Employee(new Integer(managerId));
        Location location = new Location(new Short(locationId));
        Department department = new Department(new Short(departmentId), departmentName, employee, location);
        return iController.doDDL(department, true);
    }
    
    public boolean delete(String departmentId){
        Department department = new Department(new Short(departmentId));
        return iController.doDDL(department, false);
    }
    
    public List<Department> getAll(){
        return iController.doDML(false, null, null);
    }
    
    public List<Department> search(String category, String key){
        return iController.doDML(true, category, key);
    }
    
    public Department getById(String departmentId){
        return iController.getById(new Short(departmentId));
    }
    
    public List<Object[]> getAllData(List<Department> departments){
        List<Object[]> datas = new ArrayList<>();
        int i = 1;
        for (Department department : departments) {
            Object[] data = new Object[5];
            data[0]=i;
            data[1]=department.getDepartmentId();
            data[2]=department.getDepartmentName();
            data[3]=department.getManagerId().getLastName()
                    +","+department.getManagerId().getFirstName();
            data[4]=department.getLocationId().getCity();
            i++;
            datas.add(data);
        }
        return datas;
    }
}
