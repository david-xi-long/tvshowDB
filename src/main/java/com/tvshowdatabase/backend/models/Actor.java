package com.tvshowdatabase.backend.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actorid")
    private int actorID;

    @Column (name = "actorName")
    private String actorName;

    @Column (name = "actorDOB")
    private String actorDOB;

    @Column (name = "actsID")
    private int actsID;

    @Column (name = "charName")
    private String charName;

    /* connect to Actor-TVShow relationship */
    @OneToMany(mappedBy="actor")
    private Set<ActsIn> actsIns = new HashSet<>();

    public Actor(int actorID, String actorName, String actorDOB, int actsID, String charName) {
        this.actorID = actorID;
        this.actorName = actorName;
        this.actorDOB = actorDOB;
        this.actsID = actsID;
        this.charName= charName;
    }

    public Actor(){}

    public Actor(String actorName, String actorDOB, int actsID, String charName) {
        this.actorName = actorName;
        this.actorDOB = actorDOB;
        this.actsID = actsID;
        this.charName = charName;
    }

    public int getActorID() {
        return this.actorID;
    }

    public String getActorName() {
        return this.actorName;
    }

    public String getActorDOB() {
        return this.actorDOB;
    }

    public Set<ActsIn> getActsIn() {
        return this.actsIns;
    }

    public void addActsIns(ActsIn actsIn) {
        this.actsIns.add(actsIn);
    }
}
