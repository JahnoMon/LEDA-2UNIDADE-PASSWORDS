package drivers;

import entities.AlgoritmoDeOrdenação;
import repositories.CriarArquivoCSV;
import services.varInput;

public class HeapSort extends AlgoritmoDeOrdenação {
    CriarArquivoCSV criar = new CriarArquivoCSV();

    public void tamanho(String[] data, String nameCase) {
        varInput v = new varInput();
        String[] copiaDados = data.clone();

        long iniciarTimer = System.nanoTime();

        heapSortLength(copiaDados, v);

        long finalizarTimer = System.nanoTime();
        long duracao = (finalizarTimer - iniciarTimer) / 1000000;

        System.out.println("Tempo de execução Heap Sort p/ o " + nameCase + ": " + duracao + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_length_heapSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_length_heapSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_length_heapSort_piorCaso.csv";
        }

        criar.criarCSV(copiaDados, filename);
    }

    private void heapSortLength(String[] array, varInput v) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyLength(array, n, i, v);

        for (int i = n - 1; i > 0; i--) {
            String temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapifyLength(array, i, 0, v);
        }
    }

    private void heapifyLength(String[] array, int n, int i, varInput v) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && v.getTamanhoSenha(array[esquerda]) < v.getTamanhoSenha(array[maior]))
            maior = esquerda;

        if (direita < n && v.getTamanhoSenha(array[direita]) < v.getTamanhoSenha(array[maior]))
            maior = direita;

        if (maior != i) {
            String swap = array[i];
            array[i] = array[maior];
            array[maior] = swap;

            heapifyLength(array, n, maior, v);
        }
    }

    public void mes(String[] data, String nameCase) {
        varInput v = new varInput();
        String[] copiaDados = data.clone();

        long iniciarTimer = System.nanoTime();

        heapSortMonth(copiaDados, v);

        long finalizarTimer = System.nanoTime();
        long duration = (finalizarTimer - iniciarTimer) / 1000000;

        System.out.println("Tempo de execução Heap Sort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_data_month_heapSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_data_month_heapSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_month_heapSort_piorCaso.csv";
        }

        criar.criarCSV(copiaDados, filename);
    }

    private void heapSortMonth(String[] array, varInput v) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyMonth(array, n, i, v);

        for (int i = n - 1; i > 0; i--) {
            String temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapifyMonth(array, i, 0, v);
        }
    }

    private void heapifyMonth(String[] array, int n, int i, varInput v) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && v.getMesData(array[esquerda]) > v.getMesData(array[maior]))
            maior = esquerda;

        if (direita < n && v.getMesData(array[direita]) > v.getMesData(array[maior]))
            maior = direita;

        if (maior != i) {
            String swap = array[i];
            array[i] = array[maior];
            array[maior] = swap;

            heapifyMonth(array, n, maior, v);
        }
    }

    public void data(String[] data, String nameCase) {
        varInput v = new varInput();
        String[] copiaDados = data.clone();

        long iniciarTimer = System.nanoTime();

        heapSortDate(copiaDados, v);

        long finalizarTimer = System.nanoTime();
        long duration = (finalizarTimer - iniciarTimer) / 1000000;

        System.out.println("Tempo de execução Heap Sort p/ o " + nameCase + ": " + duration + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_data_heapSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_data_heapSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_heapSort_piorCaso.csv";
        }

        criar.criarCSV(copiaDados, filename);
    }

    private void heapSortDate(String[] array, varInput v) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyDate(array, n, i, v);

        for (int i = n - 1; i > 0; i--) {
            String temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapifyDate(array, i, 0, v);
        }
    }

    private void heapifyDate(String[] array, int n, int i, varInput v) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && v.getDataCompleta(array[esquerda]) > v.getDataCompleta(array[maior]))
            maior = esquerda;

        if (direita < n && v.getDataCompleta(array[direita]) > v.getDataCompleta(array[maior]))
            maior = direita;

        if (maior != i) {
            String swap = array[i];
            array[i] = array[maior];
            array[maior] = swap;

            heapifyDate(array, n, maior, v);
        }
    }

}
