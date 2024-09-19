package dev.cyp.DbdAPI;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerkRepository extends MongoRepository<Perk, ObjectId> {

    Optional<Perk> findPerkByShortName(String shortName);
}
