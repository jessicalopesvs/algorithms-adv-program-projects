/*
@author Jéssica Lopes
x21147477
AAP CA1
 */

package aap_21_ca_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Functions {

    /**PART 01**/
    /**
     * 1.01 - MERGE SORT
     **/

    static void merge(ArrayList<CFP> a, int beg, int mid, int end) {

        int left, right, initial;//indexes
        int n1 = mid - beg + 1;
        int n2 = end - mid;

        //creating temporary arrays
        CFP[] LeftArray = new CFP[n1];
        CFP[] RightArray = new CFP[n2];


        // temporary arrays - coping the data
        for (left = 0; left < n1; left++) {
            LeftArray[left] = a.get(beg + left);
        }
        for (right = 0; right < n2; right++) {
            RightArray[right] = a.get(mid + 1 + right);
        }

        left = 0; //first index of first sub-array
        right = 0; // first index of second sub-array
        initial = beg; // first index of merged sub-array

        while (left < n1 && right < n2) {
            if (LeftArray[left].compareTo(RightArray[right]) < 0) {
                a.set(initial, LeftArray[left]);
                left++;
            } else {
                a.set(initial, RightArray[right]);
                right++;
            }
            initial++;
        }
        while (left < n1) {
            a.set(initial, LeftArray[left]);
            left++;
            initial++;
        }

        while (right < n2) {
            a.set(initial, RightArray[right]);
            right++;
            initial++;
        }
    }

    static void mergeSort(ArrayList<CFP> a, int beginning, int end) {

        if (beginning < end) {
            //find a middle point
            int middle = (beginning + end) / 2;

            //
            mergeSort(a, beginning, middle);
            mergeSort(a, middle + 1, end);
            merge(a, beginning, middle, end);

        }

    }//merge sort end

    /**
     * 1.02ELAPSED TIME
     **/

    //We can input how many we want to do the merge sort
    static long elapsedTime(ArrayList<CFP> array, int quantity) {
        quantity = quantity - 1; //to avoid index out of bounds
        long start;
        long end;

        start = System.nanoTime();
        Functions.mergeSort(array, 0, quantity);
        end = System.nanoTime();

        long mergeSortNanoTime = end - start;
        return mergeSortNanoTime;//return result
    }

    /* Function to print the array */

    static void printArray(ArrayList<CFP> a, int n) {
        String leftAlignFormat1 = "| %-13d | %-15s | %-15s | %-15d | %-15f |%n";//formatting the table cells

        //table header
        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("| StudentCode   | StudentName     | ModeOfTransport | Distance (km)   | Emission        |");
        System.out.println("+---------------------------------------------------------------------------------------+");

        //printing table information loop
        // m = initial index n = array max index to print
        for (int m = 0; m < n; m++) {
            System.out.format(leftAlignFormat1,
                    a.get(m).getStudentCode(), a.get(m).getStudentName(), a.get(m).getModeOfTransport(),
                    a.get(m).getDistance(), a.get(m).getEmission());
            System.out.println("+---------------------------------------------------------------------------------------+");
        }
    }//print array end

    /**
     * 1.03 BINARY SEARCH
     **/

    //Starting with a bubble sort to sort by Student Code (1 to 9999)
    //the binary search demands that the array are sorted to do compare the numbers and sort it
    static void bubbleSort(ArrayList<CFP> array) {
        int n = array.size();


        while (n > 0) {
            int lastModifiedIndex = 0;

            for (int currentIndex = 1; currentIndex < n; currentIndex++) {
                if (array.get(currentIndex - 1).getStudentCode() > array.get(currentIndex).getStudentCode()) {

                    //store the value that needs to be swapped
                    CFP temp = array.get(currentIndex - 1);
                    //swap
                    array.set(currentIndex - 1, array.get(currentIndex));
                    array.set(currentIndex, temp);
                    //save modified index

                    lastModifiedIndex = currentIndex;
//                    System.out.println(java.util.Arrays.toString(array));
                }
            }
            //save last modified index, so we know nor ro iterate past it since
//           all the proceeding values are sorted
            n = lastModifiedIndex;


        }
    }

    //binary search

    public static int binarySearch(ArrayList<CFP> array, int start, int end, int searchElement) {

        bubbleSort(array); //sort numerically student code

        //start sorting
        while (start <= end) {
            int middle = (start + end) / 2;
//            System.out.println("start " + start + " end " + end + " middle " + middle);
            if (searchElement == array.get(middle).getStudentCode()) {
                return middle;
            }
            if (searchElement < array.get(middle).getStudentCode()) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }


    //Search and print student

    public static void searchStudent(ArrayList<CFP> array, int studentCode) {

        int arrayLength;

        arrayLength = array.size() - 1;

        int searchIndex = binarySearch(array, 0, arrayLength, studentCode);//calling the binary search function

        if (searchIndex != -1) {//if binary search do not return -1, it means that the student was not found

            //formatting the elapsed timetable
            String leftAlignFormat1 = "| %-13d | %-15s | %-15s | %-15d | %-15f |%n";//format cells

            //table heading
            System.out.println("+---------------------------------------------------------------------------------------+");
            System.out.println("| StudentCode   | StudentName     | ModeOfTransport | Distance (km)   | Emission        |");
            System.out.println("+---------------------------------------------------------------------------------------+");
            //printing information
            System.out.format(leftAlignFormat1,
                    array.get(searchIndex).getStudentCode(), array.get(searchIndex).getStudentName(), array.get(searchIndex).getModeOfTransport(),
                    array.get(searchIndex).getDistance(), array.get(searchIndex).getEmission());
            System.out.println("+---------------------------------------------------------------------------------------+");

        } else {//Not found message
            System.out.println("STUDENT NOT FOUND");
        }


    }

    /**
     * EXTRA FUNCTION to start the part 2
     **/ //to use on the exception handling
    public static void addStudent(ArrayList<CFP> listOfStudents, int n) {
        int StudentCode;
        String StudentName;
        String ModeOfTransport;
        int distance;
        float Emission;

        CFP newCfp = new CFP();

        Scanner input = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Add a new to the student code");
        StudentCode = n + 1;//generate new student id
        System.out.println(StudentCode);
        newCfp.setStudentCode(StudentCode);

        System.out.println("Student's Name");
        StudentName = input.next();
        newCfp.setStudentName(StudentName);

        /**MODE OF TRANSPORTATION VALIDATION**/

        boolean transportValid = false;
        while (!transportValid) {
            //run the mode of transport exception
            //while loop for user input (if is invalid ask to input again)
            try {
                System.out.println("Insert mode of transportations");

                ModeOfTransport = input.next().toUpperCase();
                newCfp.setModeOfTransport(ModeOfTransport);
                transportValid = true;
            } catch (UnsupportedModeOfTransportException e) {
                System.out.println(e);
            }
        }

        /**DISTANCE VALIDATION**/

        boolean distanceValid = false;

        //run the Distance validation
        //while loop for user input (if is invalid ask to input again)
        while (!distanceValid) {
            try {
                System.out.println("Distance");
                distance = input.nextInt();
                distanceValidator(distance);
                newCfp.setDistance(distance);
                distanceValid = true;
            } catch (OutOfBoundsDistanceException e) {
                System.out.println(e);
            }
        }

        System.out.println("Emission");
        Emission = input.nextFloat();
        newCfp.setEmission(Emission);

        //create a new student
        listOfStudents.add(newCfp);//adding to array list
        int size = listOfStudents.size();

        System.out.println("Student data saved successfully!");
        searchStudent(listOfStudents, size);//search and print last student
    }

    public static void distanceValidator(int distance) throws OutOfBoundsDistanceException {
        if (distance < 1 || distance > 500) {
            throw new OutOfBoundsDistanceException("Invalid distance, must be between 1 and 500");
        }
    }
}
