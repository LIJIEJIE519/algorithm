public class Main {
    /**
     *
     * @param A string字符串一维数组 
     * @return int整型
     */
    public static void help (String[] A) {

        int res = 0;
        for(int i = 0; i < A[0].length(); i++) {
            int j = 1;
            for (; j < A.length; j++) {
                if (A[j].charAt(i) - A[j-1].charAt(i) < 0) {
                    res += 1;
                    break;
                }
            }
            System.out.print(j + " ");
            if (j == A.length)
                break;
        }
        System.out.println();
        System.out.println(res);
    }

    public static void main(String[] args) {
        String[] a = {"xyx","yvu","asr"};
        help(a);
    }
}