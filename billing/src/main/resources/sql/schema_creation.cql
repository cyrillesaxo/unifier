CREATE KEYSPACE IF NOT EXISTS billing_domain WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

billing_nbr

DROP TABLE IF EXISTS billing_domain.billing;
CREATE TABLE billing_domain.billing(
customer_id text,
number_of_billing int,
date, text
PRIMARY KEY (customer_id, number_of_billing, date)
    )WITH CLUSTERING ORDER BY (number_of_billing ASC, date ASC);
          CREATE INDEX IF NOT EXISTS billing_date_idx ON billing_domain.billing(number_of_billing);
          CREATE INDEX IF NOT EXISTS billing_amount_idx ON billing_domain.billing(date); 

DROP TABLE IF EXISTS billing_domain.last_payment;
CREATE TABLE billing_domain.last_payment(
customer_id text,
date text,
amount text,
PRIMARY KEY (customer_id, date, amount)
    )WITH CLUSTERING ORDER BY (date ASC, amount ASC);
          CREATE INDEX IF NOT EXISTS billing_date_idx ON billing_domain.last_payment(date);
          CREATE INDEX IF NOT EXISTS billing_amount_idx ON billing_domain.last_payment(amount);      



DROP TABLE IF EXISTS billing_domain.usage;
CREATE TABLE billing_domain.usage(
customer_id text,
cycle_code text,
start_date text,
end_start text,
offer_name text,
mdn text,
usage_level text,
data_cap text,
used text,
coverage text,
units text,
PRIMARY KEY (billing_id, mdn, cycle_code)
    )WITH CLUSTERING ORDER BY (mdn ASC, cycle_code ASC);
          CREATE INDEX IF NOT EXISTS billing_mdn_idx ON billing_domain.usage(mdn);
          CREATE INDEX IF NOT EXISTS billing_cycle_code_idx ON billing_domain.usage(cycle_code);      


DROP TABLE IF EXISTS billing_domain.charges_credits;
CREATE TABLE billing_domain.charges_credits(
customer_id text,
charge_origin text,
cycle_code text,
mdn text,
charge_type text,
charge_code text,
amount text,
PRIMARY KEY (customer_id, mdn, cycle_code)
    )WITH CLUSTERING ORDER BY (mdn ASC, cycle_code ASC);
          CREATE INDEX IF NOT EXISTS billing_mdn_idx ON billing_domain.charges_credits(mdn);
          CREATE INDEX IF NOT EXISTS billing_cycle_code_idx ON billing_domain.charges_credits(cycle_code);      


DROP TABLE IF EXISTS billing_domain.allowances;
CREATE TABLE billing_domain.allowances(
customer_id text,
cycle_code text,
start_date text,
end_start text,
offer_name text,
mdn text,
allowance text,
used text,
remaining text,
overage text,
units text,
PRIMARY KEY (customer_id, mdn, cycle_code)
    )WITH CLUSTERING ORDER BY (mdn ASC, cycle_code ASC);
          CREATE INDEX IF NOT EXISTS billing_mdn_idx ON billing_domain.allowances(mdn);
          CREATE INDEX IF NOT EXISTS billing_cycle_code_idx ON billing_domain.allowances(cycle_code);      


DROP TABLE IF EXISTS billing_domain.billing_info;
CREATE TABLE billing_domain.billing_info(
customer_id text,
last_billed_amount text,
past_due_balance text,
current_balance text,
balance_due_date text,
last_billed_date text,
next_bill_date text,
PRIMARY KEY (billing_id, current_balance, past_due_balance)
    )WITH CLUSTERING ORDER BY (current_balance ASC, past_due_balance ASC);
          CREATE INDEX IF NOT EXISTS billing_current_balance_idx ON billing_domain.billing_info(current_balance);
          CREATE INDEX IF NOT EXISTS billing_last_name_idx ON billing_domain.billing_info(past_due_balance);      




==========================================================================
DROP TYPE IF EXISTS billing_domain.AddressUDT;							   
CREATE TYPE billing_domain.AddressUDT(
ADR_LINE_1 text,
ADR_LINE_2 text,
ADR_LINE_3 text,
CITY text,
STATE text,
ZIP_CODE text,
COUNTRY text
);

DROP TABLE IF EXISTS billing_domain.billing;
CREATE TABLE billing_domain.billing(
billing_id text,
faid text,
first_name text,
last_name text,
primary_contact_number text,
account_status text,
credit_class text,
approved_lines text,
plan text,
address AddressUDT,
PRIMARY KEY (billing_id, faid, last_name)
    )WITH CLUSTERING ORDER BY (faid ASC, last_name ASC);
              CREATE INDEX IF NOT EXISTS billing_faid_idx ON billing_domain.billing(faid);
              CREATE INDEX IF NOT EXISTS billing_last_name_idx ON billing_domain.billing(last_name);      

			  
			  
DROP MATERIALIZED VIEW IF EXISTS billing_domain.billing_view;                           
CREATE MATERIALIZED VIEW IF NOT EXISTS billing_domain.billing_view 
			   AS SELECT billing_id, faid, first_name, last_name, primary_contact_number, 
				account_status,	credit_class, approved_lines, plan, address 		   
			   FROM billing_domain.billing 
			   WHERE faid IS NOT NULL AND billing_id IS NOT NULL AND last_name IS NOT NULL
			   PRIMARY KEY (faid, billing_id , last_name);
							   


====================================================================================

	
	
	
DROP TABLE IF EXISTS billing_domain.Address;							   
CREATE TABLE billing_domain.Address(
billing_id text,
ADR_LINE_1 text,
ADR_LINE_2 text,
ADR_LINE_3 text,
CITY text,
STATE text,
ZIP_CODE text,
COUNTRY text,
PRIMARY KEY (billing_id, ADR_LINE_1, ADR_LINE_2)
    )WITH CLUSTERING ORDER BY (ADR_LINE_1 ASC, ADR_LINE_2 ASC);
              CREATE INDEX IF NOT EXISTS Address_ADR_LINE_1_idx ON billing_domain.Address(ADR_LINE_1);
              CREATE INDEX IF NOT EXISTS Address_ADR_LINE_2_idx ON billing_domain.Address(ADR_LINE_2);      



===============================================================================================			  
			  
			  

              DROP TABLE IF EXISTS ORGANIZATION_DOMAIN.ORGANIZATION;
              CREATE TABLE IF NOT EXISTS ORGANIZATION_DOMAIN.ORGANIZATION (
                               organization_id text,
                               tax_id text,
                               trading_name text,
                               cas int,
                               PRIMARY KEY (organization_id, tax_id, trading_name)
    )WITH CLUSTERING ORDER BY (tax_id ASC, trading_name ASC);
              CREATE INDEX IF NOT EXISTS organization_tax_id_idx ON ORGANIZATION_DOMAIN.ORGANIZATION(tax_id);
              CREATE INDEX IF NOT EXISTS organization_trading_name_idx ON ORGANIZATION_DOMAIN.ORGANIZATION(trading_name);      


              DROP MATERIALIZED VIEW IF EXISTS ORGANIZATION_DOMAIN.ORGANIZATION_VIEW;                           
              CREATE MATERIALIZED VIEW IF NOT EXISTS ORGANIZATION_DOMAIN.ORGANIZATION_VIEW 
                               AS SELECT organization_id, tax_id, trading_name, cas   
                               FROM ORGANIZATION_DOMAIN.ORGANIZATION 
                               WHERE tax_id IS NOT NULL AND organization_id IS NOT NULL AND trading_name IS NOT NULL
                               PRIMARY KEY (tax_id, organization_id , trading_name);



   
              DROP TABLE IF EXISTS ORGANIZATION_DOMAIN.ORGANIZATION_ANALYTIC;
              CREATE TABLE IF NOT EXISTS ORGANIZATION_DOMAIN.ORGANIZATION_ANALYTIC(                     
                                 observed_at timeuuid, 
                                           organization_id text, 
                                 node_line_count counter,
                                           total counter,
                                           active counter,
                                           suspended counter,
                                           reserved counter,
                                           cancelled counter,
                                           PRIMARY KEY (observed_at, organization_id) 
  )WITH CLUSTERING ORDER BY (organization_id ASC);


INSERT INTO ORGANIZATION_DOMAIN.ORGANIZATION   (organization_id, tax_id, trading_name) VALUES ('node_1', 'tax_1', 'T-mobile1');
  
INSERT INTO ORGANIZATION_DOMAIN.ORGANIZATION   (organization_id, tax_id, trading_name) VALUES ('node_2', 'tax_2', 'T-mobile2');

SELECT * FROM ORGANIZATION_DOMAIN.ORGANIZATION  WHERE organization_id = 'node_1';

SELECT * FROM ORGANIZATION_DOMAIN.ORGANIZATION_VIEW WHERE tax_id = 'tax_1';


===================================================== queries=======================================================





CREATE KEYSPACE IF NOT EXISTS belongings WITH replication = {'class':'SimpleStrategy', 'replication_factor':3};

              CREATE TABLE boxes (                                                                       
                 boxes_id int,                                                                 
                 belongs_to_user text,                                                               
                 box_title text,    
       PRIMARY KEY (boxes_id, belongs_to_user, box_title)                
              );WITH CLUSTERING ORDER BY (belongs_to_user ASC, box_title ASC);
              CREATE INDEX IF NOT EXISTS SegmentFlightID_idx ON belongings.boxes(belongs_to_user);
              CREATE INDEX IF NOT EXISTS BagSegmentDate_idx ON belongings.boxes(box_title);      

              
              CREATE TABLE box_items (                                                                   
                 boxes_id int,                                                                             
                 item_id int,                                                                           
                 size counter,                                                                       
                 PRIMARY KEY(boxes_id, item_id, size)                                                               
              );WITH CLUSTERING ORDER BY (item_id ASC, size DESC);
              CREATE INDEX IF NOT EXISTS SegmentFlightID_idx ON belongings.box_items(item_id);
              CREATE INDEX IF NOT EXISTS BagSegmentDate_idx ON belongings.box_items(size);
              
              CREATE TABLE box_item_names (
                  boxes_id int PRIMARY KEY,
                  item_id int,
                  name text
              );WITH CLUSTERING ORDER BY (item_id ASC, name ASC);
              CREATE INDEX IF NOT EXISTS SegmentFlightID_idx ON belongings.box_items(item_id);
              CREATE INDEX IF NOT EXISTS BagSegmentDate_idx ON belongings.box_items(name);
              
              BEGIN BATCH
                INSERT INTO boxes (boxes_id, belongs_to_user, box_title) VALUES (23442, 'user1', 'the box title');
                INSERT INTO box_items (boxes_id, item_id , name) VALUES (23442, 1, 'itemname1');
                INSERT INTO box_items (boxes_id, item_id , name) VALUES (23442, 1, 'itemname2');
                UPDATE box_items SET size = size + 44 WHERE boxes_id = 23442 AND item_id = 1;                       
                UPDATE box_items SET size = size + 24 WHERE boxes_id = 23442 AND item_id = 2;
              APPLY BATCH
              
              -- Get items for box by ID                                                               
              SELECT size FROM box_items WHERE boxes_id = 23442 AND item_id = 1;
              
              -- Boxes by user ID
              SELECT * FROM boxes WHERE belongs_to_user = 'user1';
