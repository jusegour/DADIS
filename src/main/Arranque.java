/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import vista.Login;



/**
 *
 * @author PC5
 */
public class Arranque {

    public static void main(String args[]) {
        try {
            Login l=new Login();
            l.setVisible(true);
            l.setLocationRelativeTo(null);
        } catch (ParseException ex) {
            Logger.getLogger(Arranque.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Arranque.class.getName()).log(Level.SEVERE, null, ex);
        }
              
       

    }

}
