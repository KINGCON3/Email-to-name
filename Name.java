package com.code;
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Name {
    public static void main(String[] args) throws Exception {
        String person;
        System.out.println("Write the start of the email of a member of staff/researcher");
        Scanner sc = new Scanner(System.in);
        person = sc.nextLine();
        try{
            URL url = new URL("https://www.ecs.soton.ac.uk/people/" + person);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null)
                  if ((line.indexOf("<em property=", 0)) > -1) {
                      int index1 = (line.indexOf("compressed\" property=", 0) + 28);
                      int index2 = (line.indexOf("<em property=", 0));
                      System.out.println(line.substring(index1, index2));
              }
            reader.close();
        }catch(Exception ex){
            System.out.println("Name doesn't exist for email " + person);
        }
    }
}