import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class PasswordEntry {
    private String label;
    private String username;
    private String password;

    static ArrayList<PasswordEntry> database = new ArrayList<>();
    final static private String FILE_NAME = "passwords.txt";
    private final static Scanner sc = new Scanner(System.in);

    public PasswordEntry(String label, String username, String password) {
        this.label = label;
        this.username = username;
        this.password = password;
    }

    public static void recordEntry() {
        System.out.print("\nLabel: ");
        String label = sc.nextLine();
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        if (!password.isEmpty()) {
            PasswordEntry entry = new PasswordEntry(label, username, password);
            addPassword(label, username, password);
            database.add(entry);
            System.out.println("\nNew entry recorded.");
        } else {
            System.out.println("Password field must be filled");
        }
    }

    public static void addPassword(String label, String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            String entry = label + ", " + username + ", " + password;
            writer.write(entry);
            writer.newLine();
            System.out.println("Password saved for " + label);
        } catch (IOException e) {
            System.out.println("Error saving password: " + e.getMessage());
        }
    }

    public static void loadAllPasswords() {
        database.clear();

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No passwords saved yet.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(", ", 3);
                    if (parts.length == 3) {
                        PasswordEntry entry = new PasswordEntry(parts[0], parts[1], parts[2]);
                        database.add(entry);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading passwords: " + e.getMessage());
        }
    }

    public static void saveAllToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (PasswordEntry entry : database) {
                String line = entry.label + ", " + entry.username + ", " + entry.password;
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public static void closeScanner() {
        sc.close();
    }

    public String getLabel() {
        return label;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setLabel(String newLabel) {
        this.label = newLabel;
    }

    @Override
    public String toString() {
        return "\n\tLabel: " + label + "\n\tUsername: " + username + "\n\tPassword: " + password + "\n";
    }
}