package proyecto1;

import java.util.Date;

public class Vehiculo {
    private int id_vehiculo;
    private String tipo;
    private String marca;
    private int potencia;
    private String fecha_compra;


    public Vehiculo(int id_vehiculo, String tipo, String marca, int potencia, String fecha_compra) {
        this.id_vehiculo = id_vehiculo;
        this.tipo = tipo;
        this.marca = marca;
        this.potencia = potencia;
        this.fecha_compra = fecha_compra;
    }
    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }


}


