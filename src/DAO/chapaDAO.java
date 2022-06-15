package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.Chapa;

/**
 *
 * @author Israel
 */
public class chapaDAO extends ExecuteSQL{
    public chapaDAO(Connection con){
        super(con);
    }
    
    public String salvar(Chapa chapa){
        String sql = "INSERT INTO CHAPA VALUES(?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);    
            ps.setInt(1, chapa.getNumero());
            ps.setString(2, chapa.getNome());
            if(ps.executeUpdate() > 0){
                return "Chapa cadastrada com sucesso";
            }else{
                return "Erro ao cadastrar";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
}