package drivers;

import entities.AlgoritmoDeOrdenação;
import repositories.CriarArquivoCSV;
import services.varInput;

public class SelectionSort extends AlgoritmoDeOrdenação {

    CriarArquivoCSV criar = new CriarArquivoCSV();

    public void tamanho(String[] data, String nameCase) {
        varInput v = new varInput();
        String[] copiaDados = data.clone();

        long iniciarTimer = System.nanoTime();

        for (int i = 0; i < copiaDados.length - 1; i++) {
            int maiorIndex = i;
            for (int j = i + 1; j < copiaDados.length; j++) {
                if (v.getTamanhoSenha(copiaDados[j]) > v.getTamanhoSenha(copiaDados[maiorIndex])) {
                    maiorIndex = j;
                }
            }
            if (maiorIndex != i) {
                String temp = copiaDados[i];
                copiaDados[i] = copiaDados[maiorIndex];
                copiaDados[maiorIndex] = temp;
            }
        }

        long finalizarTimer = System.nanoTime();
        long duration = (finalizarTimer - iniciarTimer) / 1000000;

        System.out.println(
                "Tempo de execução drivers.SelectionSort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_length_selectionSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_length_selectionSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_length_selectionSort_piorCaso.csv";
        }

        criar.criarCSV(copiaDados, filename);
    }

    public void mes(String[] data, String nameCase) {
        varInput v = new varInput();
        String[] copiaDados = data.clone();

        long iniciarTimer = System.nanoTime();

        for (int i = 0; i < copiaDados.length - 1; i++) {
            int maiorIndex = i;
            for (int j = i + 1; j < copiaDados.length; j++) {
                if (v.getMesData(copiaDados[j]) < v.getMesData(copiaDados[maiorIndex])) {
                    maiorIndex = j;
                }
            }
            if (maiorIndex != i) {
                String temp = copiaDados[i];
                copiaDados[i] = copiaDados[maiorIndex];
                copiaDados[maiorIndex] = temp;
            }
        }

        long finalizarTimer = System.nanoTime();
        long duration = (finalizarTimer - iniciarTimer) / 1000000;

        System.out.println(
                "Tempo de execução drivers.SelectionSort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase == "melhor caso") {
            filename = "./src/dataset/passwords_data_month_selectionSort_melhorCaso.csv";
        } else if (nameCase == "médio caso") {
            filename = "./src/dataset/passwords_data_month_selectionSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_month_selectionSort_piorCaso.csv";
        }

        criar.criarCSV(copiaDados, filename);
    }

    public void data(String[] data, String nameCase) {
        varInput v = new varInput();
        String[] copiaDados = data.clone();

        long iniciarTimer = System.nanoTime();

        for (int i = 0; i < copiaDados.length - 1; i++) {
            int maiorIndex = i;
            for (int j = i + 1; j < copiaDados.length; j++) {
                if (v.getDataCompleta(copiaDados[j]) < v.getDataCompleta(copiaDados[maiorIndex])) {
                    maiorIndex = j;
                }
            }
            if (maiorIndex != i) {
                String temp = copiaDados[i];
                copiaDados[i] = copiaDados[maiorIndex];
                copiaDados[maiorIndex] = temp;
            }
        }

        long finalizarTimer = System.nanoTime();
        long duration = (finalizarTimer - iniciarTimer) / 1000000;

        System.out.println(
                "Tempo de execução drivers.SelectionSort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase == "melhor caso") {
            filename = "./src/dataset/passwords_data_selectionSort_melhorCaso.csv";
        } else if (nameCase == "médio caso") {
            filename = "./src/dataset/passwords_data_selectionSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_selectionSort_piorCaso.csv";
        }

        criar.criarCSV(copiaDados, filename);
    }
}
