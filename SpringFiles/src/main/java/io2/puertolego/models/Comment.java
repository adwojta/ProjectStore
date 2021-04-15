package io2.puertolego.models;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Comment")
public class Comment {

    @Id
    private int id_com;
    private int rating;
    private String description;
    private int id_pro;
    private int id_client;

    public int getId_com() {
        return id_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Comment() {
        super();
    }

    public Comment(int id_com, int rating, String description, int id_pro, int id_client) {
        super();
        this.id_com = id_com;
        this.rating = rating;
        this.description = description;
        this.id_pro = id_pro;
        this.id_client = id_client;
    }
}