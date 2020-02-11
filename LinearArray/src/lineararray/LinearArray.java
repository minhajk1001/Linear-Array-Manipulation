package lineararray;

public class LinearArray {

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 60};

        System.out.println("\n///// TEST 01: Copy Array example /////");
        int[] b = copyArray(a, a.length);
        printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 

        System.out.println("\n///// TEST 02: Print Reverse example /////");
        printArray(a); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
        printReverse(a); // This Should Print: { 60, 50, 40, 30, 20, 10 } 

        System.out.println("\n///// TEST 03: Reverse Array example /////");
        reverseArray(b);
        printArray(b); // This Should Print: { 60, 50, 40, 30, 20, 10 } 

        System.out.println("\n///// TEST 04: Shift Left k cell example /////");
        b = copyArray(a, a.length);
        b = shiftLeft(b, 3);
        printArray(b); // This Should Print: { 40, 50, 60, 0, 0, 0 } 

        System.out.println("\n///// TEST 05: Rotate Left k cell example /////");
        b = copyArray(a, a.length);
        printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
        b = rotateLeft(b, 3);
        printArray(b); // This Should Print: { 40, 50, 60, 10, 20, 30 } 

        System.out.println("\n///// TEST 06: Shift Right k cell example /////");
        b = copyArray(a, a.length);
        printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
        b = shiftRight(b, 3);
        printArray(b);  // This Should Print: { 0, 0, 0, 10, 20, 30 } 

        System.out.println("\n///// TEST 07: Rotate Right k cell example /////");
        b = copyArray(a, a.length);
        printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 } 
        b = rotateRight(b, 3);
        printArray(b); // This Should Print: { 40, 50, 60, 10, 20, 30 } 

        System.out.println("\n///// TEST 08: Insert example 1 /////");
        b = copyArray(a, a.length);
        printArray(b);  // This Should Print: { 10, 20, 30, 40, 50, 60 } 
        boolean bol = insert(b, 6, 70, 2); // This Should Print: No space Left 
        System.out.println(bol); // This Should Print: false
        printArray(b);  // This Should Print: { 10, 20, 30, 40, 50, 60 } 

        System.out.println("\n///// TEST 09: Insert example 2 /////");
        int[] c = {10, 20, 30, 40, 50, 0, 0};
        printArray(c);  // This Should Print: { 10, 20, 30, 40, 50, 0, 0 }
        bol = insert(c, 5, 70, 2);  // This Should Print: Number of elements after insertion: 6
        System.out.println(bol); // This Should Print: true
        printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 0 } 

        System.out.println("\n///// TEST 10: Insert example 3 /////");
        printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 0 } 
        bol = insert(c, 6, 70, 6); // This Should Print: Number of elements after insertion: 7 
        System.out.println(bol); // This Should Print: true
        printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 

        System.out.println("\n///// TEST 11: Remove example 1 /////");
        printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 
        bol = removeAll(c, 7, 90);
        System.out.println(bol); // This Should Print: false
        printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 

        System.out.println("\n///// TEST 12: Remove example 2 /////");
        printArray(c);  // This Should Print: { 10, 20, 70, 30, 40, 50, 70 } 
        bol = removeAll(c, 7, 70);
        System.out.println(bol); // This Should Print: true
        printArray(c);  // This Should Print: { 10, 20, 30, 40, 50, 0, 0 } 
//
    }

    // Prints the contents of the source array
    public static void printArray(int[] source) {
        for (int i : source) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Prints the contents of the source array in reverse order
    public static void printReverse(int[] source) {
        for (int i = source.length - 1; i >= 0; i--) {
            System.out.print(source[i] + " ");
        }
        System.out.println();
    }

    // creates a copy of the source array and returns the reference of the newly created copy array
    public static int[] copyArray(int[] source, int len) {
        int tempArr[] = new int[len];
        for (int i = 0; i < len; i++) {
            tempArr[i] = source[i];
        }
        return tempArr;
    }

    // creates a reversed copy of the source array and returns the reference of the newly created reversed array
    public static void reverseArray(int[] source) {
        int reversed[] = copyArray(source, source.length);
        for (int i = source.length - 1, j = 0; i >= 0; i--, j++) {
            source[j] = reversed[i];
        }
    }

    // Shifts all the elements of the source array to the left by 'k' positions
    // Returns the updated array
    public static int[] shiftLeft(int[] source, int k) {
        int tempArr[] = new int[source.length];
        for (int i = k, j = 0; i < source.length; i++, j++) {
            tempArr[j] = source[i];
        }
        return tempArr;
    }

    // Rotates all the elements of the source array to the left by 'k' positions
    // Returns the updated array
    public static int[] rotateLeft(int[] source, int k) {
        int tempArr[] = new int[source.length];
        for (int i = k, j = 0; j < source.length; i++, j++) {
            tempArr[j] = source[i % source.length];
        }
        return tempArr;
    }

    // Shifts all the elements of the source array to the right by 'k' positions
    // Returns the updated array
    public static int[] shiftRight(int[] source, int k) {
        int tempArr[] = new int[source.length];
        for (int i = k, j = 0; i < source.length; i++, j++) {
            tempArr[i] = source[j];
        }
        return tempArr;
    }

    // Rotates all the elements of the source array to the right by 'k' positions
    // Returns the updated array
    public static int[] rotateRight(int[] source, int k) {
        int tempArr[] = new int[source.length];
        for (int i = 0, j = k; i < source.length; i++, j++) {
            tempArr[i] = source[j % source.length];
        }
        return tempArr;
    }

    /**
     * @return true if insertion is successful; @return false otherwise
     * @param arr the reference to the linear array
     * @param size the number of elements that exists in the array.
     * size<=arr.length @para m elem the element that is to be inserted @param
     * index the index in which the element is required to
     * be inserted if insertion is not successful due to lack space, print "No
     * space Left" if given index is invalid, print "Invalid Index" if insertion
     * is successful, print the 'Number of elements after insertion' is
     * completed
     */
    public static boolean insert(int[] arr, int size, int elem, int index) {
        if (index >= 0 && index < arr.length) {
            if (size < arr.length) {
                int tempArr[] = copyArray(arr, arr.length);
                for (int i = 0; i < index; i++) {
                    arr[i] = tempArr[i];
                }
                arr[index] = elem;
                for (int i = index + 1; i < arr.length; i++) {
                    arr[i] = tempArr[i - 1];
                }
                size++;
                System.out.println("Number of elements after insertion: " + size);
                return true;
            } else {
                System.out.println("No space left");
            }
        } else {
            System.out.println("Invalid Index");
        }

        return false;
    }

    /**
     * removes all the occurences of the given element
     *
     * @param arr the reference to the linear array
     * @param size the number of elements that exists in the array.
     * size<=arr.length @param elem the element to be removed @return true if
     * removal is successful; return fal se otherwise if removal is successful,
     * print the 'Number of elements after removal' is completed
     */
    public static boolean removeAll(int[] arr, int size, int elem) {
        boolean exits = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                arr[i] = 0;
                exits = true;
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                arr[i] = arr[i + 1];
                arr[i + 1] = 0;
            }
        }
        return exits;
    }

}
