-- *** CUSTOMER ***
create table customer
(
    "CUSTO_ID"                       int not null,
    "CUSTO_FIRSTNAME"                varchar(255),
    "CUSTO_LASTNAME"                 varchar(255),
    "CUSTO_TECH_VERSION"             INTEGER      NOT NULL DEFAULT 1,
    "CUSTO_TECH_INSERTEDAT"          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);
