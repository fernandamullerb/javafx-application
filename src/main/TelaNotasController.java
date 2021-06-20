package main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TelaNotasController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonConfirmar;

    @FXML
    private TextField textFieldAv1;

    @FXML
    private TextField textFieldAv2;

    @FXML
    private ComboBox<String> comboBoxNames;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] alunos = {"Fernanda Müller", "Reuel Freitas", "William Robert"};
        comboBoxNames.getItems().addAll(alunos);
        Validacoes.validarTipoEntrada(textFieldAv1);
        Validacoes.validarTipoEntrada(textFieldAv2);
    }
    
    @FXML
    public void habilitarBotao() {
        buttonConfirmar.setDisable(Validacoes.validarPreenchimentoNotas(comboBoxNames, textFieldAv1, textFieldAv2));
    }
    
    @FXML
    private void cadastrarNotas(ActionEvent event) throws IOException {
        String nome = comboBoxNames.getValue();
        double nota1 = Double.parseDouble(textFieldAv1.getText());
        double nota2 = Double.parseDouble(textFieldAv2.getText());
        double mediaAluno = (nota1 + nota2) / 2;
        String situacaoAluno = situacaoAluno(nota1, nota2, mediaAluno);
        
        File arq = ArquivoDeNotas.criarAquivo();
        ArquivoDeNotas.escreverArquivo(arq, nome, mediaAluno, situacaoAluno);
    }
    
    @FXML
    private void limparCampos(MouseEvent event) {
        comboBoxNames.setValue("");
        textFieldAv1.setText("");
        textFieldAv2.setText("");
        buttonConfirmar.setDisable(true);
    }
    
    public static String situacaoAluno(double nota1, double nota2, double mediaAluno) {
        String situacao = "";
        if  (mediaAluno >= 7 && mediaAluno <= 10) {
            situacao = "Aprovado(a)";
        } else if (mediaAluno >= 0 && mediaAluno <7) {
            situacao = "Reprovado(a)";
        } else {
            situacao = "Valor de notas inválido.";
        }
        return situacao;
    }
}

