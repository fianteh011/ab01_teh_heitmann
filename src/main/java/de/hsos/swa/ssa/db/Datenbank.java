package de.hsos.swa.ssa.db;

import java.sql.*;

/**
 * Inspiriert von Tutorials:
 * Quelle1: https://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm
 * Quelle2: https://www.youtube.com/watch?v=B928IDexsGk
 * --> Java, JDBC und MySQL-Datenbank (einfaches Beispiel)*/

public class Datenbank {
    static final String DB_URL = "jdbc:mysql://localhost:3306/swashop";
    static final String USER = "root";
    static final String PW = "sheiSef8cken909";


    public static void main(String[] args) {

        try (
                //lege Connection an
                //Verbindungsaufbau -->" try with resource" - Ansatz
                //hat zur Folge: die Verbindung die aufgebaut wird, wird automatisch am Ende geschlossen
                Connection conn = DriverManager.getConnection(DB_URL, USER, PW)){

            if (conn != null){
                System.out.println("Connected to DB!");
            } else {
                System.out.println("Connection error, please try again!");
            }

        } catch (SQLException e){
            System.err.println(e.getMessage());
        }

    }
}
