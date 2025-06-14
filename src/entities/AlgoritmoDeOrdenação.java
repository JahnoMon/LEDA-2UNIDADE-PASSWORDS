package entities;

public abstract class AlgoritmoDeOrdenação {

    public abstract void tamanho(String[] data, String nameCase);

    public abstract void mes(String[] data, String nameCase);

    public abstract void data(String[] data, String nameCase);

    public void toggleSort(String[] data, String nameCase, String type) {
        if (type.equals("Mês")) {
            mes(data, nameCase);
        } else if (type.equals("Tamanho da Senha")) {
            tamanho(data, nameCase);
        } else {
            data(data, nameCase);
        }
    }

}
