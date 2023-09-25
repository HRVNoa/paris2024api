package bts.sio.api.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;

    @Data
    @Entity
    @Table(name = "epreuve")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public class Epreuve {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nom ;

        @ManyToOne
        @JoinColumn(name = "sport_id")
        private Sport sport;

        @ManyToOne
        @JoinColumn(name = "typeepreuve_id")
        private TypeEpreuve typeEpreuve;
    }


