INSERT INTO person(person_id, age, name)
VALUES ('10', '50', 'Alfred');

INSERT INTO house(house_id, address, type, zip_code, person_id)
VALUES ('20', 'Str', 'FLAT', '123344', '10');

INSERT INTO child(child_id, age, name, parent_person_id, fav_color, type)
VALUES ('1', '20', 'Pascal', '10', 'blue', 'SON');

INSERT INTO child(child_id, age, name, parent_person_id, fav_color, type)
VALUES ('2', '30', 'Christin', '10', 'red', 'DAUGHTER');
