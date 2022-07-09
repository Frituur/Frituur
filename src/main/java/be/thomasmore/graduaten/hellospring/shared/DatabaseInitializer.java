package be.thomasmore.graduaten.hellospring.shared;

import org.slf4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Hashtable;

public class DatabaseInitializer {
    private Logger logger;

    public DatabaseInitializer(Logger logger){
        this.logger = logger;

    }
    // First make a connection to the database

    // then find the schema of the database

    // Update data to update the photo's

    public void SeedDatabase(){

    }

    public Connection GetConnection() throws SQLException {
        String jdbcUrl = "jdbc:mysql://frituur.mysql.database.azure.com:3306/frituur?useSSL=FALSE";
        Connection connection = DriverManager.getConnection(jdbcUrl, "Arno", "passwoord12345!");
        logger.info("Database connected");
        return connection;
    }

    public void InsertPhotosForProducts(Connection connection, String imagePath, int id ) throws SQLException, FileNotFoundException {
        // read files images from the webapp
        // Find the file from images

        PreparedStatement pstmt = connection.prepareStatement("update frituur.products set photo = ? where productid = ?");
        File blob = new File(imagePath);
        FileInputStream in = new FileInputStream(blob);


        pstmt.setBinaryStream(1, in, (int)blob.length());

        pstmt.setInt(2, id);  // set the PK value
        pstmt.executeUpdate();
        pstmt.close();

        logger.info("Image has been inserted");



    }

    private String FindFileImages() {
        // Select the right directory Products directory loop throu
        Dictionary<Integer, String> orderOfProductDirectories
                = new Hashtable<Integer, String>() {
        };
        orderOfProductDirectories = FillDict(orderOfProductDirectories);
        String pathDirectionProduct = "src/main/webapp/images/products";
        File file = new File(pathDirectionProduct);
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });
        //Go throuh all the directories



        return null;

    }
    private Dictionary<Integer, String> FillDict(Dictionary<Integer, String> dict){
        dict.put(1, "images/snacks");
        dict.put(2, "images/burgers");
        dict.put(3, "dranken");
        dict.put(4, "desert");
        return dict;
    }


}
