package dev.cyp.DbdAPI;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController //let framework know that this class is an API controller and not just a simple class
@RequestMapping("/api/perks")
public class PerkController {

    @Autowired
    private PerkService perkService;

    @GetMapping
    public ResponseEntity<List<Perk>> getAllPerks(){
        return new ResponseEntity<List<Perk>>(perkService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{shortName}")
    public ResponseEntity<Optional<Perk>> getSinglePerk(@PathVariable String shortName){//let the framework know that we'll use the info from the mapping as a path variable
        return new ResponseEntity<Optional<Perk>>(perkService.singlePerk(shortName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Perk> createPerk(@RequestBody Perk perk) { //Spring Boot est capable de convertir automatiquement le JSON reçu dans la requête HTTP en un objet Java
        Perk createdPerk = perkService.createPerk(
                perk.getName(),
                perk.getShortName(),
                perk.getDescription(),
                perk.getRole(),
                perk.getOwnerName(),
                perk.getTeachLevel(),
                perk.getIcon(),
                perk.isPtb()
        );
        return new ResponseEntity<>(createdPerk, HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deletePerk(@RequestBody String perkShortName){
        Optional<Perk> perkToDelete = perkService.deletePerk(perkShortName);
        if (perkToDelete.isPresent()) {
            // Si le perk a été trouvé et supprimé, renvoie le nom du perk supprimé.
            return new ResponseEntity<>(perkToDelete.get().getName(), HttpStatus.OK);
        } else {
            // Si le perk n'existe pas, renvoie une réponse 404.
            return new ResponseEntity<>("Perk not found", HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/update")
    public ResponseEntity<Perk> updatePerk(@RequestBody Perk perk){
        //TODO
        return null;
    }


}
