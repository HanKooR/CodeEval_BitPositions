package codeeval_BitPositions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static void loadFile(String fileName) {
        File file = new File(fileName);
        if (!file.canRead() || !file.isFile()) {
            System.exit(0);
        }
        BufferedReader in = null;
        String row;
        try {
            in = new BufferedReader(new FileReader(fileName));
            while ((row = in.readLine()) != null) {
                int bit1 = Integer.decode(row.split(",")[1]);
                int bit2 = Integer.decode(row.split(",")[2]);
                String number = Integer.toBinaryString(Integer.decode(row.split(",")[0]));
                if (number.charAt(number.length() - bit1) == number.charAt(number.length() - bit2)) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ioEx) {
                    ioEx.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] pathToFile) {
        if ((pathToFile != null) && (pathToFile.length == 1) && (!pathToFile[0].isEmpty())) {
            loadFile(pathToFile[0]);
        }
    }
}
