package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.Eleitor;

/**
 *
 * @author Israel
 */
public class eleitorDAO extends ExecuteSQL{
    public eleitorDAO(Connection con){
        super(con);
    }
    
    public String salvar(Eleitor eleitor){
        String sql = "INSERT INTO eleitor VALUES(?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);  
            ps.setString(1, eleitor.getNome());
            ps.setString(2, eleitor.getCpf());
            if(ps.executeUpdate() > 0){
                return "Eleitor Inserido com sucesso";
            }else{
                return "Erro ao Inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
}