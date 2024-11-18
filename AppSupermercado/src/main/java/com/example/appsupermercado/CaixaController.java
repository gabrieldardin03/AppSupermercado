package com.example.appsupermercado;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

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

            // Atualiza o total
            total += subtotal;
            totalLabel.setText(String.format("R$ %.2f", total));

            // Adiciona à lista de sacola
            sacolaObservableList.add(produto + " - Qtd: " + quantidade + " - Total: R$ " + String.format("%.2f", subtotal));

        } catch (Exception e) {
            produtoLabel.setText("Erro ao adicionar produto.");
        } finally {
            // Limpa os campos de entrada
            codProdutoTextField.clear();
            quantidadeTextField.clear();
            codProdutoTextField.requestFocus();

            // Atualiza o troco
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

                    // Atualiza o total
                    total -= subtotal;
                    totalLabel.setText(String.format("R$ %.2f", total));
                }

                // Remove o item da lista
                sacolaObservableList.remove(selectedIndex);

            } catch (Exception e) {
                System.err.println("Erro ao excluir item: " + e.getMessage());
            } finally {
                // Atualiza o troco
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

            // Atualiza o rótulo do troco
            trocoLabel.setText(String.format("R$ %.2f", Math.max(troco, 0)));
        } catch (NumberFormatException e) {
            trocoLabel.setText("R$ 0.00");
        }
    }

    @FXML
    public void abrirCaixa() {
    }


    @FXML
    public void sairSistema() {
        System.exit(0);
    }


}
