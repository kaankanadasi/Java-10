import java.util.Scanner;
public class Guess{
     public static void main(String []args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Determine the range: ");
        int range = scan.nextInt();
        // alıcağın sayı aralığı için input al
        
        int int1 = scan.nextInt();
        int int2 = scan.nextInt();
        
        int int3 = scan.nextInt();
        int int4 = scan.nextInt();
        
        int count1 = 0;
        int count2 = 0;
        
        for (int i=0; i<range; i++) {
            if (i%int1==0 || i%int2==0) {
                count1 += i;
            }
            if (i%int3==0 || i%int4==0) {
                count2 += i;
            }
        }
        
        int a = Math.abs(count2 - count1);
        System.out.println(a);
        
     }
}