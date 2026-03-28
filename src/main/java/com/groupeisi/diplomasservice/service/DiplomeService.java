package com.groupeisi.diplomasservice.service;

import com.groupeisi.diplomasservice.dto.DiplomeDto;
import com.groupeisi.diplomasservice.entities.Diplome;
import com.groupeisi.diplomasservice.mapper.DiplomeMapper;
import com.groupeisi.diplomasservice.repository.DiplomeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DiplomeService {

    private final DiplomeRepository diplomeRepository;
    private final DiplomeMapper diplomeMapper;

    public DiplomeDto create(DiplomeDto dto) {
        log.info("Création diplôme pour : {}", dto.getEmail());
        if (diplomeRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email déjà utilisé : " + dto.getEmail());
        }
        Diplome diplome = new Diplome();
        diplome.setNom(dto.getNom());
        diplome.setPrenom(dto.getPrenom());
        diplome.setEmail(dto.getEmail());
        diplome.setTitre(dto.getTitre());
        diplome.setEtablissement(dto.getEtablissement());
        diplome.setMention(dto.getMention());
        diplome.setDateObtention(dto.getDateObtention());
        Diplome saved = diplomeRepository.save(diplome);
        log.info("Diplôme créé : {}", saved.getId());
        return diplomeMapper.toDto(saved);
    }

    public List<DiplomeDto> getAll() {
        log.info("Récupération de tous les diplômes");
        return diplomeRepository.findAll()
                .stream()
                .map(diplomeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "diplomes", key = "#id")
    public DiplomeDto getById(Long id) {
        log.info("Récupération diplôme id : {}", id);
        return diplomeMapper.toDto(
                diplomeRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Diplôme non trouvé : " + id))
        );
    }

    // ✅ Nouvelle méthode pour la communication synchrone
    public DiplomeDto getByEmail(String email) {
        log.info("Récupération diplôme pour email : {}", email);
        return diplomeMapper.toDto(
                diplomeRepository.findByEmail(email)
                        .orElseThrow(() -> new EntityNotFoundException("Diplôme non trouvé pour email : " + email))
        );
    }

    @CacheEvict(value = "diplomes", key = "#id")
    public DiplomeDto update(Long id, DiplomeDto dto) {
        log.info("Mise à jour diplôme id : {}", id);
        Diplome diplome = diplomeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Diplôme non trouvé : " + id));
        diplome.setNom(dto.getNom());
        diplome.setPrenom(dto.getPrenom());
        diplome.setEmail(dto.getEmail());
        diplome.setTitre(dto.getTitre());
        diplome.setEtablissement(dto.getEtablissement());
        diplome.setMention(dto.getMention());
        diplome.setDateObtention(dto.getDateObtention());
        log.info("Diplôme mis à jour : {}", id);
        return diplomeMapper.toDto(diplomeRepository.save(diplome));
    }

    @CacheEvict(value = "diplomes", key = "#id")
    public void delete(Long id) {
        log.info("Suppression diplôme id : {}", id);
        if (!diplomeRepository.existsById(id)) {
            throw new EntityNotFoundException("Diplôme non trouvé : " + id);
        }
        diplomeRepository.deleteById(id);
        log.info("Diplôme supprimé : {}", id);
    }
}