/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time.of.adventure.game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Gabriel
 */
public class TimeOfAdventureGame {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<String> lugares = new ArrayList();
    
    public static void main(String[] args) {
        lugares.add("Bosque");
        lugares.add("Santuario");
        lugares.add("Almacen");
        Personaje prota = new Personaje();
        System.out.println("Heroe bienvenido a tu aventura");
        int direccion;
        String lugar = null;
        do{
            do{
            direccion=prota.caminar(lugares.size());
            }while(lugar==lugares.get(direccion));
            lugar=lugares.get(direccion);
            int opcion;
            do{
            System.out.println("Estas en "+lugar);
            System.out.println("¿Que deseas hacer?");
            System.out.println("1 para ver tu status - 2 para seguir caminando - 3 usar el objeto que has encontrado(no sabes que te encontraras)");
            opcion=ingresarRespuesta();
            manejoDeRespuesta(opcion,prota,lugar,direccion);
            }while(opcion==1);
        }while(!lugares.isEmpty());
        System.out.println("Has terminado tu aventura joven heroe");
    }
    
    private static int ingresarRespuesta(){
        int opcion=0;
        boolean error;
        do{
            error=false;
            try{
                Scanner leer = new Scanner(System.in);
                opcion=leer.nextInt();
            }catch(InputMismatchException e){
                error=true;
                System.out.println("Error - Ingrese de nuevo el dato");
            }
        }while(error||opcion<1||opcion>3);
        return opcion;
    }
    
    private static void manejoDeRespuesta(int n,Personaje pj,String place,int direccion){
        switch(n){
            case 1:
                pj.mostrarEstado();
                break;
                
            case 2:
                System.out.println("Has seguido caminando");
                if(lugares.size()==1){
                    System.out.println("Has terminado en "+place+" quizas este es el camino que has de tomar para terminar tu aventura");
                }
                break;
                
            case 3:
                System.out.println("Has decidido terminar este camino");
                usarObjeto(place,pj,direccion);
                break;
        }
    }
    
    private static void usarObjeto(String place,Personaje pj,int direccion){
        switch(place){
            case "Bosque":
                Monstruo mon = new Monstruo();
                mon.atacarHumano(pj);
                lugares.remove(direccion);
                break;
                
            case "Almacen":
                Pocion pot = new Pocion();
                pot.usar(pj);
                lugares.remove(direccion);
                break;
                
            case "Santuario":
                Bendicion ben = new Bendicion();
                ben.recibir(pj);
                lugares.remove(direccion);
                break;
        }
    }
}
