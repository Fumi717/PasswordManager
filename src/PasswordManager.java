import java.util.Scanner;

class PasswordManager {
    private Scanner sc = new Scanner(System.in);

    public void viewEntries() {
        int dataSize = PasswordEntry.database.size();

        System.out.println("");
        System.out.println("Saved entries (" + dataSize + ")");
        System.out.println("=".repeat(50));

        if (dataSize == 0) {
            System.out.println("No entries found.");
            return;
        }

        int count = 1;
        for (PasswordEntry entry : PasswordEntry.database) {
            System.out.println("Entry #" + count);
            System.out.println(entry);
            System.out.println("-".repeat(50));
            count++;
        }
    }

    public void editLabelValue() {
        if (PasswordEntry.database.isEmpty()) {
            System.out.println("No entries to edit.");
            return;
        }
        viewEntries();
        System.out.print("\nEdit label at index (1-" + PasswordEntry.database.size() + "): ");

        try {
            int index = sc.nextInt();
            if (index < 1 || index > PasswordEntry.database.size()) {
                System.out.println("Invalid index. Valid range: 1.." + PasswordEntry.database.size());
                return;
            }

            String oldLabel = PasswordEntry.database.get(index - 1).getLabel();
            System.out.print("New label: ");
            String newLabel = sc.next();

            System.out.print("\nChange label from '" + oldLabel + "' to '" + newLabel + "'? (Y/N): ");
            String confirmation = sc.next().toUpperCase();

            if (confirmation.equals("Y")) {
                PasswordEntry.database.get(index - 1).setLabel(newLabel);
                PasswordEntry.saveAllToFile(); // Save changes to file
                System.out.println("Label updated successfully!");
            } else {
                System.out.println("Changes cancelled!");
            }
        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine(); // Clear buffer
        }
    }

    public void editUsernameValue() {
        if (PasswordEntry.database.isEmpty()) {
            System.out.println("No entries to edit.");
            return;
        }
        viewEntries();
        System.out.print("\nEdit username at index (1-" + PasswordEntry.database.size() + "): ");

        try {
            int index = sc.nextInt();
            if (index < 1 || index > PasswordEntry.database.size()) {
                System.out.println("Invalid index. Valid range: 1.." + PasswordEntry.database.size());
                return;
            }

            String oldUsername = PasswordEntry.database.get(index - 1).getUsername();
            System.out.print("New username: ");
            String newUsername = sc.next();

            System.out.print("\nChange username from '" + oldUsername + "' to '" + newUsername + "'? (Y/N): ");

            String confirmation = sc.next().toUpperCase();
            if (confirmation.equals("Y")) {
                PasswordEntry.database.get(index - 1).setUsername(newUsername);
                PasswordEntry.saveAllToFile(); // Save changes to file
                System.out.println("Username updated successfully!");
            } else {
                System.out.println("Changes cancelled!");
            }
        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine(); // Clear buffer
        }
    }

    public void editPasswordValue() {
        if (PasswordEntry.database.isEmpty()) {
            System.out.println("No entries to edit.");
            return;
        }
        viewEntries();
        System.out.print("\nEdit password at index (1-" + PasswordEntry.database.size() + "): ");

        try {
            int index = sc.nextInt();
            if (index < 1 || index > PasswordEntry.database.size()) {
                System.out.println("Invalid index. Valid range: 1.." + PasswordEntry.database.size());
                return;
            }

            String oldPassword = PasswordEntry.database.get(index - 1).getPassword();
            System.out.print("New password: ");
            String newPassword = sc.next();

            System.out.print("\nChange password? (Y/N): ");

            String confirmation = sc.next().toUpperCase();
            if (confirmation.equals("Y")) {
                PasswordEntry.database.get(index - 1).setPassword(newPassword);
                PasswordEntry.saveAllToFile(); // Save changes to file
                System.out.println("Password updated successfully!");
            } else {
                System.out.println("Changes cancelled!");
            }
        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine(); // Clear buffer
        }
    }

    public void searchByLabel() {
        if (PasswordEntry.database.isEmpty()) {
            System.out.println("No entries to search.");
            return;
        }

        System.out.println("\nSearch entry by label (e.g., 'Facebook'):");
        System.out.print("Search for: ");
        String search = sc.next().toLowerCase();

        boolean found = false;
        for (int i = 0; i < PasswordEntry.database.size(); i++) {
            PasswordEntry entry = PasswordEntry.database.get(i);
            if (entry.getLabel().toLowerCase().contains(search)) {
                System.out.println("\nEntry #" + (i + 1));
                System.out.println(entry);
                System.out.println("-".repeat(50));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No entry found containing '" + search + "'");
        }
    }

    public void deleteEntry() {
        if (PasswordEntry.database.isEmpty()) {
            System.out.println("No entries to delete.");
            return;
        }
        viewEntries();
        System.out.print("\nDelete entry at index (1-" + PasswordEntry.database.size() + "): ");

        try {
            int index = sc.nextInt();
            if (index < 1 || index > PasswordEntry.database.size()) {
                System.out.println("Invalid index!");
                return;
            }

            PasswordEntry entry = PasswordEntry.database.get(index - 1);
            System.out.print("Delete entry '" + entry.getLabel() + "'? (Y/N): ");
            String confirmation = sc.next().toUpperCase();

            if (confirmation.equals("Y")) {
                PasswordEntry.database.remove(index - 1);
                PasswordEntry.saveAllToFile();
                System.out.println("Entry deleted successfully!");
            } else {
                System.out.println("Deletion cancelled!");
            }
        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    public void closeScanner() {
        sc.close();
    }
}