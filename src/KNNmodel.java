import java.util.*;

public class KNNmodel {

    private int k;
    String[][] trainingSet;
    ArrayList<Neighbors> topResults;

    public KNNmodel(String[][] trainingSet) {
        this.k = (int) Math.round(Math.sqrt(trainingSet.length));
        this.trainingSet = trainingSet;
        topResults = new ArrayList<>();
    }

    //this method will just return the string value which is the predicted digit.
    public String makePrediction(String[] inputData){
        String res = "";
        euclidean_distances(inputData);
        double smallestNeighbor = 10000000;
        for(int i = 0; i < topResults.size(); i++){
            if(topResults.get(i).getEuclideanDistance() < smallestNeighbor){
                smallestNeighbor = topResults.get(i).getEuclideanDistance();
                res = topResults.get(i).getDigit();
            }
        }
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

            if (topResults.size() >= k) {
                topResults.sort(Neighbors::compareTo);
                topResults.remove(topResults.size() - 1); //remove the last item which should be the furthest euclidean distance
            }
            topResults.add( new Neighbors(trainingSet[i][0], euclideanDistance));
        }

    }
}
