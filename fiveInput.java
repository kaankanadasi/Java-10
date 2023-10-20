import java.util.Scanner;

public class fiveInput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        int oddSum = 0;
        // bu ikisini loop'un dışında define'lamam gerekti
        System.out.println("Enter five numbers:");
        for (int i = 0; i < 5; i++) {
            int input = scan.nextInt();
            // 5 kere inout alsın diye for loopu
            if (i==0) {
                int length = String.valueOf(input).length();
                System.out.println("The length of the number 1 is " + length);
                // diyecek bir şey yok, görüyorsunuz efem. direk Java'nın içindeki bir func kullanıldı
            } else if (i==1) {
                int length = String.valueOf(input).length();
                for (int j=0; j<length; j++) {
                    int digit = input % 10;
                    sum += digit;
                    input /= 10;
                    // kısacası son digiti alıyor, bunu sum'a ekliyor sonra da input'tan bu son digiti çıkartıyor ki diğer loopta sonraki digiti alsın
                }
                System.out.println("Sum of the digits of the number 2 is " + sum);
            } else if (i == 2) {
                int digit = input % 10;
                if (digit % 2 == 1) { 
                oddSum += digit;
                // digit tekil ise (2ye bölündüğünde 1 veriyorsa) o digiti oddSum'a ekle
                }
                input /= 10;
                // son digiti çıkart
                System.out.println("Sum of the odd digits of number 3 is " + oddSum);
            } else if (i == 3) {
                int four = 0;
                int digit = input % 10;
                if (digit == 4) {
                    four ++;
                }
                input /= 10;
                System.out.println("There are/is " + four + "four in the digits of number 4");
                // kolaydı
            } else if (i == 4) {
                int length = String.valueOf(input).length();
                int halfLength = length/2;
                if (length % 2 == 0) {
                    System.out.println("The halflength of number 5 is " + halfLength);
                } else {
                    // bunu ben yapmadım ama ChatGpt çok iyi yazdı ki kalem oynatamdım
                    for (int j = 0; j < halfLength; j++) {
                        input /= 10;
                        // halfLength'e gelene kadarki son digitleri çıkartıyor
                    }
                    int middleDigit = input % 10;
                    // halfLength deki digit
                    System.out.println("Middle digit of number 5 is " + middleDigit);
                }
            }

        }

    }
}