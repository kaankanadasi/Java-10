public class LineTown {
    public static void main(String []args) {
        int length = Integer.parseInt(args[0]);
        int[] arr = new int[length];
        int swaps = 0;
        
        // array inputu
        for(int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(args[i + 1]);
        }

        // swap 
        while(!isIncreasingOrder(arr)) {
            for(int k = 0; k < arr.length-1; k++) {
                if(arr[k] > arr[k+1]) {

                    swaps++;
                }
            }
        }

    }

    // istenilen düzenin olup olmadığını kontrol ediyor
    public boolean isIncreasingOrder(int[] arr) {
        for(int n = 0; n < arr.length-1; i++) {
            if (!(arr[n] < arr[n+1])) {
                return false;
            }
        }
        return true;
    }

    public int notConvertable(int[] arr) {
        // checks if the array can be converted to increasing order
        return -1;
    }

}
