package Viox.dtos.cat;

import Viox.models.CatColor;

import java.time.LocalDate;

public record CatCreationDto (
        String name,
        LocalDate dateOfBirth,
        CatColor color,
        String breed
) {}