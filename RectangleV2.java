public class RectangleV2 {
    private double length;
    private double width;
    // instance variables 
    private static double angle;
    private static int sides;
    private static String name;
    // static variables

    // default RectangleV2
    RectangleV2() {
        this.length = 0.0;
        this.width = 0.0;
    }
    // RectangleV2 with parameters
    RectangleV2(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    /* accessors: In Java, accessor methods return the value of a private variable. This gives other classes 
    access to that value stored in that variable. without having direct access to the variable itself.
    Kaynak: https://www.codecademy.com/learn/learn-java/modules/java-access-encapsulation-and-static-methods/cheatsheet */  
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }
    public String toString() {
        return ("The length of the rectangle is " + length + ", while the width is " + width + ".");
    }

    /* mutators: In Java, mutator methods reset the value of a private variable. This gives other classes the 
    ability to modify the value stored in that variable without having direct access to the variable itself. 
    Kaynak: https://www.codecademy.com/learn/learn-java/modules/java-access-encapsulation-and-static-methods/cheatsheet */ 
    public void setLength(double length) {
        this.length = length;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    // double length ve double width yazmayı unuttum ama chatgpt hatırlattı

    // orther methods
    public double getArea() {
        return length * width;
    }
    public double getPerimeter() {
        return 2 * (length + width);
    } 

    public static void main(String[] args) {
        RectangleV2 rec = new RectangleV2(10.0, 20.5);
        RectangleV2 defaultRec = new RectangleV2();
        // ilk başta objenin ismine default demiştim ama "reserved name"imiş chatgpt her zamanki gibi iş başında
        boolean equal = rec.equals(defaultRec);
        System.out.println("The area of the rectange is " + rec.getArea());
        System.out.println("The perimeter of the rectange is " + rec.getPerimeter());
        // rec. demeyi unuttum chatGPT sağolsun düzeltti
        if (equal) {
            System.out.println("The default ractangle and the other rectangle are eqaul");
        } else {
            System.out.println("The default ractangle and the other rectangle are not eqaul");
        }
    }

}