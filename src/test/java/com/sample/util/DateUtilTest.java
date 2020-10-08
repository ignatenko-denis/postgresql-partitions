package com.sample.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static com.sample.util.PlatformUtils.ZONE;

class DateUtilTest {
    private static Stream<Arguments> format() {
        return Stream.of(
                arguments(null, null),
                arguments(OffsetDateTime.of(2020, 6, 15,
                        22, 57, 58, 0, ZONE), "2020-06-15T22:57:58.000+0000")
        );
    }

    @ParameterizedTest
    @MethodSource("format")
    void format(OffsetDateTime source, String expected) {
        assertEquals(expected, DateUtil.format(source));
    }

    private static Stream<Arguments> formatHalfYear() {
        return Stream.of(
                arguments(null, null),
                arguments(OffsetDateTime.of(2020, 6, 30,
                        22, 57, 58, 0, ZONE), "2020_1"),
                arguments(OffsetDateTime.of(2020, 7, 1,
                        22, 57, 58, 0, ZONE), "2020_2"),
                arguments(OffsetDateTime.of(2021, 1, 1,
                        22, 57, 58, 0, ZONE), "2021_1")
        );
    }

    @ParameterizedTest
    @MethodSource("formatHalfYear")
    void formatHalfYear(OffsetDateTime source, String expected) {
        assertEquals(expected, DateUtil.formatHalfYear(source));
    }

    private static Stream<Arguments> formatLocalDate() {
        return Stream.of(
                arguments(null, null),
                arguments(LocalDate.of(2020, 6, 15), "2020-06-15")
        );
    }

    @ParameterizedTest
    @MethodSource("formatLocalDate")
    void formatLocalDate(LocalDate source, String expected) {
        assertEquals(expected, DateUtil.format(source));
    }

    @ParameterizedTest
    @MethodSource("format")
    void toDateTime(OffsetDateTime expected, String source) {
        assertEquals(expected, DateUtil.toDateTime(source));
    }

    @ParameterizedTest
    @MethodSource("formatLocalDate")
    void toDate(LocalDate expected, String source) {
        assertEquals(expected, DateUtil.toDate(source));
    }
}