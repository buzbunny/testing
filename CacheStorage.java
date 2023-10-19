import java.util.Scanner;

public class CacheStorage {
    public static void main(String[] args) {
        CacheStoreList cacheLibrary = new CacheStoreList();
        Scanner keyboard = new Scanner(System.in);
        int userOption;

        System.out.println("_____MY CACHE LIBRARY_____");
        System.out.println("1. Add item");
        System.out.println("2. Get item");
        System.out.println("3. Evict least used item");
        System.out.println("4. Display entire cache library");
        System.out.println("5. Exit");
        System.out.println("Enter an option...");

        while (true) {

            if (keyboard.hasNextInt()) {
                userOption = keyboard.nextInt();
                if (userOption >= 0 && userOption <= 5) {
                    if (userOption == 1) {
                        do {
                            int maxSize;
                            int ID;
                            String storedData;

                            while (true) {
                                System.out.print("Enter cache's maximum size: ");
                                if (keyboard.hasNextInt()) {
                                    maxSize = keyboard.nextInt();
                                    break;
                                } else {
                                    System.out.println("Invalid input. Please enter an integer for the maximum size.");
                                    keyboard.next(); // A loop to constrain the users input to the required data type
                                }
                            }

                            while (true) {
                                System.out.print("Enter data ID: ");
                                if (keyboard.hasNextInt()) {
                                    ID = keyboard.nextInt();
                                    // Check if the ID already exists in the list
                                    boolean isDuplicate = false;
                                    cNode current = cacheLibrary.head;
                                    while (current != null) {// case where ID is found, then isDuplicate is now
                                                             // instantiated to True
                                        if (current.data.getID() == ID) {
                                            isDuplicate = true;
                                            break;
                                        }
                                        current = current.next;
                                    }

                                    if (isDuplicate) {
                                        System.out.println("ID already exists. Please use another ID.");
                                    } else {
                                        break; // when the ID is valid and not a duplicate, this line of code exists the
                                               // loop
                                    }
                                } else {
                                    System.out.println("Invalid input. Please enter an integer for the ID.");
                                    keyboard.next();
                                }
                            }

                            System.out.print("Enter data to be stored: ");
                            storedData = keyboard.next();

                            Cache newData = new Cache(maxSize, ID, storedData);
                            cacheLibrary.addItem(newData);

                            System.out.print("Would you like to add another item to your library? (y/n): ");
                            String anotherInput = keyboard.next();
                            System.out.println(" ");
                            if (!"y".equalsIgnoreCase(anotherInput)) {
                                break;
                            }
                        } while (true);

                    } else if (userOption == 2) {
                        System.out.print("Enter ID of data to be retrieved from the library: ");
                        int ID = keyboard.nextInt();
                        cacheLibrary.getItem(ID);
                    } else if (userOption == 3) {
                        cacheLibrary.evictLeastUsedItem();
                    } else if (userOption == 4) {
                        cacheLibrary.displayCacheLibrary();
                    } else if (userOption == 5) {
                        break; // Exit the while loop
                    } else {
                        System.out.println("Invalid option. Please enter a valid option from the menu.");
                    }
                    System.out.println("Enter an option or 5 to exit");
                } else {
                    System.out.println("Invalid option. Please enter a valid option from the menu.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid option from the menu.");
                keyboard.next();
            }
        }
    }
}