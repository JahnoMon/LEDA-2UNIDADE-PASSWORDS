package drivers;

import entities.AlgoritmoDeOrdenação;
import repositories.CriarArquivoCSV;
import services.varInput;

public class MergeSort extends AlgoritmoDeOrdenação {
    CriarArquivoCSV criar = new CriarArquivoCSV();

    public void tamanho(String[] data, String nameCase) {
        varInput v = new varInput();
        String[] copiaDados = data.clone();

        long iniciarTimer = System.nanoTime();

        mergeSortLength(copiaDados, 0, copiaDados.length - 1, v);

        long finalizarTimer = System.nanoTime();
        long duracao = (finalizarTimer - iniciarTimer) / 1000000;

        System.out.println("Tempo de execução Merge Sort p/ o " + nameCase + ": " + duracao + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_length_mergeSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_length_mergeSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_length_mergeSort_piorCaso.csv";
        }

        criar.criarCSV(copiaDados, filename);
    }

    private void mergeSortLength(String[] array, int inicio, int fim, varInput v) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSortLength(array, inicio, meio, v);
            mergeSortLength(array, meio + 1, fim, v);
            mergeLength(array, inicio, meio, fim, v);
        }
    }

    private void mergeLength(String[] array, int inicio, int meio, int fim, varInput v) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        String[] L = new String[n1];
        String[] R = new String[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[inicio + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[meio + 1 + j];

        int i = 0, j = 0;

        int k = inicio;
        while (i < n1 && j < n2) {
            if (v.getTamanhoSenha(L[i]) >= v.getTamanhoSenha(R[j])) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public void mes(String[] data, String nameCase) {
        varInput v = new varInput();
        String[] copiaDados = data.clone();

        long iniciarTimer = System.nanoTime();

        mergeSortMonth(copiaDados, 0, copiaDados.length - 1, v);

        long finalizarTimer = System.nanoTime();
        long duracao = (finalizarTimer - iniciarTimer) / 1000000;

        System.out.println("Tempo de execução Merge Sort p/ o " + nameCase + ": " + duracao + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_data_month_mergeSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_data_month_mergeSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_month_mergeSort_piorCaso.csv";
        }

        criar.criarCSV(copiaDados, filename);
    }

    private void mergeSortMonth(String[] array, int inicio, int fim, varInput v) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSortMonth(array, inicio, meio, v);
            mergeSortMonth(array, meio + 1, fim, v);
            mergeMonth(array, inicio, meio, fim, v);
        }
    }

    private void mergeMonth(String[] array, int inicio, int meio, int fim, varInput v) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        String[] L = new String[n1];
        String[] R = new String[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[inicio + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[meio + 1 + j];

        int i = 0, j = 0;

        int k = inicio;
        while (i < n1 && j < n2) {
            if (v.getMesData(L[i]) <= v.getMesData(R[j])) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public void data(String[] data, String nameCase) {
        varInput v = new varInput();
        String[] copiaDados = data.clone();

        long iniciarTimer = System.nanoTime();

        mergeSortDate(copiaDados, 0, copiaDados.length - 1, v);

        long finalizarTimer = System.nanoTime();
        long duracao = (finalizarTimer - iniciarTimer) / 1000000;

        System.out.println("Tempo de execução Merge Sort p/ o " + nameCase + ": " + duracao + " milissegundos");
        String filename = "";

        if (nameCase.equals("melhor caso")) {
            filename = "./src/dataset/passwords_data_mergeSort_melhorCaso.csv";
        } else if (nameCase.equals("médio caso")) {
            filename = "./src/dataset/passwords_data_mergeSort_medioCaso.csv";
        } else {
            filename = "./src/dataset/passwords_data_mergeSort_piorCaso.csv";
        }

        criar.criarCSV(copiaDados, filename);
    }

    private void mergeSortDate(String[] array, int inicio, int fim, varInput v) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSortDate(array, inicio, meio, v);
            mergeSortDate(array, meio + 1, fim, v);
            mergeDate(array, inicio, meio, fim, v);
        }
    }

    private void mergeDate(String[] array, int inicio, int meio, int fim, varInput v) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        String[] L = new String[n1];
        String[] R = new String[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[inicio + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[meio + 1 + j];

        int i = 0, j = 0;

        int k = inicio;
        while (i < n1 && j < n2) {
            if (v.getDataCompleta(L[i]) <= v.getDataCompleta(R[j])) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

}
