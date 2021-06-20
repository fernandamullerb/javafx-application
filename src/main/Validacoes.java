package main;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Validacoes {
    
    public static void validarTipoEntrada(TextField txt) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
                    txt.setText(oldValue);
            }
        });
    }
    
    public static boolean validarPreenchimentoNotas(ComboBox cbb, TextField txt1, TextField txt2) {      
        return (cbb.getValue().equals("") || txt1.getText().isEmpty() || txt2.getText().isEmpty());
   } 
}
