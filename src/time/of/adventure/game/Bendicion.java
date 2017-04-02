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
public class Bendicion {
    private int bendicion;
    private int dios;
    
    Bendicion(){
        Random rnd = new Random();
        dios=rnd.nextInt(2);
        bendicion=rnd.nextInt(10)+1;
    }
    
    public void recibir(Personaje pj){
        String nombre = null;
        switch(dios){
            case 0:
                nombre="vida";
                pj.setSalud(pj.getSalud()+bendicion);
                break;
                
            case 1:
                nombre="guerra";
                pj.setAtaque(pj.getAtaque()+bendicion);
                break;
        }
        System.out.println("Has recibido una bendicion del dios de la "+nombre);
    }
}
