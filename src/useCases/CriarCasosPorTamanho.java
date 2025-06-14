package useCases;

import entities.ArvoreDePesquisaBinaria;
import services.varInput;

public class CriarCasosPorTamanho {

    public varInput csvParaArray = new varInput();

    public String[] data;
    public ArvoreDePesquisaBinaria treeData;

    public CriarCasosPorTamanho() {
        this.treeData = new ArvoreDePesquisaBinaria(this::compareLength);
        this.data = csvParaArray.dataArray();
        treeData.insertAll(data);
    }

    public int compareLength(String s1, String s2) {
        int length1 = csvParaArray.getTamanhoSenha(s1);
        int length2 = csvParaArray.getMesData(s2);

        return Integer.compare(length1, length2);
    }

    public String[] bestCase() {
        return treeData.inOrderAscending();
    }

    public String[] mediumCase() {
        return data;
    }

    public String[] worstCase() {
        return treeData.inOrderDescending();
    }

}
