package models;

import javax.persistence.*;

@Entity
@Table(name = "dreamType")
public class DreamType {
    private int typeID;
    private String type;

    public DreamType( String type) {
        this.type = type;
    }
    public DreamType(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="typeID")
    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    @Column(name="type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
