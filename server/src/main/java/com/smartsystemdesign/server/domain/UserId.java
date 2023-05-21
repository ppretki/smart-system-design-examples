package com.smartsystemdesign.server.domain;

import java.util.UUID;

public record UserId(UUID id) {

    public static UserId random(){
        return new UserId(UUID.randomUUID());
    }
    public String asString(){
        return id.toString();
    }
}
