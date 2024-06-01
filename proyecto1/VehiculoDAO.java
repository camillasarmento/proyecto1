package proyecto1;

import java.sql.*;



/**
 *
 * @author Camilla
 */
public class VehiculoDAO {

    public static void consultarTodosVehiculos() {
        String query = "SELECT * FROM vehiculo";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id_vehiculo = rs.getInt("id_vehiculo");
                String tipo = rs.getString("tipo");
                String marca = rs.getString("marca");
                int potencia = rs.getInt("potencia");
                String fecha_compra = rs.getString("fecha_compra");
                System.out.println(" ID_Vehiculo: " + id_vehiculo + " , tipo: " + tipo + " , marca: " + marca + " " +
                        ", potencia: " + potencia + "fecha de compra: " + fecha_compra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public Vehiculo getVehiculoId(int id) {
        String sql = "SELECT id_vehiculo, tipo, marca, potencia, fecha_compra FROM vehiculo WHERE id_vehiculo = ?";
        Vehiculo vehiculo = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                vehiculo = new Vehiculo(
                        rs.getInt("id_vehiculo"),
                        rs.getString("tipo"),
                        rs.getString("marca"),
                        rs.getInt("potencia"),
                        rs.getString("fecha_compra")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vehiculo;
    }


    public static void insertVehiculo(int id_vehiculo, String tipo, String marca, int potencia, String fecha_compra) {
        String query = "INSERT INTO vehiculo (id_vehiculo, tipo, marca, potencia,fecha_compra) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id_vehiculo);
            pstmt.setString(2, tipo);
            pstmt.setString(3, marca);
            pstmt.setInt(4, potencia);
            pstmt.setString(5, fecha_compra);
            pstmt.executeUpdate();
            System.out.println("Se ha agregado el vehiculo");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleteVehiculo(int id_vehiculo) {
    String query = "DELETE FROM vehiculo where id_vehiculo =?;";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, id_vehiculo);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }


    public void updateVehiculo(Vehiculo vehiculo) {
        String sql = "UPDATE vehiculo SET tipo = ?, marca = ?, potencia = ?, fecha_compra = ? WHERE id_vehiculo = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vehiculo.getTipo());
            pstmt.setString(2, vehiculo.getMarca());
            pstmt.setInt(3, vehiculo.getPotencia());
            pstmt.setString(4, vehiculo.getFecha_compra());
            pstmt.setInt(5, vehiculo.getId_vehiculo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getAveragePotenciaByTipo(String tipo) {
        String sql = "SELECT AVG(potencia) AS avg_potencia FROM vehiculo WHERE tipo = ?";
        double avgPotencia = 0;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tipo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                avgPotencia = rs.getDouble("avg_potencia");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return avgPotencia;
    }

    public int getMaxPotenciaByTipo(String tipo) {
        String sql = "SELECT MAX(potencia) AS max_potencia FROM vehiculo WHERE tipo = ?";
        int maxPotencia = 0;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tipo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                maxPotencia = rs.getInt("max_potencia");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return maxPotencia;
    }

}

