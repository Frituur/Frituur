package be.thomasmore.graduaten.hellospring.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileCreater {

    private static String tempFilePath  = "";
    private static String MainProjectPath = "src/main/java/be/thomasmore/graduaten/hellospring/temp/";

    public void CreateTempFile(String filename) throws IOException {
        String absoluteTestPath = new File(MainProjectPath).getAbsolutePath();
        System.out.println(absoluteTestPath);
        var newfile = MainProjectPath + filename;
        Path textFilePath = Paths.get(newfile);
        tempFilePath = newfile.toString();
        System.out.println(tempFilePath);
        Files.createFile(textFilePath);
    }

    public void AssignTempFile(String filename) {
        String absoluteTestPath = new File(MainProjectPath).getAbsolutePath();
        tempFilePath = absoluteTestPath + filename;
    }

    public void ClearTempFile(String File){


    }

    public void WriteToTempFile(String json) throws IOException {
        File fout = new File(tempFilePath);
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (int i = 0; i < 10; i++) {
            bw.write(json);
            bw.newLine();
        }

        bw.close();

    }

    public String ReadFromTempFile() throws IOException {
        BufferedReader reader = new BufferedReader(new BufferedReader(new FileReader(tempFilePath)));
        return reader.readLine();
    }

    public String SearchTempFile() {

        String tempfile = "";
        File directory = new File(MainProjectPath);
        File[] contents = directory.listFiles();
        for ( File f : contents) {
            tempfile = f.getAbsolutePath();
            break;
        }
        return tempfile;
    }

    private String SearchRightDirectory(String directoryPath, String directoryName) {
        File file = new File(directoryPath);
        File tempDirectory = new File("");
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });
        for (var directory : directories) {
            if(directory.contains(directoryName)){
                     var pathTempDirectory =  directory;
                     tempDirectory = new File(pathTempDirectory);
            }
        }
        return tempDirectory.getAbsolutePath();
    }
}

