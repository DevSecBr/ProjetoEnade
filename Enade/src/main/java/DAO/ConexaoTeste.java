/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author joaod
 */
public class ConexaoTeste {

    public static void main(String[] args) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            System.out.println("Conexão estabelecida com sucesso!");
            SpringApplication.run(Application.class, args);

            connection.close();
        } catch (SQLException e) {
            System.out.println("Falha ao estabelecer a conexão!");

            e.printStackTrace();
        }
    }
}
