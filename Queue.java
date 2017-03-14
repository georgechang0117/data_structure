import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

class Queue {
  int max = 10;
  String[] st = new String[max];
  int front, rear;
  int tag;

  static Scanner keyboard = new Scanner(System.in);

  Queue() {
    front = max -1;
    rear = max -1;
    tag = 0;
  }

  public void enqueue() {
    if(front == rear && tag == 1) {
      System.out.print("\n\n 此佇列已滿!\n");
    }
    else {
      rear = (rear + 1) % max;
      System.out.print("\n請輸入一筆資料(字串格式): ");
      st[rear] = keyboard.nextLine();
      if(front == rear) {
        tag = 1;
      }
    }
    System.out.println();
  }

  public void dequeue() {
    if(front == rear && tag == 0) {
      System.out.print("\n 此佇列是空的! \n\n");
    }
    else {
      front = (front + 1) % max;
      System.out.printf("\n %s已被刪除\n", st[front]);
      if(front == rear) {
        tag = 0;
      }
      System.out.println();
    }
  }

  public void list() {
    int count = 0, i = 0;

    if(front == rear && tag == 0) {
      System.out.print("\n 此佇列是空的\n\n");
    }
    else {
      System.out.print("\n\n 佇列有下列資料\n");
      for(i=(front+1)%max; i!=rear; i=++i%max) {
        System.out.print(" ");
        System.out.print(st[i] + "\n");
        count++;
      }
      System.out.print(" ");
      System.out.print(st[i] + "\n");
      System.out.print("共有 " + (++count) + "筆資料。\n\n");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int option = 0;

    Queue obj = new Queue();
    do {
      System.out.println("環狀佇列的選單");
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
          obj.enqueue();
          break;
        case 2:
          obj.dequeue();
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