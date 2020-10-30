/*Crearacion de clase con atributos metodos setters, getters y toString  */
public class Cliente {
//atributos
    private String cedula;
    private String nombre;
    private double saldo;

    public Cliente() {

    }
// constructor
    public Cliente(String cedula, String nombre, double saldo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.saldo = saldo;
    }
//metodos set y get
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return this.cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //metodo tostring heredado de clase padre object
    @Override
    public String toString() {
        return "Cliente{" + "cedula=" + cedula + ", nombre=" + nombre + ", saldo=" + saldo + '}';
    }

}
