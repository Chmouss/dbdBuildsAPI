package dev.cyp.DbdAPI;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerkService {

    @Autowired // makes the framework instanciate this class (PerkRepository) for us
    private PerkRepository perkRepository;

    /*
    @Autowired
    private MongoTemplate mongoTemplate;
    not used here but we would use this if we needed to add in the database an object with a reference from another object (ex here we could have
    the perk referencing a survivor if we had survivors database aswell)
    */

    public List<Perk> allMovies(){
        return perkRepository.findAll(); //method from the MongoRepository class
    }

    public Optional<Perk> singlePerk(String shortName){
        return perkRepository.findPerkByShortName(shortName);
    }

    public Perk createPerk(String name, String shortName, String description, String role, String ownerName, int teachLevel, String icon, boolean isPtb){
        Perk perk = new Perk(name, shortName, description, role, ownerName, teachLevel, icon, isPtb);
        perkRepository.insert(perk);
        /*
        mongoTemplate.update(); see note above (mongo template) -> https://youtu.be/5PdEmeopJVQ?list=PLQ0NfZMNsbxNKZNPS7wjlme3760T5hdls&t=4942
        * */
        return perk;
    }

    public Optional<Perk> deletePerk(String perkShortName){
        Optional<Perk> perkToDelete = perkRepository.findPerkByShortName(perkShortName);
        if(perkToDelete.isPresent())
            perkRepository.deleteById(perkToDelete.get().getId());
        return perkToDelete;
    }

    public Optional<Perk> updatePerk(String perkShortName, Perk updatedPerk) {
        //TODO
        return null;
    }

}
