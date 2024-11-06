CREATE TABLE colors
(
    color_id        BIGSERIAL    NOT NULL,
    color_name      VARCHAR(255) NOT NULL,
    color_hex_value VARCHAR(255) NOT NULL,
    CONSTRAINT colors_pkey PRIMARY KEY (color_id)
);

CREATE TABLE model_sizes
(
    ms_size_id     BIGSERIAL NOT NULL,
    ms_size_depth  BIGINT    NOT NULL,
    ms_size_height BIGINT    NOT NULL,
    ms_size_width  BIGINT    NOT NULL,
    CONSTRAINT model_sizes_pkey PRIMARY KEY (ms_size_id)
);

CREATE TABLE models_options
(
    id                BIGSERIAL NOT NULL,
    model_option_name VARCHAR(255),
    ttd_id            BIGINT,
    CONSTRAINT models_options_pkey PRIMARY KEY (id)
);

CREATE INDEX idx_models_options_tt_id ON models_options (ttd_id);
CREATE INDEX idx_models_options_name ON models_options (model_option_name);
CREATE INDEX idx_models_options_id ON models_options (id);


CREATE TABLE models_options_values
(
    id                  BIGSERIAL NOT NULL,
    models_option_value VARCHAR(255),
    mo_id               BIGINT,
    tm_id               BIGINT,
    CONSTRAINT models_options_values_pkey PRIMARY KEY (id)
);

CREATE INDEX idx_models_options_values_mo_id ON models_options_values (mo_id);
CREATE INDEX idx_models_options_values_tm_id ON models_options_values (tm_id);
CREATE INDEX idx_models_options_values_value ON models_options_values (models_option_value);
CREATE INDEX idx_models_options_values_id ON models_options_values (id);

CREATE TABLE technics_models
(
    tm_id            BIGSERIAL      NOT NULL,
    tm_is_in_stock   BOOLEAN        NOT NULL,
    tm_name          VARCHAR(255)   NOT NULL,
    tm_price         numeric(12, 2) NOT NULL,
    tm_serial_number VARCHAR(255)   NOT NULL,
    color_id         BIGINT,
    tm_size_id       BIGINT,
    ttd_id           BIGINT,
    CONSTRAINT technics_models_pkey PRIMARY KEY (tm_id)
);

CREATE INDEX idx_technics_models_tm_id ON technics_models (tm_id);
CREATE INDEX idx_technics_models_tm_is_in_stock ON technics_models (tm_is_in_stock);
CREATE INDEX idx_technics_models_tm_price ON technics_models (tm_price);
CREATE INDEX idx_technics_models_ttd_id ON technics_models (ttd_id);

CREATE TABLE technics_type
(
    tt_id   BIGSERIAL    NOT NULL,
    tt_name VARCHAR(255) NOT NULL,
    CONSTRAINT technics_type_pkey PRIMARY KEY (tt_id)
);

CREATE INDEX idx_technics_type_tt_id ON technics_type (tt_id);
CREATE INDEX idx_technics_type_tt_name ON technics_type (tt_name);

CREATE TABLE technics_types_categories
(
    id           BIGSERIAL    NOT NULL,
    ttc_cat_name VARCHAR(255) NOT NULL,
    ttd_id       BIGINT,
    CONSTRAINT technics_types_categories_pkey PRIMARY KEY (id)
);

CREATE INDEX idx_technics_types_categories_id ON technics_types_categories (id);
CREATE INDEX idx_technics_types_categories_ttc_cat_name ON technics_types_categories (ttc_cat_name);
CREATE INDEX idx_technics_types_categories_ttd_id ON technics_types_categories (ttd_id);

CREATE TABLE technics_types_data
(
    ttd_id                        BIGSERIAL    NOT NULL,
    ttd_is_installments_available BOOLEAN      NOT NULL,
    ttd_is_online_order_available BOOLEAN      NOT NULL,
    ttd_manufacture_country       VARCHAR(255) NOT NULL,
    ttd_manufacturer_name         VARCHAR(255) NOT NULL,
    ttd_name                      VARCHAR(255) NOT NULL,
    tt_id                         BIGINT,
    CONSTRAINT technics_types_data_pkey PRIMARY KEY (ttd_id)
);

CREATE INDEX idx_technics_types_data_ttd_id ON technics_types_data (ttd_id);
CREATE INDEX idx_technics_types_data_ttc_ttd_is_installments_available ON technics_types_data (ttd_is_installments_available);
CREATE INDEX idx_technics_types_data_ttd_ttd_is_online_order_available ON technics_types_data (ttd_is_online_order_available);
CREATE INDEX idx_technics_types_data_ttd_ttd_name ON technics_types_data (ttd_name);
CREATE INDEX idx_technics_types_data_ttd_tt_id ON technics_types_data (tt_id);

ALTER TABLE technics_models
    ADD CONSTRAINT uk_37csl7g5gu8wa0k2oaa4s5nas UNIQUE (tm_serial_number);

ALTER TABLE models_options
    ADD CONSTRAINT fk35afmmol28966t622k5dn7mfx FOREIGN KEY (ttd_id) REFERENCES technics_types_data (ttd_id) ON DELETE NO ACTION;

ALTER TABLE models_options_values
    ADD CONSTRAINT fkb6a51vjrwhb6hfdw8l94qpdva FOREIGN KEY (mo_id) REFERENCES models_options (id) ON DELETE NO ACTION;

ALTER TABLE technics_models
    ADD CONSTRAINT fkbglyvwdwwwooymy71bbhec8rq FOREIGN KEY (tm_size_id) REFERENCES model_sizes (ms_size_id) ON DELETE NO ACTION;

ALTER TABLE technics_types_data
    ADD CONSTRAINT fkbsfwm5p8j6f5n3fm1hwey0g20 FOREIGN KEY (tt_id) REFERENCES technics_type (tt_id) ON DELETE NO ACTION;

ALTER TABLE technics_models
    ADD CONSTRAINT fkbuf139gh9h96big0r0av7vk4d FOREIGN KEY (ttd_id) REFERENCES technics_types_data (ttd_id) ON DELETE NO ACTION;

ALTER TABLE technics_types_categories
    ADD CONSTRAINT fkeg5de2dktcb6qan1aa7ecjnds FOREIGN KEY (ttd_id) REFERENCES technics_types_data (ttd_id) ON DELETE NO ACTION;

ALTER TABLE models_options_values
    ADD CONSTRAINT fklcffulytpok9rtqic7jnw133g FOREIGN KEY (tm_id) REFERENCES technics_models (tm_id) ON DELETE NO ACTION;

ALTER TABLE technics_models
    ADD CONSTRAINT fkmk6fwpd7d72ekcwnk2c92p9w5 FOREIGN KEY (color_id) REFERENCES colors (color_id) ON DELETE NO ACTION;