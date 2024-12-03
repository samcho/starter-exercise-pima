import java.util.ArrayList;

public class PimaCorrelation {

    // Method to calculate correlation coefficient
    public static double Correlation(ArrayList<Double> xs, ArrayList<Double> ys) {
        // Check if both ArrayLists are non-null and of the same length
        if (xs == null || ys == null || xs.size() != ys.size()) {
            throw new IllegalArgumentException("Input arrays must not be null and must have the same length.");
        }

        double sx = 0.0;
        double sy = 0.0;
        double sxx = 0.0;
        double syy = 0.0;
        double sxy = 0.0;

        int n = xs.size();  // Get the size of the ArrayLists

        // Loop through the elements in the ArrayLists
        for (int i = 0; i < n; ++i) {
            double x = xs.get(i);
            double y = ys.get(i);

            sx += x;
            sy += y;
            sxx += x * x;
            syy += y * y;
            sxy += x * y;
        }

        // Covariance
        double cov = sxy / n - sx * sy / n / n;
        // Standard deviation of x
        double sigmax = Math.sqrt(sxx / n - sx * sx / n / n);
        // Standard deviation of y
        double sigmay = Math.sqrt(syy / n - sy * sy / n / n);

        // Correlation is the normalized covariance
        return cov / sigmax / sigmay;
    }

    public static void main(String[] args) {
        // TODO: Replace sample data with Pima Indians Diabetes Dataset https://www.kaggle.com/datasets/uciml/pima-indians-diabetes-database
        ArrayList<Double> X = new ArrayList<>();
        X.add(15.0);
        X.add(18.0);
        X.add(21.0);
        X.add(24.0);
        X.add(27.0);

        ArrayList<Double> Y = new ArrayList<>();
        Y.add(25.0);
        Y.add(25.0);
        Y.add(27.0);
        Y.add(31.0);
        Y.add(32.0);

        // Function call to correlationCoefficient
        System.out.printf("%6f\n", Correlation(X, Y));
    }
}
