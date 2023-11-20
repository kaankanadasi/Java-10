/**
 * bir zar 20 kere atılcak (5 set). her 20likten en yüksek zar değeri bir listeye eklenecek 
 * ve sonunda her 20lik setten en yüksek zar değeri print edilcek
 * @author Kaan Kanadasi
 * @since 20 Nov 2023
 */

import java.util.ArrayList;

public class Dice { 
    public static void main(String[] args) {

for (int i = 0; i < 5; i++) { // looping 5 sets
    ArrayList<Integer> dice = new ArrayList<>(); // creates an empty Integer array list called dice
    int max = 0; // ensures that max is 0 at the start of these 5 sets

    for (int j = 0; j < 20; j++) { // looping 20 times - you can't say dice.size() instead of 20 since the array is initially empty
        int num = (int)(Math.random() * 6) + 1; // stores a random num between 1-6
        dice.add(num); // adds this num to the array  
    }

    for (int n = 0; n < dice.size(); n++) { // loops throuhgt the array length
        if(dice.get(n)>max) { // iterates over the array
            max = dice.get(n); // if an elements is bigger than max assigns max to that elements
        }
    }
    System.out.println(max); 

        }
    }
}