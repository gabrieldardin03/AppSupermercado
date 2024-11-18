package com.example.appsupermercado;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    protected void abrirCaixa() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("caixa-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 340);
        Stage stage = new Stage();
        stage.setTitle("Caixa");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void abrirVerificadorDePreco() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("verificador-preco.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Verificador de Preço");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected  void onSairButtonClick(){
        System.exit(0);
    }

    @FXML
    public void sobre() throws IOException {    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sobre-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 340);
        Stage stage = new Stage();
        stage.setTitle("sistema");
        stage.setScene(scene);
        stage.show();
    }

}

