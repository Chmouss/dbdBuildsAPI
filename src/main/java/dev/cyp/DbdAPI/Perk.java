package dev.cyp.DbdAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "perks") //let the framework know that this class present each Perk in the perks collection
@Data //from Lombok dependancy, takes care of all the getters and setters for us
@AllArgsConstructor //creates a default constructor that takes all the fields
@NoArgsConstructor // another constructor that takes no argument
public class Perk {

    @Id
    private ObjectId id;

    private String name;
    private String shortName;
    private String description;
    private String role;
    private String ownerName;
    private int teachLevel;
    private String icon;
    private boolean isPtb;


    //constructor without ID
    public Perk(String name, String shortName, String description, String role, String ownerName, int teachLevel, String icon, boolean isPtb) {
        this.name = name;
        this.shortName = shortName;
        this.description = description;
        this.role = role;
        this.ownerName = ownerName;
        this.teachLevel = teachLevel;
        this.icon = icon;
        this.isPtb = isPtb;
    }
}
