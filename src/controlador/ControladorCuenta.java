/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Banco;
import modelo.Cliente;
import modelo.Cuenta;

/**
 *
 * @author jmari
 */
public class ControladorCuenta {
    
    private ControladorBanco banco;

    public ControladorCuenta() {
        
    }
    
    public ControladorBanco getBanco() {
        return banco;
    }
    
    public boolean consignarDinero(int numero, double cantidad) {
        
        Cuenta cuenta = buscarCuenta(numero);
        
        if (cuenta == null) {
            return false;
        }
        
        cuenta.setSaldo(cantidad + cuenta.getSaldo());
        return true;
    }
    
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
        for (Cuenta cuenta : getBanco().getBanco().getLstCuentas()) {
            if (cuenta.getNumero() == numero) {
                return cuenta;
            }
        }
        return null;
    }
    
}
