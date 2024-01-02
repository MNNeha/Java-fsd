package BudgetTrackingPgm;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class BudgetTracker {
    private Map<String, Double> budgets = new HashMap<>(); // Map to store budgets for each month
    private String username;
    private String password;

    // Constructor to set username and password
    public BudgetTracker(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to allow users to change password
    public boolean changePassword(String oldPassword, String newPassword) {
        if (password.equals(oldPassword)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }

    // Method to add budget for a month
    public void addBudget(String month, double budget) {
        budgets.put(month, budget);
    }

    // Method to check if expenses exceed the budget for a given month
    public boolean checkExpenses(String month, double expenses) {
        if (budgets.containsKey(month)) {
            double budget = budgets.get(month);
            return expenses > budget;
        }
        return false; // Budget for the given month not found
    }

    // Method to validate password before allowing entries
    public boolean validatePassword(String enteredPassword) {
        return password.equals(enteredPassword);
    }

	public Map<String, Double> getDateWiseExpenses(String formattedDate) {
		 // Example implementation (You should adapt this to your data structure)
	    Map<String, Double> expenses = new HashMap<>();

	    // Assuming you have a data structure where expenses are stored with their descriptions
	    // Retrieve expenses for the formatted date and populate the 'expenses' map
	    // This is a placeholder logic, adjust it based on your data storage

	    // For example:
	    if (formattedDate.equals("2023-01-15")) {
	        expenses.put("Expense 1", 50.0);
	        expenses.put("Expense 2", 30.0);
	        // Add more expenses as needed
	    } else if (formattedDate.equals("2023-01-20")) {
	        expenses.put("Expense 3", 40.0);
	        // Add more expenses as needed
	    }
	  

	    return expenses;
	}

	private Map<String, Map<String, Double>> expensesByMonth;

    public BudgetTracker() {
        expensesByMonth = new HashMap<>();
    }

    // Method to add expenses for a specific month
    public void addExpenses(String formattedMonth, String expenseDescription, double expenseAmount) {
        expensesByMonth
            .computeIfAbsent(formattedMonth, k -> new HashMap<>())
            .put(expenseDescription, expenseAmount);
    }

    // Method to retrieve month-wise expenses for a given month
    public Map<String, Double> getMonthWiseExpenses(String formattedMonth) {
        return expensesByMonth
            .getOrDefault(formattedMonth, Collections.emptyMap());
    }
	



private Map<String, Double> monthlyBudgets; // Map to store monthly budgets

// Method to display total budget log
public void displayTotalBudgetLog() {
    System.out.println("Total Budget Log:");

    double totalBudget = 0;
    double totalExpenses = 0;

    for (Map.Entry<String, Double> entry : monthlyBudgets.entrySet()) {
        String month = entry.getKey();
        double monthlyBudget = entry.getValue();
        totalBudget += monthlyBudget;

        Map<String, Double> expenses = expensesByMonth.getOrDefault(month, new HashMap<>());
        double currentExpenses = expenses.values().stream().mapToDouble(Double::doubleValue).sum();
        totalExpenses += currentExpenses;

        double remainingBudget = monthlyBudget - currentExpenses;

        System.out.println("Month: " + month +
                ", Monthly Budget: $" + monthlyBudget +
                ", Current Expenses: $" + currentExpenses +
                ", Remaining Budget: $" + remainingBudget);

        if (remainingBudget < 0) {
            System.out.println("  - WARNING: Expenses exceeded budget for " + month);
        }
    }

    System.out.println("Total Budget: $" + totalBudget +
            ", Total Expenses: $" + totalExpenses +
            ", Remaining Total Budget: $" + (totalBudget - totalExpenses));
}

public Map<String, Double> getMonthlyBudgets() {
	
	 return budgets;
}

}

public class BudgetTrackerApp {
    public static void main(String[] args) {
    	  Scanner scanner = new Scanner(System.in);
          BudgetTracker userBudget = null;

          // Output: Welcome Message
          System.out.println("***************************************");
          System.out.println("*    Welcome To Budget Tracker App    *");
          System.out.println("***************************************");
          System.out.println("   Please Login to continue        ");
   

          // User Login
          System.out.print("Enter username: ");
          String username = scanner.nextLine();

          System.out.print("Enter password: ");
          String password = scanner.nextLine();

          // Validating user and creating BudgetTracker object
          userBudget = new BudgetTracker(username, password);

          // Main Menu Options
          int choice = 0;
          while (choice != 5) {
              System.out.println("\nChoose an option:");
              System.out.println("1. Set Monthly Budget");
              System.out.println("2. Record an Expense");
              System.out.println("3. Budgetary Logs");
              System.out.println("4. Change Password");
              System.out.println("5. Exit");

              System.out.print("Enter your choice: ");
              choice = scanner.nextInt();
              scanner.nextLine(); // Consume newline

              switch (choice) {
                  case 1:
                      // Set Monthly Budget
                	  if (userBudget != null) {
                	        if (!userBudget.getMonthlyBudgets().isEmpty()) {
                	            System.out.println("Monthly budget is already set.");
                	            System.out.print("Do you want to update it? (Y: Yes | N: No): ");
                	            String updateChoice = scanner.nextLine().toUpperCase();

                	            if (updateChoice.equals("Y")) {
                	            	for (int i = 1; i <= 12; i++) {
                	                    System.out.print("Enter the month: ");
                	                    String month = scanner.nextLine();
                	                    if (month.equalsIgnoreCase("exit")) {
                	                        break; // Exit the loop if 'exit' is entered
                	                    }

                	                    System.out.print("Enter the updated budget for " + month + ": ");
                	                    double updatedBudget = scanner.nextDouble();
                	                    scanner.nextLine(); // Consume newline

                	                    userBudget.addBudget(month, updatedBudget);
                	                    System.out.println("Budget for " + month + " updated successfully.");
                	                    System.out.print("Enter 'B' to go back to the main menu or any other key to continue: ");
                	                    String backChoice = scanner.nextLine().toUpperCase();

                	                    if (backChoice.equals("B")) {
                	                        break; // Exit the loop and go back to the main menu
                	                    }
                	                }
                	            	
                	                System.out.println("Your Monthly Budget Has Been Updated Successfully.");
                	            } else if (updateChoice.equals("N")) {
                	                // User chose not to update
                	                System.out.println("Monthly budget remains unchanged.");
                	            } else {
                	                // Invalid choice
                	                System.out.println("Invalid choice. Monthly budget remains unchanged.");
                	            }
                	        } else {
                	            // Logic to set the monthly budget if not already set
                	            for (int i = 1; i <= 12; i++) {
                	                System.out.print("Enter the month: ");
                	                String month = scanner.nextLine();

                	                System.out.print("Enter the budget for " + month + ": ");
                	                double budgetAmount = scanner.nextDouble();
                	                scanner.nextLine(); // Consume newline

                	                userBudget.addBudget(month, budgetAmount);
                	                System.out.println("Budget for " + month + " set successfully.");
                	            }
                	            System.out.println("Your Monthly Budget Has Been Set Successfully.");
                	        }
                	    } else {
                	        System.out.println("User not logged in. Please login to set the budget.");
                	    }
                	    break;
                  case 2:
                      // Record an Expense
                	  if (userBudget != null) {
                	        // Displaying Expense Categories
                	        System.out.println("Choose an expense category:");
                	        System.out.println("1. Clothes");
                	        System.out.println("2. Electricity Bill");
                	        System.out.println("3. Exam Fees");
                	        System.out.println("4. Food");
                	        System.out.println("5. Fuel");
                	        System.out.println("6. House Rent");
                	        System.out.println("7. Travelling");
                	        System.out.println("8. Other");

                	        System.out.print("Enter your choice: ");
                	        int expenseCategory = scanner.nextInt();
                	        scanner.nextLine(); // Consume newline

                	        System.out.print("Enter expense amount: ");
                	        double expenseAmount = scanner.nextDouble();
                	        scanner.nextLine(); // Consume newline

                	        // Implement logic to record the expense in the BudgetTracker object
                	        String category = ""; // Placeholder for the selected category

                	        switch (expenseCategory) {
                	            case 1:
                	                category = "Clothes";
                	                break;
                	            case 2:
                	                category = "Electricity Bill";
                	                break;
                	            case 3:
                	                category = "Exam Fees";
                	                break;
                	            case 4:
                	                category = "Food";
                	                break;  
                	            case 5:
                	                category = "Fuel";
                	                break;
                	            case 6:
                	                category = "House Rent";
                	                break;
                	            case 7:
                	                category = "Travelling";
                	                break;
                	            case 8:
                	                category = "Others";
                	                break;
                	            default:
                	                System.out.println("Invalid expense category.");
                	                break;
                	        }

                	        // Record the expense in the selected category
                	        // userBudget.recordExpense(category, expenseAmount);
                	        System.out.println("Expense of $" + expenseAmount + " recorded for " + category + ".");
                	        System.out.print("Enter your password: ");
                	        String enteredPassword = scanner.nextLine();

							// Validate password before confirming expense recording
                	        if (userBudget.validatePassword(enteredPassword)) {
                	            // Record the expense in the selected category
                	            // userBudget.recordExpense(category, expenseAmount);
                	            System.out.println("Expenses recorded successfully.");
                	        } else {
                	            System.out.println("Invalid password. Expense recording aborted.");
                	        }
                	    } else {
                	        System.out.println("User not logged in. Please login to record expenses.");
                	    }
                	    break;
                  case 3:
                	  
                      // Budgetary Logs
                	  int logChoice = 0;
                	    while (logChoice != 4) {
                	        System.out.println("\nBudgetary Logs:");
                	        System.out.println("1. Date wise log");
                	        System.out.println("2. Month wise log");
                	        System.out.println("3. Total Budget Log");
                	        System.out.println("4. Back to Main Menu");

                	        System.out.print("Enter your choice: ");
                	        logChoice = scanner.nextInt();
                	        scanner.nextLine(); // Consume newline

                	        switch (logChoice) {
                	            case 1:
                	                // Logic to display date wise log
                	            	if (userBudget != null) {
                	                    // Get input for date in dd-mm-yyyy format
                	                    System.out.print("Enter the date (dd-mm-yyyy): ");
                	                    String date = scanner.nextLine();

                	                    // Implement logic to convert date format if needed and display expenses for the entered date
                	                    // Assuming userBudget.getDateWiseExpenses(date) returns expenses for the given date
                	                    String inputDate = "25-12-2023"; // Example input date in dd-MM-yyyy format
                	                    String formattedDate = convertDateFormat(date); // Convert date format if needed
                	                    System.out.println("Converted Date: " + formattedDate);
                	                    // Display expenses for the formatted date
                	                    // Modify the following logic based on your implementation to retrieve expenses for the formatted date
                	                    Map<String, Double> dateExpenses = userBudget.getDateWiseExpenses(formattedDate);

                	                    if (dateExpenses != null && !dateExpenses.isEmpty()) {
                	                        System.out.println("Expenses for " + formattedDate + ":");
                	                        for (Map.Entry<String, Double> entry : dateExpenses.entrySet()) {
                	                            System.out.println(entry.getKey() + ": $" + entry.getValue());
                	                        }
                	                    } else {
                	                        System.out.println("No expenses found for " + formattedDate);
                	                    }
                	                } else {
                	                    System.out.println("User not logged in. Please login to view logs.");
                	                }
                	                break;
                	            
                	            case 2:
                	                // Logic to display month wise log
                	            	if (userBudget != null) {
                	                    System.out.print("Enter the month number (1-12): ");
                	                    int inputMonthNumber = scanner.nextInt();
                	                    scanner.nextLine(); // Consume newline

                	                    if (inputMonthNumber >= 1 && inputMonthNumber <= 12) {
                	                        String inputMonth = String.format("%02d", inputMonthNumber) + "-" + "yyyy"; // Replace "yyyy" with the desired year format

                	                        // Implement logic to display expenses for the entered month
                	                        // Assuming userBudget.getMonthWiseExpenses(inputMonth) returns expenses for the given month
                	                        Map<String, Double> monthExpenses = userBudget.getMonthWiseExpenses(inputMonth);

                	                        if (monthExpenses != null && !monthExpenses.isEmpty()) {
                	                            System.out.println("Expenses for " + inputMonth + ":");
                	                            for (Map.Entry<String, Double> entry : monthExpenses.entrySet()) {
                	                                System.out.println(entry.getKey() + ": $" + entry.getValue());
                	                            }
                	                        } else {
                	                            System.out.println("No expenses found for " + inputMonth);
                	                        }
                	                    } else {
                	                        System.out.println("Invalid month number. Please enter a number between 1 and 12.");
                	                    }
                	                } else {
                	                    System.out.println("User not logged in. Please login to view logs.");
                	                }
                	                break;
                	            case 3:
                	            	 if (userBudget != null) {
                	                        userBudget.displayTotalBudgetLog();
                	                    } else {
                	                        System.out.println("User not logged in. Please log in to view logs.");
                	                    }
                	                    break;
                	            case 4:
                	                System.out.println("Returning to main menu...");
                	                break;
                	            default:
                	                System.out.println("Invalid choice. Please enter a valid option.");
                	                break;
                	        }
                	    }
                	    break;
                  case 4:
                      // Change Password
                	  System.out.println("Enter old password:");
                      String oldPassword = scanner.nextLine();
                      System.out.println("Enter new password:");
                      String newPassword = scanner.nextLine();

                      if (userBudget != null) {
                          boolean passwordChanged = userBudget.changePassword(oldPassword, newPassword);
                          if (passwordChanged) {
                              System.out.println("Your Password has been changed successfully!");
                          } else {
                              System.out.println("Failed to change password. Please check your old password.");
                          }
                      } else {
                          System.out.println("User not logged in. Please log in to change the password.");
                      }
                      break;
                  case 5:
                      System.out.println("Exiting Budget Tracker App. Goodbye!");
                      break;
                  default:
                      System.out.println("Invalid choice. Please enter a valid option.");
                      break;
              }
          }

        scanner.close();
    }

	private static String convertDateFormat(String date) {
		try {
	        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy"); // Input date format
	        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd"); // Desired output date format

	        Date parsedDate = inputFormat.parse(date);
	        return outputFormat.format(parsedDate);
	    } catch (ParseException e) {
	        // Handle the parsing exception as needed
	        e.printStackTrace();
	        return ""; // Return an empty string or handle the error in the application
	    }
	}
}

