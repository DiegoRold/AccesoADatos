package ejFicheroObjeto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Modificar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Listar contactos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellidos: ");
                    String apellidos = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Correo Electrónico: ");
                    String correo = scanner.nextLine();
                    agenda.agregarContacto(new Contacto(nombre, apellidos, telefono, correo));
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellidos: ");
                    apellidos = scanner.nextLine();
                    Contacto contacto = agenda.buscarContacto(nombre, apellidos);
                    if (contacto != null) {
                        System.out.println(contacto);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellidos: ");
                    apellidos = scanner.nextLine();
                    System.out.print("Nuevo Teléfono: ");
                    String nuevoTelefono = scanner.nextLine();
                    System.out.print("Nuevo Correo Electrónico: ");
                    String nuevoCorreo = scanner.nextLine();
                    if (agenda.modificarContacto(nombre, apellidos, nuevoTelefono, nuevoCorreo)) {
                        System.out.println("Contacto modificado.");
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellidos: ");
                    apellidos = scanner.nextLine();
                    if (agenda.eliminarContacto(nombre, apellidos)) {
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 5:
                    agenda.listarContactos();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
