package aap_21_ca_1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReadCFPDataSample {

//    public static void main(String[] args) throws Exception {
//        //parsing and reading the CSV file data into the CFP (object) array
//        // provide the path here...
//        String dir = System.getProperty("user.dir");
//        System.out.println(dir);
//        //Don't forget to change the file to the location on your computer below.
//        Scanner sc = new Scanner(new File("./CA/CFP_Data.csv"));
////        CFP[] cfp = new CFP[10000];
//        ArrayList<CFP> cfp = new ArrayList<>();
//
//        String header = sc.nextLine();
//
//        // this will just print the header in CSV file
////        System.out.println(header);
//
//        String st = "";
//        while (sc.hasNextLine()) //returns a boolean value
//        {
//
//            st = sc.nextLine();
//            st = st.replace("\"", "");
//            String[] data = st.split(",");
////            System.out.println(st);
//            if (data[3] == "") {
//                data[3] = "0";
//            }
//            cfp.add(new CFP(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), Float.parseFloat(data[4])));
//        }
//        sc.close();  //closes the scanner
//
////        // We can print CFP details due to overridden toString method in CFP class
////        System.out.println("==================");
////        System.out.println(cfp[0]);
////        System.out.println(cfp[9999]);
////        System.out.println("==================");
////        // we can compare CFPs based on their name due to overridden CompareTo method in CFP class
////        System.out.println(cfp[0] == cfp[1]);
//
//
//        /**CA PART 1**/
//
//        //Declaring n of the end of the array
//        int n = cfp.size() - 1;
//
//        Functions.mergeSort(cfp, 0, n);
//        Functions.printArray(cfp, 1000);
//
//        /** Merge Sort 10**/
//        long MS10Start;
//        long MS10End;
//
//        MS10Start = System.nanoTime();
//        Functions.mergeSort(cfp, 0, 10);
//        MS10End = System.nanoTime();
//
//        long mergeSort10NanoTime = MS10End - MS10Start;
//
//        /** Merge Sort 100**/
//
//        long MS100Start;
//        long MS100End;
//
//        MS100Start = System.nanoTime();
//        Functions.mergeSort(cfp, 0, 100);
//        MS100End = System.nanoTime();
//        long mergeSort100NanoTime = MS100End - MS100Start;
//
//
//        /**Merge Sort 1,000**/
//
//        long MS1000Start;
//        long MS1000End;
//
//        MS1000Start = System.nanoTime();
//        Functions.mergeSort(cfp, 0, 1000);
//        MS1000End = System.nanoTime();
//
//        long mergeSort1000NanoTime = MS1000End - MS1000Start;
//
//        /**Merge Sort 10,000**/
//
//        long MS10000Start;
//        long MS10000End;
//
//        MS10000Start = System.nanoTime();
//        Functions.mergeSort(cfp, 0, n);
//        MS10000End = System.nanoTime();
//
//        long mergeSort10000NanoTime = MS10000End - MS10000Start;
//
//        /**Print the elapsed times**/
//
//        System.out.println("It took " + mergeSort10NanoTime + " nano seconds to MergeSort 10 inputs");
//        System.out.println("It took " + mergeSort100NanoTime + " nano seconds to MergeSort 100 inputs");
//        System.out.println("It took " + mergeSort1000NanoTime + " nano seconds to MergeSort 1000 inputs");
//        System.out.println("It took " + mergeSort10000NanoTime + " nano seconds to MergeSort 10.000 inputs");
//
//        /**3 - Binary Search**/
//
//        Scanner input = new Scanner(System.in);
//        System.out.println("From 1 to 1000, insert an Student ID that you want to search");
//        int searchCode = input.nextInt();
//
//        Functions.searchStudent(cfp,searchCode);
//
////
//        /**Part 2.1 - Exception Handling**/
//        /**Part 2.2 - km validator**/
////        ArrayList<CFP> listOfStudents = new ArrayList<>(Arrays.asList(cfp));
//
//        int inputStudent;
//        System.out.println("Do you want do add a new student?(1 = yes or 2 = No)");
//        inputStudent = input.nextInt();
//
//        int initialSize = cfp.size();
//        if (inputStudent == 1) {
//            Functions.addStudent(cfp, cfp.size());
//            if (cfp.size() > initialSize) {
//                System.out.println(cfp.get(initialSize));
//            }
//        }
//    }//main


}//class
