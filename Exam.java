public class Exam {
    // attributes
    private double time; 
    private int numQuestion;
    private String name;

    // Default constructor
    Exam() {
        this.time = 50.5;
        this.numQuestion = 25;
        this.name = "Kaan";
    }

    // Non-default constructor
    Exam(double time, int numQuestion, String name) {
        this.time = time;
        this.numQuestion = numQuestion;
        this.name = name;
    }

    // Accessor methods
    public double getTime() {
        return time;
    }
    public int GetNumQuestion() {
        return numQuestion;
    }
    public int getName() {
        return name;
    }

    // Mutator methods
    public void setTime(double time) {
        this.time = time;
    }
    public void setGetNumQuestion(int numQuestion) {
        this.numQuestion = numQuestion;
    }
    public void setName(String name) {
        this.name = name;
    }

    // non-void method
    public double timePerQuestion() {
        return (numQuestion/time);
    }
 
    public static void main(String[] args) {
        Exam geliyor = new Exam();
        Exam gelmekte = new Exam(60.2, 30, "Kaan");
        Exam gelecek = gelmekte;
        Exam geldi = new Exam(60.2, 30, "Kaan");

        System.out.println(geliyor == gelmekte);  // false
        System.out.println(gelecek == gelmekte);  // true 
        System.out.println(geldi == gelmekte);    // false

        System.out.println(geliyor.equals(gelmekte));  // false 
        System.out.println(gelecek.equals(gelmekte));  // true 
        System.out.println(geldi.equals(gelmekte));    // true 
    }

}