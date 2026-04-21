package com.stephanofer.practice.api.queue;

import java.util.UUID;

public interface PracticeRegistrationGateway {

    boolean isRegistered(UUID playerId);
}
