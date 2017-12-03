package com.sirheadless.battle.structures.structure.building;

import com.sirheadless.util.Position;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class ResourceFactory implements Building {

    @NonNull
    private final UUID UUId;
    @NonNull
    private final String kind = "ResourceFactory";
    private Position position;
}
