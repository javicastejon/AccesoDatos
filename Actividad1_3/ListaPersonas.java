package ficheros.act03;

import java.util.ArrayList;
import java.util.List;

public class ListaPersonas {
    private List<Persona> lista = new ArrayList<Persona>(null);

    public ListaPersonas() {}

    public void add(Persona per) {
        lista.add(per);
    }

    public List<Persona> getListaPersonas(){
        return lista;
    }

    
}
