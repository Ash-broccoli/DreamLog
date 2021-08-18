package models;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "dream")
public class Dream {
    private int dreamID;
    private String title;
    private String shortDesc;
    private String longDesc;
    private DreamType typeID;
    private Date date;


    public Dream(int dreamID, String title, String shortDesc, String longDesc ,DreamType typeID, Date date) {
        this.dreamID = dreamID;
        this.title = title;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.typeID = typeID;
        this.date = date;
    }

    public Dream() {
    }

    public String noTimeDate(Date currentDate){
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MMM/yyyy");
        return dateFormat.format(currentDate);
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

    @Column(name="shortDesc")
    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }


    @Column(name="longDesc", length=2048)
    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    @OneToOne
    @JoinColumn(name="typeID")
    public DreamType getTypeID() {
        return typeID;
    }

    public void setTypeID(DreamType typeID) {
        this.typeID = typeID;
    }

    @Column(name="date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
