package Internas;

import ejercicio04.Coche;

import java.util.HashSet;
import java.util.Set;

import java.util.ArrayList;
import java.util.List;

import  java.util.HashMap;
import java.util.Map;

import java.util.Iterator;

public class Interna {
    public static void main(String[] args) {
        
        // Creación de los objetos
        Coche coche1 = new Coche("Peugeot");
        Coche coche2 = new Coche("Seat");
        Coche coche3 = new Coche("Renault");

        // Creación de las colecciones de objetos, aunque map no hereda de collection. 
        Set<Coche> conjunto=new HashSet<>();
        List<Coche> lista=new ArrayList<>();
        Map<Integer, Coche> mapa = new HashMap<>();        
        
        // Añadimos los objetos a las colecciones
        conjunto.add(coche1);
        conjunto.add(coche2);
        conjunto.add(coche3);
        
        lista.add(coche1);
        lista.add(coche2);
        lista.add(coche3);

        mapa.put(1, coche1);
        mapa.put(2, coche2);
        mapa.put(3, coche3);        
        
        // Recorremos las colecciones con los iteradores
        Iterator<Coche> itConjunto = conjunto.iterator();
        Iterator<Coche> itLista = lista.iterator();
        Iterator<Integer> itMapa = mapa.keySet().iterator(); // Devuelve un conjunto de claves
         
        while (itConjunto.hasNext()) {
            System.out.println(itConjunto.next());
        }
        while (itLista.hasNext()) {
            Coche cocheLista = itLista.next(); // Hacemos una copia del objeto para que no mute el original
            System.out.println(cocheLista.toString());
        }
        while (itMapa.hasNext()) {
            System.out.println(mapa.get(itMapa.next()).getNombre());
        }
        for (Integer llave:mapa.keySet()) {
            System.out.println(mapa.get(llave));
        }
    }
}
