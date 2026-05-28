/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Banco;
import modelo.Cuenta;

/**
 *
 * @author jmari
 */
public class ControladorCuenta {
    
    private Banco banco;

    public ControladorCuenta(Banco banco) {
        this.banco = banco;
    }
    
    public Banco getBanco() {
        return banco;
    }
    
    /*
    * Nombre del método: consignarDinero
    * Parámetros recibidos: Número, Cantidad
    * Tipo de retorno: boolean
    * Descripción: Consignar dinero a una cuenta
    */
    public boolean consignarDinero(int numero, double cantidad) {
        
        Cuenta cuenta = buscarCuenta(numero);
        
        if (cuenta == null) {
            return false;
        }
        
        cuenta.setSaldo(cantidad + cuenta.getSaldo());
        return true;
    }
    
    /*
    * Nombre del método: retirarDinero
    * Parámetros recibidos: Número, Cantidad
    * Tipo de retorno: boolean
    * Descripción: Retirar dinero de una cuenta
    */
    public boolean retirarDinero(int numero, double cantidad) {
        Cuenta cuenta = buscarCuenta(numero);
        
        if (cuenta == null || cuenta.getSaldo() < cantidad) {
            return false;
        }
        
        cuenta.setSaldo(cuenta.getSaldo() - cantidad);
        return true;
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
    
}
