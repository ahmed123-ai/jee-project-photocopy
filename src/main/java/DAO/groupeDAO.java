package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.groupe;

public class groupeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/photocopy?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_GROUPE_SQL = "INSERT INTO groupes" + "  (label) VALUES " +
        " (?);";

    private static final String SELECT_GROUPE_BY_ID = "select id, label from groupes where id = ?";
    private static final String SELECT_ALL_GROUPES = "select * from groupes";
    private static final String DELETE_GROUPE_SQL = "delete from groupes where id = ?;";
    private static final String UPDATE_GROUPE_SQL = "update groupes set label = ? where id = ?";

    public groupeDAO() {}

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

    public void insertGroupe(groupe groupe) throws SQLException {
        System.out.println(INSERT_GROUPE_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GROUPE_SQL)) {
            preparedStatement.setString(1, groupe.getLabel());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public groupe selectGroupe(int id) {
        groupe groupe = null;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GROUPE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String label = rs.getString("label");
                groupe = new groupe(id, label);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return groupe;
    }

    public List<groupe> selectAllGroupes() {
        List<groupe> groupes = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_GROUPES);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String label = rs.getString("label");

                groupes.add(new groupe(id, label));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return groupes;
    }

    public boolean deleteGroupe(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_GROUPE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateGroupe(groupe groupe) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_GROUPE_SQL);) {
            statement.setString(1, groupe.getLabel());
            statement.setInt(2, groupe.getId());

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
