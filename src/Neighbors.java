public class Neighbors implements Comparable<Neighbors>{
    private String digit;
    private double euclideanDistance;

    public Neighbors(String digit, double euclideanDistance) {
        this.digit = digit;
        this.euclideanDistance = euclideanDistance;
    }

    public String getDigit() {
        return digit;
    }

    public double getEuclideanDistance() {
        return euclideanDistance;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

    public void setEuclideanDistance(double euclideanDistance) {
        this.euclideanDistance = euclideanDistance;
    }

    @Override
    public int compareTo(Neighbors o) {

        return (int) Math.round(this.euclideanDistance - o.euclideanDistance);
    }
}
