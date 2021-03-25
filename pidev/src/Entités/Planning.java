/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entités;

/**
 *
 * @author Wissem
 */
public class Planning {
        private int id_planning,id_film,id_salle,day,month,year,places;
        private String projection_time;

    public Planning(int id_planning, int id_film, int id_salle,int places, int day, int month, int year, String projection_time) {
        this.id_planning = id_planning;
        this.id_film = id_film;
        this.id_salle = id_salle;
        this.places=places;
        this.day = day;
        this.month = month;
        this.year = year;
        this.projection_time = projection_time;
    }

    public int getId_planning() {
        return id_planning;
    }
     public int getPlaces() {
        return places;
    }


    public int getId_film() {
        return id_film;
    }

    public int getId_salle() {
        return id_salle;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getProjection_time() {
        return projection_time;
    }

    public void setId_planning(int id_planning) {
        this.id_planning = id_planning;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
    }
    public void setplaces(int places) {
        this.places = places;
    }


    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setProjection_time(String projection_time) {
        this.projection_time = projection_time;
    }

    @Override
    public String toString() {
        return "Planning{" + "id_planning=" + id_planning+"places=" + places + ", id_film=" + id_film + ", id_salle=" + id_salle + ", day=" + day + ", month=" + month + ", year=" + year + ", projection_time=" + projection_time + '}';
    }
    
    
}
