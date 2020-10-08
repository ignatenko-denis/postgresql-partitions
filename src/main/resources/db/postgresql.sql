SET search_path = sample;

CREATE TABLE IF NOT EXISTS sample_rq
(
    id                   UUID                        NOT NULL,
    request_received_key VARCHAR(6)                  NOT NULL,
    code                 VARCHAR(40)                 NOT NULL,
    start                DATE                        NOT NULL,
    "end"                DATE                        NOT NULL,
    request_received     TIMESTAMP(3) WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id, request_received_key),
    CONSTRAINT date_period_start_less_end CHECK (start <= "end")
) PARTITION BY LIST (request_received_key);


-- Warning: Admin should manually create new partitions.
-- Warning: Admin should manually delete old partitions and then execute VACUUM (VERBOSE, ANALYZE);
-- see PartitionGenerator.java
CREATE TABLE sample_rq_2020_1 PARTITION OF sample_rq
    FOR VALUES IN ('2020_1');
CREATE TABLE sample_rq_2020_2 PARTITION OF sample_rq
    FOR VALUES IN ('2020_2');

CREATE TABLE sample_rq_2021_1 PARTITION OF sample_rq
    FOR VALUES IN ('2021_1');
CREATE TABLE sample_rq_2021_2 PARTITION OF sample_rq
    FOR VALUES IN ('2021_2');

CREATE TABLE sample_rq_2022_1 PARTITION OF sample_rq
    FOR VALUES IN ('2022_1');
CREATE TABLE sample_rq_2022_2 PARTITION OF sample_rq
    FOR VALUES IN ('2022_2');

CREATE TABLE sample_rq_2023_1 PARTITION OF sample_rq
    FOR VALUES IN ('2023_1');
CREATE TABLE sample_rq_2023_2 PARTITION OF sample_rq
    FOR VALUES IN ('2023_2');

CREATE TABLE sample_rq_2024_1 PARTITION OF sample_rq
    FOR VALUES IN ('2024_1');
CREATE TABLE sample_rq_2024_2 PARTITION OF sample_rq
    FOR VALUES IN ('2024_2');
