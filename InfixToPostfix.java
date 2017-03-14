import java.io.*;
import java.lang.String;
import java.util.Scanner;

class InfixToPostfix {
  int max = 20;
  char infix_q[] = new char[max];
  static Scanner keyboard = new Scanner(System.in);

  InfixToPostfix() {
    int i;
    for(i=0;i<max;i++) {
      infix_q[i] = '\0';
    }
  }

  public void infix_to_postfix() throws IOException {
    int rear = 0, top = 0, ctr = 0, i = 0, index = -1;
    char stack_t[] = new char[max];
    for(i=0;i<max;i++) {
      stack_t[i] = '\0';
    }

    System.out.print("輸入一中序運算式: ");
    String str = keyboard.next();

    i = 0;
    while(i<str.length()) {
      index++;
      infix_q[index] = str.charAt(index);
      i++;
    }

    infix_q[index+1] = '#';

    System.out.print("Postfix expression: ");
    stack_t[top] = '#';

    for(ctr=0;ctr<=index+1;ctr++) {
      
      switch(infix_q[ctr]) {
      
        case ')':
          while(stack_t[top]!='(') {
            System.out.printf("%c", stack_t[top--]);
          }
          top--;
          break;
        case '#':
          while(stack_t[top]!='#') {
            System.out.printf("%c", stack_t[top--]);
          }
          break;
        case '(':
        case '^':
        case '*':
        case '/':
        case '+':
        case '-':
          while(compare(stack_t[top], infix_q[ctr])==1) {
            System.out.printf("%c", stack_t[top--]);
          }
          stack_t[++top] = infix_q[ctr];
          break;
        default :
          System.out.printf("%c", infix_q[ctr]);
      }
    }
    System.out.println();
  }

  public int compare(char stack_o, char infix_o) {
    char[] infix_priority = new char[9];
    char[] stack_priority = new char[8];
    int index_s = 0, index_i = 0;

    stack_priority[0] = '#';
    stack_priority[1] = '(';
    stack_priority[2] = '+';
    stack_priority[3] = '-';
    stack_priority[4] = '*';
    stack_priority[5] = '/';
    stack_priority[6] = '^';
    stack_priority[7] = ' ';

    infix_priority[0] = '#';
    infix_priority[1] = ')';
    infix_priority[2] = '+';
    infix_priority[3] = '-';
    infix_priority[4] = '*';
    infix_priority[5] = '/';
    infix_priority[6] = '^';
    infix_priority[7] = ' ';
    infix_priority[8] = '(';

    while(stack_priority[index_s] != stack_o) {
      index_s++;
    }
    while(infix_priority[index_i] != infix_o) {
      index_i++;
    }

    return ((int)(index_s/2) >= (int)(index_i/2) ? 1 : 0 );
  }

  public static void main(String args[]) throws IOException {
    InfixToPostfix obj = new InfixToPostfix();
    obj.infix_to_postfix();
  }
}