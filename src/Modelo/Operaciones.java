/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author marcooo
 */
public class Operaciones {
    private int a, b;
    double resultado = 0;

    public Operaciones(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    public int suma(){
        return a + b;
    }
    
    public int resta(){
        return a - b;
    }
    
    public int multiplicacion(){
        return (a)*(b);
    }
    
    public double division(){
        if(b!=0){
            resultado = (double) a / b;
            resultado = Math.round(resultado * 10.0) / 10.0;
        }
        return resultado;
    }
    
    
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    
}
