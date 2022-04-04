public class Correlation {

    public static double Correlation(int[] xs, int[] ys) {
        //TODO: check here that arrays are not null, of the same length etc

        double sx = 0.0;
        double sy = 0.0;
        double sxx = 0.0;
        double syy = 0.0;
        double sxy = 0.0;

        int n = xs.length;

        for(int i = 0; i < n; ++i) {
            double x = xs[i];
            double y = ys[i];

            sx += x;
            sy += y;
            sxx += x * x;
            syy += y * y;
            sxy += x * y;
        }

        // covariation
        double cov = sxy / n - sx * sy / n / n;
        // standard error of x
        double sigmax = Math.sqrt(sxx / n -  sx * sx / n / n);
        // standard error of y
        double sigmay = Math.sqrt(syy / n -  sy * sy / n / n);

        // correlation is just a normalized covariation
        return cov / sigmax / sigmay;
    }

    public static void main(String[] args) {
        // TODO: Replace this with Pima Indians Diabetes Dataset https://www.kaggle.com/datasets/uciml/pima-indians-diabetes-database
        int X[] = {15, 18, 21, 24, 27};
        int Y[] = {25, 25, 27, 31, 32};

        // Function call to correlationCoefficient.
        System.out.printf("%6f",
                Correlation(X, Y));


    }
}
