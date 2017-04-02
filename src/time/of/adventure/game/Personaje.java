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
public class Personaje {
    private int salud;
    private int ataque;
    
    Personaje(){
        salud=100;
        ataque=10;
    }
    
    public void setSalud(int s){
        salud=s;
    }
    
    public void setAtaque(int a){
        ataque=a;
    }
    
    public int getSalud(){
        return salud;
    }
    
    public int getAtaque(){
        return ataque;
    }
    
    public void mostrarEstado(){
        System.out.println("Mi salud es  :"+salud);
        System.out.println("Mi ataque es :"+ataque);
    }
    
    public int caminar(int n){
        Random rnd = new Random();
        return rnd.nextInt(n);
    }
}
