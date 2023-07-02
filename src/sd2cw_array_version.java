import java.io.*;
import java.util.Scanner;

public class sd2cw_array_version {
    private static String[] Cashier_01 = {"X", "X"};
    private static String[] Cashier_02 = {"X", "X", "X"};
    private static String[] Cashier_03 = {"X", "X", "X", "X", "X"};
    private static String[] Cashier_01_customer_names = new String[2];
    private static String[] Cashier_02_customer_names = new String[3];
    private static String[] Cashier_03_customer_names = new String[5];
    private static String[] all_cashier_customer_names;
    private static  final int max_burger_stock = 50;
    private static final int low_stock_msg = 10;
    private static int stock_count = max_burger_stock;
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] ags) {
        System.out.println();
        System.out.println("Welcome to \" Foodies Fave Food center \"");
        System.out.println();
        menu_display();
    }
    //making the menu and the switch to represent the inputs for each option
    private static void menu_display() {
        String choice;
        do {
            System.out.println("*****************");
            System.out.println("*  Food Center  *");
            System.out.println("*****************");
            System.out.println("100 or VFQ: View all Queues.");
            System.out.println("101 or VEQ: View all Empty Queues.");
            System.out.println("102 or ACQ: Add customer to a Queue.");
            System.out.println("103 or RCQ: Remove a customer from a Queue. (From a specific location)");
            System.out.println("104 or PCQ: Remove a served customer.");
            System.out.println("105 or VCS: View Customers Sorted in alphabetical order.");
            System.out.println("106 or SPD: Store Program Data into file.");
            System.out.println("107 or LPD: Load Program Data from file.");
            System.out.println("108 or STK: View Remaining burgers Stock.");
            System.out.println("109 or AFS: Add burgers to Stock.");
            System.out.println("999 or EXT: Exit the Program.");
            System.out.print("Enter your choice: ");
            choice = scanner.next();
            scanner.nextLine();

            switch (choice) {
                case "100", "VFQ":
                    view_all_queues();
                    break;
                case "101", "VEQ":
                    view_all_empty_queues();
                    break;
                case "102", "ACQ":
                    add_customer_queue();
                    break;
                case "103", "RCQ":
                    remove_customers_queue();
                    break;
                case "104", "PCQ":
                    remove_served_customer();
                    break;
                case "105", "VCS":
                    all_cashier_customer_names = new  String[10];
                    view_sorted_customer();
                    break;
                case "106", "SPD":
                    store_program_data();
                    break;
                case "107", "LPD":
                    load_program_data();
                    break;
                case "108", "STK":
                    view_remaining_stock();
                    break;
                case "109", "AFS":
                    add_burgers_to_stock();
                    break;
                case "999", "EXT":
                    System.out.println("Exiting the program.....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice... Please try again...");
                    break;
            }
        } while (choice != "999" && choice != "EXT");// making a default if the user have havent enter the exit commant then loop the menue
    }

    //making the below sub method to display the cashier in vertical
    private static void view_all_queues() {
        System.out.println("*****************");
        System.out.println("*   Cashiers    *");
        System.out.println("*****************");

        for (int j = 0; j < 6; j++) {
            for (String[] arr : new String[][]{Cashier_01, Cashier_02, Cashier_03}) {
                if (j < arr.length) {
                    System.out.print(arr[j] + "       ");
                } else {
                    System.out.print("        ");
                }
            }
            System.out.println();
        }
    }


    //making the below sub method to display cashier with the empty queues
    private static void view_all_empty_queues() {
        System.out.println();
        System.out.println("Empty Slots = \"X\"");
        System.out.println("Reserved Slots = \"O\"");
        System.out.println("*****************");
        System.out.println("* Empty Cashiers *");
        System.out.println("*****************");


        for (int j = 0; j < 6; j++) {
            for (String[] arr : new String[][]{Cashier_01, Cashier_02, Cashier_03}) {
                if (j < arr.length) {
                    System.out.print(arr[j] + "       ");
                } else {
                    System.out.print("        ");
                }
            }
            System.out.println();
        }
        System.out.println("Empty Slots = \"X\"");
        System.out.println("Reserved Slots = \"O\"");
    }

    //making the option to add customers to the queue
    private static void add_customer_queue() {
        System.out.print("Enter the Customer Name: ");
        String customer_name = scanner.nextLine();

        System.out.print("Enter the cashier number that the customer to be added (1-3): ");
        int customer_cashier = scanner.nextInt();

        System.out.println();
        int position = 1;

        switch (customer_cashier) {
            case 1:
                for (int i = 0; i < Cashier_01.length; i++) {
                    if (Cashier_01[i].equals("X")) { // checking whether the cashier01 positions is equal to X
                        Cashier_01[i] = "O";
                        Cashier_01_customer_names[i] = customer_name; // assigning the inputed customer name to the cashier01 name array
                        System.out.println(customer_name + " added to the row " + (position + i) + " in Cashier 01...");
                        System.out.println();
                        return;
                    }
                }
                System.out.println("Cashier 01 is already full...");
                System.out.println();
            case 2:
                for (int i = 0; i < Cashier_02.length; i++) {
                    if (Cashier_02[i].equals("X")) { // checking whether the cashier02 positions is equal to X
                        Cashier_02[i] = "O";
                        Cashier_02_customer_names[i] = customer_name; // assigning the inputed customer name to the cashier02 name array
                        System.out.println(customer_name + " added to the row " + (position + i) + "  in Cashier 02...");
                        System.out.println();
                        return;
                    }
                }
                System.out.println("Cashier 01 is already full...");
                System.out.println();
            case 3:
                for (int i = 0; i < Cashier_03.length; i++) {
                    if (Cashier_03[i].equals("X")) { // checking whether the cashier03 positions is equal to X
                        Cashier_03[i] = "O";
                        Cashier_03_customer_names[i] = customer_name; // assigning the inputed customer name to the cashier03 name array
                        System.out.println(customer_name + " added to the row " + (position + i) + "  in Cashier 03...");
                        System.out.println();
                        return;
                    }
                }
                System.out.println("Cashier 03 is already full...");
        }
    }

    //making the option to remove customers to the queue
    private static void remove_customers_queue() {
        System.out.print("Enter the cashier number that the customer who needs to remove(1-3): ");
        int customer_cashier = scanner.nextInt();

        System.out.print("Enter the row position where the customer is in: ");
        int position = scanner.nextInt();
        position = position - 1;
        System.out.println();

        if (customer_cashier == 1) {
            if (Cashier_01[position].equals("O")) { // check whether the cashier is equal to O
                for (int i = position; i < Cashier_01.length - 1; i++) {
                    Cashier_01[i] = Cashier_01[i + 1];
                    Cashier_01_customer_names[i] = Cashier_01_customer_names[i + 1];
                }
                Cashier_01[Cashier_01.length - 1] = "X"; // replacing the removed person with the next person
                Cashier_01_customer_names[Cashier_01_customer_names.length - 1] = null;
                System.out.println("Successfully removed customer " + (position + 1) + " in cashier 01... ");
                System.out.println();
            } else {
                System.out.println("The row that you selected in cashier 01 is already empty...");
                System.out.println();
            }
        }
        else if(customer_cashier == 2){
            if (Cashier_02[position].equals("O")) { // check whether the cashier is equal to O
                for (int i = position; i < Cashier_02.length - 1; i++) {
                    Cashier_02[i] = Cashier_02[i + 1];
                    Cashier_02_customer_names[i] = Cashier_02_customer_names[i + 1];
                }
                Cashier_02[Cashier_02.length - 1] = "X";// replacing the removed person with the next person
                Cashier_02_customer_names[Cashier_02_customer_names.length - 1] = null;
                System.out.println("Successfully removed customer " + (position + 1) + " in cashier 02... ");
                System.out.println();
            } else {
                System.out.println("The row that you selected in cashier 02 is already empty...");
                System.out.println();
            }
        }
        else if (customer_cashier == 3){
            if (Cashier_03[position].equals("O")) { // check whether the cashier is equal to O
                for (int i = position; i < Cashier_03.length - 1; i++) {
                    Cashier_03[i] = Cashier_03[i + 1];
                    Cashier_03_customer_names[i] = Cashier_03_customer_names[i + 1];
                }
                Cashier_03[Cashier_03.length - 1] = "X"; // replacing the removed person with the next person
                Cashier_03_customer_names[Cashier_03_customer_names.length - 1] = null;
                System.out.println("Successfully removed customer " + (position + 1) + " in cashier 03... ");
                System.out.println();
            } else {
                System.out.println("The row that you selected in cashier 03 is already empty...");
                System.out.println();
            }
        }
    }

    //making the option to remove served customers to the queue
    private static void remove_served_customer(){
        if(stock_count > 0){ // making an if to check if the burger count is 0 then not looping
            System.out.print("Enter the cashier number that you need to remove the served customer: ");
            int customer_cashier = scanner.nextInt();
            System.out.println();
            int position = 0;
                if(customer_cashier == 1){
                    if(!Cashier_01[0].equals("X")) {// checking whether the cashier is not equal to X
                        for (int i = position; i < Cashier_01.length - 1; i++) {
                            Cashier_01[i] = Cashier_01[i + 1];
                            Cashier_01_customer_names[i] = Cashier_01_customer_names[i + 1];
                        }
                        Cashier_01_customer_names[Cashier_01_customer_names.length - 1] = null; // removing the served customer and assign the position to an empty string
                        Cashier_01[Cashier_01.length - 1] = "X"; // then assign it to X
                        System.out.println("Successfully removed served customer in Cashier 01...");
                        System.out.println("Thank you for ordering 5 Burgers From \"Foodies Fave Food center\"");
                        System.out.println("Please Come Again!!!!");
                        System.out.println();
                        stock_count -= 5;
                    } else{
                        System.out.println("Cashier 01 is empty...");
                    }
                } else if(customer_cashier == 2){
                    if(!Cashier_02[0].equals("X")) {
                        for (int i = position; i < Cashier_02.length - 1; i++) {
                            Cashier_02[i] = Cashier_02[i + 1];
                            Cashier_02_customer_names[i] = Cashier_02_customer_names[i + 1];
                        }
                        Cashier_02_customer_names[Cashier_02_customer_names.length - 1] = null;
                        Cashier_02[Cashier_02.length - 1] = "X";
                        System.out.println("Successfully removed served customer in Cashier 02...");
                        System.out.println("Thank you for ordering 5 Burgers From \"Foodies Fave Food center\"");
                        System.out.println("Please Come Again!!!!");
                        System.out.println();
                        stock_count -= 5;
                    } else{
                        System.out.println("Cashier 02 is empty...");
                    }
                } else if(customer_cashier == 3){
                    if(!Cashier_01[0].equals("X")) {
                        for (int i = position; i < Cashier_03.length - 1; i++) {
                            Cashier_03[i] = Cashier_03[i + 1];
                            Cashier_03_customer_names[i] = Cashier_03_customer_names[i + 1];
                        }
                        Cashier_03_customer_names[Cashier_03_customer_names.length - 1] = null;
                        Cashier_03[Cashier_03.length - 1] = "X";
                        System.out.println("Successfully removed served customer in Cashier 03...");
                        System.out.println("Thank you for ordering 5 Burgers From \"Foodies Fave Food center\"");
                        System.out.println("Please Come Again!!!!");
                        System.out.println();
                        stock_count -= 5;
                    } else{
                        System.out.println("Cashier 03 is empty...");
                    }
                }else {
            System.out.println("Invalid Cashier....");
            System.out.println();
        }
            if(stock_count < low_stock_msg){
                System.out.println();
                System.out.println("Warning: Low stock! Remaining burger count is: " + stock_count);// warning if the burger stock is less than to 10
            }
        }else{
            System.out.println();
            System.out.println("Stock is: " + stock_count + " Please add Burgers to the stock..");
            System.out.println();
        }
    }

    //making the option to see the customers in the 3 queues in alphabetical order
    private static void view_sorted_customer() {
        all_customer_cashier_names();// function assigned below
        String temp;
        System.out.println("Sorted customer names: ");
        for (int j = 0; j < all_cashier_customer_names.length; j++) {
            for (int i = j + 1; i < all_cashier_customer_names.length; i++) {
                if (all_cashier_customer_names[i] != null) { // making if it is null not to print
                    if (compareStrings(all_cashier_customer_names[i], all_cashier_customer_names[j]) < 0) {
                        temp = all_cashier_customer_names[j]; //swapping the names
                        all_cashier_customer_names[j] = all_cashier_customer_names[i];
                        all_cashier_customer_names[i] = temp;
                    }
                }
            }
            if (all_cashier_customer_names[j] != null) {
                System.out.println(all_cashier_customer_names[j]);
            }
        }
    }

    //this method is to merge the cashier 1, 2, 3 name arrays into a one
    private static void all_customer_cashier_names(){
        int count = 0;
        for(String name: Cashier_01_customer_names){
            if (name != null){
                all_cashier_customer_names[count] = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase(); //substrings to lowercase
                count++;
            }
        }
        for(String name: Cashier_02_customer_names){
            if (name != null){
                all_cashier_customer_names[count] = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
                count++;
            }
        }
        for(String name: Cashier_03_customer_names){
            if (name != null){
                all_cashier_customer_names[count] = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
                count++;
            }
        }
    }

    //sorting compare method
    private static int compareStrings(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());// taking the length
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.charAt(i) - str2.charAt(i);
            }
        }
        return str1.length() - str2.length();
    }

    //making the option to store the data to a text file
    private static void store_program_data(){
        try {
            FileWriter output_file = new FileWriter("Output.txt");//textfile name and filewritter assigning

            output_file.write("Current Burger stock is:\n" + stock_count + "\n\n");//writing the burger stock
            System.out.println();
            output_file.write("Cashier 01 customer names:\n" + String.join("\n", Cashier_01_customer_names) + "\n\n");
            output_file.write("Cashier 02 customer names:\n" + String.join("\n", Cashier_02_customer_names) + "\n\n");
            output_file.write("Cashier 03 customer names:\n" + String.join("\n", Cashier_03_customer_names) + "\n\n");

            output_file.close();

            System.out.println("Successfully stored the data into the text file...");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file");
        }
    }

    //making the option to load the data from the text file and append them to the arrays
    private static void load_program_data(){
        File file = new File("Output.txt"); // read the file
        Scanner load = null;
        try {
            load = new Scanner(file);
            String data;
            while (load.hasNextLine()){
                if(load.nextLine().contains("Current Burger")){ //assigning the txt file burger stock to the stock count
                    stock_count = Integer.parseInt(load.nextLine());
                    break;
                }
            }
            while (load.hasNextLine()){
                if(load.nextLine().contains("Cashier 01")){
                    int count = 0;
                    while (load.hasNextLine()){
                        data = load.nextLine();
                        if(!data.equals("null")){
                            Cashier_01[count] = "O";
                            Cashier_01_customer_names[count] = data; //assigning the txt file cashier 01 names to the array
                        }else{
                            Cashier_01[count] = "X";
                        } if(count < 1){
                            count++;
                        }else{
                            break;
                        }
                    }
                    break;
                }
            }
            while (load.hasNextLine()){
                if(load.nextLine().contains("Cashier 02")){
                    int count = 0;
                    while (load.hasNextLine()){
                        data = load.nextLine();
                        if(!data.equals("null")){
                            Cashier_02[count] = "O";
                            Cashier_02_customer_names[count] = data;
                        }else{
                            Cashier_02[count] = "X";
                        } if(count < 2){
                            count++;
                        }else{
                            break;
                        }
                    }
                    break;
                }
            }
            while (load.hasNextLine()){
                if(load.nextLine().contains("Cashier 03")){
                    int count = 0;
                    while (load.hasNextLine()){
                        data = load.nextLine();
                        if(!data.equals("null")){
                            Cashier_03[count] = "O";
                            Cashier_03_customer_names[count] = data;
                        }else{
                            Cashier_03[count] = "X";
                        } if(count < 4){
                            count++;
                        }else{
                            break;
                        }
                    }
                    break;
                }
            }

            load.close();
            System.out.println("\n loaded from the text file...");
            view_all_queues();
        } catch (FileNotFoundException e) {
            System.out.println("Loading failed...");
        }
}

    //making the option to view the remaining burger stock
    private static void view_remaining_stock(){
        System.out.println();
        System.out.println("Remaining burger stock balance is: " + stock_count);
    }

    //making the option to add burgers to the current burger stock
    private static void add_burgers_to_stock(){
        System.out.print("Enter the number of burgers to add : ");
        int burger_add = scanner.nextInt();

        if(burger_add < 0){
            System.out.println("Invalid number of burgers... please try again...");
            return;
        }
        int new_stock_count = stock_count + burger_add;
        if(new_stock_count >= 51){
            System.out.println("Maximum stock count exceeded. Maximum stock is 50. Current stock count it: " +stock_count);
            return;
        }
        stock_count += burger_add;
        System.out.println();
        System.out.println(burger_add + " burgers added to the burger stock... Remaining burgers are: " + stock_count);
    }
}

