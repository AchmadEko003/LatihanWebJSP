/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.services;

import controllers.GeneralController;
import controllers.InterfaceController;
import models.Country;
import models.Region;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ignatius
 */
public class CountryService {

    private final InterfaceController<Country> iController;

    public CountryService(SessionFactory sessionFactory) {
        this.iController = new GeneralController(sessionFactory, Country.class);
    }

    public boolean saveOrUpdate(String countryId, String countryName, String regionId) {
        Region region = new Region(new BigDecimal(regionId));
        Country country = new Country(countryId, countryName, region);
        return iController.doDDL(country, true);
    }

    public boolean delete(String countryId) {
        Country country = new Country(countryId);
        return iController.doDDL(country, false);
    }

    public List<Country> getAll() {
        return iController.doDML(false, null, null);
    }

    public List<Country> search(String category, String key) {
        return iController.doDML(true, category, key);
    }

    public Country getById(String regionId) {
        return iController.getById(regionId);
    }

    public List<Object[]> getAllData(List<Country> countries) {
        List<Object[]> datas = new ArrayList<>();
        int i = 1;
        for (Country country : countries) {
            Object[] data = new Object[4];
            data[0] = i;
            data[1] = country.getCountryId();
            data[2] = country.getCountryName();
            data[3] = country.getRegionId().getRegionName();
            i++;
            datas.add(data);
        }
        return datas;
    }
}
