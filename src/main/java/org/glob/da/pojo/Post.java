package org.glob.da.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * @author me
 */
@Entity
public class Post {
    Long id;
    String text;
    Date date;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString() {
        return id + ":" + date + ":" + text;
    }
}
