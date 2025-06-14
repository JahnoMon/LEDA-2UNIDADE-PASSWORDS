package drivers;

import entities.AlgoritmoDeOrdenação;
import repositories.CriarArquivoCSV;
import services.varInput;

public class InsertionSort extends AlgoritmoDeOrdenação {
    CriarArquivoCSV criar = new CriarArquivoCSV();

    public void tamanho(String[] data, String nameCase) {
        varInput v = new varInput();
        String[] copiaDados = data.clone();

        long iniciarTimer = System.nanoTime();

        for (int i = 1; i < copiaDados.length; i++) {
            String chave = copiaDados[i];
            int j = i - 1;
            while (j >= 0 && v.getTamanhoSenha(copiaDados[j]) < v.getTamanhoSenha(chave)) {
                copiaDados[j + 1] = copiaDados[j];
                j = j - 1;
            }
            copiaDados[j + 1] = chave;
        }

        long finalizarTimer = System.nanoTime();
        long duracao = (finalizarTimer - iniciarTimer) / 1000000;

        System.out.println(
                "Tempo de execução drivers.InsertionSort p/ o " + nameCase + ": " + duracao + " milissegundos");
        String filename = "";

        if (nameCase == "melhor caso") {
            filename = "./src/dataset/passwords_length_insertionSort_melhorCaso.csv";
        } else if (nameCase == "médio caso") {
            filename = "./src/dataset/passwords_length_insertionSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_length_insertionSort_piorCaso.csv";
        }

        criar.criarCSV(copiaDados, filename);
    }

    public void mes(String[] data, String nameCase) {
        varInput v = new varInput();
        String[] copiaDados = data.clone();

        long iniciarTimer = System.nanoTime();

        for (int i = 1; i < copiaDados.length; i++) {
            String chave = copiaDados[i];
            int j = i - 1;
            while (j >= 0 && v.getMesData(copiaDados[j]) > v.getMesData(chave)) {
                copiaDados[j + 1] = copiaDados[j];
                j = j - 1;
            }
            copiaDados[j + 1] = chave;
        }

        long finalizarTimer = System.nanoTime();
        long duration = (finalizarTimer - iniciarTimer) / 1000000;

        System.out.println("Tempo de execução Insertion Sort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_data_month_insertionSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_data_month_insertionSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_month_insertionSort_piorCaso.csv";
        }

        criar.criarCSV(copiaDados, filename);
    }

    public void data(String[] data, String nameCase) {
        varInput v = new varInput();
        String[] copiaDados = data.clone();

        long iniciarTimer = System.nanoTime();

        for (int i = 1; i < copiaDados.length; i++) {
            String chave = copiaDados[i];
            int j = i - 1;
            while (j >= 0 && v.getDataCompleta(copiaDados[j]) > v.getDataCompleta(chave)) {
                copiaDados[j + 1] = copiaDados[j];
                j = j - 1;
            }
            copiaDados[j + 1] = chave;
        }

        long finalizarTimer = System.nanoTime();
        long duration = (finalizarTimer - iniciarTimer) / 1000000;

        System.out.println("Tempo de execução Insertion Sort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_data_insertionSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_data_insertionSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_insertionSort_piorCaso.csv";
        }

        criar.criarCSV(copiaDados, filename);
    }

}
