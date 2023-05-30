/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import Ejercicio3.AeroGenerador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

/**
 * Programa para trabajar con arbol DOM.
 *
 * @profesorado
 */
public class Ejercicio4 {

    /**
     * Método principal.
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada        
        // Variables de salida
        // Variables auxiliares
        String ruta = System.getProperty("user.dir") + "/recursos/BDAeroGens.xml";
        try {
            //----------------------------------------------
            //                Abrir Archivo 
            //----------------------------------------------

            // 1º Creamos una nueva instancia de un fábrica de constructores de documentos.
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // 2º A partir de la instancia anterior, fabricamos un constructor de documentos, que procesará el XML.
            DocumentBuilder db = dbf.newDocumentBuilder();
            // 3º Procesamos el documento (almacenado en un archivo) y lo convertimos en un árbol DOM.
            Document documento = db.parse(ruta);
            //----------------------------------------------
            //                 Convertir a DOM 
            //----------------------------------------------

            documento.getDocumentElement().normalize();
            Element nodo = documento.getDocumentElement();

            // Lista de nodos de aero generadores
            NodeList nodeList = nodo.getChildNodes();

            // Avanzamos por la lista para presentar los conceptos
            for (int temp = 0; temp < nodeList.getLength(); temp++) {

                // Obtenemos un nodo
                Node nodoAeroGen = nodeList.item(temp);

                // Verificamos que el nodo sea un elemento, para prevenir errores
                if (nodoAeroGen.getNodeType() == Node.ELEMENT_NODE) {

                    // Convertimos de Node a elemento
                    Element elementoAeroGen = (Element) nodoAeroGen;

                    NodeList nodeListIn = elementoAeroGen.getChildNodes();
                    Boolean cambio = false;
//                     Presentamos los datos de cada elemento del areogen
                    for (int u = 0; u < nodeListIn.getLength(); u++) {

                        // Obtenemos un nodo
                        Node nodoElement = nodeListIn.item(u);
                        if (nodoElement.getNodeType() == Node.ELEMENT_NODE) {

                            //----------------------------------------------
                            //              Eliminar el primer elemento
                            //----------------------------------------------
                            if (nodoElement.getNodeName().equals("distancia")) {
                                elementoAeroGen.removeChild(nodoElement);
                                cambio = true;
                            }
                        }
                    }
                    //----------------------------------------------
                    //              Añadir nuevo elemento al final 
                    //----------------------------------------------
                    if (cambio) {
                        Element elementoColor = documento.createElement("color");
                        elementoColor.setTextContent("Blanco");
                        elementoAeroGen.appendChild(elementoColor);
                    }

                }
            }
            //----------------------------------------------
            //              Cerrar Archivo
            //----------------------------------------------
            FileWriter ficheroSalida;
            ficheroSalida = new FileWriter(new File(ruta));
            // Escribo el array en el fichero

            DOMSource domSource = new DOMSource(documento);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            
            TransformerFactory tf = TransformerFactory.newInstance();            
            tf.setAttribute("indent-number", 2);
            
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(domSource, result);
            String xml = writer.toString();
            ficheroSalida.write(xml);

            // Cerramos el fichero
            ficheroSalida.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println("El fichero " + ruta + " no existe.");
        } catch (IOException ioe) {
            System.err.println("Error: falló la escritura en el fichero " + ruta);
        } catch (Exception ex) {
            System.out.println("¡Error! No se ha podido cargar el documento XML.");
        }

        System.out.println();
        System.out.println("Archivo cerrado y procesamento finalizado");
        System.out.println("---------");

        System.out.println();
        System.out.println("Fin del programa.");
    }
}
