/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
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
    
    /*
    * Nombre del método: CrearCuenta
    * Parámetros recibidos: Número, Tipo, Saldo, Clave, Titular
    * Tipo de retorno: Cuenta
    * Descripción: Crear una nueva Cuenta
    */
    public Cuenta crearCuenta(int numero, String tipo, double saldo, String clave, Cliente titular) {
        if (buscarCuenta(numero) != null) {
            return null;
        }

        Cuenta cuenta = new Cuenta(numero, tipo, saldo, clave, titular);
        banco.getLstCuentas().add(cuenta);

        return cuenta;
    }
    
    /*
    * Nombre del método: BuscarCuenta
    * Parámetros recibidos: Número
    * Tipo de retorno: Cuenta
    * Descripción: Buscar una cuenta
    */
    public Cuenta buscarCuenta(int numero) {
        for (Cuenta cuenta : banco.getLstCuentas()) {
            if (cuenta.getNumero() == numero) {
                return cuenta;
            }
        }
        return null;
    }
    
    /*
    * Nombre del método: ListarCuentas
    * Parámetros recibidos: Null
    * Tipo de retorno: ArrayList<Cuenta>
    * Descripción: Listar todas las cuentas existentes
    */
    public ArrayList<Cuenta> listarCuentas() {
        return banco.getLstCuentas();
    }
    
    /*
    * Nombre del método: ActualizarCuenta
    * Parámetros recibidos: Numero, nuevoTipo, nuevoSaldo, nuevaClave, nuevoTitular
    * Tipo de retorno: boolean
    * Descripción: Editar la información una Cuenta
    */
    public boolean actualizarCuenta(int numero, String nuevoTipo, double nuevoSaldo, String nuevaClave, Cliente nuevoTitular) {
        Cuenta cuenta = buscarCuenta(numero);

        if (cuenta == null) {
            return false;
        }

        cuenta.setTipo(nuevoTipo);
        cuenta.setSaldo(nuevoSaldo);
        cuenta.setClave(nuevaClave);
        cuenta.setTitular(nuevoTitular);

        return true;
    }
    
    /*
    * Nombre del método: BorrarCuenta
    * Parámetros recibidos: Número
    * Tipo de retorno: boolean
    * Descripción: Borrar una cuenta
    */
    public boolean borrarCuenta(int numero) {
        Cuenta cuenta = buscarCuenta(numero);

        if (cuenta == null) {
            return false;
        }

        banco.getLstCuentas().remove(cuenta);
        return true;
    }
}
