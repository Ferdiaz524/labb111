package org.example.lab11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListController {
    private final List<Employee> employees = new ArrayList<>();
    private ObservableList<Employee> itemsToRender;
    @FXML
    private ListView<Employee> lvEmployees;
    @FXML
    private Button btnNombre;
    @FXML
    private Button btnSalario;
    Comparator<Employee> comparadorNombre = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getNombre().compareTo(e2.getNombre());
        }
    };
    Comparator<Employee> comparadorSalario = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return Double.compare(e1.getSalario(), e2.getSalario());
        }
    };

    protected void initList() {
        employees.add(new Employee("Marta", 40, 1500.89));
        employees.add(new Employee("Enrique", 35, 500.5));
        employees.add(new Employee("Maria", 32, 450));
        employees.add(new Employee("Melissa", 56, 2000));
        employees.add(new Employee("Victor", 28, 1200));
        employees.add(new Employee("Daniel", 46, 1000));
        employees.add(new Employee("Rebeca", 41, 800));
        employees.add(new Employee("Eduardo", 25, 1500.89));

    }

    public void initialize() {
        initList();

        // Configuración inicial de nuestro ListView
        itemsToRender = FXCollections.observableArrayList(employees);
        lvEmployees.setItems(itemsToRender);

        // Set the cell factory
        lvEmployees.setCellFactory(param -> new ListCell<Employee>() {
            @Override
            protected void updateItem(Employee item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item.getNombre() + "- Age: "+ item.getEdad() + "-Salary: " + item.getSalario());
                }
            }
        });
    }

    @FXML
    private void handleBtnNombre() {
        Collections.sort(employees, comparadorNombre);
        itemsToRender.setAll(employees);

    }
    @FXML
    private void handleBtnSalario() {
        Collections.sort(employees, comparadorSalario);
        itemsToRender.setAll(employees);
    }


}