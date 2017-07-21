CREATE KEYSPACE customer_domain WITH REPLICATION = { 'class' : 'org.apache.cassandra.locator.SimpleStrategy', 'replication_factor': '1' } AND DURABLE_WRITES = true;

CREATE TYPE customer_domain.addressudt (
    adr_line_1 text,
    adr_line_2 text,
    adr_line_3 text,
    city text,
    state text,
    zip_code text,
    country text
);

CREATE TABLE customer_domain.customer (
    customer_id text,
    faid text,
    last_name text,
    account_status text,
    address frozen<customer_domain.addressudt>,
    approved_lines text,
    credit_class text,
    first_name text,
    plan text,
    primary_contact_number text,
    PRIMARY KEY (customer_id, faid, last_name)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy', 'max_threshold' : 32, 'min_threshold' : 4 }
   AND compression = { 'chunk_length_in_kb' : 64, 'class' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048
   AND crc_check_chance = 1.0;
CREATE INDEX customer_faid_idx ON customer_domain.customer (faid);
CREATE INDEX customer_first_name_idx ON customer_domain.customer (first_name);
CREATE INDEX customer_last_name_idx ON customer_domain.customer (last_name);
CREATE MATERIALIZED VIEW customer_domain.customer_view AS SELECT faid, customer_id, last_name, account_status, address, approved_lines, credit_class, first_name, plan, primary_contact_number FROM customer_domain.customer WHERE faid IS NOT NULL AND customer_id IS NOT NULL AND last_name IS NOT NULL PRIMARY KEY (faid, customer_id, last_name) WITH read_repair_chance = 0.0 AND dclocal_read_repair_chance = 0.1 AND gc_grace_seconds = 864000 AND bloom_filter_fp_chance = 0.01 AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' } AND comment = '' AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy', 'max_threshold' : 32, 'min_threshold' : 4 } AND compression = { 'chunk_length_in_kb' : 64, 'class' : 'org.apache.cassandra.io.compress.LZ4Compressor' } AND default_time_to_live = 0 AND speculative_retry = '99PERCENTILE' AND min_index_interval = 128 AND max_index_interval = 2048 AND crc_check_chance = 1.0;
