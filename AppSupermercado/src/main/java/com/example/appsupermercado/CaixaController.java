package com.example.appsupermercado;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CaixaController {
    @FXML
    private TextField valorProdutoTextField;

    @FXML
    private TextField quantidadeTextField;

    @FXML
    private Label totalLabel;

    @FXML
    protected void calcularTotal() {
        try {
            double valorProduto = Double.parseDouble(valorProdutoTextField.getText());
            int quantidade = Integer.parseInt(quantidadeTextField.getText());
            double total = valorProduto * quantidade;
            totalLabel.setText(String.format("%.2f", total));
        } catch (NumberFormatException e) {
            totalLabel.setText("Erro de entrada");
        }
    }


}
