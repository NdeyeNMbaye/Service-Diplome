package com.groupeisi.diplomasservice.controller;

import com.groupeisi.diplomasservice.dto.DiplomeDto;
import com.groupeisi.diplomasservice.service.DiplomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diplomes")
@RequiredArgsConstructor
public class DiplomeController {

    private final DiplomeService diplomeService;

    @PostMapping
    public ResponseEntity<DiplomeDto> create(@RequestBody DiplomeDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(diplomeService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<DiplomeDto>> getAll() {
        return ResponseEntity.ok(diplomeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiplomeDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(diplomeService.getById(id));
    }

    // ✅ Nouvelle route pour la communication synchrone
    @GetMapping("/by-email")
    public ResponseEntity<DiplomeDto> getByEmail(@RequestParam String email) {
        return ResponseEntity.ok(diplomeService.getByEmail(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiplomeDto> update(@PathVariable Long id,
                                             @RequestBody DiplomeDto dto) {
        return ResponseEntity.ok(diplomeService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        diplomeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}