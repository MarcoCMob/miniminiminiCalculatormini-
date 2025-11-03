/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Operaciones;
import javax.swing.JTextArea;
/**
 *
 * @author marcooo
 */
public class C_Operaciones {
    private Operaciones operacion;
    private double resultado = 0;

    public C_Operaciones(Operaciones op) {
        this.operacion =  new Operaciones(op.getA(),op.getB());
    }
    
    public int suma(){
        return operacion.suma();
    }
    
    public int resta(){
        return operacion.resta();
    }
    
    public int multiplicacion(){
        return operacion.multiplicacion();
    }
    
    public double division(){
        if(operacion.getA()!=0){
            resultado = operacion.division();
            // txtArea.setText(String.format("%.1f", resultado)); // 👈 1 decimal o más
        }
        return resultado;
    }
    
    public void limpiar(){
        operacion.setA(0);
        operacion.setB(0);
    }
    
    public void llenatxA(JTextArea textA, String texto){
        if (textA.getText().equals("0")){
            textA.setText(texto);
        } else {
            textA.append(texto);
        }
    }

    public void separaYGuarda(JTextArea text){
        String texto = text.getText();
        char operador = ' ';
        
        if (texto.contains("+")) {
            operador = '+';
        } else if (texto.contains("-")) {
            operador = '-';
        } else if (texto.contains("*")) {
            operador = '*';
        } else if (texto.contains("/")) {
            operador = '/';
        }
        
        String[] partes = texto.split("\\" + operador); 
        // "\\+" si el operador es + (el doble backslash es necesario para regex)
        
        String parte1 = partes[0]; // "15"
        String parte2 = partes[1]; // "20"
        System.out.println(parte1+parte2+operador);
        
        int a = Integer.parseInt(parte1.trim());
        int b = Integer.parseInt(parte2.trim());

        operacion.setA(a);
        operacion.setB(b);
        
        double resultado = 0;
        switch (operador) {
            case '+': resultado = suma(); break;
            case '-': resultado = resta(); break;
            case '*': resultado = multiplicacion(); break;
            case '/': resultado = division(); break;
        }
        
        text.setText(String.format("%.1f", resultado));

    }
}
