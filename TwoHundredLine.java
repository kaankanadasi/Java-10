import java.util.Random;
import java.util.Scanner;

public class TwoHundredLine {
    /* Class attributes are variables defined in the class. These 
    attributes define the state of the object at a particular time. */ 
    // primitive type
    private int length;
    private boolean done;
    // non-primitive type
    private String description;; 

    // Default constructor
    public TwoHundredLine() {
        length = 0;
        done = false;
        description = "Default";
    }

    // Constructor with three formal parameters (int, boolean, and String)
    public TwoHundredLine(int length, boolean done, String description) {
        this.length = length;
        this.done = done;
        this.description = description;
    }

    // Constructor that can be used to create a 200line object with "toDo" but no "lenght" or "done"
    public TwoHundredLine(String description) {
        this(0, false, description);
    }

    // birşey return ediyorsak o şeyin type'ını yazmamız lazım - storege da ne kadar yer kaplayacağını anlasın 
    public int getLength() {
        return length;
    }
    public boolean getDone() {
        return done;
    }
    public String getDescription() {
        return description;
    }

    public void setLenght(int length) {
        if (length >= 0) {
            this.length = length;
        } else {
            System.out.println("Invalid task length. Task length must be non-negative.");
            // if the lenghth is smaller than 0
        }
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // void method
    public void displayInfo() {
        System.out.println("There are " + length + " tasks to be done");
        System.out.println("To-do: " + description);
        System.out.println("Is it done? " + done);
    }

    public static void compareTasks(TwoHundredLine task1, TwoHundredLine task2) {
        if (task1.getLength() > task2.getLength()) {
            System.out.println(task1.getDescription() + " is longer than " + task2.getDescription());
        } else if (task1.getLength() < task2.getLength()) {
            System.out.println(task2.getDescription() + " is longer than " + task1.getDescription());
        } else {
            System.out.println(task1.getDescription() + " and " + task2.getDescription() + " have the same length.");
        }
    }

    public static TwoHundredLine createTaskWithUserInput() {
        Scanner scanner = new Scanner(System.in);
        
        // takes input for description
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        // takes input for length
        System.out.print("Enter task length (in hours): ");
        int length = scanner.nextInt();

        return new TwoHundredLine(length, false, description);
    }

    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);

        // create objects from TwoHundredLine class
        TwoHundredLine firstTask = new TwoHundredLine(10, false, "Sedat HW");
        TwoHundredLine secondTask = new TwoHundredLine(10, false, "Physics HW");
        TwoHundredLine thirdTask = new TwoHundredLine("nothing");

        System.out.println("Existing tasks:");
        firstTask.displayInfo();
        secondTask.displayInfo();
        thirdTask.displayInfo();

        //  Initialize the boolean variable to control the loop 
        boolean createNewTask = true;
        while (createNewTask) {
            TwoHundredLine newTask = createTaskWithUserInput(scanner);
            System.out.println("Newly added task:");
            newTask.displayInfo();

            // Prompt the user to decide if they want to create another task
            System.out.print("Do you want to create another task? (y/n): ");
            String response = scanner.next().toLowerCase();

            // Check the user's response; if not "y", exit the loop
            if (!response.equals("y")) {
                createNewTask = false;
            }
        }

        TwoHundredLine newTask = createTaskWithUserInput();
        System.out.println("Newly added task:");
        newTask.displayInfo();

        // take a random integer between 0 and 2
        int a = new Random().nextInt(3);

        if (a == 0) {
            System.out.println("Perform firstTask");
        } else if (a == 1) {
            System.out.println("Perform secondTask");
        } else {
            System.out.println("Perform thirdTask");
        }

        boolean equal1 = firstTask.equals(secondTask);
        boolean equal2 = firstTask.equals(thirdTask);
        boolean equal3 = thirdTask.equals(secondTask);

        firstTask.setLength(20);
        firstTask.setDone(true);
        firstTask.setDescription("Updated Sedat HW");
        firstTask.displayInfo();

        secondTask.setLength(20);
        secondTask.setDone(true);
        secondTask.setDescription("Updated Sedat HW");
        secondTask.displayInfo();

        if (equal1) {
            System.out.println("The first taks and the second task are the same");
        } else {
            System.out.println("The first task and the second task are not the same");
        }
        
        else if (equal2) {
            System.out.println("The default task and the first task are the same");
        } else {
            System.out.println("The default task and the first task are not the same");
        }

        else if (equal3) {
            System.out.println("The default task and the second task are the same");
        } else {
            System.out.println("The default task and the second task are not the same");
        }

        public static boolean areAllTasksDone(TwoHundredLine... tasks) {
            // "TwoHundredLine... tasks" allows to pass any number of TwoHundredLine objects as arguments
            for (int i = 0; i < tasks.length; i++) {
                // // Iterate through the provided tasks
                if (!tasks[i].getDone()) {
                    // If any task is not done, return false 
                    return false; 
                }
            }
            // all tasks are done
            return true; 
        }

        if (areAllTasksDone(firstTask, secondTask, thirdTask)) {
            System.out.println("Everything is done!");
        } else {
            System.out.println("Not everything is done yet.");
        }

        double hourToFinish = 2.5;
        int averageTimeFirstTask = (int)(firstTask.length * hourToFinish);
        int averageTimeSecondTask = (int)(secondTask.length * hourToFinish);
        int averageTimeThirdTask = (int)(thirdTask.length * hourToFinish);
        
        System.out.println("Average time for the first task: " + averageTimeFirstTask + " hours");
        System.out.println("Average time for the second task: " + averageTimeSecondTask + " hours");
        System.out.println("Average time for the third task: " + averageTimeThirdTask + " hours");

        compareTasks(firstTask, secondTask);
        compareTasks(thirdTask, secondTask);
        compareTasks(firstTask, thirdTask);
    }
}