create table colors
(
    color_id        serial       not null primary key,
    color_name      varchar(255) not null,
    color_hex_value varchar(255) not null
);


create table computers_model_categories
(
    id          serial       not null primary key,
    cm_cat_name varchar(255) not null
);

create table tvs_model_categories
(
    id          serial       not null primary key,
    tm_cat_name varchar(255) not null
);


create table technics_types
(
    tt_id                        serial       not null primary key,
    tt_is_installments_available boolean      not null,
    tt_is_online_order_available boolean      not null,
    tt_manufacture_country       varchar(255) not null,
    tt_manufacturer_name         varchar(255) not null,
    tt_name                      varchar(255) not null
);

create table tt_model_size
(
    tt_model_size_id     serial not null primary key,
    tt_model_size_depth  bigint not null,
    tt_model_size_height bigint not null,
    tt_model_size_width  bigint not null
);

create table tt_models
(
    tt_model_id            serial         not null primary key,
    tt_model_is_in_stock   boolean        not null,
    tt_model_name          varchar(255)   not null,
    tt_model_price         numeric(12, 2) not null,
    tt_model_serial_number varchar(255)   not null
        constraint uk_tt_models_serial_number unique,
    color_id               bigint
        constraint fk_tt_models_colors references colors,
    tt_model_size_id       bigint
        constraint fk_tt_models_tt_model_size references tt_model_size,
    tt_id                  bigint not null
        constraint fk_tt_models_technics_types references technics_types
);

create table computers_models
(
    cm_processor_type varchar(255),
    tt_model_id       serial not null primary key
        constraint fk_computers_models_tt_models references tt_models,
    cm_cat_id         bigint
        constraint fk_computers_models_computers_model_categories references computers_model_categories,
    tt_id             bigint
);

create table refrigerators_models
(
    rf_model_compressor_type integer,
    rf_doors_count           integer,
    tt_model_id              serial not null primary key
        constraint fk_refrigerators_models_tt_models
            references tt_models
);

create table smartphones_models
(
    sm_cameras_count   integer not null,
    sm_memory_count_gb integer not null,
    tt_model_id        serial  not null primary key
        constraint fk_smartphones_models_smartphones_models
            references tt_models
);


create table tvs_models
(
    tv_model_technology varchar(255),
    tt_model_id         serial not null primary key
        constraint fk_tvs_models_tt_models
            references tt_models,
    tv_model_cat_id     bigint
        constraint fk_tvs_models_tvs_model_categories
            references tvs_model_categories,
    tt_id               bigint
);

create table vacuum_cleaners_models
(
    vc_dust_collector_volume integer not null,
    vc_modes_count           integer,
    tt_model_id              serial not null primary key
        constraint fk_vacuum_cleaners_models_tt_models
            references tt_models
);