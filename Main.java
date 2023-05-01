package Task3_1_ProgramInstallation.src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.StringBuilder;

public class Main {

    public static void main(String[] args) {
        StringBuilder sbLog = new StringBuilder();

        // В папке Games создайте несколько директорий: src, res, savegames, temp.
        createNewFile("C:/Java/Task3.1_Files_Installation/Games/src", sbLog);
        createNewFile("C:/Java/Task3.1_Files_Installation/Games/res", sbLog);
        createNewFile("C:/Java/Task3.1_Files_Installation/Games/savegames", sbLog);
        createNewFile("C:/Java/Task3.1_Files_Installation/Games/temp", sbLog);

        // В каталоге src создайте две директории: main, test.
        createNewFile("C:/Java/Task3.1_Files_Installation/Games/src/main", sbLog);
        createNewFile("C:/Java/Task3.1_Files_Installation/Games/src/test", sbLog);

        //В подкаталоге main создайте два файла: Main.java, Utils.java.
        createNewFile("C:/Java/Task3.1_Files_Installation/Games/src/main",
                "Main.java", sbLog);
        createNewFile("C:/Java/Task3.1_Files_Installation/Games/src/main",
                "Utils.java", sbLog);

        //В каталог res создайте три директории: drawables, vectors, icons.
        createNewFile("C:/Java/Task3.1_Files_Installation/Games/res/drawables", sbLog);
        createNewFile("C:/Java/Task3.1_Files_Installation/Games/res/vectors", sbLog);
        createNewFile("C:/Java/Task3.1_Files_Installation/Games/res/icons", sbLog);

        //В директории temp создайте файл temp.txt.
        createNewFile("C:/Java/Task3.1_Files_Installation/Games/temp",
                "temp.txt", sbLog);



        try (FileWriter logFile = new FileWriter(
                "C:/Java/Task3.1_Files_Installation/Games/temp/temp.txt", false)) {
            logFile.write(sbLog.toString());
            logFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void createNewFile(String dirPath, StringBuilder sbLog ) {

        File dir = new File(dirPath);
        if (dir.mkdir()) {
            sbLog.append("Congratulations! Catalog '"+ dirPath +"' successfully created\n");
        }

    }


    private static void createNewFile(String dirPath, String fileName, StringBuilder sbLog) {

        File file = new File(dirPath, fileName);
        try {
            if ( file.createNewFile()) {
                sbLog.append("Congratulations! File '"+ fileName +"' in the catalog '"
                        + dirPath +"' successfully created\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}