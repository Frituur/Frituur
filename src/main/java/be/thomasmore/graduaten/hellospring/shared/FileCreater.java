package be.thomasmore.graduaten.hellospring.shared;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileCreater {

    private String filename = "C:\\Users\\ArnoS\\Downloads\\Frituur-master\\Frituur-master\\src\\main\\java\\be\\thomasmore\\graduaten\\hellospring\\temp\\temp1.txt";
    private String folder = "C:\\Users\\ArnoS\\Downloads\\Frituur-master\\Frituur-master\\src\\main\\java\\be\\thomasmore\\graduaten\\hellospring\\temp";


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
}