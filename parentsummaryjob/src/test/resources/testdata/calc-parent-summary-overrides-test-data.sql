INSERT INTO person(person_id)
VALUES ('10');

INSERT INTO child(child_id, parent_person_id)
VALUES ('1', '10');

INSERT INTO child(child_id, parent_person_id)
VALUES ('2', '10');

insert into parentsummary (parent_summary_id, amount_of_children, amount_of_persons)
values (9, 0, 0);

insert into parentsummary (parent_summary_id, amount_of_children, amount_of_persons)
values (10, 1, 1);

insert into parentsummary (parent_summary_id, amount_of_children, amount_of_persons)
values (11, 2, 4);
