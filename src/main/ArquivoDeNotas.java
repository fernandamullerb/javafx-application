package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoDeNotas {
    
    public static File criarAquivo() throws IOException {
        File arq = new File("notas_alunos.txt");
        arq.createNewFile();
        return arq;
    }

    public static void escreverArquivo(File arq, String nome, double mediaAluno, String situacao) { 
        try {
            FileWriter escrita = new FileWriter(arq.getName(), true);
            escrita.write("\nAluno(a): " + nome + " | Média: " + mediaAluno + " | Situação: " + situacao);
            escrita.close();
        } catch (IOException e) {
            System.out.println("Não foi possível conectar ao disco.");
        } 
    }
}
