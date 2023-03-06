
import java.util.Scanner;

public class MinMax {
    public static int minmax(int[] a, int[] b) {
        int n = a.length;
        int maxA =0;
        int maxB=0;

        // let maximum in both list is in list b;
        boolean whichMax = false;

        for(int i=0; i<n; i++){
            maxA=Math.max(maxA,a[i]);
            maxB = Math.max(maxB, b[i]);
        }

        // getting max element among both;
        if(maxA>maxB){
            whichMax = true;
        }

        // if max of f=both is in a,
        if(whichMax){

            for(int i=0; i<n; i++){
                if(a[i]<b[i]){
                    int temp=a[i];
                    a[i]=b[i];
                    b[i]=temp;
                }
            }
        }

        else{
            for(int i=0; i<n; i++){
                if(b[i]<a[i]){
                    int temp=a[i];
                    a[i]=b[i];
                    b[i]=temp;
                }
            }
        }
        maxA=0;
        maxB =0;
        for(int i=0; i<n; i++){
            maxA=Math.max(maxA,a[i]);
            maxB = Math.max(maxB, b[i]);

        }
        return maxA*maxB;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for(int i=0; i<n; i++){
            a[i]=sc.nextInt();
        }
        for (int i=0; i<n; i++){
            b[i]=sc.nextInt();
        }
        int result = minmax(a, b);
        System.out.println(result);
    }
}
