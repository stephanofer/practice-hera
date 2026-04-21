package com.stephanofer.practice.core.queue;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QueueEligibilityServiceTest {

    @Test
    void allowsRankedWhenGatewaySaysPlayerIsRegistered() {
        UUID playerId = UUID.randomUUID();
        PracticeRegistrationGateway gateway = mock(PracticeRegistrationGateway.class);

        when(gateway.isRegistered(playerId)).thenReturn(true);

        QueueEligibilityService service = new QueueEligibilityService(gateway);

        assertTrue(service.canJoinRanked(playerId));
    }

    @Test
    void blocksRankedWhenGatewaySaysPlayerIsNotRegistered() {
        UUID playerId = UUID.randomUUID();
        PracticeRegistrationGateway gateway = mock(PracticeRegistrationGateway.class);

        when(gateway.isRegistered(playerId)).thenReturn(false);

        QueueEligibilityService service = new QueueEligibilityService(gateway);

        assertFalse(service.canJoinRanked(playerId));
    }
}
