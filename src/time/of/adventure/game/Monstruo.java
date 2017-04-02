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
public class Monstruo {
    private int salud;
    private int ataque;
    
    Monstruo(){
        Random rnd = new Random();
        salud=rnd.nextInt(20)+1;
        ataque=rnd.nextInt(10+1);
    }
    
    public void atacarHumano(Personaje pj){
        int turnos=0;
        System.out.println("Te has encontrado con un monstruo");
        while(salud!=0){
            turnos++;
            pj.setSalud(pj.getSalud()-ataque);
            if(salud-pj.getAtaque()<=0){
                salud=0;
            }else{
                salud-=pj.getAtaque();
            }
        }
        System.out.println("El monstruo a muerto despues de "+turnos+"ataques");
        System.out.println("Pero todo tiene su costo");
    }
}
