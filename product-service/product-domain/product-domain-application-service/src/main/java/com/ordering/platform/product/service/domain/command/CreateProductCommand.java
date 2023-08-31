package com.ordering.platform.product.service.domain.command;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateProductCommand {

    @NotNull
    private final String name;

    @NotNull
    private final String type;


}
