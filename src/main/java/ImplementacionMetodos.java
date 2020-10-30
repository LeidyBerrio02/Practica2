
import java.util.List;
import java.util.Scanner;

public class ImplementacionMetodos {
//Implementacion de metodos de la clase Cliente

    /*Metodo ingresar 
    añade clientes al arraylist de tipo cliente dependiendo de la cantidad ingresada por el usuario*/
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
// asignacion
            cliente.add(i, objC);

        }
    }

    /*Metodo consigancion
    valida si el arraylist cliente de tipo cliente esta vacio 
    si no realiza consignacion a cliente por medio de cedula sumando el valor de consignacion a saldo ya existente*/
    public static void consignacion(Scanner leer, List<Cliente> cliente) {
        boolean conf = false; //variable para confirmar si cliente existe 

        if (cliente.isEmpty()) {//validacion que existan registros en el arraylist tipo cliente
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
                        System.out.println("Cliente " + cliente1.getNombre());
                        //variable nuevo almacenara el nuevo saldo que tendra el cliente (saldo anterior+consignacion)
                        double nuevo = (cliente1.getSaldo()) + sal;
                        //se envia nuevo saldo por medio del metodo setSaldo
                        cliente1.setSaldo(nuevo);
                        System.out.println("Nuevo saldo: " + cliente1.getSaldo());
                        conf = true; //sliente existe y la consignacion fue exitosa
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Ocurrio un error: " + ex.getMessage());
                }
            }
            if (conf == false) {
                //se imprime mensaje al validar que el cliente no fue encontrado
                System.out.println("Cliente no encontrado");
            }
        }
    }

    /*Metodo transfencia de saldo por medio de ambas cedulas de clientes
    
     */
    public static void transferenciaSaldo(Scanner leer, List<Cliente> cliente) {
        boolean confRemi = false, confDes = false; //variables de validacion de existencia de clientes
        if (cliente.isEmpty()) { //validacion que existan registros en el arraylist tipo cliente
            System.out.println("No ha creado clientes");
        } else {
            //se pide informacion de ambos clientes
            System.out.println("Transferencia de Saldo");
            System.out.println("Ingrese cedula de cliente remitente");
            String rem = leer.nextLine();
            System.out.println("Ingrese cedula de cliente destinatario");
            String des = leer.nextLine();
            for (int i = 0; i < cliente.size(); i++) { // iteracion pata cliente i (remitente)
                for (int j = 0; j < cliente.size(); j++) { //iteracion para cliente j (destinatario)
// validacion por medio de cedula de que ambos registros de clientes existan 
                    if (rem.equals(cliente.get(i).getCedula())) {
                        confRemi = true;

                        if (des.equals(cliente.get(j).getCedula())) {
                            confDes = true;

                            System.out.println("Ingrese valor a tranferir: ");
                            double valor = Double.parseDouble(leer.nextLine());
                            //se valida que el valor sea correcto 
                            if (valor > 0 && valor < cliente.get(i).getSaldo()) {
                                /*se crean variables receptoras las cuales almacenaran 
                                los nuevos valores que tendran ambos saldos*/
                                double nuevoValorR = (cliente.get(i).getSaldo()) - valor;
                                double nuevoValorD = (cliente.get(j).getSaldo()) + valor;
                                //se asignan nuevos valores por medio del metodo set
                                cliente.get(i).setSaldo(nuevoValorR);
                                cliente.get(j).setSaldo(nuevoValorD);
                                //transferencia exitosa
                                System.out.println("Valor transferido: " + valor + " a " + cliente.get(j).getNombre());
                            }
                        }
                    }
                }
            }
            if (confRemi == false) {
                //se imprime mensaje al validar que el cliente no fue encontrado

                System.out.println("No se encontro cliente remitente");
            }
            if (confDes == false) {
                //se imprime mensaje al validar que el cliente no fue encontrado

                System.out.println("No se encontro cliente destinatario");
            }
        }

    }

    /*Metodo consultar saldo de cliente por medio de cedula*/
    public static void consultarSaldoCliente(Scanner leer, List<Cliente> cliente) {
        boolean conf = false; //variable para confirmar por medio de mensaje si el registro del cliente existe o no
        if (cliente.isEmpty()) {//validacion que existan registros en el arraylist tipo cliente
            System.out.println("No ha creado clientes");
        } else {
            System.out.println("Mostrar saldo de un cliente");
            System.out.println("Ingrese cedula de cliente");
            String ced = leer.nextLine();
            for (int i = 0; i < cliente.size(); i++) {
                // se valida que la cedula ingresada exista
                if (ced.equals(cliente.get(i).getCedula())) {
                    // se muestra saldo correspondiente de cliente
                    System.out.println("Cliente " + cliente.get(i).getNombre() + " saldo: " + cliente.get(i).getSaldo());
                    conf = true;
                }
                //System.out.println("No existe cliente");
            }
            if (conf == false) {
                                //se imprime mensaje al validar que el cliente no fue encontrado

                System.out.println("Cliente no encontrado, no se pudo realizar busqueda ");
            }
        }

    }

    public static void consultarClientes(List<Cliente> cliente) {
        if (cliente.isEmpty()) {//validacion que existan registros en el arraylist tipo cliente
            System.out.println("No ha creado clientes");
        } else {
            System.out.println("Mostrando todos los clientes");
            // se accede a tamaño de ArrayList por medio de funcion size();
            for (int i = 0; i < cliente.size(); i++) {
                //se itera para registro existente en el ArrayList y se muestra 
                System.out.println((i + 1) + ": " + cliente.get(i));
                
            }
        }
        System.out.println("\n");
    }

    public static void eliminarCliente(Scanner leer, List<Cliente> cliente) {
        if (cliente.isEmpty()) {//validacion que existan registros en el arraylist tipo cliente
            System.out.println("No ha creado clientes");
        } else {
            System.out.println("Eliminar cliente");
            System.out.println("Ingrese cedula de cliente a eliminar");
            String elim = leer.nextLine();
            boolean conf = false; //variable para confirmar por medio de mensaje si el registro del cliente existe o no
            for (int i = 0; i < cliente.size(); i++) {
                //validacion si la cedula ingresada existe en el array
                if (elim.equals(cliente.get(i).getCedula())) {
                    //se remueve persona por medio de metodo remove en la posicion en la cual fue encontrado el registro
                    cliente.remove(i);
                    conf = true;
                }
            }
            if (conf == false) {
                                //se imprime mensaje al validar que el cliente no fue encontrado

                System.out.println("Cliente no encontrado, no se pudo realizar eliminacion ");
            } else {
                System.out.println("Se realizo eliminacion correctamente");
            }
        }

    }

}
