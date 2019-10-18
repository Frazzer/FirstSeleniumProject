package selenium;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class BasicCsvReader {

    private static String testFile;


    public static void main(String[] args) throws IOException {

        testFile = BasicCsvReader.class.getClassLoader().getResource("test.csv").getFile();
        Reader reader = new FileReader(new File(testFile).getAbsolutePath());
        CSVReader csvreader = new CSVReader(reader);

        List<String[]> list = csvreader.readAll();

        Iterator<String[]> ite= list.iterator();

        while(ite.hasNext()){
            String[] data = ite.next();
            for(int i=0; i<data.length; i++){
                System.out.println(data[i]);
            }
        }
    }
}
