CREATE TABLE STORE  (
                         ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         NAME VARCHAR(60),
                         LOCATION POINT
) ENGINE=InnoDB;

INSERT INTO STORE VALUES (0, 'Store 1', ST_GEOMFROMTEXT('POINT (1 1)'));
