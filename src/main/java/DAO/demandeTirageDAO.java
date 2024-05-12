package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.demandeTirage;

public class demandeTirageDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/photocopy?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_DEMANDE_TIRAGE_SQL = "INSERT INTO demandetirages" +
            "  (user_id, matier_id, dateArriver, nbCopier, statu) VALUES " +
            " (?, ?, ?, ?, ?);";

    private static final String SELECT_DEMANDE_TIRAGE_BY_ID = "SELECT * FROM demandetirages WHERE id = ?";
    private static final String SELECT_ALL_DEMANDES_TIRAGE = "SELECT * FROM demandetirages";
    private static final String DELETE_DEMANDE_TIRAGE_SQL = "DELETE FROM demandetirages WHERE id = ?;";
    private static final String UPDATE_DEMANDE_TIRAGE_SQL = "UPDATE demandetirages SET user_id = ?, matier_id = ?, dateArriver = ?, nbCopier = ?, statu = ? WHERE id = ?;";
    private static final String UPDATE_DEMANDE_TIRAGE_STATUS_TO_1_SQL = "UPDATE demandetirages SET statu = 1 WHERE id = ?";
    private static final String UPDATE_DEMANDE_TIRAGE_STATUS_TO_2_SQL = "UPDATE demandetirages SET statu = 2 WHERE id = ?";

    public demandeTirageDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertDemandeTirage(demandeTirage demandeTirage) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DEMANDE_TIRAGE_SQL)) {
            preparedStatement.setInt(1, demandeTirage.getUser_id());
            preparedStatement.setInt(2, demandeTirage.getMatier_id());
            preparedStatement.setString(3,demandeTirage.getDateArriver());
            preparedStatement.setInt(4, demandeTirage.getNbCopier());
            preparedStatement.setInt(5, demandeTirage.getStatu());
            preparedStatement.executeUpdate();
        }
    }

    public demandeTirage selectDemandeTirage(int id) {
        demandeTirage demandeTirage = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DEMANDE_TIRAGE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                 int user_id = rs.getInt("user_id");
                int matier_id = rs.getInt("matier_id");
                String dateArriver = rs.getString("dateArriver");
                int nbCopier = rs.getInt("nbCopier");
                int statu = rs.getInt("statu");

                demandeTirage = new demandeTirage(id, user_id, matier_id, dateArriver, nbCopier, statu);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return demandeTirage;
    }

    public List<demandeTirage> selectAllDemandesTirage() {
        List<demandeTirage> demandesTirage = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DEMANDES_TIRAGE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int matier_id = rs.getInt("matier_id");
                String dateArriver = rs.getString("dateArriver");
                int nbCopier = rs.getInt("nbCopier");
                int statu = rs.getInt("statu");

                demandesTirage.add(new demandeTirage(id, user_id, matier_id, dateArriver, nbCopier, statu));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return demandesTirage;
    }

    public boolean deleteDemandeTirage(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_DEMANDE_TIRAGE_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateDemandeTirage(demandeTirage demandeTirage) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_DEMANDE_TIRAGE_SQL)) {
            statement.setInt(1, demandeTirage.getUser_id());
            statement.setInt(2, demandeTirage.getMatier_id());
            statement.setString(3, demandeTirage.getDateArriver());
            statement.setInt(4, demandeTirage.getNbCopier());
            statement.setInt(5, demandeTirage.getStatu());
            statement.setInt(6, demandeTirage.getId());

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
    public boolean updateDemandeTirageStatusTo1(int id) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_DEMANDE_TIRAGE_STATUS_TO_1_SQL)) {
            statement.setInt(1, id);
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean updateDemandeTirageStatusTo0(int id) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_DEMANDE_TIRAGE_STATUS_TO_2_SQL)) {
            statement.setInt(0, id);
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
