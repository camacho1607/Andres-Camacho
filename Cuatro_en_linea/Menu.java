
/**
 * Esta clase es el menu del juego en el cual el usuario ingresa el modo de juego que quiera.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class Menu
{
    int opcion;
    public static void menu(String args[])
    {
        Juego jugar= new Juego();
        Menu menu= new Menu();
        menu.setOpcion(Integer.parseInt(JOptionPane.showInputDialog("Elija el modo de juego que desee:\n"+"1. Un jugador.\n"+"2. Dos jugadores")));
        jugar.setModoJuego(menu.getOpcion());
        jugar.jugar();
        
    }
    public void setOpcion(int opcion)
    {
        this.opcion=opcion;
    }
    public Integer getOpcion()
    {
        return this.opcion;
    }
}
