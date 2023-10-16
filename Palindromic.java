import java.util.Scanner;
public class Palindromic {
    
    // ilk kısımı internetten yardım alarak yaptım
    public static int reverse(int num) {
    // reverse is a function to reverse an integer
    int reverse = 0;
    while (num != 0) {
        // num = 0 olduğunda loop'u kapatır
        reverse = reverse * 10 + num % 10;
        // son basamklı sayıyı alıyor, sonraki loopta bu sayıyı onlar basamğına geçiriyor ve yeni aldığı sayıyı birler basamağına alıyor 
        num /= 10;
        // aldığı birler basamğını tekrar almamak için num'ı 10'a bölüyor
    }
    return reverse;
}

     public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Write a integer: ");
        int num = scan.nextInt();  
        int reversed = reverse(num);
        // calls the reverse func
        if (num == reversed) {
            // .equals yapmak için şu gerekir: String.valueOf(num).equals(String.valueOf(reversed))
            System.out.println(num + " is a PALINDROMIC NUMBER (True)");
        } else {
            System.out.println(num + " is NOT a PALINDROMIC NUMBER (False)");
        }
     }
     
}