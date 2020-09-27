/*
Luis Jesus Reyes Velazquez 201732135
 */
package condicionescompetencias;


public class rCompartido {
    private String datoCompartido;      //nombre del dato compartido
    private Interrupcion i1,i2;         //dos interrupciones las cuales se activaran y desactivaran
    private boolean estado;             //estado del recurso compartido
rCompartido(){      //constructor e inicializaciónj de las variables
    datoCompartido="";
    i1=new Interrupcion();
    i2=new Interrupcion();
    i1.activar();
    i2.activar();
    estado=false;
}
    
    public String getDatoCompartido() {     //Función para obtener el dato compartido
        return datoCompartido;
    }

    public void setDatoCompartido(String datoCompartido) {  //Función para colocar el dato compartido
        this.datoCompartido = datoCompartido;
    }
    
    
    
    public boolean estadoDeLasInterrupciones(){    //Función para saber el estado de las interrupciones
        if(i1.estado()==true||i2.estado()==true){ // han sido bloqueadas o no
            return true;
        }else{
            return false;
        }
    }
    public void desactivarInterrupciones(){     //Función para desactivar las interrupciones
        i1.desactivar();
        i2.desactivar();
        
    }
    public void activarInterrupciones(){    //Función para activar las interrupciones
        i1.activar();
        i2.activar();
        
    }
    public boolean getEstado(){         //Función para obtener el estado del recurso compartido
        return estado;
    }
    public void setEstado(boolean x){   //Función para modificar el estado del recurso
        this.estado=x;                  //es utilizado cuando las interrupciones 
    }                                   //son bloqueadas y nadie más puede activarlas
                                        //solo el thread que esta siendo atendido
}
