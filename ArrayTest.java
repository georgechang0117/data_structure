import java.util.Random;
import java.util.Arrays;

public class ArrayTest {

  //Pratice 2.5 將Bn*n的上三角形，儲存於B(1:n(n+1)/2)
  //以列為主
  public static int[] get_array_from_upper_triangular_matrix(int n, int b[][]) {
    int d[] = new int[n*(n+1)/2];
    
    int k = 0;
    for(int i=1;i<=n;i++){
      for(int j=1;j<=n;j++) {
        if(i<=j) {
          k = n*(i-1) - (i*(i-1)/2) + j -1;
          d[k] = b[i-1][j-1];
        }
      }
    }
    return d;
  }

  public static int[][] get_upper_triangular_matrix_from_array(int n, int d[]) {
    int b[][] = new int[n][n];
    int p;
    int k = 0;
    for(int i=1;i<=n;i++){
      for(int j=1;j<=n;j++) {
        if(i>j) {
          b[i-1][j-1] = 0;
        }
        else {
          k = n*(i-1) - (i*(i-1)/2) + j -1;
          b[i-1][j-1] = d[k];
        }
      }
    }
    return b;
  }


  public static void main(String[] args) {
    /*
    int a1[] = new int[20];
    int a2[][] = new int[20][10];
    int a3[][][] = new int[30][20][10];

    String aStr = new String("Apple iPod");
    System.out.printf("%s\n", aStr);
    System.out.printf("%s\n", aStr.substring(6,10));

    int i[] = new int[10];
    int k, total = 0;
    for(k=0;k<10;k++) {
      i[k]=k+1;
    }
    for(k=0;k<10;k++) {
      total += i[k];
    }
    System.out.printf("%d\n", total);
    */
    /*
    int sm[][] = new int[6][6];
    for(int i=0; i<sm.length; i++) {
      for (int j=0; j<sm[i].length; j++) {
        sm[i][j] = 0;
      }
    }
    sm[0][1] = 15;
    sm[0][4] = -8;
    sm[1][2] = 6;
    sm[2][3] = -6;
    sm[3][2] = 18;
    sm[4][5] = 16;
    sm[5][0] = 72;
    sm[5][4] = 20;

    int sm_two_dim[][] = new int[9][3];
    
    sm_two_dim[0][0] = sm.length;
    sm_two_dim[0][1] = sm[0].length;
    sm_two_dim[0][2] = 8;
    System.out.println(sm_two_dim[0][0] + ", " + sm_two_dim[0][1] + ", " + sm_two_dim[0][2]);
    System.out.println("============");
    int n = 1;
    for(int i=0; i<sm.length; i++) {
      for (int j=0; j<sm[i].length; j++) {
        if(sm[i][j] != 0) {
          sm_two_dim[n][0] = i+1;
          sm_two_dim[n][1] = j+1;
          sm_two_dim[n][2] = sm[i][j];
          System.out.println(sm_two_dim[n][0] + ", " + sm_two_dim[n][1] + ", " + sm_two_dim[n][2]);
          n += 1;
        }
      }
    }
    */
    int n = 4;
    int b[][] = new int[n][n];
    Random r = new Random();
    b[0][0] = r.nextInt(100);
    for(int i=0;i<n;i++) {
      for(int j=0;j<n;j++) {
        if(i>j)
          b[i][j] = 0;
        else
          b[i][j] = r.nextInt(100)+1;
      }
    }
    System.out.println(Arrays.deepToString(b));
    int d[] = get_array_from_upper_triangular_matrix(n, b);
    
    System.out.println(Arrays.toString(d));
    int b2[][] = get_upper_triangular_matrix_from_array(n, d);
    System.out.println(Arrays.deepToString(b2));
  }
}