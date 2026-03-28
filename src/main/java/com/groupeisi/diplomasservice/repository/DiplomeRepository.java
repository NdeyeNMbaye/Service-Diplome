package com.groupeisi.diplomasservice.repository;

import com.groupeisi.diplomasservice.entities.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Long> {
    Optional<Diplome> findByEmail(String email);
    boolean existsByEmail(String email);
}