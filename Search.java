class Search {

  //return index
  private static short NonSentinelSearch(int[] a, int k) {
    int i = 1;
    while (i <= a.length -1) {
      if (a[i] == k) {
        return (short)i;
      }
      i++;
    }
    return -1;
  }

  private static short SentinelSearch(int[] a, int k) {
    int i = a.length -1;
    while(i >= 0 && a[i] != k) {
      i--;
    }
    return (short)i;
  }

  private static short BinarySearch(int[] a, int k) {
    int i = -1;
    int l=1;
    int u=a.length-1;
    boolean done = false;
    int m;
    while (l<=u && !done) {
      m = (l+u)/2;
      if (k > a[m]) {
        l=m+1;
      }
      else if (k < a[m]) {
        l=m-1;
      }
      else {
        i=m;
        done = true;
      }
    }
    return (short)i;
  }

  public static void main(String[] args) {
    int[] a1 = new int[] {1, 2, 5, 6, 13, 8, 26, 37};
    int[] a2 = new int[] {1, 2, 5, 6, 8, 13, 26, 37};
    short nss;
    nss = NonSentinelSearch(a1, 37);
    System.out.println(nss);
    nss = SentinelSearch(a1, 5);
    System.out.println(nss);
    nss = BinarySearch(a2, 100);
    System.out.println(nss);

  }
}