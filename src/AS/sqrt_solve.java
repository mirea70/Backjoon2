package AS;

public class sqrt_solve {
    public static void main(String[] args) {
        System.out.println(String.format("%.2f" ,sqrt(6,144)));
    }
    private static double sqrt(int n, int num) {
        if(n == 0) return 1;
        double result = ((sqrt(n -1,  num)) * (sqrt( n -1,  num)) + num ) / (double)(2 * sqrt( n -1,  num));
        return result ;
    }
}