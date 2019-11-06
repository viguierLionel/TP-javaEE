/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;


public class DAO {


    protected final DataSource myDataSource;
    
    	/**
	 *
	 * @param dataSource la source de données à utiliser
	 */
    public DAO(DataSource dataSource) {
	this.myDataSource = dataSource;
    }
    
    /**
     *
     * @throws DAOException
     */
    public int supprimerCode(String codeId) throws DAOException{
    // Une requête SQL paramétrée
		String sql = "DELETE FROM Discount_Code WHERE discount_code = ?";
		try (   Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)
                ) {
                        // Définir la valeur du paramètre
			stmt.setString(1, codeId);
			
			return stmt.executeUpdate();

		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
}
    public int ajouterCode(String a,float b ) throws DAOException, SQLException {
            String sql = "INSERT INTO DISCOUNT_CODE (DISCOUNT_CODE,RATE) VALUE (?,?)";
            try (   Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)
		) {
                    stmt.setString(1, a);
                    stmt.setFloat(2, b);
                    return stmt.executeUpdate();
                    
                }
           catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
        }
    public CodeEntity findCode(int codeID) throws DAOException {
		CodeEntity result = null;

		String sql = "SELECT * FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
		try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, codeID);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) { // On a trouvé
					float taux = rs.getFloat("RATE");
					
					// On crée l'objet "entity"
					result = new CodeEntity(codeID, taux);
				} // else on n'a pas trouvé, on renverra null
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return result;
	}

        
}
    
   

