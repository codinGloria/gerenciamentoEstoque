/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gerenciamentodeestoque;

import com.mycompany.gerenciamentodeestoque.data.AppQuery;
import com.mycompany.gerenciamentodeestoque.model.Product;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Glória
 */
public class ProductController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showProducts();
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        fieldSearch.textProperty().addListener((ObservableList, oldValue, newValue)->{
            filterData(newValue);
        });
    }    
    
    @FXML  
    public TextField fieldCode;
    @FXML
    public TextField fieldName;
    @FXML
    public TextField fieldQuantity;
    @FXML
    public TextField fieldSearch;
    
    @FXML
    public Button btnRegister;
    @FXML
    public Button btnUpdate;
    @FXML
    public Button btnDelete;
    @FXML
    public Button btnList;
    @FXML
    public Button btnListSoldOut;
    @FXML
    public Button btnPrint;
    
    @FXML
    public TableView<Product> tableView;
    @FXML
    public TableColumn <Product,Integer> colId;
    @FXML
    public TableColumn <Product,Integer> colCode;
    @FXML
    public TableColumn <Product,String> colName;
    @FXML
    public TableColumn <Product,Integer> colQuantity;
           
    private Product product;
    
    @FXML
    private void register(){
        try {
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Adicionar registro...");
            dialog.setHeaderText("Tem certeza?");
            dialog.initModality(Modality.APPLICATION_MODAL);
            Label label = new Label("Codigo: " + Integer.parseInt(fieldCode.getText()) + 
                    "\nNome: " + fieldName.getText() + 
                    "\nQuantidade: " + Integer.parseInt(fieldQuantity.getText()));
            dialog.getDialogPane().setContent(label);
            ButtonType okButton = new ButtonType("Cadastrar", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButton = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
            Optional<ButtonType> result = dialog.showAndWait();
            if(result.isPresent() && result.get() == okButton){
                String codeText = fieldCode.getText();
                String name = fieldName.getText();
                String quantityText = fieldQuantity.getText();

                int code = Integer.parseInt(codeText);
                int quantity = Integer.parseInt(quantityText);

                com.mycompany.gerenciamentodeestoque.model.Product product = 
                    new com.mycompany.gerenciamentodeestoque.model.Product(code, name, quantity);
                com.mycompany.gerenciamentodeestoque.data.AppQuery query = new AppQuery();
                query.register(product);
                showProducts();
                clearFields();
            }             
                  
    } catch (NumberFormatException e) {
        System.err.println("Erro ao converter texto para número: " + e.getMessage());
    }
    }
    
    @FXML
    private void showProducts(){
        com.mycompany.gerenciamentodeestoque.data.AppQuery query = new com.mycompany.gerenciamentodeestoque.data.AppQuery();
        ObservableList<Product> list = query.getProductList();
        colId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        colCode.setCellValueFactory(new PropertyValueFactory<Product, Integer>("code"));
        colName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        tableView.setItems(list);
    }
    
    @FXML
    private void showLastProducts(){
        com.mycompany.gerenciamentodeestoque.data.AppQuery query = new com.mycompany.gerenciamentodeestoque.data.AppQuery();
        ObservableList<Product> list = query.getLastProducts();
        colId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        colCode.setCellValueFactory(new PropertyValueFactory<Product, Integer>("code"));
        colName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        tableView.setItems(list);
    }
    
    
    @FXML
    private void mouseClicked(MouseEvent e){
        try{
            Product product = tableView.getSelectionModel().getSelectedItem();
            product = new Product (product.getId(),product.getCode(), product.getName(), product.getQuantity());
            this.product = product;
            int code = product.getCode();
            fieldCode.setText(String.valueOf(code));
            fieldName.setText(String.valueOf(product.getName()));
            fieldQuantity.setText(String.valueOf(product.getQuantity()));
            btnUpdate.setDisable(false);
            btnDelete.setDisable(false);
            
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void updateProduct(){
        try{
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Atualizar registro...");
            dialog.setHeaderText("Tem certeza?");
            dialog.initModality(Modality.APPLICATION_MODAL);
            Label label = new Label("Codigo: " + Integer.parseInt(fieldCode.getText()) + 
                    "\nNome: " + fieldName.getText() + 
                    "\nQuantidade: " + Integer.parseInt(fieldQuantity.getText()));
            dialog.getDialogPane().setContent(label);
            ButtonType okButton = new ButtonType("Atualizar", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButton = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
            Optional<ButtonType> result = dialog.showAndWait();
            if(result.isPresent() && result.get() == okButton){
                com.mycompany.gerenciamentodeestoque.data.AppQuery query = new com.mycompany.gerenciamentodeestoque.data.AppQuery();
                com.mycompany.gerenciamentodeestoque.model.Product product = 
                        new com.mycompany.gerenciamentodeestoque.model.Product(this.product.getId(),
                        Integer.parseInt(fieldCode.getText()), 
                        fieldName.getText(), 
                        Integer.parseInt(fieldQuantity.getText()));
                query.updateProduct(product);
                showProducts();
                btnUpdate.setDisable(true);
                btnDelete.setDisable(true);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
}
    
    @FXML
    private void deleteProduct(){
        try{
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Deletando registro...");
            dialog.setHeaderText("Tem certeza?");
            dialog.initModality(Modality.APPLICATION_MODAL);
            Label label = new Label("Codigo: " + Integer.parseInt(fieldCode.getText()) + 
                    "\nNome: " + fieldName.getText() + 
                    "\nQuantidade: " + Integer.parseInt(fieldQuantity.getText()));
            dialog.getDialogPane().setContent(label);
            ButtonType okButton = new ButtonType("Deletar", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButton = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
            Optional<ButtonType> result = dialog.showAndWait();
            if(result.isPresent() && result.get() == okButton){
                com.mycompany.gerenciamentodeestoque.data.AppQuery query = new com.mycompany.gerenciamentodeestoque.data.AppQuery();
                com.mycompany.gerenciamentodeestoque.model.Product product = 
                        new com.mycompany.gerenciamentodeestoque.model.Product(this.product.getId(),
                        Integer.parseInt(fieldCode.getText()), 
                        fieldName.getText(), 
                        Integer.parseInt(fieldQuantity.getText()));
                query.deleteProduct(product);
                showProducts();
                btnUpdate.setDisable(true);
                btnDelete.setDisable(true);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
}
    private void clearFields(){
       fieldCode.setText("");
       fieldName.setText("");
       fieldQuantity.setText("");
    }
    
    @FXML
    private void clickRegister(){
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        clearFields();
    }
    
    private void filterData(String searchName){
        ObservableList<Product> filterData = FXCollections.observableArrayList();
        com.mycompany.gerenciamentodeestoque.data.AppQuery query = new com.mycompany.gerenciamentodeestoque.data.AppQuery();
        ObservableList<Product> list = query.getProductList();
        for(Product product:list){
            if(product.getName().toLowerCase().contains(searchName.toLowerCase())){
                filterData.add(product);
            }
        }
        tableView.setItems(filterData);

    }
    
    @FXML
    private void print() {
        try {
            FileWriter fw = new FileWriter("ListaProdutos.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            
            com.mycompany.gerenciamentodeestoque.data.AppQuery query = new com.mycompany.gerenciamentodeestoque.data.AppQuery();
            ObservableList<Product> list = query.getProductList();

            for (Product product : list) {
                pw.println("ID: " + product.getId());
                pw.println("Código: " + product.getCode());
                pw.println("Nome: " + product.getName());
                pw.println("Quantidade: " + product.getQuantity());
                pw.println();
            }

            pw.flush();
            pw.close();
            fw.close();

            System.out.println("Arquivo criado com sucesso.");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Erro ao criar o arquivo.");
        }
    }

}

