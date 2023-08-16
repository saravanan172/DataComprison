import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataComparison {

    public static void main(String[] args) {
        List<String> emailsFromFile1 = readEmailsFromFile("file1.txt");
        List<String> emailsFromFile2 = readEmailsFromFile("file2.txt");

        System.out.println("Emails present in both files:");
        for (String email : emailsFromFile1) {
            if (emailsFromFile2.contains(email)) {
                System.out.println(email);
            }
        }

        System.out.println("\nEmails present in file1 but not in file2:");
        for (String email : emailsFromFile1) {
            if (!emailsFromFile2.contains(email)) {
                System.out.println(email);
            }
        }

        System.out.println("\nEmails present in file2 but not in file1:");
        for (String email : emailsFromFile2) {
            if (!emailsFromFile1.contains(email)) {
                System.out.println(email);
            }
        }

        System.out.println("\nAll unique emails:");
        List<String> allUniqueEmails = new ArrayList<>(emailsFromFile1);
        for (String email : emailsFromFile2) {
            if (!allUniqueEmails.contains(email)) {
                allUniqueEmails.add(email);
            }
        }
        for (String email : allUniqueEmails) {
            System.out.println(email);
        }
    }

    private static List<String> readEmailsFromFile(String filename) {
        List<String> emails = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                emails.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
            e.printStackTrace();
        }
        return emails;
    }
}
