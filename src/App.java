package sales_project;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.Scanner; // Needed for the Scanner class
import java.io.*;         // Needed for the File class

public class App {
  public static void main(String[] args) {
    String fileName = getFileName();
    double totalSales = getTotalSales(fileName);
    displayTotalSales(totalSales);
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
}