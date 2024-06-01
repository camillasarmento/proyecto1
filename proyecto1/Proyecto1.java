package proyecto1;



public class Proyecto1 {

    public static void main(String[] args) {
        VehiculoDAO dao = new VehiculoDAO();
        // Insertar un nuevo vehículo
        VehiculoDAO.insertVehiculo(0, "Sedan", "Lada", 150, "27-04-2016");

        // Consultar todos los vehículos
        System.out.println("Lista de vehiculos:");
        VehiculoDAO.consultarTodosVehiculos();

        // Consultar un vehicúlo por su ID
        Vehiculo selectedVehiculo = dao.getVehiculoId(3);
        System.out.println(selectedVehiculo);

        // Eliminar un vehículo por su ID
        VehiculoDAO.deleteVehiculo(1);

        // Actualizar los datos de un vehículo
            if (selectedVehiculo != null) {
            selectedVehiculo.setPotencia(160);
            dao.updateVehiculo(selectedVehiculo);
        }

        // Obtener la potencia media según el tipo de vehículo
        double avgPotencia = dao.getAveragePotenciaByTipo("Sedan");
        System.out.println("Average Potencia: " + avgPotencia);

        // Obtener la potencia máxima según el tipo de vehículo
        int maxPotencia = dao.getMaxPotenciaByTipo("Sedan");
        System.out.println("Maximum Potencia: " + maxPotencia);


    }
}