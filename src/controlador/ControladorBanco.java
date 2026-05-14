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

    Banco banco;
    
    public ControladorBanco() {
        banco = new Banco();
    }
    
    
    /*
    * Nombre del método: CrearCliente
    * Parámetros recibidos: Documento, Nombre, Correo, Fecha Nacimiento, Estatura, Tipo
    * Tipo de retorno: Cliente
    * Descripción: Crear un nuevo cliente
    */
    public Cliente crearCliente(String tipo, String documento, String nombre, String correo, String telefono, int diaNacimiento, int mesNacimiento, int anioNacimiento, double estatura) {
        
        Cliente cliente = null;
        
        try {
            LocalDate fechaNacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
        
            cliente = new Cliente(tipo, documento, nombre, correo, telefono, fechaNacimiento, estatura);
        
            return cliente;
            
        } catch (Exception ex) {
            System.out.println("error al crear cliente: " + ex.getMessage());
            return null;
        }  
    }
    
}
