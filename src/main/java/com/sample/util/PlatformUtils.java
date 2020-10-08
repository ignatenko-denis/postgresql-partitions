package com.sample.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.ZoneOffset;
import java.util.Locale;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlatformUtils {
    public static final Locale RU_LOCALE = new Locale("ru", "RU");
    public static final ZoneOffset ZONE = ZoneOffset.UTC;
}
