// Life Game Implement
import java.io.*;
import java.util.Scanner;

class LifeGame {
  int maxRow = 25, maxCol = 25;
  int dead = 0, alive = 1;
  int[][] map = new int[maxRow][maxCol];
  int[][] newmap = new int[maxRow][maxCol];

  int generation = 0;
  Scanner keyboard = new Scanner(System.in);

  LifeGame() {
    generation = 0;
  }

  public void init() {
    int row = 0, col = 0;
    // initial map status = cells all dead in the beginning.
    for(row=0;row<maxRow;row++) {
      for (col=0;col<maxCol;col++) {
        map[row][col] = dead;
      }
    }

    System.out.print("Game of life Program \n");
    System.out.print("Enter (x,y) where (x,y) is a living cell\n");
    System.out.print(" 0 <= x <= " + (maxRow - 1) + " , 0 <= y <= "+ (maxCol - 1) +"\n");
    System.out.print("Terminate with (x,y) = (-1, -1) \n");

    do {
      System.out.print("x-->");
      System.out.flush();
      row = keyboard.nextInt();

      System.out.print("y-->");
      col = keyboard.nextInt();

      if (0 <= row && row <maxRow && 0 <= col && col < maxCol) {
        map[row][col] = alive;
      }
      else {
        System.out.print("(x, y) exceeds map range!\n");
      }
    } while (row != -1 || col != -1);
  }

  public int neighbors(int row, int col) {
    int count = 0, c = 0, r = 0;
    // calculate each cell's neighbor count

    for(r=row-1;r<=row+1;r++) {
      for(c=col-1;c<=col+1;c++) {
        if(r<0 || r>=maxRow || c<0 || c>= maxCol)
          continue;
        if(map[r][c] == alive)
          count ++;
      }
    }

    // adjust neighbor count
    if(map[row][col] == alive) {
      count --;
    }

    return count;
  }

  public void output_map() {
    int row = 0, col = 0;
    

    System.out.println(" Game of life cell status");
    System.out.println(" -----Generation"+ (++generation) + "-----");
    for(row=0;row<maxRow;row++) {
      System.out.println();
      System.out.print(" ");
      for(col=0;col<maxCol;col++) {
        if(map[row][col] == alive)
          System.out.print("@");
        else
          System.out.print("-");
      }
    }
  }

  public void copy_map() {
    int row = 0, col = 0;

    for(row=0;row<maxRow;row++) {
      for (col=0;col<maxCol;col++) {
        map[row][col] = newmap[row][col];
      }
    }
  }

  public void access() {
    int row = 0, col = 0;
    String ans = "";
    do {
      for(row=0;row<maxRow;row++) {
        for(col=0;col<maxCol;col++) {
          switch(neighbors(row, col)) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
              newmap[row][col] = dead;
              break;
            case 2:
              newmap[row][col] = map[row][col];
              break;
            case 3:
              newmap[row][col] = alive;
              break;
          }
        }
      }
      copy_map();
      do {
        System.out.print("\nContinue next Generation ?(y/n): ");
        ans = keyboard.next();

        if(ans.equals("y") || ans.equals("n")) {
          break;
        }
      } while(true);
      if(ans.equals("y")) {
        output_map();
      }
    } while(ans.equals("y"));
  }

  public static void main(String[] args) {
    LifeGame obj = new LifeGame();
    obj.init();
    obj.output_map();
    obj.access();
  }
}