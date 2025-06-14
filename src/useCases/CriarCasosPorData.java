package useCases;

import entities.ArvoreDePesquisaBinaria;
import services.varInput;

import java.text.*;
import java.util.Date;

public class CriarCasosPorData {
    private varInput csvParaArray = new varInput();

    private String[] data;
    private ArvoreDePesquisaBinaria treeData;

    public CriarCasosPorData() {
        this.treeData = new ArvoreDePesquisaBinaria(this::compararDatas);
        this.data = csvParaArray.dataArray();
        treeData.insertAll(data);
    }

    public int compararDatas(String s1, String s2) {
        Integer dataInt1 = csvParaArray.getDataCompleta(s1);
        Integer dataInt2 = csvParaArray.getDataCompleta(s2);

        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");

        try {
            Date data1 = formato.parse(dataInt1.toString());
            Date data2 = formato.parse(dataInt2.toString());

            return data1.compareTo(data2);
        } catch (Exception error) {
            error.printStackTrace();
            throw new Error("Formato invalido de linha!");
        }

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
