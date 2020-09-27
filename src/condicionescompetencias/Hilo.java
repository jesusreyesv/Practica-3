/*
Luis Jesus Reyes Velazquez 201732135
 */
package condicionescompetencias;
import javax.swing.*;
public class Hilo extends Thread{
    private JTextArea area;
    private rCompartido rc;
    
    private boolean matar;
    private boolean stop;
    
    Hilo(JTextArea area, rCompartido rc){
        this.area=area;
        this.rc=rc;
    }
    
    public void run(){
        while(!stop){
            rc.desactivarInterrupciones();  //el proceso desactiva las interrupciones
            System.out.println(rc.getDatoCompartido()+" desactivo las interrupciones");
            try{
                
                synchronized(this){
                    if (rc.getEstado()==true||matar||rc.estadoDeLasInterrupciones()==true){ //el proceso revisa si las interrupciones están 
                        wait();                                                             //haciendo un check al estado directo del recurso compartido y 
                    }                                                                       //a las interrupciones
                }
                
                rc.setDatoCompartido(this.getName());           
                area.append(rc.getDatoCompartido()+"\n");       //Imprime el nombre del perrito que comió en el plato
                sleep(1500);
                rc.activarInterrupciones();        // Al finalizar de comer, activa las interrupciones de nuevo
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        
        
    }
    
    public synchronized void matar(){   //Función utilizada para simular el KILL en un thread
        rc.desactivarInterrupciones();  //Desactiva las interrupciones
        matar = true;                   //Pone el estado en muerto
        rc.setEstado(true);             //Pone el estado del recurso compartido para que nadie más pueda desbloquear las interrupciones
        
    } 
}
