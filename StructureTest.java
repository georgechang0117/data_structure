public class StructureTest
{
  public static int sum(int arr[]) {
    int i, total=0;
    int n = arr.length;
    for(i=0; i<n; i++){
      total += arr[i];
    }
    return total;
  }

  public static void binsrch(int a[], int x) {
    int lower = 1;
    int upper = a.length + 1;
    int mid;
    while(lower <= upper) {
      mid = (lower + upper) / 2;
      if(x > a[mid])
        lower = mid + 1;      
      else if(x < a[mid])
        upper = mid - 1;
      else {
        System.out.println("Found, " + x + "is" + mid + "record.");
        break;
      }

    }
  }

  public static int fibonacci(int n) {
    if (n == 0)
      return 0;
    else if (n==1)
      return 1;
    else
      return(fibonacci(n-1) + fibonacci(n-2));
  }

  public static int fibonacci2(int n) {
    int prev1, prev2, item = 0, i;
    if (n==0)
      return 0;
    else if (n==1)
      return 1;
    else {
      prev2 = 0;
      prev1 = 1;
      for(i=2; i<=n; i++) {
        item = prev1 + prev2;
        prev2 = prev1;
        prev1 = item;
      }
      return item;
    }
  }

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);
    System.out.println("Hello! World");
    int[] arr = {1,2, 6, 4, 5, 3, 7, 8};
    int arr_sum = sum(arr);
    System.out.println(arr_sum);

    binsrch(arr, 3);
    startTime = System.nanoTime();
    System.out.println(fibonacci(30));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println("execute time:" + duration);

    startTime = System.nanoTime();
    System.out.println(fibonacci2(30));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println("execute time:" + duration);
  }
}