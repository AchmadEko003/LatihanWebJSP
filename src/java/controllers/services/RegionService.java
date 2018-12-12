/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.services;

import controllers.GeneralController;
import controllers.InterfaceController;
import models.Region;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ignatius
 */
public class RegionService {

    private final InterfaceController<Region> iController;

    public RegionService(SessionFactory sessionFactory) {
        this.iController = new GeneralController(sessionFactory, Region.class);
    }

    public boolean saveOrUpdate(String regionId, String regionName) {
        Region region = new Region(new BigDecimal(regionId), regionName);
        return iController.doDDL(region, true);
    }

    public boolean delete(String regionId) {
        Region region = new Region(new BigDecimal(regionId));
        return iController.doDDL(region, false);
    }

    public List<Region> getAll() {
        return iController.doDML(false, null, null);
    }

    public List<Region> search(String category, String key) {
        BigDecimal data = new BigDecimal("0");
        if (category.substring(category.length() - 2, category.length()).equalsIgnoreCase("id")) {
            return iController.doDML(true, category, new BigDecimal(key));
        } else {
            return iController.doDML(true, category, key);
        }
    }

    public Region getById(String regionId) {
        return iController.getById(new BigDecimal(regionId));
    }

    public List<Object[]> getAllData(List<Region> regions) {
        List<Object[]> datas = new ArrayList<>();
        int i = 1;
        for (Region region : regions) {
            Object[] data = new Object[3];
            data[0] = i;
            data[1] = region.getRegionId();
            data[2] = region.getRegionName();
            i++;
            datas.add(data);
        }
        return datas;
    }
}
