
import java.util.List;
import java.util.Scanner;

public class ImplementacionMetodos {

    public static void ingresarClientes(Scanner leer, List<Cliente> cliente) {

        System.out.println("Registrando Cliente(s)");
        System.out.println("Ingrese cantidad de clientes que desea registrar: ");
        int cant = Integer.parseInt(leer.nextLine());
        for (int i = 0; i <= cant - 1; i++) {
            System.out.println("Información Requerida: " + (i + 1) + " \n Ingrese cedula");
            String cedula = leer.nextLine();
            System.out.println("Ingrese nombre");
            String nombre = leer.nextLine();
            System.out.println("Ingrese saldo");
            double saldo = Double.parseDouble(leer.nextLine());
            Cliente objC = new Cliente(cedula, nombre, saldo);

            cliente.add(i, objC);

        }
    }

    public static void consignacion(Scanner leer, List<Cliente> cliente) {
        boolean conf = false;

        if (cliente.isEmpty()) {
            System.out.println("No ha creado clientes");
        } else {
            System.out.println("Realizar Consignacion ");
            System.out.println("Ingrese cedula a consignar");
            String cedu = leer.nextLine();

            for (Cliente cliente1 : cliente) {
                try {
                    if (cedu.equals(cliente1.getCedula())) {
                        System.out.println("Ingrese saldo a consignar: ");
                        double sal = Double.parseDouble(leer.nextLine());
                        System.out.println("Cliente "+ cliente1.getNombre());
                        double nuevo = (cliente1.getSaldo()) + sal;
                        cliente1.setSaldo(nuevo);
                        System.out.println("Nuevo saldo: " + cliente1.getSaldo());
                        conf = true;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Ocurrio un error: " + ex.getMessage());
                }
            }
            if (conf == false) {
                System.out.println("Cliente no encontrado");
            }
        }
    }

    public static void transferenciaSaldo(Scanner leer, List<Cliente> cliente) {
        boolean confRemi = false, confDes = false;
        if (cliente.isEmpty()) {
            System.out.println("No ha creado clientes");
        } else {
            System.out.println("Transferencia de Saldo");
            System.out.println("Ingrese cedula de cliente remitente");
            String rem = leer.nextLine();
            System.out.println("Ingrese cedula de cliente destinatario");
            String des = leer.nextLine();
            for (int i = 0; i < cliente.size(); i++) {
                for (int j = 0; j < cliente.size(); j++) {

                    if (rem.equals(cliente.get(i).getCedula())) {
                        confRemi = true;

                        if (des.equals(cliente.get(j).getCedula())) {
                            confDes = true;

                            System.out.println("Ingrese valor a tranferir: ");
                            double valor = Double.parseDouble(leer.nextLine());
                            if (valor < cliente.get(i).getSaldo()) {
                                double nuevoValorR = (cliente.get(i).getSaldo()) - valor;
                                double nuevoValorD = (cliente.get(j).getSaldo()) + valor;
                                cliente.get(i).setSaldo(nuevoValorR);
                                cliente.get(j).setSaldo(nuevoValorD);
                                System.out.println("Valor transferido: " + valor + " a " + cliente.get(j).getNombre());
                            }
                        }
                    }
                }
            }
            if (confRemi == false) {
                System.out.println("No se encontro cliente remitente");
            }
            if (confDes == false) {
                System.out.println("No se encontro cliente destinatario");
            }
        }

    }

    public static void consultarSaldoCliente(Scanner leer, List<Cliente> cliente) {
        boolean conf = false;
        if (cliente.isEmpty()) {
            System.out.println("No ha creado clientes");
        } else {
            System.out.println("Mostrar saldo de un cliente");
            System.out.println("Ingrese cedula de cliente");
            String ced = leer.nextLine();
            for (int i = 0; i < cliente.size(); i++) {
                if (ced.equals(cliente.get(i).getCedula())) {
                    System.out.println("Cliente " + cliente.get(i).getNombre() + " saldo: " + cliente.get(i).getSaldo());
                    conf = true;
                }
                //System.out.println("No existe cliente");
            }
            if (conf == false) {
                System.out.println("Cliente no encontrado, no se pudo realizar busqueda ");
            }
        }

    }

    public static void consultarClientes(List<Cliente> cliente) {
        if (cliente.isEmpty()) {
            System.out.println("No ha creado clientes");
        } else {
            System.out.println("Mostrando todos los clientes");
            for (int i = 0; i < cliente.size(); i++) {
                System.out.println((i + 1) + ": " + cliente.get(i));
            }
        }
        System.out.println("\n");
    }

    public static void eliminarCliente(Scanner leer, List<Cliente> cliente) {
        if (cliente.isEmpty()) {
            System.out.println("No ha creado clientes");
        } else {
            System.out.println("Eliminar cliente");
            System.out.println("Ingrese cedula de cliente a eliminar");
            String elim = leer.nextLine();
            boolean conf = false;
            for (int i = 0; i < cliente.size(); i++) {
                if (elim.equals(cliente.get(i).getCedula())) {
                    cliente.remove(i);
                    conf = true;
                }
            }
            if (conf == false) {
                System.out.println("Cliente no encontrado, no se pudo realizar eliminacion ");
            } else {
                System.out.println("Se realizo eliminacion correctamente");
            }
        }

    }

}
