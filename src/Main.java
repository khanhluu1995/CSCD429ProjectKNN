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
        File writeFileName = new File("output.csv");

        //start to write into submission.csv
        try{
            FileWriter fileWriter = new FileWriter(writeFileName);
            fileWriter.write("ImageId,Label");

            //begin the iteration through test data and perform the prediction
            file = new File("test.csv");
            LinkedList<String> result = new LinkedList<>();
            scanner = new Scanner(file);
            scanner.nextLine();

            while(scanner.hasNext()) {
                String[] splitLine = scanner.nextLine().split(",");
                KNNmodel myModel = new KNNmodel(trainingData);
//                result.add(myModel.makePrediction(splitLine));
                System.out.println(myModel.makePrediction(splitLine));
            }

            System.out.println(result.size());

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }




//        ArrayList<Neighbors> testList = new ArrayList<>();
//
////        testList.add(new Neighbors("two",200));
////        testList.add(new Neighbors("three",80));
////        testList.add(new Neighbors("four",15));
////        testList.add(new Neighbors("five",500));
//        for(int x = 0; x < 205; x ++){
//            testList.add(new Neighbors("one",100));
////            System.out.println("digit " + testList.get(x).getDigit() + " has euclidean distance of: " + testList.get(x).getEuclideanDistance());
//        }
//        testList.add(new Neighbors("two",50));
//        testList.add(new Neighbors("two",200));
//        testList.sort(Neighbors::compareTo);
//        System.out.println("digit " + testList.get(0).getDigit() + "has euclidean distance of: " + testList.get(0).getEuclideanDistance());
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