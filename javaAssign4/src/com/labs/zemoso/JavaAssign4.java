package com.labs.zemoso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class JavaAssign4 {

    public static void main(String args[]) throws ParseException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        while(n-->0){
            String st = sc.nextLine();
            String date1 = st.substring(0,10);
            String date2 = st.substring(11);

            String date3 = st.substring(0,6) + st.substring(17);
            //System.out.println(date1 + " " + date2 + " " + date3);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate signUp = LocalDate.parse(date1, formatter);
            LocalDate signUpAnni = LocalDate.parse(date3, formatter);
            //System.out.println("signUp: " + signUp); // 2010-01-02

            LocalDate signUpPlus30 = signUpAnni.plusDays(30);
            //System.out.println("signUpPlus30: " + signUpPlus30);

            LocalDate signUpMinus30 = signUpAnni.minusDays(30);
            //System.out.println("signUpMinus30: " + signUpMinus30);

            LocalDate current = LocalDate.parse(date2, formatter);

            if(current.isBefore(signUp) || current.isEqual(signUp)|| current.isBefore(signUpMinus30))
            {
                System.out.println("No range");
                //today.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
            }
            else if(current.isAfter(signUpPlus30) || current.isEqual(signUpPlus30))
            {
                System.out.println(signUpMinus30.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " "  + signUpPlus30.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            }
            else if((current.isEqual(signUpMinus30) || current.isAfter(signUpMinus30)) && current.isBefore(signUpPlus30))
            {
                System.out.println(signUpMinus30.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " "  + current.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            }
        }
    }
}
