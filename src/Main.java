import entities.ClassificadorDeSenhas;
import entities.FiltroDeClassificadorDeSenhas;
import entities.FormatadorDasDatasDasSenhas;
//import repositories.CriarArquivoCSV;
import services.RunTestes;

//import java.nio.file.Path;
//import java.nio.file.Paths;

public class Main {

        public static void main(String[] args) {

                ClassificadorDeSenhas classifier = new ClassificadorDeSenhas();
                classifier.classifyPasswords(
                                "./src/dataset/passwords.csv",
                                "./src/dataset/password_classifier.csv");

                FormatadorDasDatasDasSenhas formatter = new FormatadorDasDatasDasSenhas();
                formatter.formatDates(
                                "./src/dataset/password_classifier.csv",
                                "./src/dataset/passwords_formated_data.csv");

                FiltroDeClassificadorDeSenhas filterClassifier = new FiltroDeClassificadorDeSenhas();
                filterClassifier.filterPasswords(
                                "./src/dataset/password_classifier.csv",
                                "./src/dataset/passwords_classifier.csv");

                RunTestes runTests = new RunTestes();

                System.out.println("\n------ Inicializando ordenações... --------\n\n");

                runTests.run();
        }
}
