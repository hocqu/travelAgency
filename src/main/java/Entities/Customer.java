package Entities;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;
public class Customer{
    @Expose(serialize = false)
    public Integer id;
    @Expose(serialize = true)
    private String name;
    @Expose(serialize = true)
    private String phone;
    @Expose(serialize = true)
    private String email;
    @Expose(serialize = true)
    private Integer sale;
    @Expose(serialize = true)
    private List<Tour> tours =new ArrayList<>();

    public Customer(Integer id, String name, String phone, String email, Integer sale) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Клиент " + id+
                ", Имя: " + name +
                ", Номер телефона " + phone +
                ", Адрес электронной почты: " + email +
                ", Скидка: " + sale +"%";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours.addAll(tours);
    }
}
