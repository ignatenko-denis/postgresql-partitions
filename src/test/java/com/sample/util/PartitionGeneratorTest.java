package com.sample.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Slf4j
class PartitionGeneratorTest {
    private static final String TABLE_NAME = "sample_rq";

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                arguments(TABLE_NAME, 2020, 2024, 10),
                arguments(TABLE_NAME, 2020, 2020, 2),
                arguments(TABLE_NAME, 2020, 2021, 4),
                arguments(TABLE_NAME, 2021, 2020, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    void generate(String tableName, int from, int to, int expected) {
        String result = PartitionGenerator.generate(tableName, from, to);

        log.info(result);
        assertNotNull(result);
        assertEquals(expected, StringUtils.countMatches(result, "CREATE TABLE "));
    }
}