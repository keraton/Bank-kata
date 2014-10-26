package com.bbr;

import java.time.Instant;

public class DateTimeService {

    private static Instant instantMock = null;

    public static void setInstant(Instant mock) {
        instantMock = mock;
    }

    public static void reset() {
        instantMock = null;
    }

    public static Instant getInstant() {
        if (instantMock != null) {
            return instantMock;
        }
        else {
            return Instant.now();
        }
    }
}
