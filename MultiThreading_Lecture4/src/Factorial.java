import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {

        int[]arr = {10000, 20000, 30000, 60000, 7700, 4000, 5000, 7000, 15000, 40000, 50000};

        long start = System.currentTimeMillis();

        for(int i=0;i<arr.length;i++){
            System.out.println(calculate(arr[i]));
        }

        System.out.println(System.currentTimeMillis() - start);
    }

    private static BigInteger calculate(int num){
        BigInteger bi = BigInteger.valueOf(1);

        for(int i=2;i<=num;i++){
            bi = bi.multiply(BigInteger.valueOf(i));
        }

        return bi;
    }
}
