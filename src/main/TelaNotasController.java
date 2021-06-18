package main;

import java.io.File;
import java.io.FileWriter;
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
    }

    @FXML
    private void cadastrarNotas(ActionEvent event) throws IOException {
        String nome = comboBoxNames.getValue();
        String av1 = textFieldAv1.getText();
        String av2 = textFieldAv2.getText();

        double notaConvertida1 = Double.parseDouble(av1);
        double notaConvertida2 = Double.parseDouble(av2);
        double mediaAluno = (notaConvertida1 + notaConvertida2) / 2;
        String situacao = "";

        if  (mediaAluno >= 7 && mediaAluno <= 10) {
            situacao = "Aprovado(a)";
        } else if (mediaAluno >= 0 && mediaAluno <7) {
            situacao = "Reprovado(a)";
        } else {
            situacao = "Valor de notas inválido.";
        }
        
        System.out.println("Aluno(a): " + nome + " | Média: " + mediaAluno + " | Situação: " + situacao);
        
        File arq = new File("alunos.txt");
        arq.createNewFile();
        FileWriter escrita = new FileWriter(arq.getName(), true);
        escrita.write("\nAluno(a): " + nome + " | Média: " + mediaAluno + " | Situação: " + situacao);
        escrita.close();
    }
    
    @FXML
    private void limparCampos(MouseEvent event) {
        comboBoxNames.setValue("");
        textFieldAv1.setText("");
        textFieldAv2.setText("");
    }

}

