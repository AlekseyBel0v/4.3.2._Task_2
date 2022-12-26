import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Ziper {
    public static void zipFiles(String pathForArchive, List<String> pathForFiles) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        try (ZipOutputStream zops = new ZipOutputStream(new FileOutputStream(pathForArchive))) {
            for (int i = 0; i < pathForFiles.size(); i++) {
                File file = new File(pathForFiles.get(i));
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
                    byte[] buffer = new byte[bis.available()];
                    bis.read(buffer);
                    ZipEntry ze = new ZipEntry(file.getName());
                    zops.putNextEntry(ze);
                    zops.write(buffer);
                    zops.closeEntry();
                    System.out.println(sdf.format(new Date()) + " архивация файла " + file.getName() + " завершена.");
                    delete(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delete(File file) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        if (file.delete()) {
            System.out.println(sdf.format(new Date()) + " Файл " + file.getName() + " был удален.");
        } else {
            System.out.println(sdf.format(new Date()) + " Удаление файл " + file.getName() + " не выполнено.");
        }
    }
}