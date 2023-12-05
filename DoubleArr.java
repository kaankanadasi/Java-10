import java.util.Scanner;
public class DoubleArr {
    public static void main(String[] args) {
        int start = 0;

        // Initialize to literal values
        int[][] base = { 
            { 2, 4, 5, 6, 1, 8, 9, 1, 4, 5 },
            { 3, 5, 7, 9, 10, 3, 2, 5, 6, 7 },
            { 6, 4, 4, 5, 10, 8, 5, 6, 7, 8 },
            { 4, 7, 7, 9, 3, 2, 7, 14, 9, 0 },
            { 4, 7, 7, 9, 3, 2, 7, 14, 9, 0 },
            { 6, 5, 4, 6, 4, 1, 3, 6, 8, 7 },
            { 8, 8, 3, 7, 8, 4, 4, 4, 6, 3 },
            { 10, 8, 16, 7, 3, 7, 8, 25, 9, 2 },
            { 4, 8, 3, 8, 2, 4, 6, 7, 10, 4 }, 
            { 4, 3, 6, 8, 1, 4, 3, 7, 3, 4 }
        };

        // take input
        Scanner scan = new Scanner(System.in);
        int firstX = scan.nextInt();
        int firstY = scan.nextInt(); 
        int secondX = scan.nextInt();
        int secondY = scan.nextInt(); 

        // adding the values in 2-D array, checking the validity of values
        if (valid(firstX, secondX, firstY, secondY, base)) {
            for(int i = firstY; i <= secondY; i++) {
                for(int j = firstX; j <= secondX; j++) {
                    start += base[i][j];
                }
            }
        } else {
            System.out.print("Give appropriate values: ");
            firstX = scan.nextInt();
            firstY = scan.nextInt(); 
            secondX = scan.nextInt();
            secondY = scan.nextInt(); 
            while( !valid(firstX, secondX, firstY, secondY, base) ) {
                System.out.print("Give appropriate values: ");
                firstX = scan.nextInt();
                firstY = scan.nextInt(); 
                secondX = scan.nextInt();
                secondY = scan.nextInt(); 
            }
        }
        System.out.println(start);

    }

    // YSC önerdi
    public static boolean valid(int firstX, int secondX, int firstY, int secondY, int[][] base) { 
        // base accessible olması için parametre olarak gir
        return firstX >= secondX && firstY >= secondY &&
            firstX >= 0 && firstX < base[0].length &&
            firstY >= 0 && firstY < base.length &&
            secondX >= 0 && secondX < base[0].length &&
            secondY >= 0 && secondY < base.length;
    }
}