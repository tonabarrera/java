package com.tona.backendninja.entity;

/**
 * @author tona created on 10/03/2018 for backendninja.
 */
import javax.persistence.*;

@Entity
@Table(name = "course") // Si se llama igual no es necesario
public class Course {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id; // idCourse se mapea a id_course y eso es malo

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "hours")
    private int hours;

    // Si tenemos un constructor personalizado necesitamos uno vacio
    public Course() {
    }

    public Course(int id, String name, String description, int price, int hours) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
