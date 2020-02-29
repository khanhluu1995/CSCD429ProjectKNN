import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        File file = new File("train.csv");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        final double totalExample = 42000;
//        int k  = (int) Math.round(Math.sqrt(totalExample));
        String[][] trainingData, testData;
        trainingData = new String[42000][784];
        int i = 0;

        while (scanner.hasNext()) {
            String[] splitLine = scanner.nextLine().split(",");
            for(int j =0; j < 784; j++){
                trainingData[i][j] = splitLine[j];
            }
            i++;
        }

//        print2D(trainingData);
    }

    public static void print2D(String mat[][])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++) {
            System.out.println();
            // Loop through all elements of current row
            for (int j = 0; j < 784; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }
    }
}