/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author jmari
 */
public class Banco {
    
    private String nit;
    private String nombre;
    private ArrayList<Cuenta> lstCuentas;
    private ArrayList<Cliente> lstClientes;

    public Banco() {
        this.nit = "123456789-01";
        this.nombre = "Banco U. Caldas";
        this.lstCuentas = new ArrayList<>();
        this.lstClientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public ArrayList<Cuenta> getLstCuentas() {
        return lstCuentas;
    }

    public void setLstCuentas(ArrayList<Cuenta> lstCuentas) {
        this.lstCuentas = lstCuentas;
    }

    public ArrayList<Cliente> getLstClientes() {
        return lstClientes;
    }

    public void setLstClientes(ArrayList<Cliente> lstClientes) {
        this.lstClientes = lstClientes;
    }
    
    
    
}
