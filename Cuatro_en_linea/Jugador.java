
/**
 * En la clase Jugador es en la cual los usuarios ingresan sus nombres
 *
 * @author Andres Camacho
 * @version 7/10/2020
 */
import javax.swing.JOptionPane;
import java.util.Random;
public class Jugador
{
    /*
     * el metodo ingresarJugador() lo que hace es utilizar JOptionPane para preguntarle a los posibles jugadores sus nombres
     */
    public String ingresarJugador()
    {
        String jugador;
        jugador= JOptionPane.showInputDialog("Ingrese el nombre del jugador.");
        return jugador;
        
    }
    /*
     * generarJugador es el metodo que se invoca en caso de que el usuareio decida jugar contra un jugador virtual
     * y este crea un numnero aleatorio para seleccionar de una pila de nombres predeterminados.
     */
    public String generarJugador()
    {
        Random rand= new Random();
        
        String nombreCPU="El pepe";
        boolean esCero= true; 
        while(esCero== true)
        { 
            int nombrePredetermninado= rand.nextInt(7);
            if (nombrePredetermninado>0)
            {
                switch(nombrePredetermninado)
                {
                    case 1: 
                    nombreCPU= "Alpha";
                    return nombreCPU;
                    case 2:
                    nombreCPU= "Bravo";
                    return nombreCPU;
                    case 3:
                    nombreCPU= "Charlie";
                    return nombreCPU;
                    case 4:
                    nombreCPU= "Delta";
                    return nombreCPU;
                    case 5:
                    nombreCPU= "Echo";
                    return nombreCPU;
                    case 6:
                    nombreCPU= "Foxtrot";
                    return nombreCPU;
                }
                esCero= false;
            }
        }
        return nombreCPU;
    }
}
