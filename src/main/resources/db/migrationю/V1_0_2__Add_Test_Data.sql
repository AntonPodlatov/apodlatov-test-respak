insert into technics_type (tt_id, tt_name)
values (1, 'vacuumCleaner'),
       (2, 'smartphone'),
       (3, 'computer'),
       (4, 'refrigerator'),
       (5, 'tv');

INSERT INTO colors (color_id, color_name, color_hex_value)
VALUES (1, 'white', 'FFFFFF'),
       (2, 'black', '000000'),
       (3, 'silver', 'C0C0C0');

insert into technics_types_categories (ttc_id, ttc_cat_name)
values (1, 'notebook'),
       (2, 'desktopComputer'),
       (3, 'smartTv'),
       (4, 'simpleTv');

insert into technics_types_data (ttd_id,
                                 ttd_is_installments_available,
                                 ttd_is_online_order_available,
                                 ttd_manufacture_country,
                                 ttd_manufacturer_name,
                                 tt_id)
values (1, true, false, 'USA', 'Dyson', 1),
       (2, true, true, 'CHI', 'Xiaomi', 1),
       (3, true, true, 'DEU', 'Bosh', 1),

       (4, true, true, 'CHI', 'Apple', 2),
       (5, true, true, 'CHI', 'Xiaomi', 2),
       (6, true, true, 'CHI', 'Huawei', 2),

       (7, true, true, 'CHI', 'Apple', 3),
       (8, true, true, 'KOR', 'Samsung', 3),
       (9, true, false, 'JPN', 'Sony', 3),

       (10, true, true, 'KOR', 'LG', 4),
       (11, true, true, 'CHI', 'Dexp', 4),
       (12, true, true, 'JPN', 'Hitachi', 4),

       (13, true, true, 'KOR', 'Samsung', 5),
       (14, true, false, 'JPN', 'Sony', 5),
       (15, true, false, 'CHI', 'Xiaomi', 5);

insert into technics_type_categories (ttd_id, ttc_id)
values (7, 1),
       (8, 1),
       (9, 1),
       (13, 3),
       (14, 3),
       (15, 3);

DROP PROCEDURE IF EXISTS insert_into_model_sizes;
CREATE PROCEDURE insert_into_model_sizes()
    LANGUAGE plpgsql
AS
$$
DECLARE
    i INTEGER := 1;
BEGIN
    FOR i IN 1..30
        LOOP
            INSERT INTO model_sizes(ms_size_id, ms_size_depth, ms_size_height, ms_size_width)
            VALUES (i, 100, 100, 100);
        END LOOP;
END;
$$;

call insert_into_model_sizes();

insert into technics_models (tm_id,
                             tm_is_in_stock,
                             tm_name,
                             tm_price,
                             tm_serial_number,
                             color_id,
                             tm_size_id,
                             ttd_id)
values (1, true, 'Cyclone V11™ Absolute Extra', 22000, 'CLNCV11', 3, 1, 1),
       (2, true, 'V10 Motorhead', 18000, 'V10MOTOR', 2, 2, 1),
       (3, true, 'Mi Robot Vacuum-Mop P', 25000, 'MIVACUMP', 2, 2, 2),
       (4, true, 'Mi Vacuum Cleaner G10', 23000, 'MIVACG10', 1, 3, 2),
       (5, true, 'Serie 8 BGS7MS64', 20000, 'SERIE8BGSM', 1, 4, 3),
       (6, true, 'ProPower M2378', 19000, 'PROPWR2378', 3, 5, 3),

       (7, true, 'iPhone 13 Pro', 80000, 'IPHONE13P', 1, 5, 4),
       (8, true, 'iPhone 12', 70000, 'IPHONE12', 3, 5, 4),
       (9, true, 'Mi 11', 45000, 'MI11XIAOMI', 3, 5, 5),
       (10, true, 'Redmi Note 10', 25000, 'REDMINOTE10', 1, 5, 5),
       (11, true, 'P50 Pro', 50000, 'HWP50PRO', 2, 5, 6),
       (12, true, 'Mate 40', 48000, 'MATE40HUAWEI', 3, 5, 6),

       (13, true, 'MacBook Pro 16', 120000, 'MBPRO16', 3, 5, 7),
       (14, true, 'MacBook Air', 80000, 'MBAIR13', 2, 5, 7),
       (15, true, 'Galaxy Book', 100000, 'GALAXYBOOK', 2, 5, 8),
       (16, true, 'Notebook Odyssey', 90000, 'NBOOKODYS', 1, 5, 8),
       (17, true, 'Vaio Z', 90000, 'VAIOZ', 1, 5, 9),
       (18, true, 'Vaio SX14', 85000, 'VAIOSX14', 2, 5, 9),

       (19, true, 'GC-B459SQUM', 35000, 'GCB459SQUM1', 2, 5, 10),
       (20, true, 'GC-B509SBSM', 30000, 'GCB509SBSM2', 3, 5, 10),
       (21, true, 'TF050D', 32000, 'DEXPTF050D', 1, 5, 11),
       (22, true, 'DEXP S2-17AHE', 29000, 'DEXPS2-17AHE12', 3, 5, 11),
       (23, true, 'Hitachi R-WB800', 55000, 'HITACHIRWB', 3, 5, 12),
       (24, true, 'Hitachi JX330', 50000, 'HITACHIJX3', 2, 5, 12),

       (25, true, 'Samsung UHD', 40000, 'SAMSUNGUHD', 2, 5, 13),
       (26, true, 'Samsung QLED', 42000, 'SAMSUNGQLED', 1, 5, 13),
       (27, true, 'Sony Bravia', 45000, 'SONYBRAVIA', 3, 5, 14),
       (28, true, 'Sony X90J', 47000, 'SONYX90J', 2, 5, 14),
       (29, true, 'Mi TV 4S', 30000, 'MITV4S', 1, 5, 15),
       (30, true, 'Mi TV 5X', 32000, 'MITV5X', 3, 5, 15);

insert into models_options(id, model_option_name, tt_id)
VALUES (1, 'tvTechnology', 5),        --tv--
       (2, 'dustCollectorVolume', 1), --vacuum cleaner--
       (3, 'modesCount', 1),          --vacuum cleaner--
       (4, 'doorsCount', 4),          --refrigerator--
       (5, 'compressorType', 4),      --refrigerator--
       (6, 'nemoryGb', 2),            --smartphone--
       (7, 'camerasCount', 2),        --smartphone--
       (8, 'processorType', 3); --computer--

insert into models_options_values(id, mo_id, models_option_value, tm_id)
VALUES (1, 1, 'LED', 25),
       (2, 1, 'OLED', 26),
       (3, 1, 'QD-OLED', 27),
       (4, 1, 'QNED', 28),
       (5, 1, 'QNED', 29),
       (6, 1, 'QNED', 30),

       (7, 2, '30', 1),
       (8, 2, '31', 2),
       (9, 2, '31', 3),
       (10, 2, '40', 4),
       (11, 2, '80', 5),
       (12, 2, '91', 6),

       (13, 3, '30', 1),
       (14, 3, '31', 1),
       (15, 3, '31', 3),
       (16, 3, '40', 4),
       (17, 3, '80', 5),
       (18, 3, '91', 6),

       (19, 4, '2', 19),
       (20, 4, '2', 20),
       (21, 4, '3', 21),
       (22, 4, '1', 22),
       (23, 4, '2', 23),
       (24, 4, '2', 24),

       (25, 5, 'Screw', 19),
       (26, 5, 'Screw', 20),
       (27, 5, 'Scroll', 21),
       (28, 5, 'Rotary', 22),
       (29, 5, 'Centrifugal', 23),
       (30, 5, 'Centrifugal', 24),

       (31, 6, '8', 7),
       (32, 6, '16', 8),
       (33, 6, '24', 9),
       (34, 6, '64', 10),
       (35, 6, '12', 11),
       (36, 6, '32', 12),

       (37, 7, '3', 7),
       (38, 7, '2', 8),
       (39, 7, '2', 9),
       (40, 7, '4', 10),
       (41, 7, '2', 11),
       (42, 7, '3', 12),

       (43, 8, 'Intel Atom', 7),
       (44, 8, 'Intel Pentium 4', 8),
       (45, 8, 'Intel Pentium Silver', 9),
       (46, 8, 'AMD Ryzen 5 5600G, OEM', 10),
       (47, 8, 'AMD Athlon 64', 11),
       (48, 8, 'Intel Xeon', 12)