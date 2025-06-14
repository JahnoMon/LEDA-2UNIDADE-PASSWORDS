package useCases;

import entities.ArvoreDePesquisaBinaria;
import services.varInput;

public class CriarCasosPorMes {
    private varInput  csvParaArray = new varInput();

    private String[] data;

    private ArvoreDePesquisaBinaria treeData;

    public CriarCasosPorMes() {
        this.treeData = new ArvoreDePesquisaBinaria(this::compararMes);
        this.data =  csvParaArray.dataArray();
        treeData.insertAll(data);
    }

    public int compararMes(String s1, String s2) {
        int month1 =  csvParaArray.getMesData(s1);
        int month2 =  csvParaArray.getMesData(s2);

        return Integer.compare(month1, month2);
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
