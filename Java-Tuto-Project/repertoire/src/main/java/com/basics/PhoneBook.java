package com.basics;

import java.io.*;
import java.io.IOException;
import java.util.*;

public class PhoneBook {

    public static Scanner sc = null;

    public static final String PHONE_BOOK_FILE_PATH = "./Java-Tuto-Project/repertoire/phoneBookFile.csv";

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        String userLastName = getUserInput("Entrez un nom de famille :");
        String userFirstName = getUserInput("Entrez un prénom :");
        String userPhoneNumber = getUserInput("Entrez un numéro de téléphone :");

        Contact newContact = new Contact(userLastName, userFirstName, userPhoneNumber);
        System.out.println(newContact.toString());
        sc.close();

        File phoneBookFile = getOrCratePhoneBookFile(PHONE_BOOK_FILE_PATH);
        appendContactToPhoneBook(phoneBookFile, newContact);
    }

    public static String getUserInput(String userRequest) {

        System.out.println(userRequest);
        return sc.nextLine();
    }

    public static File getOrCratePhoneBookFile(String phoneBookFilePath) {
        // File phoneBookFile = new File("./phoneBookFile.csv");
        File phoneBookFile = new File(phoneBookFilePath);

        if (phoneBookFile.exists()) {
            System.out.println("File exist !");
            return phoneBookFile;
        }

        try {
            System.out.println("WRN:" + phoneBookFilePath + " File does not exist !");
            phoneBookFile.createNewFile();
            System.out.println("Creating file ok");
            return phoneBookFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void appendContactToPhoneBook(File phoneBookFile, Contact newContact) {

        // Permetre, si une varible doit etre fermée, de directement l'instancier pour
        // qu'elle soit fermée automatiquement
        try (BufferedWriter fileWriter = new BufferedWriter(
                new FileWriter(phoneBookFile, true))) {

            fileWriter.append(newContact.toString());
            // fileWriter.append("\n");
            fileWriter.append(System.lineSeparator());
            // fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}