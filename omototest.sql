CREATE TABLE OMOTO_TEST(
ID BIGINT not null auto_increment,
OMOTORESPONSE VARCHAR(1000),
PRIMARY KEY (ID)) ENGINE=InnoDB;

CREATE TABLE OMOTO_REPORT(
ID BIGINT not null auto_increment,
CLIENTNAME VARCHAR(255),
CLIENTID BIGINT,
NPSSCORE BIGINT,
CITY VARCHAR(255),
UNIT VARCHAR(255),
DEPARTMENT VARCHAR(255),
CAMPAIGN VARCHAR(255),
CAMPAIGNID BIGINT,
REGION VARCHAR(255),
SCNAME VARCHAR(255),
SEGMENTS VARCHAR(255),
RESPONSEDATE TIMESTAMP,
RESPONSEDATESTR VARCHAR(50),
PRIMARY KEY (ID)) ENGINE=InnoDB;



| ID              | bigint(20)   | NO   |     | 0                   |       |
| CLIENTNAME      | varchar(255) | YES  |     | NULL                |       |
| CLIENTID        | bigint(20)   | YES  |     | NULL                |       |
| NPSSCORE        | bigint(20)   | YES  |     | NULL                |       |
| CITY            | varchar(255) | YES  |     | NULL                |       |
| UNIT            | varchar(255) | YES  |     | NULL                |       |
| DEPARTMENT      | varchar(255) | YES  |     | NULL                |       |
| CAMPAIGN        | varchar(255) | YES  |     | NULL                |       |
| CAMPAIGNID      | bigint(20)   | YES  |     | NULL                |       |
| RESPONSEDATE    | timestamp    | NO   |     | 0000-00-00 00:00:00 |       |
| RESPONSEDATESTR | varchar(255) | YES  |     | NULL                |       |
| REGION          | varchar(255) | YES  |     | NULL                |       |
| SCNAME          | varchar(255) | YES  |     | NULL                |       |
| SEGMENTS       