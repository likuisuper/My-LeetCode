package ArrayAndString;

public class TwoArray {
    private static void printArray(int[][] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        for(int i=0;i<a.length;i++){
            for(int j=0;a[i]!=null&&j<a[i].length;++j){
                System.out.println(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("example1:");
        int[][] a=new int[2][5];
        printArray(a);
        System.out.println("example2:");
        int[][] b=new int[2][];
        printArray(b);
        System.out.println("example3:");
        b[0]=new int[3];
        b[1]=new int[5];
        printArray(b);
    }
}
