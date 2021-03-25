/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntService;

import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author JAIDI
 */
public interface IService <T> {
    
    public void add (T t) throws SQLException;
    public  List<T> read() throws SQLException;
    public void update(T t) throws SQLException;
    public void delete(T t) throws SQLException;

    
    
}