package com.example.appsupermercado;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VerificadorDePrecoController {

    @FXML
    private Label produtoLabel;

    @FXML
    private Label valorLabel;

    @FXML
    private TextField codigoProdutoTextField;

    @FXML
    protected void onCodigoProdutoTextFieldKeyTyped(){
        if(codigoProdutoTextField.getText().isEmpty() == false){
            int codigo = Integer.parseInt(codigoProdutoTextField.getText());
            if(codigo == 1){
                produtoLabel.setText("Arroz Branco 1KG Tio João");
                valorLabel.setText("R$ 8,99");
            }else if(codigo == 2){
                produtoLabel.setText("Feijão Preto 1KG Namorado");
                valorLabel.setText("R$ 10,00");
            }
        }
    }
}
