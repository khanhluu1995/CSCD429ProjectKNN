import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        File file = new File("train.csv");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        final int totalExample = 42000;
        final int totalAttr = 784;
        String[][] trainingData = new String[totalExample][totalAttr];
        int i = 0;

        //reading the training data into 2D array
        while (scanner.hasNext()) {
            String[] splitLine = scanner.nextLine().split(",");
            for(int j =0; j < 784; j++){
                trainingData[i][j] = splitLine[j];
            }
            i++;
        }

        //create submission.csv
        File writeFileName = new File("submission.csv");

        //start to write into submission.csv
        try{
            FileWriter fileWriter = new FileWriter(writeFileName);
            fileWriter.write("ImageId,Label\n");

            //begin the iteration through test data and perform the prediction
            file = new File("test.csv");
            LinkedList<String> result = new LinkedList<>();
            scanner = new Scanner(file);
            scanner.nextLine();

            //predicting by each line from the test.csv
            while(scanner.hasNext()) {
                String[] splitLine = scanner.nextLine().split(",");
                KNNmodel myModel = new KNNmodel(trainingData);
                result.add(myModel.makePrediction(splitLine));
//                System.out.println(myModel.makePrediction(splitLine));
            }

            //write to file from the linkedList that has been stored from the prediction process
            for(i = 0; i < result.size(); i++){
                fileWriter.write(i + "," + result.get(i) + "\n");
//                System.out.println(i + "," + result.get(i) + "\n");
            }
            fileWriter.close();

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

//    public static void print2D(String mat[][])
//    {
//        // Loop through all rows
//        for (int i = 0; i < mat.length; i++) {
//            System.out.println();
//            // Loop through all elements of current row
//            for (int j = 0; j < 784; j++) {
//                System.out.print(mat[i][j] + " ");
//            }
//        }
//    }
}