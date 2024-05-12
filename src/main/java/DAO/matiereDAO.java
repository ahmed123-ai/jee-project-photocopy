package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.matiere; // Assuming your subject model is named "Matiere"

public class matiereDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/photocopy?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_MATIERE_SQL = "INSERT INTO matieres (label, groupe_id) VALUES (?, ?)";
    private static final String SELECT_MATIERE_BY_ID = "SELECT id, label, groupe_id FROM matieres WHERE id = ?";
    private static final String SELECT_ALL_MATIERES = "SELECT id, label, groupe_id FROM matieres";
    private static final String DELETE_MATIERE_SQL = "DELETE FROM matieres WHERE id = ?";
    private static final String UPDATE_MATIERE_SQL = "UPDATE matieres SET label = ?, groupe_id = ? WHERE id = ?";

    public matiereDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertMatiere(matiere matiere) throws SQLException {
        try (Connection connection = getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MATIERE_SQL)) {
            preparedStatement.setString(1, matiere.getLabel());
            preparedStatement.setInt(2, matiere.getGroup_id());
            preparedStatement.executeUpdate();
            
            System.out.println(preparedStatement);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public matiere selectMatiere(int id) {
        matiere matiere = null;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MATIERE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String label = rs.getString("label");
                int groupeId = rs.getInt("groupe_id");
                matiere = new matiere(id, label, groupeId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return matiere;
    }

    public List<matiere> selectAllMatieres() {
        List<matiere> matieres = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MATIERES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String label = rs.getString("label");
                int groupeId = rs.getInt("groupe_id");
                matieres.add(new matiere(id, label, groupeId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return matieres;
    }

    public boolean deleteMatiere(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); 
             PreparedStatement statement = connection.prepareStatement(DELETE_MATIERE_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateMatiere(matiere matiere) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); 
             PreparedStatement statement = connection.prepareStatement(UPDATE_MATIERE_SQL)) {
            statement.setString(1, matiere.getLabel());
            statement.setInt(2, matiere.getGroup_id());
            statement.setInt(3, matiere.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
