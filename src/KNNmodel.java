import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;

public class KNNmodel {

    private int k;
    private HashMap<String, Integer> distances;
    private LinkedList<Double> topResults;
    String[][] trainingSet;

    public KNNmodel(int k, String[][] trainingSet, String[][] testSet) {
        this.k = (int) Math.round(Math.sqrt(trainingSet.length));
        this.trainingSet = trainingSet;
        distances = new HashMap<>();

    }

    //this method will just return the string value which is the predicted digit.
    public String makePrediction(String[] inputData){

        String res = "";
        topResults = new LinkedList<>();
        euclidean_distances(inputData);

        return res;
    }

    private void euclidean_distances(String[] inputData){
        for(int i = 0; i < trainingSet.length; i++){
            double euclideanDistance = 0;
            for(int j = 0; j<783;j++){
                //calculate the euclidean distance
                euclideanDistance += Math.pow((Double.parseDouble(inputData[j])-Double.parseDouble(trainingSet[i][j+1])),2);
            }
            euclideanDistance = Math.sqrt(euclideanDistance);
            // end calculate the euclidean distance

            //checking if the distance is valid to put into the top 205 results.
            if(topResults.size() < k){
                for(int x = 0; x < topResults.size(); x++){
                    if(topResults.get(x) > euclideanDistance){
                        topResults.add(x-1,euclideanDistance);
                    }
                }


            }

        }

    }
}
