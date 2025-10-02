package moisoft;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoMoi {

    private static final String URL = "jdbc:postgresql://localhost:5432/MoiSoft";
    private static final String USER = "postgres";
    private static final String PASS = "mehu";

    
    public void insertMoi(ModelMoi model) throws SQLException {
        String sql = "INSERT INTO moi(name, place, amount) VALUES (?, ?, ?)";
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, model.getName());
        ps.setString(2, model.getPlace());
        ps.setDouble(3, model.getAmount());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    
    public List<ModelMoi> getAllMoi() throws SQLException {
        List<ModelMoi> list = new ArrayList<>();
        String sql = "SELECT id, name, place, amount FROM moi";
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            list.add(new ModelMoi(
                rs.getString("name"),
                rs.getString("place"),
                (float) rs.getDouble("amount") 
            ));
        }

        rs.close();
        stmt.close();
        con.close();
        return list;
    }


    public void updateAmountByName(String name, double newAmount) throws SQLException {
        String sql = "UPDATE moi SET amount = ? WHERE name = ?";
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, newAmount);
        ps.setString(2, name);
        ps.executeUpdate();
        ps.close();
        con.close();
    }

  
    public void deleteByName(String name) throws SQLException {
        String sql = "DELETE FROM moi WHERE name = ?";
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.executeUpdate();
        ps.close();
        con.close();
    }

  
    public List<ModelMoi> findByName(String name) throws SQLException {
        List<ModelMoi> list = new ArrayList<>();
        String sql = "SELECT id, name, place, amount FROM moi WHERE name = ?";
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new ModelMoi(
                rs.getString("name"),
                rs.getString("place"),
                (float) rs.getDouble("amount")
            ));
        }

        rs.close();
        ps.close();
        con.close();
        return list;
    }
}
