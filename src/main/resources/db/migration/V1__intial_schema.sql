CREATE TABLE category
(
    id               BIGINT   NOT NULL,
    created_at       datetime NULL,
    last_updated_at  datetime NULL,
    is_deleted       BIT(1) NULL,
    name             VARCHAR(255) NOT NULL,
    `description`    VARCHAR(255) NULL,
    subcategories_id BIGINT NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE product
(
    id              BIGINT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    is_deleted      BIT(1) NULL,
    title           VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    price DOUBLE NULL,
    imageurl        VARCHAR(255) NULL,
    category_id     BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE subcategory
(
    id              BIGINT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    is_deleted      BIT(1) NULL,
    lastname        VARCHAR(255) NULL,
    CONSTRAINT pk_subcategory PRIMARY KEY (id)
);

ALTER TABLE category
    ADD CONSTRAINT uc_category_name UNIQUE (name);

ALTER TABLE category
    ADD CONSTRAINT FK_CATEGORY_ON_SUBCATEGORIES FOREIGN KEY (subcategories_id) REFERENCES subcategory (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);