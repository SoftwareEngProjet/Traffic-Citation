DELETE from `driver`;

insert into `driver`(name,suspended,revoked,birthday,license)
values 
('Adam Savage', false, false, '2000-01-01', 'F0234-23234-13562'),
('Mike Savage', false, false, '2000-01-01', 'F0234-23234-12562'),
('Matt Savage', false, true, '2000-02-01', 'F0134-53234-12562'),
('Fred Savage', false, false, '2000-03-01', 'F0234-43234-12562'),
('Bill Savage', true, false, '2000-04-05', 'F0234-33234-12562'),
('Adam Smith', false, false, '2000-01-12', 'F0234-63234-12562'),
('Adam Phil', false, false, '2000-05-23', 'F0234-73234-12562');

delete from `officer`;

insert into `officer` (name)
values 
('Graeme Hollingsworth'),
('Adam Hollingsworth'),
('Graeme Smith'),
('Phil Bill'),
('Matt Frolinio'),
('Mike Boyer');

delete from vehicle;

insert into vehicle (license, make,stolen, registered, wanted, driver_id)
values
('GE2E24', 'Ford', false,false,true,1),
('YE2E24', 'Dodge', false,false,true,1),
('TED231', 'Buick', true,false,true,2),
('YE2231', 'Toyota', false,true,true,3),
('YE2652', 'Ford', false,true,true,4),
('TE2E24', 'Honda', false,false,true,5),
('UT4E24', 'Dodge', false,false,true,4);

delete from school;

insert into school (day_one, day_two, driver_id)
values
('2020-01-01 07:00:00','2020-01-02 07:00:00',1),
('2020-01-01 07:00:00','2020-01-02 07:00:00',2),
('2020-01-01 07:00:00','2020-01-02 07:00:00',3),
('2020-01-01 07:00:00','2020-01-02 07:00:00',4),
('2020-01-01 07:00:00','2020-01-02 07:00:00',5);

insert into school (day_one, driver_id)
values
('2020-01-01 07:00:00',6),
('2020-01-02 07:00:00',7);

delete from offense;

insert into offense (`date`, fine, paid, officer_id, driver_id)
values
('2020-01-01', 122.23, true, 1, 1),
('2019-01-01', 1122.23, false, 4, 3),
('2020-02-01', 112.23, true, 4, 2),
('2020-03-01', 122.23, true, 5, 7),
('2020-01-04', 222.23, false, 1, 1),
('2020-01-23', 422.23, true, 1, 1),
('2020-01-12', 522.23, false, 4, 6);

delete from ticket;

insert into ticket (offense_id)
values
(1),
(2);

delete from warrant;

insert into warrant (offense_id, description)
values
(3, 'Reckless Driving'),
(4, 'No Seat Belt');

delete from citation;

insert into citation (offense_id, vehicle_id)
values
(5,6),
(6,2),
(7,4);

delete from traffic_codes;

insert into traffic_codes (description, violation)
values
('Parking Violation', true),
('Reckless Driving', true),
('No signal light', false),
('Proceed through red light', true);

delete from offense_has_traffic_codes;

insert into offense_has_traffic_codes (offense_id, traffic_codes_id)
values
(1,1),
(2,2),
(3,2);








