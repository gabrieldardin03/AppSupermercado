package com.example.appsupermercado;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CaixaController {
    @FXML
    private TextField ItemsDaSacola;

    @FXML
    private TextField CodProdutoTextField;

    @FXML
    private TextField quantidadeTextField;

    @FXML
    private Label totalLabel;

    @FXML
    protected void calcularTotal() {
        try {
            int CodProduto =  (int) Double.parseDouble(CodProdutoTextField.getText());
            int quantidade = Integer.parseInt(quantidadeTextField.getText());
            char ItensDaSacola = ItemsDaSacola.getText().charAt(0);
            int total = CodProduto * quantidade;
            totalLabel.setText(String.format("%.2f", total));
        } catch (NumberFormatException e) {
            totalLabel.setText("Erro de entrada");
        }
    }


}
