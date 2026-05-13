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
public class Empleado extends Persona {
    
    private String cargo;
    private int salario;

    public Empleado() {
    }

    public Empleado(String cargo, int salario, String documento, String nombre, String correo, String telefono, LocalDate fechaNacimiento, double estatura) {
        super(documento, nombre, correo, telefono, fechaNacimiento, estatura);
        this.cargo = cargo;
        this.salario = salario;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    
}
