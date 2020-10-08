package com.sample.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PartitionGenerator {
    private static final String END = "\n";

    static String generate(String tableName, int from, int to) {
        StringBuilder result = new StringBuilder(END);

        for (int i = from; i <= to; i++) {
            result.append(generateOne(tableName, i, 1));
            result.append(generateOne(tableName, i, 2));
            result.append(END);
        }

        return result.toString();
    }

    private static String generateOne(String tableName, int from, int half) {
        return String.format("CREATE TABLE %1$s_%2$s_%3$s PARTITION OF %1$s\n" +
                "    FOR VALUES IN ('%2$s_%3$s');\n", tableName, from, half);
    }
}
