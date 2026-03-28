package com.groupeisi.diplomasservice.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "diplomes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Diplome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String etablissement;

    private String mention;

    private LocalDate dateObtention;
}