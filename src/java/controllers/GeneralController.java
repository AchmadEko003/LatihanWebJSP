/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.daos.GeneralDAO;
import controllers.daos.InterfaceDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ignatius
 * @param <T>
 */
public class GeneralController<T> implements InterfaceController<T> {

    private final InterfaceDAO iDAO;

    public GeneralController(SessionFactory sessionFactory, Class type) {
        this.iDAO = new GeneralDAO(sessionFactory, type);
    }

    @Override
    public boolean doDDL(T t, boolean isSave) {
        if (isSave) return iDAO.saveOrUpdate(t);
        else return iDAO.delete(t);
    }

    @Override
    public List<T> doDML(boolean isSearch, String category, Object key) {
        if (isSearch) return (List<T>) castToT(iDAO.search(category, key));
        else return (List<T>) castToT(iDAO.getAll());
    }

    @Override
    public T getById(Object id) {
        return (T) iDAO.getById(id);
    }

    private List<T> castToT(List<Object> datas){
        List<T> results = new ArrayList<>();
        datas.stream().map((data) -> (T) data)
                .forEachOrdered((result) -> {
            results.add(result);
        });
        return results;
    }
}
