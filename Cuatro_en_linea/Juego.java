
/**
 * La clase Juego esta hecha para llevar a cabo todos los procesos relacionados
 * con las jugadas que los jugadores tomen.
 *
 * @author Andres Camacho
 * @version 7/10/2020
 */
import javax.swing.JOptionPane;
public class Juego
 {
     String jugador1;
    String jugador2;
    int ronda= 0;
    char ficha;
   static  char[][] fichas= {{'*','*','*','*','*','*','*'},
                          {'*','*','*','*','*','*','*'},
                          {'*','*','*','*','*','*','*'},
                          {'*','*','*','*','*','*','*'},
                          {'*','*','*','*','*','*','*'},
                          {'*','*','*','*','*','*','*'}};
    int modoJuego;
    int fila1=5;
    int fila2=5;
    int fila3=5;
    int fila4=5;
    int fila5=5;
    int fila6=5;
    int fila7=5;
    int columna;
    
    /*
     * El metodo jugar es el que ejecuta los metodos necesarios para correr el juego y es invocado desde el menu.
     */
    public void jugar() 
    {
        Chequeos ganador= new Chequeos();
        int seguir= 0;
        jugadores();
        while(seguir<3 && getRonda()<42)
        {
            
            if(getRonda()>0)
            {
                
                turno();
                switch(getColumna()+1)//Este switch se encarga de mantener los valores de las filas y cada vez que se usa una fila se le agrega 1 a su valor para la proxima vez que se use
                {
                    case 1:
                    fichas[getFila1()][getColumna()]=getFicha();
                    seguir=ganador.chequeos(getFila1(), getColumna());
                    setFila1(getFila1()-1);
                    break;
                    case 2:
                    fichas[getFila2()][getColumna()]=getFicha();
                    seguir=ganador.chequeos(getFila2(), getColumna());
                    setFila2(getFila2()-1);
                    break;
                    case 3:
                    fichas[getFila3()][getColumna()]=getFicha();
                    seguir=ganador.chequeos(getFila3(), getColumna());
                    setFila3(getFila3()-1);
                    break;
                    case 4:
                    fichas[getFila4()][getColumna()]=getFicha();
                    seguir=ganador.chequeos(getFila4(), getColumna());
                    setFila4(getFila4()-1);
                    break;
                    case 5:
                    fichas[getFila5()][getColumna()]=getFicha();
                    seguir=ganador.chequeos(getFila5(), getColumna());
                    setFila5(getFila5()-1);
                    break;
                    case 6:
                    fichas[getFila6()][getColumna()]=getFicha();
                    seguir=ganador.chequeos(getFila6(), getColumna());
                    setFila6(getFila6()-1);
                    break;
                    case 7:
                    fichas[getFila7()][getColumna()]=getFicha();
                    seguir=ganador.chequeos(getFila7(), getColumna());
                    setFila7(getFila7()-1);
                    break;
                }
            }
            char[][] tablero= {{'[',fichas[0][0],']','[',fichas[0][1],']','[',fichas[0][2],']','[',fichas[0][3],']','[',fichas[0][4],']','[',fichas[0][5],']','[',fichas[0][6],']'},
                        {'[',fichas[1][0],']','[',fichas[1][1],']','[',fichas[1][2],']','[',fichas[1][3],']','[',fichas[1][4],']','[',fichas[1][5],']','[',fichas[1][6],']'},
                        {'[',fichas[2][0],']','[',fichas[2][1],']','[',fichas[2][2],']','[',fichas[2][3],']','[',fichas[2][4],']','[',fichas[2][5],']','[',fichas[2][6],']'},
                        {'[',fichas[3][0],']','[',fichas[3][1],']','[',fichas[3][2],']','[',fichas[3][3],']','[',fichas[3][4],']','[',fichas[3][5],']','[',fichas[3][6],']'},
                        {'[',fichas[4][0],']','[',fichas[4][1],']','[',fichas[4][2],']','[',fichas[4][3],']','[',fichas[4][4],']','[',fichas[4][5],']','[',fichas[4][6],']'},
                        {'[',fichas[5][0],']','[',fichas[5][1],']','[',fichas[5][2],']','[',fichas[5][3],']','[',fichas[5][4],']','[',fichas[5][5],']','[',fichas[5][6],']'},};
            
            imprimirTablero(tablero);
            ronda();
        }
        if(getRonda()==42)
        {
            System.out.println("Es un empate");
        }
        else
        {
            if((getRonda()-1)%2==0)
             {
                System.out.println(getJugador2()+ " gana");
             }
             else
             {
                System.out.println(getJugador1()+ " gana");
             }
        }
    }
    /*
     * el metodo ronda se encarga de llevar la cuenta de las rondas transcurridas, se utiliza tambien para decidir los turnos
     */
    public void ronda()
    {
      
      System.out.println(getRonda()+" jugadas");
      setRonda(getRonda()+1);
    }
    /*
     * el metodo jugadores lo que hace es establecer los nombres de los jugadores
     */
    public void jugadores()
    {
          Jugador jugador= new Jugador();
      
          switch(getModoJuego())
          {
              case 1:
              setJugador1(jugador.ingresarJugador());
              setJugador2(jugador.generarJugador());
              break;
              case 2:
              setJugador1(jugador.ingresarJugador());
              setJugador2(jugador.ingresarJugador());
              break;
         
            }
    }
    /*
     * imprimirTablero lo que hace es utilizar 2 ciclos de for para imprimire el tablero de juego
     * @param tablero[][] el metodo recibe una variable de tipo char[][] y la imprime
     */
    public void imprimirTablero(char[][] tablero)
    {
        System.out.println("(1)(2)(3)(4)(5)(6)(7)");
        for(int columna=0; columna<=5; columna++)
        {
            for(int fila=0; fila<=20; fila++)
            {
                System.out.print(tablero[columna][fila]);
                if(fila==20)
                {
                    System.out.println("");
                }
            }
        }
    }
    /*
     * el metodo turno es utilizado para decidir a cual jugador le toca
     * realizar una movida y lo hace dividiendo el numero de rondas y
     * asignandole a cada jugador un turno basado en lo que sobra de la division
     */
    public void turno()
    {
      CPU cpu= new CPU();
      if((getRonda()%2)==0)
       {
          setFicha('R');
          System.out.println("Es turno de " + getJugador2());
          if(getModoJuego()==2)
          {
              setColumna(Integer.parseInt(JOptionPane.showInputDialog(getJugador2()+ " digite la columna en dode quiera colocar su ficha"))-1);
          }
          else
          {
              setColumna(cpu.generarMovida());
          }
      }
      else
      {
         setFicha('N');
         System.out.println("Es turno de " + getJugador1());
         try
         {
             setColumna(Integer.parseInt(JOptionPane.showInputDialog(getJugador1()+ " digite la columna en dode quiera colocar su ficha"))-1);
         }
         catch(java.lang.NumberFormatException nulo)
         {
            JOptionPane.showMessageDialog(null, "Debe ingresar un numero valido del 1 al 7");
        }
      }
    }
     public void setJugador1(String jugador1)
    {
       this.jugador1=jugador1;
    }
   public String getJugador1()
    {
       return this.jugador1;
    }  
    public void setJugador2(String jugador2)
    {
       this.jugador2=jugador2;
    }
    public String getJugador2()
    {
       return this.jugador2;
    }
    public void setRonda(int ronda)
       {
           this.ronda= ronda;
    }
      public Integer getRonda()
    {
            return this.ronda;
    }
      public void setFicha(char ficha)
    {
          this.ficha=ficha;
    }
      public Character getFicha()
    {
          return this.ficha;
        }
      public void setModoJuego(int modoJuego)
    {
        this.modoJuego=modoJuego;
      }
       public Integer getModoJuego()
    {
          return this.modoJuego;
      }
    public int getFila1() 
    {
        return fila1;
    }
    public void setFila1(int fila1) 
    {
        this.fila1 = fila1;
    }
    public int getFila2() 
    {
        return fila2;
    }
    public void setFila2(int fila2) 
    {
        this.fila2 = fila2;
    }
    public int getFila3() 
    {
        return fila3;
    }
    public void setFila3(int fila3) 
    {
        this.fila3 = fila3;
    }
    public int getFila4() 
    {
        return fila4;
    }
    public void setFila4(int fila4) 
    {
        this.fila4 = fila4;
    }
    public int getFila5() 
    {
        return fila5;
    }
    public void setFila5(int fila5) 
    {
        this.fila5 = fila5;
    }
    public int getFila6() 
    {
        return fila6;
    }
    public void setFila6(int fila6) 
    {
        this.fila6 = fila6;
    }
    public int getFila7() 
    {
        return fila7;
    }
    public void setFila7(int fila7) 
    {
        this.fila7 = fila7;
    }
    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) 
    {
        this.columna = columna;
    }
 }