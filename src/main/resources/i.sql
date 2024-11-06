create table colors
(
    color_id        bigserial    not null primary key,
    color_name      varchar(255) not null,
    color_hex_value varchar(255) not null
);

create table model_sizes
(
    ms_size_id     bigserial not null primary key,
    ms_size_depth  bigint    not null,
    ms_size_height bigint    not null,
    ms_size_width  bigint    not null
);

create table technics_types
(
    tt_id                        bigserial    not null primary key,
    tt_is_installments_available boolean      not null,
    tt_is_online_order_available boolean      not null,
    tt_manufacture_country       varchar(255) not null,
    tt_manufacturer_name         varchar(255) not null,
    tt_name                      varchar(255) not null
);

create table models_options
(
    id                bigint not null primary key,
    model_option_name varchar(255),

    tt_id             bigint
        constraint fk_models_options_technics_types
            references technics_types
);


create table technics_models
(
    tm_id            bigint         not null primary key,
    tm_is_in_stock   boolean        not null,
    tm_name          varchar(255)   not null,
    tm_price         numeric(12, 2) not null,

    tm_serial_number varchar(255)   not null
        constraint uk_tm_serial_number unique,

    color_id         bigint         not null
        constraint fk_technics_models_colors
            references colors,

    tm_size_id       bigint
        constraint fk_technics_model_sizes
            references model_sizes,

    tt_id            bigint
        constraint fk_technics_technics_types
            references technics_types
);


create table models_options_values
(
    id                  bigint not null primary key,
    models_option_value varchar(255),

    mo_id               bigint
        constraint fk_mo_values_models_options
            references models_options,

    tm_id               bigint
        constraint fk_mo_values_technics_models
            references technics_models
);


create table technics_types_categories
(
    id           bigint       not null primary key,
    ttc_cat_name varchar(255) not null,

    tt_id        bigint
        constraint fk_tt_categories_technics_types
            references technics_types
);