package com.basics;

import java.io.*;
import java.io.IOException;
import java.util.*;

public class PhoneBook {

    public static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        String userLastName = getUserInput("Entrez un nom de famille :");
        String userFirstName = getUserInput("Entrez un prénom :");
        String userPhoneNumber = getUserInput("Entrez un numéro de téléphone :");

        Contact newContact = new Contact(userLastName, userFirstName, userPhoneNumber);

        File phoneBookFile = new File("./phoneBookFile.csv");

        if (phoneBookFile.exists()) {
            System.out.println("File exist !");
        } else {
            System.out.println("WRB: File does not exist !");
            try {
                phoneBookFile.createNewFile();
                System.out.println("Creating file ok");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(phoneBookFile, true));
            fileWriter.append(newContact.toString());
            fileWriter.append("\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(newContact.toString());
        sc.close();
    }

    public static String getUserInput(String userRequest) {

        System.out.println(userRequest);
        return sc.nextLine();
    }
}