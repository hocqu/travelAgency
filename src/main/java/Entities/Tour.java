package Entities;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class Tour {
    @Expose(serialize = false)
    private Integer id;
    @Expose(serialize = false)
    private Integer customer_id;
    @Expose(serialize = true)
    private String tourType;
    @Expose(serialize = true)
    private String departureDate;
    @Expose(serialize = true)
    private Integer daysInTour;
    @Expose(serialize = true)
    private String city;
    @Expose(serialize = true)
    private Integer cost;
    @Expose(serialize = true)
    private Boolean burning;

    public Tour(Integer id, Integer customer_id, String tourType, String departureDate, Integer daysInTour, String city, Integer cost, Boolean burning) {
        this.id = id;
        this.customer_id = customer_id;
        this.tourType = tourType;
        this.departureDate = departureDate;
        this.daysInTour = daysInTour;
        this.city = city;
        this.cost = cost;
        this.burning = burning;
    }

    @Override
    public String toString() {
        return "Tour " + id+
                " Type: " + tourType +
                " Departure date: " + departureDate +
                 "Tour duration: " + daysInTour +
                " Place: " + city +
                " Cost: " + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return tourType.equals(tour.tourType) &&
                departureDate.equals(tour.departureDate) &&
                daysInTour.equals(tour.daysInTour) &&
                city.equals(tour.city) &&
                cost.equals(tour.cost) &&
                burning.equals(tour.burning);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourType, departureDate, daysInTour, city, cost, burning);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public void setTourType(String tourType) {
        this.tourType = tourType;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public void setDaysInTour(Integer daysInTour) {
        this.daysInTour = daysInTour;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setBurning(Boolean burning) {
        this.burning = burning;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public String getTourType() {
        return tourType;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public Integer getDaysInTour() {
        return daysInTour;
    }

    public String getCity() {
        return city;
    }

    public Integer getCost() {
        return cost;
    }

    public Boolean getBurning() {
        return burning;
    }
}
