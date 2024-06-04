package org.example.lab11;

public class Employee{
    private String nombre;
    private int edad;
    private double salario;

    // Constructor
    public Employee(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    // Getter
    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

}
