import java.util.Random;
import java.util.Scanner;
public class AnimalCollectionGame {
    public static void main(String args[]) {
      Random random = new Random();
     
      String[] animal= {"Balık","Turtle"," Köpek","Ördek","Frog"};
      String[][] position= new String[4][4];
      position[0][0]= "1";
      position[0][1]= "2";
      position[0][2]= "3";
      position[0][3]= "4";
      position[1][0]= "5";
      position[1][2]= "7";
      position[1][3]= "8";
      position[1][1]= "6";
      position[2][0]= "9";
      position[2][1]= "10";
      position[2][2]= "11";
      position[2][3]= "12";
      position[3][0]= "13";
      position[3][1]= "14";
      position[3][2]= "15";
      position[3][3]= "16";

      Scanner scanner= new Scanner(System.in);
      int points = 0;
      for (int i = 0; i <= 10; i++) {
          int x = random.nextInt(5);
          String a = animal[x];
          System.out.println(a +" nerde(1-16YA KADAR");
          String cevap=scanner.nextLine();
          int y = random.nextInt(4);
          int z = random.nextInt(4);
          String b= position[y][z];
          if (cevap == b) {
              points+=1;
              System.out.println("Doğru, " + a + " buldun");
             
          }
          else{
              System.out.println("Yanlış " + a +" bulamadın");
          }
         

      }
      System.out.println(points);
   
     
    }
}