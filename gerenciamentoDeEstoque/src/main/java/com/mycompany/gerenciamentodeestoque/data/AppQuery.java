/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciamentodeestoque.data;

import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Glória
 */
public class AppQuery {
    
    private DBConnection c = new DBConnection();
    
    public void register(com.mycompany.gerenciamentodeestoque.model.Product product) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO produto (codigo_produto,nome,quantidade) VALUES (?,?,?)");
            ps.setInt(1,product.getCode());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getQuantity());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public ObservableList<com.mycompany.gerenciamentodeestoque.model.Product> getProductList() {
        ObservableList<com.mycompany.gerenciamentodeestoque.model.Product> productList = FXCollections.observableArrayList();
           try{
               String query = "SELECT id, codigo_produto, nome, quantidade FROM produto ORDER BY nome ASC";
               c.getDBConn();
               Statement st = c.getCon().createStatement();
               ResultSet rs = st.executeQuery(query);
               com.mycompany.gerenciamentodeestoque.model.Product p;
               while(rs.next()){
                   p = new com.mycompany.gerenciamentodeestoque.model.Product(rs.getInt("id"), rs.getInt("codigo_produto"), rs.getString("nome"), rs.getInt("quantidade"));
                   productList.add(p);
               }
               rs.close();
               st.close();
               c.closeConnection();
           } catch (Exception e){
               e.printStackTrace();
           }
           return productList;
    }
    
    public void updateProduct(com.mycompany.gerenciamentodeestoque.model.Product product){
        try{
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE estoque.produto SET quantidade=? WHERE id=?;");
            ps.setInt(1, product.getQuantity());
            ps.setInt(2, product.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void deleteProduct(com.mycompany.gerenciamentodeestoque.model.Product product){
        try{
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("DELETE FROM produto WHERE id=?;");
            ps.setInt(1, product.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public ObservableList<com.mycompany.gerenciamentodeestoque.model.Product> getLastProducts() {
        ObservableList<com.mycompany.gerenciamentodeestoque.model.Product> productList = FXCollections.observableArrayList();
           try{
               String query = "SELECT id, codigo_produto, nome, quantidade FROM produto WHERE quantidade <= 10 ORDER BY nome ASC";
               c.getDBConn();
               Statement st = c.getCon().createStatement();
               ResultSet rs = st.executeQuery(query);
               com.mycompany.gerenciamentodeestoque.model.Product p;
               while(rs.next()){
                   p = new com.mycompany.gerenciamentodeestoque.model.Product(rs.getInt("id"), rs.getInt("codigo_produto"), rs.getString("nome"), rs.getInt("quantidade"));
                   productList.add(p);
               }
               rs.close();
               st.close();
               c.closeConnection();
           } catch (Exception e){
               e.printStackTrace();
           }
           return productList;
    }
    
}
