package com.example.mylocalization;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Helper {
    public static String withNumberingFormat(String input) {
        try {
            double value = Double.parseDouble(input);
            return NumberFormat.getNumberInstance().format(value);
        } catch (NumberFormatException e) {
            return input;
        }
    }

    public static String withDateFormat(String inputDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

            Date date = format.parse(inputDate);

            return DateFormat.getDateInstance(DateFormat.FULL).format(Objects.requireNonNull(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return inputDate;
        }
    }

    public static String withCurrencyFormat(String price) {
        // Exchange rates for Rupiah (IDR) to USD and EUR
        double rupiahExchangeRate = 12495.95;
        double euroExchangeRate = 0.88;

        try {
            // Convert price from String to double
            double priceInDollar = Double.parseDouble(price) / rupiahExchangeRate;

            // Initialize currency format
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

            // Get the current locale of the device
            String deviceLocale = Locale.getDefault().getCountry();

            // Adjust price based on device locale
            switch (deviceLocale) {
                case "ES":
                    // If locale is Spain (ES), convert to Euro
                    priceInDollar *= euroExchangeRate;
                    break;
                case "ID":
                    // If locale is Indonesia (ID), convert to Rupiah
                    priceInDollar *= rupiahExchangeRate;
                    break;
                default:
                    // For other locales, use USD format
                    currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
                    break;
            }

            // Return the formatted currency string
            return currencyFormat.format(priceInDollar);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return price;
        }
    }
}
