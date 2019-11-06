/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


// Une classe d'exceptions spécifiques pour le DAO
public class DAOException extends Exception {
    
    public DAOException(String message) {
        super(message);
    }
    
}