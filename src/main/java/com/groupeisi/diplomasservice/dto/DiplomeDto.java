package com.groupeisi.diplomasservice.dto;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class DiplomeDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String titre;
    private String etablissement;
    private String mention;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateObtention;


    public DiplomeDto() {}

    public DiplomeDto(Long id, String nom, String prenom, String email,
                      String titre, String etablissement, String mention,
                      LocalDate dateObtention) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.titre = titre;
        this.etablissement = etablissement;
        this.mention = mention;
        this.dateObtention = dateObtention;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getEtablissement() { return etablissement; }
    public void setEtablissement(String etablissement) { this.etablissement = etablissement; }

    public String getMention() { return mention; }
    public void setMention(String mention) { this.mention = mention; }

    public LocalDate getDateObtention() { return dateObtention; }
    public void setDateObtention(LocalDate dateObtention) { this.dateObtention = dateObtention; }
}