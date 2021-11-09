package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        LocalDate epoch = LocalDate.EPOCH;
        System.out.println(epoch); //Early Unix engineers picked that date arbitrarily because they needed to set a uniform date for the start of time, and New Year's Day, 1970, seemed most convenient.
        LocalDate now = LocalDate.now();
        LocalDate dob = LocalDate.of(1992,6,19);
        Period period = Period.between(dob, now);
        System.out.println(period.getYears());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj swoją datę urodzenia (dd-mm-yyyy):");
        String input = scanner.nextLine();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(input);
        Instant instant = date.toInstant();
        ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
        LocalDate givenDate = zone.toLocalDate();
        Period period1 = Period.between(givenDate, now);
        System.out.println("Twój wiek to: " + period1.getYears()+ " lat.");
    }

}
