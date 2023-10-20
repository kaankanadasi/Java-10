public class Midnight{
    public static void main(String []args) {
        String a = "am";
        for(int b =1; b <= 2; b++) {
        
            System.out.println("12 midnight");
        for(int i =1; i <= 12; i++) {
            System.out.println(i + a);
            if(i==12) {
                System.out.println("12 noon");
                i = 1;
                a = "pm";
            }
        }
    }

    }
}