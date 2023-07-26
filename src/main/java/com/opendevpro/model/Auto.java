package com.opendevpro.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Objects;

@Entity
@Table(name = "auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //es una interfaz @Gen.... y strategy busca similar el generador de indentity con el motor de db
    private Integer id;
    private String brand;
    private Integer wheels;
    private String type;
    private String color;
    private Integer doors;
    private String maxSpeed;
    private String engine;
    private String torque;
    private String hp;
    private Double price;
    private Integer stock;

    public Auto() {}

    public Auto(Integer id, Double price) {
        this.id = id;
        this.price = price;
    }

    public Auto(String brand, Integer wheels, String type, String color, Integer doors, String maxSpeed, String engine, String torque, String hp, Double price, Integer stock) {
        this.brand = brand;
        this.wheels = wheels;
        this.type = type;
        this.color = color;
        this.doors = doors;
        this.maxSpeed = maxSpeed;
        this.engine = engine;
        this.torque = torque;
        this.hp = hp;
        this.price = price;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getWheels() {
        return wheels;
    }

    public void setWheels(Integer wheels) {
        this.wheels = wheels;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTorque() {
        return torque;
    }

    public void setTorque(String torque) {
        this.torque = torque;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", wheels=" + wheels +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", doors=" + doors +
                ", maxSpeed='" + maxSpeed + '\'' +
                ", engine='" + engine + '\'' +
                ", torque='" + torque + '\'' +
                ", hp='" + hp + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(brand, auto.brand) && Objects.equals(wheels, auto.wheels) && Objects.equals(type, auto.type) && Objects.equals(color, auto.color) && Objects.equals(doors, auto.doors) && Objects.equals(maxSpeed, auto.maxSpeed) && Objects.equals(engine, auto.engine) && Objects.equals(torque, auto.torque) && Objects.equals(hp, auto.hp) && Objects.equals(price, auto.price) && Objects.equals(stock, auto.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, wheels, type, color, doors, maxSpeed, engine, torque, hp, price, stock);
    }
}
