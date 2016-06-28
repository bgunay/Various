package com.github.pnowy.various.guava.beans;

/**
 *
 */
public class ViewValue implements Comparable<ViewValue> {
    private Long id;
    private String name;
    private int yearsOfService;

    public ViewValue(Long id, String name, int yearsOfService) {
        this.id = id;
        this.name = name;
        this.yearsOfService = yearsOfService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    public int compareTo(ViewValue employee) {
        return this.getName().compareTo(employee.getName());
    }

    @Override
    public String toString() {
        return "id=" + id + "-firstName=" + name + "-years of service=" + yearsOfService;
    }

}
