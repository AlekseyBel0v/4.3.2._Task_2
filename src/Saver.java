import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Saver {
    static void saveGame(String pathForSave, GameProgress gameProgress) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        File saveFile = new File(pathForSave);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile))) {
            if (saveFile.createNewFile()) {
                System.out.println(sdf.format(new Date()) + " Save file " + saveFile.getName() + " created.");
            } else {
                System.out.println(sdf.format(new Date()) + " Save file " + saveFile.getName() + " didn't create!");
            }
            oos.writeObject(gameProgress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}