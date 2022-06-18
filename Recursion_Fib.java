public class Recursion_Fib {

    public static void main(String[] args) {
        int []arr=new int[20];
        arr[1]=1;
        arr[2]=1;
        System.out.print(" "+arr[1]);
        System.out.print(" "+arr[2]);
        for(int i=3;i<20;i++){
            arr[i]=arr[i-1]+arr[i-2];
            System.out.print("  "+arr[i]);
        }
    }
}
