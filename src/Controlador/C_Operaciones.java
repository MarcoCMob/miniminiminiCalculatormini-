/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Operaciones;
import java.util.regex.Pattern;
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
        String operador = "";
        
        if (texto.indexOf('+', 1) != -1) {
            operador = "+";
        } else if (texto.indexOf('-', 1) != -1) {
            operador = "-";
        } else if (texto.indexOf('*', 1) != -1) {
            operador = "*";
        } else if (texto.indexOf('/', 1) != -1) {
            operador = "/";
        }  
        
        String[] partes = texto.split(Pattern.quote(operador));
        String parte1;
        String parte2;
        
        if (texto.startsWith("-") && partes.length > 2) {
            // Ejemplo: "-5*6" → split da ["", "5", "6"]
            parte1 = "-" + partes[1];
            parte2 = partes[2];
        } else {
            parte1 = partes[0];
            parte2 = partes[1];
        }
        System.out.println(operador+parte1+parte2);
        
        int a = Integer.parseInt(parte1.trim());
        int b = Integer.parseInt(parte2.trim());

        operacion.setA(a);
        operacion.setB(b);
        
        double resultado = switch (operador) {
            case "+" -> suma();
            case "-" -> resta();
            case "*" -> multiplicacion();
            case "/" -> division();
            default -> 0;
        };
        
        text.setText(String.format("%.1f", resultado));

    }
}
