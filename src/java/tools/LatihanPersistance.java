/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.GeneralController;
import controllers.InterfaceController;
import controllers.daos.GeneralDAO;
import controllers.services.CountryService;
import org.hibernate.SessionFactory;
import controllers.services.RegionService;
import java.math.BigDecimal;
import models.Region;

/**
 *
 * @author Ignatius
 */
public class LatihanPersistance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        RegionService regionService = new RegionService(sessionFactory);
//        System.out.println(regionService.saveOrUpdate("20", "Ini Itu"));
//        System.out.println(regionService.saveOrUpdate("20", "Ini Itu Lagi"));
//        System.out.println(regionService.delete("20"));
//        for (Region region : regionService.getAll()) {
        for (Region region : regionService.search("regionId", "1")) {
            System.out.println(region.getRegionId()+" - "+region.getRegionName());
        }
//        Region region = regionService.getById("3");
//        System.out.println(region.getRegionName());
//        for (Country country : region.getCountryList()) {
//            System.out.println(country.getCountryId()+" - "
//                    +country.getCountryName());
//        }

//        CountryService countryService = new CountryService(sessionFactory);
//        System.out.println(countryService.saveOrUpdate("JO", "Johor", "3"));
//        System.out.println(countryService.saveOrUpdate("JO", "Johor Baru", "3"));
//        System.out.println(countryService.delete("JO"));
//        for (Country country : countryService.getAll()) {
//        for (Country country : countryService.search("countryId", "a")) {
//            System.out.println(country.getCountryId()+" - "
//                    +country.getCountryName()+", with region : "
//                    +country.getRegionId().getRegionId()+" - "
//                    +country.getRegionId().getRegionName());
//        }
//        Country country = countryService.getById("SS");
//        System.out.println(country.getCountryName());
        
//        EmployeeService employeeService = new EmployeeService(sessionFactory);
//        System.out.println(employeeService.saveOrUpdate("313", "Joko", "Santosa", "Joko.Santosass", "085747478817", "22/10/2120", "4500", "0", "90", "100", "IT_PROG"));
//        List<Employee> datas = employeeService.getAll();
//        Employee obj = employeeService.getById("100");
//        for (Field declaredField : Employee.class.getDeclaredFields()) {
//            
//        }
//        for (Object object : employeeService.getAll().toArray(new Object[4])) {
//            System.out.println(object);
//        }
//        Object[] data = regionService.getAll().toArray();
//        for (int i = 0; i < data.length; i++) {
//            System.out.println(data);
//        }

//        GeneralDAO gdao = new GeneralDAO(sessionFactory, Region.class);
//        BigDecimal bc = new BigDecimal("1");
//        System.out.println(bc);
//        System.out.println(gdao.search("regionId", bc).size());
//        for (Region region : regionService.getAll()) {
//            System.out.println(region.getRegionName());
//        }

//        InterfaceController<Region> controller = 
//                new GeneralController<>(sessionFactory, Region.class);
//        Region region1 = controller.getById(new BigDecimal("3"));
//        System.out.println(region1.getRegionName());
//        
//        InterfaceController ic = 
//                new GeneralController(sessionFactory, Region.class);
//        Region region = (Region) ic.getById(new BigDecimal("2"));
//        System.out.println(region.getRegionName());
    }
}
