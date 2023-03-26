import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SaveGame {
    public void saveGame(String dir, GameProgress obj){

        try (FileOutputStream fos = new FileOutputStream(dir);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(obj);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void zipFiles(String a, String[] b, StringBuilder c) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(a))) {
            c.append("Архив Zip.zip создан\n");
            for (String x : b) {
                FileInputStream fis = new FileInputStream(x);
                ZipEntry entry = new ZipEntry(x);
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
                fis.close();
                c.append("Файл ").append(c).append(" помещен в архив\n");
                try {
                    Files.delete(Paths.get(x));
                    c.append("Исходный файл ").append(x).append(" удален\n\n");
                }  catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
