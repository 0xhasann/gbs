package com.global.booking.service.mapper;

import org.springframework.stereotype.Component;

import com.global.booking.service.booking.entity.Booking;
import com.global.booking.service.dto.response.ParentBookingViewResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BookingMapper {

        private final TimeZoneMapper timeZoneMapper;

        public ParentBookingViewResponse toResponse(
                        Booking booking,
                        String timezone) {

                return ParentBookingViewResponse.builder()
                                .bookingId(booking.getId())
                                .offeringName(
                                                booking.getOffering().getName())
                                .sessions(
                                                booking.getOffering()
                                                                .getSessions()
                                                                .stream()
                                                                .map(session -> timeZoneMapper.mapSession(
                                                                                session,
                                                                                timezone))
                                                                .toList())
                                .build();
        }

}
