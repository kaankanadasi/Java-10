public class sort {
    public static void main(String []args) {
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        // initilize the arrayList
        sequence.add(9);
        sequence.add(3);
        sequence.add(10);
        sequence.add(13);
        sequence.add(47);
        sequence.add(15);
        sequence.add(38);
        sequence.add(47);
        sequence.add(6);
        sequence.add(34);
        
        for (int i = 0; i < sequence.size(); i++) {
            int currentMin = i;
            // for() each of the unsorted elements
            for (int j = i; j < sequence.size(); j++) {
                if (sequence.get(j) < sequence.get(currentMin)) {
                    // set the element as new minimum
                    currentMin = j;
                }
                // swap minimum with first unsorted position
                int temp = sequence.get(i);
                sequence.set(i, sequence.get(currentMin));
                sequence.set(i, temp);
            }
        }
        
    }
}
