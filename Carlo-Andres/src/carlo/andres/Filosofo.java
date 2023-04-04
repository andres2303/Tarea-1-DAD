/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carlo.andres;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Filosofo implements Runnable {
    int id,res;  
Thread t;  
JButton filosofo;
JLabel derecho;
JLabel izquierdo;
JLabel resultado;
String proceso;
JTextArea textArea;

Filosofo(int id,JLabel izquierdo, JLabel derecho,JButton filosofo,JLabel resultado, JTextArea textArea){  
    this.id = id;  
    this.derecho = derecho;  
    this.izquierdo = izquierdo;  
    this.filosofo=filosofo;
    this.resultado=resultado;
    this.textArea=textArea;
    t = new Thread(this);
    t.start();  
    
}  
   public void  run(){ 
    for(int i =0;i<4;i++){  
        synchronized(this.izquierdo){  
           synchronized(this.derecho){  
             comer();     
            } 
        }
        pensar();  
    } }  
   
   void comer () {  
    derecho.setText("Ocupado");
    derecho.setForeground(Color.BLUE);
    izquierdo.setText("Ocupado");
    izquierdo.setForeground(Color.BLUE);
    filosofo.setText("Comiendo");
    filosofo.setBackground(Color.MAGENTA);

    res=Integer.parseInt(resultado.getText());
    res+=1;
    resultado.setText(String.valueOf(res));
    proceso= "Fil.= "+(id+1)+ " Comiendo usa sus tenedores\n";
    textArea.append(proceso);
    try{  
        Thread.sleep(5000);  
    }catch(InterruptedException e){  
    }
    derecho.setText("Libre");
    derecho.setForeground(Color.black);
    
    izquierdo.setText("Libre");
    izquierdo.setForeground(Color.black);
    
    filosofo.setText("Pensando");   
    filosofo.setBackground(Color.DARK_GRAY);
    proceso="Fil.= "+(id+1)+ " Deja de comer y queda pensando, libera sus tenedores\n";  
    textArea.append(proceso);
}  
    void pensar(){  
    derecho.setText("Libre");
    derecho.setForeground(Color.black);
    
    izquierdo.setText("Libre");
    izquierdo.setForeground(Color.black);
    
    filosofo.setText("Pensando");   
    filosofo.setBackground(Color.DARK_GRAY);
    filosofo.setForeground(Color.white);

    try{  

        Thread.sleep(5000);  
    }catch(InterruptedException e){  
    }          
} 
    
}