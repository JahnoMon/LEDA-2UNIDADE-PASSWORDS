package services;

import entities.FilaCustomizada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class varInput {

    public int getTamanhoSenha(String str) {
        int indexInicial = str.lastIndexOf('"') + 2;
        int indexFinal = str.indexOf(',', indexInicial);
        if (indexInicial > 0 && indexFinal > indexInicial) {
            return Integer.parseInt(str.substring(indexInicial, indexFinal));
        }
        return 0;
    }

    public int getMesData(String str) {
        String[] partesData = str.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1)[3].split(" ")[0].split("/");
        if (partesData.length >= 2) {
            return Integer.parseInt(partesData[1]);
        }
        return 0;
    }

    public int getDataCompleta(String str) {
        String[] partesData = str.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1)[3].split(" ")[0].split("/");
        return Integer.parseInt(partesData[2]) * 10000 + Integer.parseInt(partesData[1]) * 100
                + Integer.parseInt(partesData[0]);
    }

    public String[] dataArray() {
        FilaCustomizada fila = new FilaCustomizada();
        String linha;

        try (BufferedReader br = new BufferedReader(new FileReader("./src/dataset/passwords_test.csv"))) {

            br.readLine();

            while ((linha = br.readLine()) != null) {
                fila.insert(linha);
            }

            br.close();

            return fila.toArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }
}
