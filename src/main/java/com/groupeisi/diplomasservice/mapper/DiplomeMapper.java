package com.groupeisi.diplomasservice.mapper;

import com.groupeisi.diplomasservice.dto.DiplomeDto;
import com.groupeisi.diplomasservice.entities.Diplome;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiplomeMapper {
    DiplomeDto toDto(Diplome diplome);
    Diplome toEntity(DiplomeDto dto);
}