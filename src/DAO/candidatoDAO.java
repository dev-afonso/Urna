package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.Candidato;

/**
 *
 * @author Israel
 */
public class candidatoDAO extends ExecuteSQL{
    public candidatoDAO(Connection con){
        super(con);
    }
    
    public String salvar(Candidato candidato){
        String sql = "INSERT INTO candidato VALUES(?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);  
            ps.setInt(1, candidato.getNumero());
            ps.setString(2, candidato.getNome());
            if(ps.executeUpdate() > 0){
                return "Candidato Inserido com sucesso";
            }else{
                return "Erro ao Inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
}