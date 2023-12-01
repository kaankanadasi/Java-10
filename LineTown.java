public class LineTown {
    public static void main(String []args) {
        int length = Integer.parseInt(args[0]);
        int[] arr = new int[length];
        int iteration = 0;
        for(int i = 1; i <= length; i++) {
            int arrayInput = Integer.parseInt(args[i]);
            arr[iteration] += arrayInput;
            iteration++;
        }
        // find minimum integer in the array
        for(int j = 0; j < length; j++) {
            int min = Integer.MAX;
            if( arr[j] < min ) {
                min = arr[j];
            } 

        // swap that array with the

        }
    }
}
