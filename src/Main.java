import java.io.FileWriter;
public class Main {
    public static void main(String[] args) throws Exception {

        StringBuilder temp = new StringBuilder();
        Installation installation = new Installation();

        installation.installationDir("C://Games", temp);
        installation.installationDir("C://Games/src", temp);
        installation.installationDir("C://Games/res", temp);
        installation.installationDir("C://Games/savegames", temp);
        installation.installationDir("C://Games/temp", temp);
        installation.installationDir("C://Games/src/main", temp);
        installation.installationDir("C://Games/src/test", temp);
        installation.installationDir("C://Games/res/drawables", temp);
        installation.installationDir("C://Games/res/vectors", temp);
        installation.installationDir("C://Games/res/icons", temp);

        installation.createFile("C://Games/temp/", "temp.txt", temp);
        installation.createFile("C://Games/src/main", "Main.java", temp);
        installation.createFile("C://Games/src/main", "Utils.java", temp);

        try (FileWriter file = new FileWriter("C://Games/temp/temp.txt")) {
            file.append(temp);
        }

        GameProgress firstGp = new GameProgress(90, 13, 96, 89.67);
        GameProgress secondGp = new GameProgress(45, 67, 99, 99.99);
        GameProgress thirdGp = new GameProgress(34, 45, 113, 123.54);

        SaveGame sG = new SaveGame();
        sG.saveGame("C://Games/savegames/save1.dat", firstGp);
        sG.saveGame("C://Games/savegames/save2.dat", secondGp);
        sG.saveGame("C://Games/savegames/save3.dat", thirdGp);

        String[] zipDir = new String[]{"C://Games/savegames/save1.dat", "C://Games/savegames/save2.dat", "C://Games/savegames/save3.dat"};

        sG.zipFiles("C://Games/savegames/zip.zip", zipDir, temp);

    }
}