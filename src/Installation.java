import java.io.File;
import java.io.IOException;

public class Installation {
    public void installationDir (String a, StringBuilder b){
        File newdir = new File(a);
        if (newdir.mkdir()){
            System.out.println("Директория " + a + " успешно создана!");
            b.append("Директория ").append(a).append(" успешно создана!\n");
        } else {
            System.out.println("Возникли проблемы c созданием директории " + a);
            b.append("Директория ").append(a).append(" не создана!\n");
        }
    }

    public void createFile(String parent, String child, StringBuilder a){
        File newFile = new File(parent, child);
        try {
            if (newFile.createNewFile()){
                System.out.println("Файл " + child + " создан!");
                a.append("Файл ").append(child).append(" создан!\n");
            } else {
                a.append("Файл ").append(child).append(" не создан!\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}