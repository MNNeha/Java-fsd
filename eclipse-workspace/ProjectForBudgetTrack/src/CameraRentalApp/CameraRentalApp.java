package CameraRentalApp;

import java.util.*;

class Camera {
    private int id;
    private String brand;
    private String model;
    private double pricePerDay;
    private boolean isRented;

    // Constructor
    public Camera(int id, String brand, String model, double pricePerDay) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.isRented = false; // By default, camera is available
}
 // Getters
    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isRented() {
        return isRented;
    }

    // Setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}
class User {
    private String username;
    private String password;
    private double walletBalance;
    private List<Camera> myCameras;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.walletBalance = 0.0; // Initializing wallet with zero balance
        this.myCameras = new ArrayList<>(); // Initializing an empty list for user's cameras
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public List<Camera> getMyCameras() {
        return myCameras;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public void addCamera(Camera camera) {
        myCameras.add(camera);
    }

    public boolean removeCamera(int cameraId) {
        for (Camera camera : myCameras) {
            if (camera.getId() == cameraId) {
                myCameras.remove(camera);
                return true;
            }
        }
        return false; // Camera with given ID not found in user's list
    }
}



public class CameraRentalApp {
	  private List<Camera> availableCameras;
	    private List<User> users;
	    private User currentUser;

	    // Constructor, initialization, login method, main menu method, etc.
	    public CameraRentalApp() {
	        availableCameras = new ArrayList<>();
	        users = new ArrayList<>();
	        // Populate availableCameras with some initial cameras
	        availableCameras.add(new Camera(1, "Canon", "EOS R5", 50.0));
	        availableCameras.add(new Camera(2, "Nikon", "Z7 II", 60.0));
	        // Create some initial users (for testing purposes)
	        users.add(new User("user1", "password1"));
	        users.add(new User("user2", "password2"));
	    }

	    public void login(String username, String password) {
	        for (User user : users) {
	            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
	                currentUser = user;
	                showMainMenu();
	                return;
	            }
	        }
	        System.out.println("Invalid username or password. Please try again.");
	        // Handle unsuccessful login
	    }

	    public void showMainMenu() {
	        Scanner scanner = new Scanner(System.in);
	        int choice;
	        do {
	            System.out.println("Main Menu");
	            System.out.println("1. My Camera");
	            System.out.println("2. Rent A Camera");
	            System.out.println("3. View All Cameras");
	            System.out.println("4. My Wallet");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline
	            switch (choice) {
                case 1:
                  
                	  myCameraOptions();
                    break;
                case 2:
                  
                	rentCamera();
                    break;
                case 3:
                	viewAllCameras();
                    break;
                case 4:
                	 viewMyWallet();
                	    break;
                
                case 5:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 5);
    }
	    private void myCameraOptions() {
	    	Scanner scanner = new Scanner(System.in);
	        int cameraChoice;
	        do {
	            System.out.println("My Camera Options");
	            System.out.println("1. Add Camera");
	            System.out.println("2. Remove Camera");
	            System.out.println("3. View My Cameras");
	            System.out.println("4. Go to previous menu");
	            System.out.print("Enter your choice: ");
	            cameraChoice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (cameraChoice) {
	                case 1:
	                    addCamera(); // Method to add a camera
	                    break;
	                case 2:
	                    removeCamera(); // Method to remove a camera
	                    break;
	                case 3:
	                    viewMyCameras(); // Method to view owned cameras
	                    break;
	                case 4:
	                    return; // Return to the main menu
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	                    break;
	            }
	        } while (cameraChoice != 4);
			
		}

		private void addCamera() {
			Scanner scanner = new Scanner(System.in);

		    System.out.print("Enter the Camera Brand: ");
		    String brand = scanner.nextLine();

		    System.out.print("Enter the Model: ");
		    String model = scanner.nextLine();

		    System.out.print("Enter the Per Day Price (INR): ");
		    double pricePerDay = scanner.nextDouble();

		    // Generate a unique ID for the new camera (You may have a better way to generate unique IDs)
		    int newCameraId = availableCameras.size() + 1;

		    // Create a new camera object with the entered details
		    Camera newCamera = new Camera(newCameraId, brand, model, pricePerDay);

		    // Add the new camera to the availableCameras list
		    availableCameras.add(newCamera);

		    System.out.println("Your camera has been successfully added to the list.");

	    }

	    private void removeCamera() {
	    	Scanner scanner = new Scanner(System.in);

	        System.out.println("Available Cameras:");
	        displayAvailableCameras(); // Display available cameras before removal

	        System.out.print("Enter the Camera ID to remove: ");
	        int removeCameraId = scanner.nextInt();

	        // Find the camera in the availableCameras list and remove it
	        boolean removed = false;
	        for (Camera camera : availableCameras) {
	            if (camera.getId() == removeCameraId) {
	                availableCameras.remove(camera);
	                removed = true;
	                break;
	            }
	        }

	        if (removed) {
	            System.out.println("Camera successfully removed from the list.");
	        } else {
	            System.out.println("Camera with the specified ID was not found.");
	        }
	    }
	    

	    private void rentCamera() {
	    	Scanner scanner = new Scanner(System.in);
	        System.out.println("Available Cameras for Rent:");
	        displayAvailableCameras(); // Method to display available cameras

	        System.out.print("Enter the camera id you want to rent: ");
	        int selectedCameraId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        Camera selectedCamera = findCameraById(selectedCameraId);
	        if (selectedCamera != null && !selectedCamera.isRented()) {
	            // Process the rental
	            double price = selectedCamera.getPricePerDay();
	            if (currentUser.getWalletBalance() >= price) {
	                selectedCamera.setRented(true);
	                currentUser.getMyCameras().add(selectedCamera);
	                currentUser.setWalletBalance(currentUser.getWalletBalance() - price);
	                System.out.println("Transaction successful! You rented the camera.");
	            } else {
	                System.out.println("Error: Transaction Failed due to insufficient wallet balance.");
	                System.out.println("Please deposit the amount to your wallet.");
	            }
	        } else {
	            System.out.println("Invalid camera selection or camera already rented.");
	        }
	    }
	  
	    private Camera findCameraById(int id) {
			
	    	for (Camera camera : availableCameras) {
	            if (camera.getId() == id) {
	                return camera;
	            }
	        }
	        return null;
		}

		private void displayAvailableCameras() {
	    	  for (Camera camera : availableCameras) {
	    	        if (!camera.isRented()) {
	    	            System.out.println("Camera ID: " + camera.getId() +
	    	                    ", Brand: " + camera.getBrand() +
	    	                    ", Model: " + camera.getModel() +
	    	                    ", Price per day: " + camera.getPricePerDay() +
	    	                    ", Status: " + (camera.isRented() ? "Rented" : "Available"));
	    	        }
	    	    }
			
		}

		private void viewAllCameras() {
			System.out.println("All Available Cameras:");
		    for (Camera camera : availableCameras) {
		        System.out.println("Camera ID: " + camera.getId() +
		                ", Brand: " + camera.getBrand() +
		                ", Model: " + camera.getModel() +
		                ", Price per day: " + camera.getPricePerDay() +
		                ", Status: " + (camera.isRented() ? "Rented" : "Available"));
		    }
	    }

	    private void viewMyCameras() {
	    	List<Camera> userCameras = currentUser.getMyCameras();
	        if (userCameras.isEmpty()) {
	            System.out.println("You have not rented any cameras yet.");
	        } else {
	            System.out.println("Cameras Rented by You:");
	            for (Camera camera : userCameras) {
	                System.out.println("Camera ID: " + camera.getId() +
	                        ", Brand: " + camera.getBrand() +
	                        ", Model: " + camera.getModel() +
	                        ", Price per day: " + camera.getPricePerDay());
	            }
	        }
	    }

	    private void viewMyWallet() {
	        // Display current wallet balance of the user
	    	 System.out.println("Your Current Wallet Balance: INR " + currentUser.getWalletBalance());
	    }

	    private void depositToWallet(double amount) {
	        // Logic to deposit amount to the user's wallet
	    	currentUser.setWalletBalance(currentUser.getWalletBalance() + amount);
	        System.out.println("Your wallet has been successfully updated. Current balance: INR " + currentUser.getWalletBalance());
	    }
	    private void viewMyWallet1() {
    	    System.out.println("Your Current Wallet Balance: INR " + currentUser.getWalletBalance());
    	    Scanner scanner = new Scanner(System.in);
    	    
    	    System.out.print("Do you want to deposit more amount to your wallet? (1. Yes 2. No): ");
    	    int depositChoice = scanner.nextInt();
    	    scanner.nextLine(); // Consume newline
    	    
    	    if (depositChoice == 1) {
    	        System.out.print("Enter the amount to deposit: ");
    	        double depositAmount = scanner.nextDouble();
    	        depositToWallet(depositAmount); // Call the depositToWallet method passing the deposit amount
    	    } else if (depositChoice != 2) {
    	        System.out.println("Invalid choice. Returning to the main menu.");
    	    }
	    }

	    private static boolean isValidUser(String enteredUsername, String enteredPassword) {
	        // Replace this with your actual authentication logic
	        // For simulation purposes, allow any username and password
	        return true;
	    }
	public static void main(String[] args) {
		 
		// Output: Welcome Message
        System.out.println("***************************************");
        System.out.println("*   Welcome To CAMERA RENTAL APP     *");
        System.out.println("***************************************");
     
 
        Scanner scanner = new Scanner(System.in);		
		

        boolean loggedIn = false; // Declare loggedIn variable outside the loop

        do {
            System.out.println("\nPlease Login to continue -");
            System.out.print("\n Enter username: ");
            String username = scanner.nextLine();
            System.out.print("\n Enter password: ");
            String password = scanner.nextLine();

            // Simulate user authentication - Replace this with actual user authentication logic
            if (isValidUser(username, password)) {
                loggedIn = true;
            } else {
                System.out.println("\n Invalid username or password. Please try again.");
            }
        } while (!loggedIn);
	        
	        // Starting the main menu
	        CameraRentalApp app = new CameraRentalApp();
	        app.showMainMenu();

	}

}
