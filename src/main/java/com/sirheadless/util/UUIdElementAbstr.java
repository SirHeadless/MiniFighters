package com.sirheadless.util;

import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public abstract class UUIdElementAbstr implements UUIdElement {

    @NonNull
    private final UUID UUId;

    public UUIdElementAbstr(UUID UUId) {
        this.UUId = UUId;
    }

}
