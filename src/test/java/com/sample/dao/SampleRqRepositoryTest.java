package com.sample.dao;

import com.sample.entity.SampleRq;
import com.sample.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.OffsetDateTime;
import java.util.UUID;

import static com.sample.util.DateUtil.formatHalfYear;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = "/config/application.yml")
class SampleRqRepositoryTest {
    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    private SampleRqRepository rqRepository;

    @Test
    void findByRqUid() {
        SampleRq rq = build();
        rqRepository.save(rq);

        Page<SampleRq> page = rqRepository.findByCode(rq.getCode(),
                PageRequest.of(0, 10));

        assertEquals(1, page.getNumberOfElements());

        rq = page.get().findFirst().get();
        validate(rq);

        rqRepository.delete(rq);
    }

    private SampleRq build() {
        SampleRq result = new SampleRq();

        OffsetDateTime time = DateUtil.toDateTime("2020-01-01T22:01:34.000+0300");

        UUID uuid = UUID.randomUUID();
        result.setId(uuid);
        result.setRqReceivedKey(formatHalfYear(time));
        result.setCode(uuid.toString());
        result.setStart(DateUtil.toDate("2020-01-01"));
        result.setEnd(DateUtil.toDate("2020-06-01"));
        result.setRqReceived(time);

        return result;
    }

    private void validate(SampleRq rq) {
        assertNotNull(rq.getId());
        assertEquals("2020_1", rq.getRqReceivedKey());
        assertEquals(rq.getId().toString(), rq.getCode());
        assertEquals("2020-01-01", DateUtil.format(rq.getStart()));
        assertEquals("2020-06-01", DateUtil.format(rq.getEnd()));
        assertEquals("2020-01-01T22:01:34.000+0300", DateUtil.format(rq.getRqReceived()));
    }
}