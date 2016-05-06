-- -------------------------------------------------------  --
-- creatie tabel serie                                      --
-- -------------------------------------------------------  --
CREATE TABLE SERIE (
    SERIE_ID              VARCHAR2(36)  NOT NULL,
    VERSIE                INTEGER       NOT NULL,
    LAST_MODIFIED_DATE    DATE          NOT NULL,
    PRIMARY KEY (SERIE_ID)
);

GRANT SELECT ON SERIE TO SERIESTRACKER_ROLE_RO;
GRANT DELETE, INSERT, SELECT, UPDATE ON SERIE TO SERIESTRACKER_ROLE_RW;
