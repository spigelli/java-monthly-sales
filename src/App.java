package sales_project;

import javax.swing.JOptionPane;

import java.util.Scanner; // Needed for the Scanner class
import java.io.*;         // Needed for the File class

public class App {
  public static void main(String[] args) {
    String fileName = getFileName();
    // displayTotalSales(totalSales);
    displayStats(fileName);
    System.exit(0);
  }

  /**
   * getFileName method
   * @return the file name from user
   */
  public static String getFileName() {
    String fileName = JOptionPane.showInputDialog("Enter the file name (including extension): ");
    return fileName;
  }

  /**
   * getTotalSales method - read from the file and return the total sales
   */
  public static double getTotalSales(String fileName) {
    double sales, totalSales = 0.0;
    try {
      // Read the file
      File file = new File(fileName);
      Scanner inputFile = new Scanner(file);
      while (inputFile.hasNext()) {
        sales = inputFile.nextDouble();
        totalSales += sales;
      }
      // Close the file
      inputFile.close();
    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
    }
    return totalSales;
  }

  /**
   * Displays the total number of sales to the user
   */
  public static void displayTotalSales(double totalSales) {
    JOptionPane.showMessageDialog(null, "The total sales is: " + totalSales);
  }

  /**
   * Displays all stats
   */
  public static void displayStats(String fileName) {
    double total = getTotalSales(fileName);
    double lowest = getLowest(fileName);
    double highest = getHighest(fileName);
    double average = getAverage(fileName);
    String message = "Total Sales: " + total + "\n" +
                     "Lowest Sales: " + lowest + "\n" +
                     "Highest Sales: " + highest + "\n" +
                     "Average Sales: " + average + "\n";
    JOptionPane.showMessageDialog(null, message);
  }

  // Get the lowest sales from the file
  public static double getLowest(String fileName) {
    // create variables
    double sales, lowest = 0;
    try {
      // open the file
      File file = new File(fileName);
      Scanner fileReader = new Scanner(file);
      // read the first sale
      lowest = fileReader.nextDouble();
      // loop through the entire file
      // starting from the second line
      while(fileReader.hasNext()) {
        sales = fileReader.nextDouble();
        if(sales < lowest) {
          lowest = sales;
        }
      }
      fileReader.close();
    }
    catch (IOException ex) {
      JOptionPane.showMessageDialog(null, "Something went wrong");
    }
    return lowest;
  }

  // Get the highest sales from the file
  public static double getHighest(String fileName) {
    // create variables
    double sales, highest = 0;
    try {
      // open the file
      File file = new File(fileName);
      Scanner fileReader = new Scanner(file);
      // read the first sale
      highest = fileReader.nextDouble();
      // loop through the entire file
      // starting from the second line
      while(fileReader.hasNext()) {
        sales = fileReader.nextDouble();
        if(sales > highest) {
          highest = sales;
        }
      }
      fileReader.close();
    }
    catch (IOException ex) {
      JOptionPane.showMessageDialog(null, "Something went wrong");
    }
    return highest;
  }


  // Get the average sales from the file
  public static double getAverage(String fileName) {
    // create variables
    double sales, total = 0, count = 0, average = 0;
    try {
      // open the file
      File file = new File(fileName);
      Scanner fileReader = new Scanner(file);
      // loop through the entire file
      while(fileReader.hasNext()) {
        sales = fileReader.nextDouble();
        total += sales;
        count++;
      }
      fileReader.close();
    }
    catch (IOException ex) {
      JOptionPane.showMessageDialog(null, "Something went wrong");
    }
    average = total / count;
    return average;
  }

}