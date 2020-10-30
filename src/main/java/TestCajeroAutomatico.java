
import java.util.*;

public class TestCajeroAutomatico {

    public static void main(String[] args) {
        //creacion de ArrayList tipo Cliente
        List<Cliente> cliente = new ArrayList();
        
        //funcion Scanner para leer los datos ingresados por consola 
        Scanner leer = new Scanner(System.in);
        int opcion;
        do {

            System.out.println("\n Ingrese una opcion: \n "
                    + "1. Registrar Cliente(s). \n "
                    + "2. Realizar Consignacion. \n "
                    + "3. Transferencia de Saldo. \n "
                    + "4. Mostrar saldo de un cliente. \n "
                    + "5. Mostrar todos los clientes. \n "
                    + "6. Eliminar cliente. \n "
                    + "7. Salir. \n ");
            opcion = Integer.parseInt(leer.nextLine().trim());
            System.out.println("\n");
            switch (opcion) {
                case 1:
                    ImplementacionMetodos.ingresarClientes(leer, cliente);
                    break;
                case 2:
                    ImplementacionMetodos.consignacion(leer, cliente);
                    break;
                case 3:
                    ImplementacionMetodos.transferenciaSaldo(leer, cliente);
                    break;
                case 4:
                    ImplementacionMetodos.consultarSaldoCliente(leer, cliente);
                    break;
                case 5:
                    ImplementacionMetodos.consultarClientes(cliente);
                    break;
                case 6:
                    ImplementacionMetodos.eliminarCliente(leer, cliente);
                    break;
                default:
                    break;
            }

        } while (opcion != 7);

    }

}
