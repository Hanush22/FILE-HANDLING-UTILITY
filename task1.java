import java.io.*;
import java.util.Scanner;


public class task1 {

    private static final String FILE_PATH = "example.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        
        while (running) {
            System.out.println("\nTask1:");
            System.out.println("1. Write to file");
            System.out.println("2. Read from file");
            System.out.println("3. Modify file");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    writeFile(scanner);
                    break;
                case 2:
                    readFile();
                    break;
                case 3:
                    modifyFile(scanner);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
    private static void writeFile(Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            System.out.print("Enter text to write to file: ");
            String text = scanner.nextLine();
            writer.write(text);
            System.out.println("Text written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    private static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("\nFile Contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    private static void modifyFile(Scanner scanner) {
        try (RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "rw")) {
            System.out.print("Enter the text to modify the file: ");
            String text = scanner.nextLine();
            raf.setLength(0); // Clear the file
            raf.writeBytes(text);
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

