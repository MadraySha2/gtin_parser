package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        convertSgtins();
    }

    public static void convertSgtins(){
        File file = new File("src/main/java/org/example/22122.txt");
        List<String> gtins = new ArrayList<>();
        List<String> last3chars = new ArrayList<>();
        try (Reader reader = new FileReader(file)) {
            BufferedReader br = new LineNumberReader(reader);
            while (br.ready()){
                String rawLine = br.readLine();
                if (rawLine.startsWith("01")){
                    rawLine = rawLine.substring(2, 33);
                }
                String sgtin = rawLine.substring(0, 14) + rawLine.substring(16, 29);
                last3chars.add(sgtin.substring(24, 27));
                gtins.add(sgtin);
            }
            br.close();
            File file1 = new File("new.txt");
            Writer writer = new FileWriter(file1);
            String prev = "";
            for (String s : gtins){
                writer.write(s + '\n');
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


}
