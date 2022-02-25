
INSERT INTO `mesto` (`grad`, `postanski_broj`,`obrisano`) VALUES ('Beograd', '11000',false);
INSERT INTO `mesto` (`grad`, `postanski_broj`,`obrisano`) VALUES ('Novi Sad', '21000',false);
INSERT INTO `mesto` (`grad`, `postanski_broj`,`obrisano`) VALUES ('Loznica', '15000',false);
INSERT INTO `mesto` (`grad`, `postanski_broj`,`obrisano`) VALUES ('Leskovac', '25000',false);
INSERT INTO `mesto` (`grad`, `postanski_broj`,`obrisano`) VALUES ('Kraljevo', '26000',false);
INSERT INTO `mesto` (`grad`, `postanski_broj`,`obrisano`) VALUES ('Nis', '14000',false);

INSERT INTO `preduzece` (`pib`, `adresa`, `email`, `naziv_preduzeca`, `tekuci_racun`, `telefon`, `mesto_id`) VALUES ('123456789', 'Slavka Rodica 22', 'mpetar97@gmail.com', 'Medic DOO', '12341234', '069876543', '1');

INSERT INTO `poslovni_partner` (`pib`, `adresa`, `naziv_poslovnog_partnera`, `obrisano`, `tekuci_racun`, `tip_poslovnog_partnera`, `mesto_id`, `preduzece_id`) VALUES ('111222333', 'Bulevar Oslobodjenja', 'Amazon', false, '999433', '0', '1', '1');
INSERT INTO `poslovni_partner` (`pib`, `adresa`, `naziv_poslovnog_partnera`, `obrisano`, `tekuci_racun`, `tip_poslovnog_partnera`, `mesto_id`, `preduzece_id`) VALUES ('222244445', 'Svetozara Miletica', 'Pet Centar', false , '888353', '0', '2', '1');
INSERT INTO `poslovni_partner` (`pib`, `adresa`, `naziv_poslovnog_partnera`, `obrisano`, `tekuci_racun`, `tip_poslovnog_partnera`, `mesto_id`, `preduzece_id`) VALUES ('444343434', 'Nikola Tesla', 'Zoo Centar', false, '7773343', '0', '3', '1');

INSERT INTO pdv (vrsta_pdv,obrisano) VALUES ('Opsti',false);
INSERT INTO pdv (vrsta_pdv,obrisano) VALUES ('Poseban',false);

INSERT INTO stopa_pdv (rok_vazenja,obrisano,procenat,pdv_id) VALUES ('2022-01-31 07:07:07.000',0,21,1);
INSERT INTO stopa_pdv (rok_vazenja,obrisano,procenat,pdv_id) VALUES ('2022-12-12 07:07:07.000',0,8,2);

INSERT INTO grupa_robe (naziv,obrisano,preduzece_id, pdv_id) VALUES ('Higijena i kozmetika',0,1,1);
INSERT INTO grupa_robe (naziv,obrisano,preduzece_id, pdv_id) VALUES ('Hrana',0,1,2);
INSERT INTO grupa_robe (naziv,obrisano,preduzece_id, pdv_id) VALUES ('igracke za zivotinje',0,1,2);
INSERT INTO grupa_robe (naziv,obrisano,preduzece_id, pdv_id) VALUES ('Odeca i obuca za zivotinje',0,1,2);
INSERT INTO grupa_robe (naziv,obrisano,preduzece_id, pdv_id) VALUES ('Zdjele i podloske ',0,1,1);


INSERT INTO roba (jedinica_mere, naziv_robe, obrisano, grupa_robe_id) VALUES ('komad', 'Hrana za pse Trainer', false, 2);
INSERT INTO roba (jedinica_mere, naziv_robe, obrisano, grupa_robe_id) VALUES ('komad', 'Hrana za pse Royal Cannin', false, 2);
INSERT INTO roba (jedinica_mere, naziv_robe, obrisano, grupa_robe_id) VALUES ('komad', 'Hrana za macke Whiskas', false, 2);
INSERT INTO roba (jedinica_mere, naziv_robe, obrisano, grupa_robe_id) VALUES ('komad', 'Sampon za pse', false, 1);
INSERT INTO roba (jedinica_mere, naziv_robe, obrisano, grupa_robe_id) VALUES ('komad', 'Sampon za macke', false, 1);
INSERT INTO roba (jedinica_mere, naziv_robe, obrisano, grupa_robe_id) VALUES ('komad', 'Frizbi', false, 3);
INSERT INTO roba (jedinica_mere, naziv_robe, obrisano, grupa_robe_id) VALUES ('komad', 'Loptica', false, 3);
INSERT INTO roba (jedinica_mere, naziv_robe, obrisano, grupa_robe_id) VALUES ('komad', 'Gumena kost', false, 3);
INSERT INTO roba (jedinica_mere, naziv_robe, obrisano, grupa_robe_id) VALUES ('komad', 'Masna za macke', false, 4);
INSERT INTO roba (jedinica_mere, naziv_robe, obrisano, grupa_robe_id) VALUES ('komad', 'Duks za pse', false, 4);
INSERT INTO roba (jedinica_mere, naziv_robe, obrisano, grupa_robe_id) VALUES ('komad', 'Patike za pse', false, 4);
INSERT INTO roba (jedinica_mere, naziv_robe, obrisano, grupa_robe_id) VALUES ('komad', 'Jakna za pse', false, 4);
INSERT INTO roba (jedinica_mere, naziv_robe, obrisano, grupa_robe_id) VALUES ('komad', 'Cinija za hranu', false, 5);
INSERT INTO roba (jedinica_mere, naziv_robe, obrisano, grupa_robe_id) VALUES ('komad', 'Automatska pojilica', false, 5);
INSERT INTO roba (jedinica_mere, naziv_robe, obrisano, grupa_robe_id) VALUES ('komad', 'Dvostruka cinijica', false, 5);

INSERT INTO `cenovnik` (`kraj_roka_trajanja`, `obrisano`, `pocetak_roka_trajanja`, `poslovni_partner_id`, `preduzece_id`) VALUES ('2022-05-05', false, '2021-12-12', '1', '1');
INSERT INTO `cenovnik` (`kraj_roka_trajanja`, `obrisano`, `pocetak_roka_trajanja`, `poslovni_partner_id`, `preduzece_id`) VALUES ('2024-07-05', false, '2020-08-08', '2', '1');
INSERT INTO `cenovnik` (`kraj_roka_trajanja`, `obrisano`, `pocetak_roka_trajanja`, `poslovni_partner_id`, `preduzece_id`) VALUES ('2023-05-05', false, '2019-11-06', '3', '1');

INSERT INTO `poslovna_godina` (`godina_poslovanja`, `obrisano`, `zakljucena_godina`) VALUES ('2021', false, false);

INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('2000', 1, false, 1);
INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('3000', 1, false, 2);
INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('1000', 1, false, 3);
INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('800', 1, false, 4);
INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('500', 1, false, 5);
INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('400', 1, false, 6);

INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('2000', 2, false, 1);
INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('3000', 2, false, 2);
INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('1000', 2, false, 3);
INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('800', 2, false, 4);
INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('500', 2, false, 5);
INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('400', 2, false, 6);

INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('2000', 3, false, 1);
INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('3000', 3, false, 2);
INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('1000', 3, false, 3);
INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('800', 3, false, 4);
INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('500', 3, false, 5);
INSERT INTO `stavka_cenovnika` (`cena`, `cenovnik_id`, `obrisano`, `roba_id`) VALUES ('400', 3, false, 6);

