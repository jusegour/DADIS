/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.net.*;

/**
 *
 * @author PC5
 */
public class Arranque {

    public static void main(String args[]) {
        try {
            String destinatario = "3217758511";
            String message = "Hello World";
            String username = "admin";
            String password = "3217758511";
            String emisor = "06201234567";

            String requestUrl = "http://127.0.0.1:9501/api?action=sendmessage&"
                    + "username=" + URLEncoder.encode(username, "UTF-8")
                    + "&password=" + URLEncoder.encode(password, "UTF-8")
                    + "&recipient=" + URLEncoder.encode(destinatario, "UTF-8")
                    + "&messagetype=SMS:TEXT"
                    + "&messagedata=" + URLEncoder.encode(message, "UTF-8")
                    + "&originator=" + URLEncoder.encode(emisor, "UTF-8")
                    + "&serviceprovider=GSMModem1"
                    + "&responseformat=html";

            URL url = new URL(requestUrl);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();

            System.out.println(uc.getResponseMessage());

            uc.disconnect();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

    }

}
