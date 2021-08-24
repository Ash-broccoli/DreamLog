package models;


import javax.persistence.*;

@Entity
@Table(name = "dream")
public class Dream {
    private int dreamID;
    private String title;
    private String shortDesc;
    private String longDesc;
    private DreamType typeID;
    private String date;
    private Login loginID;


    public Dream(int dreamID, String title, String shortDesc, String longDesc, DreamType typeID, String date, Login loginID) {
        this.dreamID = dreamID;
        this.title = title;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.typeID = typeID;
        this.date = date;
        this.loginID = loginID;
    }

    public Dream() {
    }

    public void setEverything(Dream d) {
        this.setTitle(d.title);
        this.setShortDesc(d.shortDesc);
        this.setLongDesc(d.longDesc);
        this.setTypeID(d.typeID);
        this.setDate(d.date);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dreamID")
    public int getDreamID() {
        return dreamID;
    }

    public void setDreamID(int dreamID) {
        this.dreamID = dreamID;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "shortDesc")
    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }


    @Column(name = "longDesc", length = 2048)
    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    @OneToOne
    @JoinColumn(name = "typeID")
    public DreamType getTypeID() {
        return typeID;
    }

    public void setTypeID(DreamType typeID) {
        this.typeID = typeID;
    }

    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @OneToOne
    @JoinColumn(name = "loginID")
    public Login getLoginID() {
        return loginID;
    }

    public void setLoginID(Login loginID) {
        this.loginID = loginID;
    }
}
