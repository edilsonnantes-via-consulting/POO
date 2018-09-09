/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Conexao.ConnectionFactory;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.PreparedStatement;
import Conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gutto
 */
public class conexaoCliente {
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
    public boolean cadastroCliente(Cliente cli){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        if (cli.getNome().equals("")){
                ConnectionFactory.closeConnection(con, stmt);
                return false;   
            }
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO CLIENTE VALUES(?,?,?)");
            
            stmt.setString(1, cli.getCPF());
            stmt.setString(2, cli.getNome());
            stmt.setInt(3, (int) cli.getEnderecoId());
            stmt.executeUpdate();
            
            ConnectionFactory.closeConnection(con, stmt);
            return true;
            
        } catch (SQLException ex) {
            
            Logger.getLogger(conexaoModalidade.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionFactory.closeConnection(con, stmt);
            return false;
        }
    }
    
    public Cliente readInfo(int cli_codigo){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
        
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM CLIENTE WHERE cli_codigo = ?");
            stmt.setInt(1, cli_codigo);
            
            rs = stmt.executeQuery();
            
            Cliente cli = new Cliente();
            
            while(rs.next()){
            
                cli.setNome(rs.getString("cli_nome"));
                cli.setCPF(rs.getString("cli_cpf"));
                cli.setEnderecoId(rs.getInt("end_codigo"));
            
            }
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            return cli;
            
        
        } catch(SQLException ex){
            
            Logger.getLogger(conexaoModalidade.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionFactory.closeConnection(con, stmt, rs);
            return null;
        
        }
    
    }
    
        
}
