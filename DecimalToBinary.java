import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int num = scan.nextInt();
    int count = 0;
    int toBinary = 0;
    
    if (num < 0) {
        System.out.println("Enter a positive integer.");
        return; 
    }
    
    while (num > 0) {
        int remainder = num % 2;
        // girdiğimiz input 2 ile bölünüyor mu
        toBinary += (int)(remainder * Math.pow(10, count));
        // Math.pow double veriyor o yüzden int'e cast ediyoruz
        num /= 2;
        count ++;
    }
    System.out.println("Binary representation: " + toBinary);

    }
} 