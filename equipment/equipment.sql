CREATE KEYSPACE equipment_domain WITH REPLICATION = { 'class' : 'org.apache.cassandra.locator.SimpleStrategy', 'replication_factor': '1' } AND DURABLE_WRITES = true;

CREATE TABLE equipment_domain.equipment (
    customer_id text,
    last_name text,
    first_name text,
    devfin_credit_limit text,
    devfin_credit_limit_available text,
    devfin_meid text,
    device_description text,
    eligible_installment_subsidy boolean,
    eu text,
    last_credit_evaulation text,
    mdn text,
    pending_orders boolean,
    pin text,
    protection_plan_charges text,
    ric_active_indicator boolean,
    ric_balance text,
    ric_end_date text,
    ric_esn_active_indicator boolean,
    ric_monthly_fee text,
    ric_start_date text,
    role text,
    upgrade_eligiblity_date text,
    PRIMARY KEY (customer_id, last_name, first_name)
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
