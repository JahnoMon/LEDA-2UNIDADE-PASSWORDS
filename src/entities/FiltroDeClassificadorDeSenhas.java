package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FiltroDeClassificadorDeSenhas {

    public void filterPasswords(String inputFile, String outputFile) {
        String linha;
        String csvSplitBy = ",";
        String csvQuotedBy = "\"";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
                FileWriter writer = new FileWriter(outputFile)) {

            writer.append(",password,length,date,class\n");

            int numeroDaLinha = -1;
            while ((linha = br.readLine()) != null) {
                numeroDaLinha++;
                if (numeroDaLinha == 0)
                    continue;
                String[] data = parseCSVLine(linha, csvSplitBy, csvQuotedBy);
                if (data.length >= 5 && (data[4].equals("Boa") || data[4].equals("Muito Boa"))) {

                    writer.append(String.valueOf(numeroDaLinha - 1)).append(",")
                            .append(String.join(",", csvQuotedBy + data[1] + csvQuotedBy, data[2], data[3], data[4]));
                    writer.append("\n");
                }
            }

            System.out.println("Filtragem concluída. Novo arquivo gerado: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] parseCSVLine(String linha, String csvSplitBy, String csvQuotedBy) {
        boolean inQuotes = false;
        StringBuilder campo = new StringBuilder();
        String[] campos = new String[5];
        int campoIndex = 0;

        for (char c : linha.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                campos[campoIndex++] = campo.toString();
                campo = new StringBuilder();
            } else {
                campo.append(c);
            }
        }
        campos[campoIndex] = campo.toString();
        return campos;
    }
}
