import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/estudiates2024";
        String user = "root";
        String password = "123456";

        String cedula= "0022342650";

        String sql = "DELETE FROM estudiantes WHERE cedula = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = conn.prepareStatement(sql))
        {
            statement.setString(1, cedula);

            int filasEliminadas = statement.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("El estudiante " + cedula + " ha sido eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún estudiante con cedula " + cedula + " para eliminar.");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            // throw new RuntimeException(e);
        }
    }
}


