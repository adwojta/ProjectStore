package io2.puertolego.models;

import javax.persistence.Entity;
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
    private String username;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {this.username = username; }

    public Comment() {
        super();
    }

    public Comment(int id_com, int rating, String description, int id_pro, String username) {
        super();
        this.id_com = id_com;
        this.rating = rating;
        this.description = description;
        this.id_pro = id_pro;
        this.username = username;
    }
}