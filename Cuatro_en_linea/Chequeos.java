/**
 * Esta clase esa la que se encarga de realizar los chequeos para verificar si hay 4 fichas en linea
 *
 * @author Andres Camacho
 * @version 11/10/2020
 */
public class Chequeos
{
    boolean cuatroEnLinea= false;
    int fichasIguales;
    /*
     * metodo principal de la clase que llama a los 3 diferentes tipos de chequeos
     * @param fila recibe como entrada el valor de la fila de la jugada mas reciente
     * @param columna recibe como entrada el valor de la columna de la jugada mas reciente
     */
    public Integer chequeos(int fila, int columna)
    {
        
        checkHorz(fila, columna);
        if(getCuatroEnLinea()==false)
        {
            checkVert(fila, columna);
            if(getCuatroEnLinea()==false)
            {
                    checkDiag(fila, columna);
            }
        }
        return fichasIguales;
    }
    /*
     * checkHorz chequea la fila de la jugada mas reciente a la izquierda y derecha para verificar que exitsa un 4 en linea
     */
    public void checkHorz(int fila, int columna)
    {
        Juego chequear= new Juego();
        fichasIguales=0;
        
        for(int izquierda= columna-1; izquierda>-1; izquierda--)
        {
            if(chequear.fichas[fila][columna]==chequear.fichas[fila][izquierda])
            {
                fichasIguales++;
            }
            else
            {
                break;
            }
        }
        for(int derecha= columna+1; derecha<7; derecha++)
        {
            if(chequear.fichas[fila][columna]==chequear.fichas[fila][derecha])
            {
                fichasIguales++;
            }
            else
            {
                break;
            }
        }
        if (fichasIguales==3)
        {
            setCuatroEnLinea(true);
        }
    }
    /*
     * checkVert es el metodo encargado de revisar por una victoria en vertical revisando las 3 fichas debajo de la mas reciente
     */
    public void checkVert(int fila, int columna)
    {
        Juego chequear= new Juego();
        fichasIguales=0;
        for(int abajo= fila+1; abajo<6; abajo++)
        {
            if(chequear.fichas[fila][columna]==chequear.fichas[abajo][columna])
            {
                fichasIguales++;
            }
            else
            {
                break;
            }
        }
        if (fichasIguales==3)
        {
            setCuatroEnLinea(true);
        }
    }
    public void checkDiag(int fila, int columna)
    {
        Juego chequear= new Juego();
        boolean seguir= true;
        fichasIguales=0;
        
        
            for(int abajo=fila+1;abajo<6;abajo++)
            {
                for(int izquierda=columna-1; izquierda>-1; izquierda--)
                {
                    if(chequear.fichas[fila][columna]==chequear.fichas[abajo][izquierda])
                    {
                        fichasIguales++;
                        break;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        
    }
    public void setCuatroEnLinea(boolean cuatroEnLinea)
    {
        this.cuatroEnLinea=cuatroEnLinea;
    }
    public Boolean getCuatroEnLinea()
    {
         return this.cuatroEnLinea;
    }
}
