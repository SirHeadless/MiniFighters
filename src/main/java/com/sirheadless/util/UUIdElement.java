package com.sirheadless.util;

import lombok.NonNull;

import java.util.UUID;

public interface UUIdElement {

    @NonNull
    UUID getUUId();
}
