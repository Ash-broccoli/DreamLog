package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dreamType")
public class DreamType {
    private int typeID;
    private String type;

    public DreamType(int typeID, String type) {
        this.typeID = typeID;
        this.type = type;
    }
    public DreamType(){

    }

    @Id
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
