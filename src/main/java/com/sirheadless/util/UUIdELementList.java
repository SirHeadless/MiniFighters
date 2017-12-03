package com.sirheadless.util;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class UUIdELementList {

    @NonNull
    private List<UUIdElement> list = new ArrayList<>();

    public UUIdElement findElementWithUUId(UUID uuid) {
        return list.stream().filter(element -> element.getUUId().equals(uuid)).findFirst().get();
    }

    public boolean add(UUIdElement uuIdElement) {
        return list.add(uuIdElement);
    }

    public boolean remove(UUIdElement uuIdElement) {
        return list.remove(uuIdElement);
    }

}
