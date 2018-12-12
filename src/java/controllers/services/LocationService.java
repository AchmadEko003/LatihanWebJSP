/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.services;

import controllers.GeneralController;
import controllers.InterfaceController;
import java.util.ArrayList;
import models.Country;
import models.Location;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ignatius
 */
public class LocationService {
    private final InterfaceController<Location> iController;

    public LocationService(SessionFactory sessionFactory) {
        this.iController = new GeneralController(sessionFactory, Location.class);
    }
    
    public boolean saveOrUpdate(String locationId, String streetAddress, 
            String postalCode, String city, String stateProvince, String countryId){
        Country country = new Country(countryId);
        Location location = new Location(new Short(locationId), streetAddress, postalCode, 
                city, stateProvince, country);
        return iController.doDDL(location, true);
    }
    
    public boolean delete(String locationId){
        Location location = new Location(new Short(locationId));
        return iController.doDDL(location, false);
    }
    
    public List<Location> getAll(){
        return iController.doDML(false, null, null);
    }
    
    public List<Location> search(String category, String key){
        return iController.doDML(true, category, key);
    }
    
    public Location getById(String locationId){
        return iController.getById(new Short(locationId));
    }
    
    public List<Object[]> getAllData(List<Location> locations){
        List<Object[]> datas = new ArrayList<>();
        int i = 1;
        for (Location location : locations) {
            Object[] data = new Object[7];
            data[0]=i;
            data[1]=location.getLocationId();
            data[2]=location.getStreetAddress();
            data[3]=location.getCity();
            data[4]=location.getPostalCode();
            data[5]=location.getStateProvince();
            data[6]=location.getCountryId().getCountryName();
            i++;
            datas.add(data);
        }
        return datas;
    }
}
