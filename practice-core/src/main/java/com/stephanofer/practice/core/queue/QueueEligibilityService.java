package com.stephanofer.practice.core.queue;

import com.stephanofer.practice.api.queue.PracticeRegistrationGateway;

import java.util.UUID;

public final class QueueEligibilityService {

    private final PracticeRegistrationGateway registrationGateway;

    public QueueEligibilityService(PracticeRegistrationGateway registrationGateway) {
        this.registrationGateway = registrationGateway;
    }

    public boolean canJoinRanked(UUID playerId) {
        return registrationGateway.isRegistered(playerId);
    }
}
