package com.ab0529.yugioh_card_finder.database;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "Cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer OBJECT_ID;

    @Column(unique = true)
    private int id;
    private String name;
    private String type;
    private String description;
    private int atk;
    private int def;
    private int level;
    private String race;
    private String attribute;
    private String imgURL;
    private String imgURLSmall;

    @Override
    public String toString() {
        return String.format("ID: %d\n" +
                "Name: %s\n" +
                "Type: %s\n" +
                "Desc: %s\n" +
                "ATK: %d\n" +
                "DEF: %d\n" +
                "Level: %d\n" +
                "Race: %s\n" +
                "Attr: %s\n" +
                "URL: %s\n" +
                "URLSmall: %s", this.id, this.name, this.type, this.description, this.atk, this.def, this.level, this.race, this.attribute, this.imgURL, this.imgURLSmall);
    }
}
