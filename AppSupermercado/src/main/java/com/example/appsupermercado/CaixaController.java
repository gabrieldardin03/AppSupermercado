package com.example.appsupermercado;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CaixaController {

    @FXML
    private TextField codProdutoTextField;

    @FXML
    private TextField quantidadeTextField;

    @FXML
    private Label produtoLabel;

    @FXML
    private ListView<String> sacolaListView;

    @FXML
    private Label totalLabel;

    @FXML
    private TextField valorPagoTextField;

    @FXML
    private Label trocoLabel;

    private final ObservableList<String> sacolaObservableList = FXCollections.observableArrayList();

    private double total = 0.0;

    @FXML
    public void initialize() {
        sacolaListView.setItems(sacolaObservableList);
    }





    @FXML
    public void codigoproduto(KeyEvent keyEvent) {
        String codigo = codProdutoTextField.getText();

        switch (codigo) {
            case "1":
                produtoLabel.setText("Desodorante - R$ 11.90");
                break;
            case "2":
                produtoLabel.setText("Arroz Tio João 1kg - R$ 3.99");
                break;
            case "3":
                produtoLabel.setText("Manteiga - R$ 7.98");
                break;
            default:
                produtoLabel.setText("Produto não encontrado.");
                break;
        }
    }

    @FXML
    public void adicionarLista() {
        try {
            int quantidade = Integer.parseInt(quantidadeTextField.getText());
            String produto = produtoLabel.getText();

            double preco = Double.parseDouble(produto.split("R\\$ ")[1].replace(",", "."));
            double subtotal = preco * quantidade;

            total += subtotal;
            totalLabel.setText(String.format("R$ %.2f", total));

            sacolaObservableList.add(produto + " - Qtd: " + quantidade + " - Total: R$ " + String.format("%.2f", subtotal));

        } catch (Exception e) {
            produtoLabel.setText("Erro ao adicionar produto.");
        } finally {
            codProdutoTextField.clear();
            quantidadeTextField.clear();
            codProdutoTextField.requestFocus();

            calcularTroco();
        }
    }

    @FXML
    public void excluirLista() {
        int selectedIndex = sacolaListView.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            String selectedItem = sacolaObservableList.get(selectedIndex);

            try {
                String[] parts = selectedItem.split("Total: R\\$ ");
                if (parts.length > 1) {
                    double subtotal = Double.parseDouble(parts[1].replace(",", ".").trim());

                    total -= subtotal;
                    totalLabel.setText(String.format("R$ %.2f", total));
                }

                sacolaObservableList.remove(selectedIndex);

            } catch (Exception e) {
                System.err.println("Erro ao excluir item: " + e.getMessage());
            } finally {
                calcularTroco();
            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Atenção");
            alerta.setHeaderText(null);
            alerta.setContentText("Nenhum item selecionado para excluir.");
            alerta.showAndWait();
        }
    }

    @FXML
    public void calcularTroco() {
        try {
            double valorPago = Double.parseDouble(valorPagoTextField.getText().replace(",", ".").trim());
            double troco = valorPago - total;

            trocoLabel.setText(String.format("R$ %.2f", Math.max(troco, 0)));
        } catch (NumberFormatException e) {
            trocoLabel.setText("R$ 0.00");
        }
    }



    @FXML
    protected  void onSairButtonClick(){
        System.exit(0);
    }




}
