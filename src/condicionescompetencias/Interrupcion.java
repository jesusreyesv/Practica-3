/*
Luis Jesus Reyes Velazquez 201732135
 */
package condicionescompetencias;
 
public class Interrupcion {    //Clase interrupción
    private boolean estado=false;  //El estado del recurso compartido, el estado depende del estado de las interrupciones
    public Interrupcion(){   //Constructor
        this.estado=true;   //Estado inicial
    }
    
    public void desactivar(){   //Función para poner desactivado el recurso compartido
        this.estado=false;
    }
    
    public void activar(){   //Función para poner activado el recurso compartido
        this.estado=true;
    }
    public boolean estado(){  //Función para revisar el estado del recurso compartido
        return estado;
    }
}
