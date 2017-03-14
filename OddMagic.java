//Odd Magic Matrix Implementation

import java.io.*;
import java.util.Scanner;

class OddMagic {
  int max = 15;
  int n=0;
  int[][] square = new int[n+1][n+1];
  
  Scanner keyboard = new Scanner(System.in);

  public void anykey_f() {
    char tChar;

    System.out.print("\n\n");
    System.out.println(" Please any key to continue... ");
    try {
      tChar = (char)System.in.read();
    }
    catch(IOException e) {

    }
  }

  public void init() {
    String str="";

    do {
      System.out.print("\nEnter odd matrix size: ");
      n = keyboard.nextInt();
      if (n%2 == 0 || n <= 0) {
        System.out.print("Should be > 0 odd number");
      }
      else {
        break;
      }
    } while (1==1);
    square = new int[n+1][n+1];
  }

  public void Magic() {
    int i=0, j=0, p=0, q=0, key=0;

    for(i=0; i<n; i++) {
      for(j=0; j<n; j++) {
        square[i][j] = 0;
      }
    }

    square[0][(n-1)/2] = 1;
    key = 2;

    i=0; j=(n-1)/2;
    while (key <= n*n) {
      p = (i-1) % n;
      q = (j-1) % n;

      if(p < 0) {
        p = n - 1;
      }
      if(q < 0) {
        q= n - 1;
      }
      if(square[p][q] != 0) {
        i = (i + 1) % n;
      }
      else {
        i = p;
        j = q;
      }
      square[i][j] = key;
      key++;
    }
  }

  public void output() {
    int i=0, j=0;

    System.out.print("\nThe " + n + "*" + n + " Magic Matrix\n");
    System.out.print("--------------------\n");

    for(i=0; i<n; i++) {
      for(j=0; j<n; j++) {
        System.out.printf("%4d ", square[i][j]);
      }
      System.out.print("\n");
    }
    anykey_f();
  }

  public static void main(String args[]) {
    OddMagic obj = new OddMagic();
    //int i=0, j=0;
    obj.init();
    obj.Magic();
    obj.output();
  }
}