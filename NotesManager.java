package com.elevatelabs.notesmanager;
import java.io.*;
import java.util.Scanner;

public class NotesManager {
    private static final String fileName = "notes.txt";

    private static void addNote(Scanner sc) {

        System.out.print("Write your note: ");
        String note = sc.nextLine();

        try {
            // 'true' enables append mode so old notes are not deleted
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(note + "\n");
            writer.close();

            System.out.println("Note saved successfully!");

        } catch (IOException e) {
            System.out.println("Something went wrong while saving the note.");
        }
    }

    private static void viewNotes() {

        System.out.println("\n----- Your Saved Notes -----");

        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);

            String line;
            boolean isEmpty = true;

            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
                isEmpty = false;
            }

            br.close();

            if (isEmpty) {
                System.out.println("No notes available.");
            }

        } catch (IOException e) {
            System.out.println("No notes found. Please add a note first.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option = 0;

        // Run menu until user chooses Exit
        while (option != 3) {

            System.out.println("\n===== SIMPLE NOTES MANAGER =====");
            System.out.println("1. Add a Note");
            System.out.println("2. View All Notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            option = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (option == 1) {
                addNote(sc);
            } else if (option == 2) {
                viewNotes();
            } else if (option == 3) {
                System.out.println("Closing application... Goodbye!");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();


    }
}
