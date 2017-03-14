import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

class Stack {
  int max = 10;
  String[] st = new String[20];
  int top;
  static Scanner keyboard = new Scanner(System.in);

  Stack() {
    top = -1;
  }

  public void push() {
    if(top >= max - 1) {
      System.out.print("\n 堆疊是滿的! \n");
    }
    else {
      top++;
      System.out.print("\n請輸入一筆資料(字串的格式): ");
      st[top] = keyboard.next();
    }
    System.out.println("");
  }

  public void pop() {
    if(top < 0) {
      System.out.print("\n 堆疊是空的! \n");
    }
    else {
      System.out.printf("\n %s已被刪除!\n", st[top]);
      top--;
    }
  }
  public void list() {
    int count = 0, i = 0;

    if (top < 0) {
      System.out.print("\n The stack is empty! \n");
    }
    else {
      System.out.print("\n\n 堆疊有下列的資料: \n");
      System.out.print("--------------------\n");
      for(i=top;i>=0;i--) {
        System.out.print(" ");
        System.out.println(st[i]);
        count++;
      }
      System.out.print("-----------------\n");
      System.out.print("堆疊共有 "+ count +"筆資料。\n\n");
    }
    System.out.println();
  }

  public static void main(String args[]) {
    int option = 0;
    Stack obj = new Stack();
    do {
      System.out.println("堆疊的選單");
      System.out.println("1. Insert");
      System.out.println("2. Delete");
      System.out.println("3. List");
      System.out.println("4. Exit");
      System.out.println("請選擇");

      try {
        option = keyboard.nextInt();
      }
      catch(InputMismatchException e) {
        keyboard.nextLine();
        System.out.print("Not a correctly number.\n");
        System.out.print("Try again\n\n");
      }

      switch(option) {
        case 1:
          obj.push();
          break;
        case 2:
          obj.pop();
          break;
        case 3:
          obj.list();
          break;
        case 4:
          System.exit(0);
      }
    } while(true);
  }
}