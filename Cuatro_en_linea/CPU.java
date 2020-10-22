
/**
 * CPU es la clase que se encarga de hacer movidas como jugador virtual
 *
 * @author Andres Camacho
 * @version 9/10/2020
 */
import java.util.Random;

public class CPU
{
    /*
     * generaMovida lo que hace es que en caso de que el usuario este jugando solo genera un numero aleatorio del 1 al 7
     */
    public Integer generarMovida()
    {
        Random rand= new Random();
        int movida= rand.nextInt(7)+1;
        return movida;
    }
}
