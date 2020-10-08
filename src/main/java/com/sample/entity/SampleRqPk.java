package com.sample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SampleRqPk implements Serializable {
    private UUID id;

    private String rqReceivedKey;
}