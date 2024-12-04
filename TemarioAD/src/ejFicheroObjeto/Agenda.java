package ejFicheroObjeto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Contacto> contactos;
    private final String archivo = "agenda.dat";
    private final String eliminadosArchivo = "Eliminados.txt";

    public Agenda() {
        contactos = cargarContactos();
    }

    private List<Contacto> cargarContactos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Contacto>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void guardarContactos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(contactos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
        guardarContactos();
    }

    public Contacto buscarContacto(String nombre, String apellidos) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellidos().equalsIgnoreCase(apellidos)) {
                return contacto;
            }
        }
        return null;
    }

    public boolean modificarContacto(String nombre, String apellidos, String nuevoTelefono, String nuevoCorreo) {
        Contacto contacto = buscarContacto(nombre, apellidos);
        if (contacto != null) {
            contacto.setTelefono(nuevoTelefono);
            contacto.setCorreoElectronico(nuevoCorreo);
            guardarContactos();
            return true;
        }
        return false;
    }

    public boolean eliminarContacto(String nombre, String apellidos) {
        Contacto contacto = buscarContacto(nombre, apellidos);
        if (contacto != null) {
            contactos.remove(contacto);
            guardarContactos();
            registrarEliminado(contacto);
            return true;
        }
        return false;
    }

    private void registrarEliminado(Contacto contacto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(eliminadosArchivo, true))) {
            writer.write(contacto.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listarContactos() {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }
}
