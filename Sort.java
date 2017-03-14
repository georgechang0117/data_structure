import java.util.ArrayList;
class Sort {

  private static void Insert(int r, ArrayList<Integer> a, int i) {
    int j = i;

    while(j>=0 && r < a.get(j)) {
      j = j-1;
    }
    a.add(j+1, r);
  }

  //Stable
  private static ArrayList<Integer> InsertSort(ArrayList<Integer> a) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(a.get(0));
    for (int i=1; i<a.size(); i++) {
      Insert(a.get(i), list, i-1);
    }
    return list;
  }

  //Unstable
  private static void SelectionSort(ArrayList<Integer> a) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i=0; i<a.size()-1;i++) {
      int m=i;
      for(int j=i+1;j<a.size();j++) {
        if(a.get(j) < a.get(m)) {
          m=j;
        }
      }
      if (i != m) {
        int k = a.get(i);
        a.set(i, a.get(m));
        a.set(m, k);
      }
    }
  }

  //Stable
  private static void BubbleSort(ArrayList<Integer> a) {
    int f;
    for(int i=0;i<a.size()-1;i++) {
      f=0;
      for(int j=0;j<a.size()-1;j++) {
        if (a.get(j+1) < a.get(j)) {
          int k = a.get(j);
          a.set(j, a.get(j+1));
          a.set(j+1, k);
          f=1;
        }
      }
      if (f==0) {
        break;
      }
    }
  }

  //Unstable
  private static void QuickSort(ArrayList<Integer> a, int m, int n) {
    if (m<n) {
      int i = m;
      int j = n+1;
      int k = a.get(m);//C.K
      
      do {
        do {
          i = i+1;
        } while(i < n && a.get(i) < k);
        do {
          j = j-1;
        } while(a.get(j) > k);
        
      } while(i<j);
      int l = a.get(m);
      a.set(m, a.get(j));
      a.set(j, l);

      QuickSort(a, m, j-1);
      QuickSort(a, j+1, n);
    }
  }

  private void MergeSort() {
    
  }

  public static void main(String[] args) {
    ArrayList<Integer> a1 = new ArrayList<Integer>();
    a1.add(26);
    a1.add(5);
    a1.add(19);
    a1.add(17);
    a1.add(3);
    for (Integer number : a1) {
      System.out.print(number + ", ");
    }
    System.out.println();
    ArrayList<Integer> a2 = InsertSort(a1);
    for (Integer number : a2) {
      System.out.print(number + ", ");
    }
    System.out.println();
    //SelectionSort(a1);
    //BubbleSort(a1);
    int m = 0;
    int n = a1.size()-1;
    QuickSort(a1, m, n);
    for (Integer number : a1) {
      System.out.print(number + ", ");
    }
    System.out.println();

    
  }
}