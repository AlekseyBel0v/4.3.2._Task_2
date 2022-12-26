import java.util.Arrays;

public class Main {
    static String pathToInstallation = "/Users/belovaleksejolegovic/Desktop/Нетология/4. JAVA CORE/4.3 Streams, files, serialisation/4.3.1._Task_1/Games";

    public static void main(String[] args) {
        GameProgress gameProgress1 = new GameProgress(100, 10, 80, 1042.4);
        GameProgress gameProgress2 = new GameProgress(80, 20, 100, 542.4);
        Saver.saveGame(pathToInstallation + "/savegames/save1.dat", gameProgress1);
        Saver.saveGame(pathToInstallation + "/savegames/save2.dat", gameProgress2);
        Ziper.zipFiles(pathToInstallation + "/savegames/save.zip",
                Arrays.asList(pathToInstallation + "/savegames/save1.dat", pathToInstallation + "/savegames/save2.dat"));
    }
}