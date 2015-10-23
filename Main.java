package codeeval_BitPositions;

/*
 * Copyright (C) 2015 hankoor
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
