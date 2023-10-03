import java.util.Scanner;
public class Guess{
     public static void main(String []args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Determine the range: ");
        int range = scan.nextInt();
        // alıcağın sayı aralığı için input al
        
        int int1 = scan.nextInt();
        // input num1
        int int2 = scan.nextInt();
        // input num2
        
        int int3 = scan.nextInt();
        // input num3
        int int4 = scan.nextInt();
        // input num4
        
        int count1 = 0;
        int count2 = 0;
        
        for (int i=0; i<range; i++) {
            // range deki her sayıyı "iterate" et
            if (i%int1==0 || i%int2==0) {
                count1 += i;
            }
            // range'deki sayıların input'u girdiğimiz iki sayıyla -num1, num2- bölünüp bölünmediğine bak, bölünüyorsa o sayıyı count1 de topla
            if (i%int3==0 || i%int4==0) {
                count2 += i;
            }
            // range'deki sayıların input'u girdiğimiz iki sayıyla -num3, num4- bölünüp bölünmediğine bak, bölünüyorsa o sayıyı count2 de topla
        }
        
        int a = Math.abs(count2 - count1);
        // difference -> absolute value al 
        System.out.println(a);
        // bul artık
        
     }
}