CREATE KEYSPACE IF NOT EXISTS customer_domain WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

DROP TYPE IF EXISTS customer_domain.AddressUDT;							   
CREATE TYPE customer_domain.AddressUDT(
ADR_LINE_1 text,
ADR_LINE_2 text,
ADR_LINE_3 text,
CITY text,
STATE text,
ZIP_CODE text,
COUNTRY text
);

DROP TABLE IF EXISTS customer_domain.Customer;
CREATE TABLE customer_domain.Customer(
customer_id text,
faid text,
first_name text,
last_name text,
primary_contact_number text,
account_status text,
credit_class text,
approved_lines text,
plan text,
address AddressUDT,
PRIMARY KEY (customer_id, faid, last_name)
    )WITH CLUSTERING ORDER BY (faid ASC, last_name ASC);
              CREATE INDEX IF NOT EXISTS Customer_faid_idx ON customer_domain.Customer(faid);
              CREATE INDEX IF NOT EXISTS Customer_last_name_idx ON customer_domain.Customer(last_name);      

			  
			  
DROP MATERIALIZED VIEW IF EXISTS customer_domain.Customer_view;                           
CREATE MATERIALIZED VIEW IF NOT EXISTS customer_domain.Customer_view 
			   AS SELECT customer_id, faid, first_name, last_name, primary_contact_number, 
				account_status,	credit_class, approved_lines, plan, address 		   
			   FROM customer_domain.Customer 
			   WHERE faid IS NOT NULL AND customer_id IS NOT NULL AND last_name IS NOT NULL
			   PRIMARY KEY (faid, customer_id , last_name);
							   


====================================================================================

	
	
	
DROP TABLE IF EXISTS customer_domain.Address;							   
CREATE TABLE customer_domain.Address(
customer_id text,
ADR_LINE_1 text,
ADR_LINE_2 text,
ADR_LINE_3 text,
CITY text,
STATE text,
ZIP_CODE text,
COUNTRY text,
PRIMARY KEY (customer_id, ADR_LINE_1, ADR_LINE_2)
    )WITH CLUSTERING ORDER BY (ADR_LINE_1 ASC, ADR_LINE_2 ASC);
              CREATE INDEX IF NOT EXISTS Address_ADR_LINE_1_idx ON customer_domain.Address(ADR_LINE_1);
              CREATE INDEX IF NOT EXISTS Address_ADR_LINE_2_idx ON customer_domain.Address(ADR_LINE_2);      



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
