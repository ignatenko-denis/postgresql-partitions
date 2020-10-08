package com.sample.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "sample_rq")
@IdClass(SampleRqPk.class)
@Data
public class SampleRq implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Id
    @Column(name = "request_received_key", nullable = false)
    private String rqReceivedKey;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "start", nullable = false)
    private LocalDate start;

    @Column(name = "\"end\"", nullable = false)
    private LocalDate end;

    @Column(name = "request_received", nullable = false)
    private OffsetDateTime rqReceived;
}
