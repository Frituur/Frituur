package be.thomasmore.graduaten.hellospring.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.*;

@Component
public class FileCreater {



    private String filename = "C:\\Users\\ArnoS\\Downloads\\Frituur-master\\Frituur-master\\src\\main\\java\\be\\thomasmore\\graduaten\\hellospring\\temp\\temp1.txt"; 
    private String folder = "C:\\Users\\ArnoS\\Downloads\\Frituur-master\\Frituur-master\\src\\main\\java\\be\\thomasmore\\graduaten\\hellospring\\temp";
    private static String tempFilePath  = "";
    private static String MainProjectPath = "src/main/java/be/thomasmore/graduaten/hellospring";
    
    
    public void WriteToTempFile(String json) throws IOException {

        File fout = new File(filename);
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (int i = 0; i < 10; i++) {
            bw.write(json);
            bw.newLine();
        }

        bw.close();

    }

    public String ReadFromTempFile() throws IOException {
        BufferedReader reader = new BufferedReader(new BufferedReader(new FileReader(filename)));
        return reader.readLine();
    }

    public String SearchTempFile() {

        String tempfile = "";
        File directory = new File(folder);
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

