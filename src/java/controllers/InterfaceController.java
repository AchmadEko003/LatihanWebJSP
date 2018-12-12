/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;

/**
 *
 * @author Ignatius
 * @param <T>
 */
public interface InterfaceController<T> {
    public boolean doDDL(T t,boolean isSave);
    public List<T> doDML(boolean isSearch,String category, Object key);
    public T getById(Object id);
}
