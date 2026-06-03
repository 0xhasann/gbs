package com.global.booking.service.mapper;

import java.time.ZoneId;
import java.time.ZoneOffset;

import org.springframework.stereotype.Component;

import com.global.booking.service.booking.entity.Session;
import com.global.booking.service.dto.response.SessionResponse;

@Component
public class TimeZoneMapper {

    public SessionResponse mapSession(
            Session session,
            String timezone) {

        var start = session.getStartTimeUtc()
                .atZone(ZoneOffset.UTC)
                .withZoneSameInstant(
                        ZoneId.of(timezone));

        var end = session.getEndTimeUtc()
                .atZone(ZoneOffset.UTC)
                .withZoneSameInstant(
                        ZoneId.of(timezone));

        return SessionResponse.builder()
                .sessionId(session.getId())
                .startTime(start.toString())
                .endTime(end.toString())
                .build();
    }

}
