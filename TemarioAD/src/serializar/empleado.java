package serializar;

import java.io.*;
import java.util.Date;
import java.util.GregorianCalendar;

public class empleado {

    private static final long serialVersionUID = 1L;
    /**
     *
     */
//		private static final long serialVersionUID = 5153895889337714012L;
    private /* transient */String nombre;
    private /* transient */double sueldo;
    private /* transient */ Date fechaContrato;

    public empleado(String nombre, double sueldo, int anio, int mes, int dia) {
        super();
        this.nombre = nombre;
        this.sueldo = sueldo;
        GregorianCalendar calendario = new GregorianCalendar(anio, mes - 1, dia);
        this.fechaContrato = calendario.getTime();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + ", sueldo=" + sueldo + ", fechaContrato=" + fechaContrato + "]";
    }

}

class Administrador extends empleado {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
//		private static final long serialVersionUID = -5118326484412875070L;
    private double incentivo;

    public Administrador(String nombre, double sueldo, int anio, int mes, int dia, double incentivo) {
        super(nombre, sueldo, anio, mes, dia);
    }

    public double getIncentivo() {
        return incentivo;
    }

    public void setIncentivo(double incentivo) {
        this.incentivo = incentivo;
    }

    @Override
    public String toString() {
        return "Administrador [incentivo=" + incentivo + ", getNombre()=" + getNombre() + ", getSueldo()=" + getSueldo()
                + ", getFechaContrato()=" + getFechaContrato() + ", toString()=" + super.toString() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + "]";
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Administrador jefe = new Administrador("PapiChulo", 20000, 2007, 07, 10, 3000.0);

        empleado[] personal = new empleado[3];
        personal[0] = jefe;
        personal[1] = new empleado("Pipo", 20000.0, 2005, 4, 24);
        personal[2] = new empleado("Popi", 30000.0, 2006, 5, 26);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                "C:\\Users\\Koinz\\Desktop\\Apuntes_Clase\\2º\\01-Acceso a Datos\\Ejerciciospersonal.dat"));
        oos.writeObject(personal);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                "C:\\Users\\Koinz\\Desktop\\Apuntes_Clase\\2º\\01-Acceso a Datos\\Ejerciciospersonal.dat"));
        empleado[] personalRecuperado = (empleado[]) ois.readObject();

        for (empleado e : personalRecuperado) {
            System.out.println(e);
        }
    }
}

