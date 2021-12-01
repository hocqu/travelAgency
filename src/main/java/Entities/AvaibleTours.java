package Entities;

public class AvaibleTours {
    private Integer id;
    private String city;
    private Integer cost;

    public AvaibleTours(Integer id, String city, Integer price) {
        this.id = id;
        this.city = city;
        this.cost = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
