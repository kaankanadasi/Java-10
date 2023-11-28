int[] scores; // Declaration for an array of ints, this does not create the array
int[] scores; = new int[6]; // Creates the array of length 6, initializes the values to 0 (int default)
int[] scores = {33, 4, 22, 40, 13, 66}; // Creates the array and initializes the values
scores.length;  // gives the length of the array
scores[0]; // gives the first element in the array         
scores[6]; // gives ArrayIndexOutOfBoundsException


int[] a = {10, 20, 30, 40, 50};
a[3] = 45; // Modifying the element at index 3 to 45
int[] referA = new int[arrayString.length];
referA = a; // this does not copy an array (it makes b and a refer to the same array).
int[] c = new int[a.length]; // to copy an array, create a new array , then copy all the values
for (int i = 0; i < a.length; i++) 
c[i] = a[i];
// the elements on referA would change as they refer to the same location on the computer memory
for (int i = 1; i < a.length; i++)  
           a[i] = i;

           
int[] highScores = { 10, 9, 8, 11 };
for (int i = 0; i < highScores.length; i++) 
    System.out.println(  highScores[i] );

int index = 0; 
while(index < highScores.length) { 
    System.out.println(  highScores[i] );
    index++; 
}


int[] highScores = { 10, 9, 8, 11 };
int index = 0;
System.out.print("Type a target integer: ”) ;
int target = Integer.parseInt(args[0]);
while (index < highScores.length) {
if (highScores[index] == target) // checks the memory location
System.out.println("The target was found at: " + index);
index ++;
}
System.out.println("The target was not found.”);


int[] values = { 6, 2, 1, 7, 12, 5 };
for (int i = 0; i < values.length; i++) {
values[i]++; // Increment each element by 1
System.out.println("New val: " + values[i]);
}
System.out.println("Array after the loop: ");
for (int v : values)
System.out.print(v + " ");

    
public static void main(String[] args) {
    String[] words = {"hello", "world", "Java", "programming", "example"};
    System.out.println("Length of each word:");
    for (String word : words) {
        int length = calculateLength(word);
        System.out.println("Length of '" + word + "': " + length);
    }
 }

 
 public static int calculateLength(String word) {
    int count = 0;
    for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) != ' ') { count++; }
    }
    return count;
 }

 
 public int findHorseSpace(String name) {
    for(int i = 0; i < spaces.length; i++) { 
        // we can't compare String with null values so we use spaces[i] != null
        // getName ensures we are comparing the name of the object not the object itself 
        if (spaces[i] != null && spaces[i].getName().equals(name)) { return i; } 
    }
    return -1;
}
