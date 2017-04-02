/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time.of.adventure.game;

import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class Pocion {
    private int recuperacion;
    private int refuerzo;
    
    Pocion(){
        Random rnd = new Random();
        int opcion=rnd.nextInt(3);
        switch(opcion){
            case 0:
                recuperacion=rnd.nextInt(10)+1;
                break;
                
            case 1:
                refuerzo=rnd.nextInt(5)+1;
                break;
                
            case 2:
                recuperacion=rnd.nextInt(10)+1;
                refuerzo=rnd.nextInt(5)+1;
                break;
        }
    }
    
    public void usar(Personaje pj){
        pj.setAtaque(pj.getAtaque()+refuerzo);
        pj.setSalud(pj.getSalud()+recuperacion);
        System.out.println("Has usado una pocion");
        System.out.println("¿Que habra pasado?");
    }
}
