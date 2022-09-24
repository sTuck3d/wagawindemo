INSERT INTO person(person_id, age, name)
VALUES ('10', '50', 'Alfred');

INSERT INTO child(child_id, age, name, parent_person_id, fav_color, type)
VALUES ('1', '20', 'Pascal', '10', 'blue', 'SON');

INSERT INTO meal(meal_id, invented, name)
VALUES ('100', '2000-12-27', 'tacos');

INSERT INTO meal(meal_id, invented, name)
VALUES ('123', '2000-12-27', 'tacos');

INSERT INTO child_meal(child_id, meal_id)
VALUES ('1', '123');
