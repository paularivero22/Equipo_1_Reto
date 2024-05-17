/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadextraescolar;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Usuario
 */
public class ValidaDatos {
    
    public static String ValidaDNI() {
        String DNI = "";
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("DNI de la persona:");
            DNI = teclado.nextLine();
        } while (!ValidarDNI(DNI));

        return DNI;
    }

    public static boolean ValidarDNI(String DNI) {
        boolean solucion = false;

        // Validamos que la longitud sea 9
        if (DNI.length() == 9 && Character.isLetter(DNI.charAt(8))) {
            // Validamos que los primeros 8 caracteres sean números
            try {
                int DNINumerico = Integer.parseInt(DNI.substring(0, 8));
                int resto = DNINumerico % 23;
                char letraValida = "TRWAGMYFPDXBNJZSQVHLCKE".charAt(resto);

                // Validamos la letra del DNI
                if (DNI.charAt(8) == letraValida) {
                    solucion = true;
                }
            } catch (NumberFormatException e) {
                // La parte numérica del DNI no es un número válido
                solucion = false;
            }
        }

        return solucion;
    }
    
    public static String ValidaEmail() {
        String email = "";
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("Correo electrónico de la persona:");
            email = teclado.nextLine();
        } while (!ValidarEmail(email));

        return email;
    }

    public static boolean ValidarEmail(String email) {
        boolean solucion = false;

        // Expresión regular para validar el correo electrónico
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            solucion = true;
        }

        return solucion;
    }



}
