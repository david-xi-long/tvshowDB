package com.tvshowdatabase.backend.repository;

import java.util.List;
import java.util.Map;

import com.tvshowdatabase.backend.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    /* Gets 3 most frequent actors for the user */
    @Query(value = "SELECT a.actorName, COUNT(t.showID) AS count FROM actors a " +
                    "INNER JOIN acted ai ON a.actorid = ai.actorID " + 
                    "INNER JOIN tv_shows t ON t.showID = ai.showID " + 
                    "INNER JOIN favorites fav ON t.showID = fav.showID " + 
                    "INNER JOIN users u ON fav.userID = u.userid " +
                    "WHERE u.username = ?1 " + 
                    "GROUP BY a.actorName " + 
                    "ORDER BY count DESC " + 
                    "LIMIT 3", nativeQuery = true)
    List<Map<String, Integer>> getTopActors(String username);

}
