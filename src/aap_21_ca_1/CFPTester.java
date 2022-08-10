package aap_21_ca_1;
/*
@author Jéssica Lopes
x21147477
AAP CA1
 */


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CFPTester {
    public static void main(String[] args) throws Exception {

        //Scanner import
        Scanner sc = new Scanner(System.in);

        int menuInput = 0;//variable to user control

        //Start the program
        System.out.println("+--------STARTING CARBON FOOTPRINT PROGRAM-----------+");

        //call the importing method
        ArrayList<CFP> cfp = read();
        System.out.println("Students Carbon Footprint data were imported successfully");
        int size = cfp.size();
        System.out.println("List of " + size + " students imported\n");


        while (menuInput != 5) {
            /**MENU**/

            System.out.println("                        MENU");
            System.out.println("+--------Welcome to the Carbon Footprint App--------+");
            System.out.println("1 - Sort the array by Student's name (MergeSort)");
            System.out.println("2 - Check the merge sort algorithm elapsed time");
            System.out.println("3 - Find a student by they Student ID (binary search)");
            System.out.println("4 - Add a new student (Exception handling and defensive program)");
            System.out.println("5 - EXIT");


            System.out.println("Enter your choice: ");
            menuInput = sc.nextInt();
            int menuInput2 = 0;

            switch (menuInput) {

                case 1: //MERGE SORT
                    System.out.println("MENU 1");

                    Functions.mergeSort(cfp, 0, size - 1);
                    System.out.println("MERGE SORT PROCESS FINISHED SUCCESSFULLY"); //check Merge sort

                    System.out.println("Do you want to to print the Student CFP Array? (1 yes 2 no)");
                    menuInput2 = sc.nextInt();
                    if (menuInput2 == 2) {
                        break;
                    }

                    System.out.println("How many student do you want to prints"); //check Merge sort
                    int mergeSortPrint;

                    mergeSortPrint = sc.nextInt();
                    Functions.printArray(cfp, mergeSortPrint);

                    System.out.println("Do you want to go back to menu? (Type 1 to go back to the Main Menu)");
                    menuInput2 = sc.nextInt();
                    if (menuInput2 == 1) {
                        break;
                    }


                case 2://ELAPSED TIME

                    while (menuInput2 != 1) {

                        //declare the elapsed variables
                        float elapsed10, elapsed100, elapsed1000, elapsed10000;
                        float totalElapsed10 = 0;
                        float totalElapsed100 = 0, totalElapsed1000 = 0, totalElapsed10000 = 0;
                        float average10, average100, average1000, average10000;

                        int times; //to calculate the average elapsed time
                        System.out.println("How many times to you want to run the merge sort");
                        times = sc.nextInt();

                        for (int i = 1; i <= times; i++) {
                            System.out.println("Running merge sort " + i);

                            Functions.bubbleSort(cfp);//to unsort and sort again
                            elapsed10 = Functions.elapsedTime(cfp, 10); // call the elapsed time method
                            Functions.bubbleSort(cfp);//to unsort and sort again
                            elapsed100 = Functions.elapsedTime(cfp, 100);// call the elapsed time method
                            Functions.bubbleSort(cfp);//to unsort and sort again
                            elapsed1000 = Functions.elapsedTime(cfp, 1000);// call the elapsed time method
                            Functions.bubbleSort(cfp);//to unsort and sort again
                            elapsed10000 = Functions.elapsedTime(cfp, 10000);// call the elapsed time method
                            System.out.println("10 -> " + elapsed10);
                            System.out.println("100 -> " + elapsed100);
                            System.out.println("1000 -> " + elapsed1000);
                            System.out.println("10000 -> " + elapsed10000);

                            totalElapsed10 += elapsed10;
                            totalElapsed100 += elapsed100;
                            totalElapsed1000 += elapsed1000;
                            totalElapsed10000 += elapsed10000;
                        }

                        //calculate the average
                        average10 = totalElapsed10 / times;
                        average100 = totalElapsed100 / times;
                        average1000 = totalElapsed1000 / times;
                        average10000 = totalElapsed10000 / times;


                        //plotting the average in a table
                        String leftAlignFormat = "| %-20s | %-20f | %-20f | %-20f | %-20f |%n";//formatting line

                        System.out.format("+----------------------+-------------------------------------------------------------------------------------------+%n");
                        System.out.format("| Input size           | 10                   | 100                  | 1000                 |10.000                |%n");
                        System.out.format("+----------------------+-------------------------------------------------------------------------------------------+%n");
                        System.out.format(leftAlignFormat, "Merge Sort (avg)", average10, average100, average1000, average10000);
                        System.out.format("+----------------------+-------------------------------------------------------------------------------------------+%n");

                        //menu option
                        System.out.println("Do you want to go back to menu? (Type 1 to go back to the Main Menu and 2 to try Elapsed time again )");
                        menuInput2 = sc.nextInt();

                    }
                    break;

                case 3:// BINARY SEARCH

                    while (menuInput2 != 1) {

                        System.out.println("From 1 to 1000, insert an Student ID that you want to search");
                        int searchCode = sc.nextInt();

                        Functions.searchStudent(cfp, searchCode);

                        System.out.println("Do you want to go back to menu? ( 1 - Go back to the main menu | 2 - Search another Student)");
                        menuInput2 = sc.nextInt();

                    }

                    break;


                case 4: //DEFENSIVE PROGRAMING AND EXCEPTION HANDLING

                    menuInput = 0;
                    while (menuInput2 != 1) {
                        Functions.addStudent(cfp, cfp.size());
                        System.out.println("Do you want to go back to menu? 1 - Go back to the main menu | 2 - Add a new Student ");
                        menuInput2 = sc.nextInt();
                    }

                    break;

                case 5:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Program is no longer running");

            }

        }
    }


    //import csv method
    public static ArrayList<CFP> read() throws Exception {

        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        //Don't forget to change the file to the location on your computer below.
        Scanner sc = new Scanner(new File("./CA/CFP_Data.csv"));
//        CFP[] cfp = new CFP[10000];

        //Create an ArrayList to import the CSV data
        ArrayList<CFP> cfp = new ArrayList<>();

        String header = sc.nextLine();

        // this will just print the header in CSV file
        String st = "";
        while (sc.hasNextLine()) //returns a boolean value
        {

            st = sc.nextLine();
            st = st.replace("\"", "");
            String[] data = st.split(",");
//            System.out.println(st);
            if (data[3] == "") {
                data[3] = "0";
            }

            //adding the new line into the linked list
            cfp.add(new CFP(Integer.parseInt(data[0]), data[1], data[2].toUpperCase(), Integer.parseInt(data[3]), Float.parseFloat(data[4])));
        }
        sc.close();  //closes the scanner

        //returning the ArrayList
        return cfp;
    }
}

