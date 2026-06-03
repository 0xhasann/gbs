package com.global.booking.service.mapper;

import org.springframework.stereotype.Component;

import com.global.booking.service.booking.entity.Offering;
import com.global.booking.service.dto.response.OfferingResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OfferingMapper {

        private final TimeZoneMapper timeZoneMapper;

        public OfferingResponse toResponse(
                        Offering offering,
                        String timezone) {

                return OfferingResponse.builder()
                                .offeringId(offering.getId())
                                .offeringName(offering.getName())
                                .courseId(offering.getCourse().getId())
                                .courseName(offering.getCourse().getName())
                                .teacherId(offering.getTeacher().getId())
                                .teacherName(offering.getTeacher().getName())
                                .sessions(
                                                offering.getSessions()
                                                                .stream()
                                                                .map(session -> timeZoneMapper.mapSession(
                                                                                session,
                                                                                timezone))
                                                                .toList())
                                .build();
        }

}
