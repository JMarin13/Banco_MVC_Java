/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import modelo.*;

/**
 *
 * @author jmari
 */
public class ControladorBanco {

    private Banco banco;
    
    public ControladorBanco() {
        banco = new Banco();
    }
    
    public Banco getBanco() {
        return banco;
    }
    
    /*
    * Nombre del método: CrearCliente
    * Parámetros recibidos: Documento, Nombre, Correo, Fecha Nacimiento, Estatura, Tipo
    * Tipo de retorno: Cliente
    * Descripción: Crear un nuevo cliente
    */
    public Cliente crearCliente(String tipo, String documento, String nombre, String correo, String telefono, int diaNacimiento, int mesNacimiento, int anioNacimiento, double estatura) {
        
        if (buscarCliente(documento) == null) {
            try {
                LocalDate fechaNacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);

                Cliente cliente = new Cliente(tipo, documento, nombre, correo, telefono, fechaNacimiento, estatura);
                banco.getLstClientes().add(cliente);
                
                return cliente;
            } catch (Exception ex) {
                System.out.println("error al crear cliente: " + ex.getMessage());
                return null;
            } 
        } else {
            System.out.println("El cliente ya existe: " + documento);
            return null;
        }
    }
    
    /*
    * Nombre del método: BuscarCliente
    * Parámetros recibidos: Documento
    * Tipo de retorno: Cliente
    * Descripción: Buscar un cliente
    */
    public Cliente buscarCliente(String documento) {
        
        for (Cliente cliente : banco.getLstClientes()) {
            if (documento.equals(cliente.getDocumento())) {
                return cliente;
            }
        }
        return null;
    }

    /*
    * Nombre del método: BorrarCliente
    * Parámetros recibidos: Documento
    * Tipo de retorno: boolean
    * Descripción: Borrar un cliente
    */
    public boolean borrarCliente(String documento) {
        try {
            Cliente cliente = buscarCliente(documento);
        
            if (cliente == null) {
                return false;
            }

            banco.getLstClientes().remove(cliente);
            return true;
        } catch (Exception ex) {
            System.out.println("Error al borrar cliente: " + ex.getMessage());
            return false;
        }
    }
    
    /*
    * Nombre del método: ActualizarCliente
    * Parámetros recibidos: Documento, Nombre, Correo, Fecha Nacimiento, Estatura, Tipo
    * Tipo de retorno: boolean
    * Descripción: Editar la información un cliente
    */
    public boolean actualizarCliente(String tipo, String documento, String nombre, String correo, String telefono, int diaNacimiento, int mesNacimiento, int anioNacimiento, double estatura) {
        
        Cliente cliente = buscarCliente(documento);
        
        if (cliente != null) {
            try {
                LocalDate fechaNacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);

                cliente.setNombre(nombre);
                cliente.setFechaNacimiento(fechaNacimiento);
                cliente.setCorreo(correo);
                cliente.setTipo(tipo);
                cliente.setTelefono(telefono);
                
                return true;
            } catch (Exception ex) {
                System.out.println("error al crear cliente: " + ex.getMessage());
                return false;
            } 
        } else {
            System.out.println("El cliente no existe: " + documento);
            return false;
        }
    }
}
