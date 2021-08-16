package models;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "dream")
public class Dream {
    private int dreamID;
    private String title;
    private String description;
    private DreamType typeID;
    private Date date;

    public Dream(int dreamID, String title, String description, DreamType typeID, Date date) {
        this.dreamID = dreamID;
        this.title = title;
        this.description = description;
        this.typeID = typeID;
        this.date = date;
    }

    public Dream() {
    }

    @Id
    @Column(name="dreamID")
    public int getDreamID() {
        return dreamID;
    }

    public void setDreamID(int dreamID) {
        this.dreamID = dreamID;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToOne
    @JoinColumn(name="typeID")
    public DreamType getType() {
        return typeID;
    }

    public void setType(DreamType typeID) {
        this.typeID = typeID;
    }

    @Column(name="date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Dream{" +
                "dreamID=" + dreamID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", typeID=" + typeID +
                ", date=" + date +
                '}';
    }
}
