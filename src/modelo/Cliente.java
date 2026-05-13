/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author jmari
 */
public class Cliente extends Persona {
    
    private String tipo;

    public Cliente() {
    }

    public Cliente(String tipo, String documento, String nombre, String correo, String telefono, LocalDate fechaNacimiento, double estatura) {
        super(documento, nombre, correo, telefono, fechaNacimiento, estatura);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
