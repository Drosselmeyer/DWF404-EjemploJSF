package sv.edu.udb.www.dao;

import sv.edu.udb.www.database.DatabaseConnection;
import sv.edu.udb.www.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {

    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setRoleName(rs.getString("role_name"));
                roles.add(role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }
}