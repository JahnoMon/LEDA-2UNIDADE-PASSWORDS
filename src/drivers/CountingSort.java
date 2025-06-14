package drivers;

import entities.AlgoritmoDeOrdenação;
import repositories.CriarArquivoCSV;
import services.varInput;

import java.util.Arrays;

public class CountingSort extends AlgoritmoDeOrdenação {
    CriarArquivoCSV criar = new CriarArquivoCSV();

    public void tamanho(String[] data, String nameCase) {
        varInput v = new varInput();
        String[] copiaDados = data.clone();

        long iniciarTimer = System.nanoTime();

        countingSortLength(copiaDados, v);

        long finalizarTimer = System.nanoTime();
        long duracao = (finalizarTimer - iniciarTimer) / 1000000;

        System.out.println("Tempo de execução Counting Sort p/ o " + nameCase + ": " + duracao + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_length_countingSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_length_countingSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_length_countingSort_piorCaso.csv";
        }

        criar.criarCSV(copiaDados, filename);
    }

    private void countingSortLength(String[] array, varInput v) {
        int n = array.length;
        String[] saida = new String[n];
        int[] contagem = new int[n];

        for (int i = 0; i < n; i++)
            contagem[i] = 0;

        for (int i = 0; i < n; i++)
            contagem[v.getTamanhoSenha(array[i])]++;

        for (int i = 1; i < n; i++)
            contagem[i] += contagem[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            saida[n - contagem[v.getTamanhoSenha(array[i])]] = array[i];
            contagem[v.getTamanhoSenha(array[i])]--;
        }

        for (int i = 0; i < n; i++)
            array[i] = saida[i];
    }

    public void mes(String[] data, String nameCase) {
        varInput v = new varInput();
        String[] copiaDados = data.clone();

        long iniciarTimer = System.nanoTime();

        countingSortMonth(copiaDados, v);

        long finalizarTimer = System.nanoTime();
        long duracao = (finalizarTimer - iniciarTimer) / 1000000;

        System.out.println("Tempo de execução Counting Sort p/ o " + nameCase + ": " + duracao + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_data_month_countingSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_data_month_countingSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_month_countingSort_piorCaso.csv";
        }

        criar.criarCSV(copiaDados, filename);
    }

    private static void countingSortMonth(String[] array, varInput v) {
        int n = array.length;
        String[] saida = new String[n + 1];
        int[] contagem = new int[n + 1];

        for (int i = 0; i < n; i++)
            contagem[i] = 0;

        for (int j = 0; j < n; j++) {
            int position = v.getMesData(array[j]);
            contagem[position]++;
        }

        for (int i = 1; i < n; i++)
            contagem[i] += contagem[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            int position = v.getMesData(array[i]);
            saida[contagem[position] - 1] = array[i];
            contagem[position]--;
        }

        for (int i = 0; i < n - 1; i++) {
            array[i] = saida[i];
        }

    }

    public void data(String[] data, String nameCase) {
        varInput v = new varInput();
        String[] copiaDados = data.clone();

        long iniciarTimer = System.nanoTime();

        countingSortDate(copiaDados, v);

        long finalizarTimer = System.nanoTime();
        long duracao = (finalizarTimer - iniciarTimer) / 1000000;

        System.out.println("Tempo de execução Counting Sort p/ o " + nameCase + ": " + duracao + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_data_countingSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_data_countingSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_countingSort_piorCaso.csv";
        }

        criar.criarCSV(copiaDados, filename);
    }

    private void countingSortDate(String[] array, varInput v) {
        int n = array.length;
        String[] saida = new String[n];

        int[] contagem = new int[10000000];

        for (int i = 0; i < n; i++)
            contagem[i] = 0;

        for (int i = 0; i < n; i++)
            contagem[v.getDataCompleta(array[i]) - 20150101]++;

        for (int i = 1; i < 10000000; i++)
            contagem[i] += contagem[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            saida[contagem[v.getDataCompleta(array[i]) - 20150101] - 1] = array[i];
            contagem[v.getDataCompleta(array[i]) - 20150101]--;
        }

        for (int i = 0; i < n; i++)
            array[i] = saida[i];
    }

}
