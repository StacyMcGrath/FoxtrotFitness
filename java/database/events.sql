BEGIN TRANSACTION;

DROP TABLE IF EXISTS event_activity_type;
DROP TABLE IF EXISTS activity_type;
DROP TABLE IF EXISTS event;

DROP SEQUENCE IF EXISTS seq_activity_type_id;
DROP SEQUENCE IF EXISTS seq_event_id;


CREATE SEQUENCE seq_event_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE event (
	event_id int DEFAULT nextval('seq_event_id'::regclass) NOT NULL,
	event_name varchar(50) NOT NULL,
	description varchar(1000),
	start_date date,
	end_date date,
	user_activity_goal int,
	total_activity_goal int,
	CONSTRAINT PK_event PRIMARY KEY (event_id)
);

CREATE SEQUENCE seq_activity_type_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE activity_type (
	activity_type_id int DEFAULT nextval('seq_activity_type_id'::regclass) NOT NULL,
	activity_type varchar(50) NOT NULL,
	CONSTRAINT PK_activity_type PRIMARY KEY (activity_type_id)
);

CREATE TABLE event_activity_type (
	event_id int NOT NULL,
	activity_type_id int NOT NULL,
	CONSTRAINT pk_event_activity_typt_id PRIMARY KEY (event_id, activity_type_id),
	FOREIGN KEY(event_id) REFERENCES event(event_id),
	FOREIGN KEY(activity_type_id) REFERENCES activity_type(activity_type_id)
);



INSERT INTO event (event_name, description, start_date, end_date, user_activity_goal, total_activity_goal)
VALUES ('Java Green Fun Run', 'Java Green is on the run! Each member will try to run (or walk) 10 miles this month, for 200 total team miles!', '2021-08-01', '2021-08-31', 10, 200);

INSERT INTO event (event_name, description, start_date, end_date, user_activity_goal)
VALUES ('TE Bike-a-thon', 'We are rolling! Set a goal to ride your bike 150 miles this month!', '2021-08-01', '2021-08-31', 150);

INSERT INTO event (event_name, description, start_date, end_date, user_activity_goal, total_activity_goal)
VALUES ('Walk the World', 'Walk around the world with us! Can we walk a total of 24901 miles in three months? Each participant''s goal is 100 miles.', '2021-08-01', '2021-10-31', 100, 24901);

INSERT INTO event (event_name, description, start_date, end_date, user_activity_goal)
VALUES ('Foxtrot 5K', 'Lace up your shoes for a virtual 5K run at your convenience this month!', '2021-08-01', '2021-8-31', 5);

INSERT INTO event (event_name, description, start_date, end_date, user_activity_goal)
VALUES ('Swim the Channel', 'The distance across the English Channel is 21 miles. Can you swim that far this month?', '2021-08-01', '2021-08-31', 21);

INSERT INTO event (event_name, description, start_date, end_date, user_activity_goal)
VALUES ('Move it - your way!', 'Run, walk, bike, or swim - anything goes! Just move your body 50 total miles!', '2021-08-01', '2021-08-14', 50);

INSERT INTO event (event_name, description, start_date, end_date, user_activity_goal)
VALUES ('Pan Ohio Hope Ride - Create Your Own 328', 'Can''t join us to ride 328 miles? Complete the miles on your own during the month of September!', '2021-09-01', '2021-09-30', 328);

INSERT INTO event (event_name, description, start_date, end_date, user_activity_goal)
VALUES ('Virtual C2C Relay Run', 'Run the distance from Cincinnati to Columbus - 139 miles - during the month of August!', '2021-08-01', '2021-08-31', 139);

INSERT INTO event (event_name, description, start_date, end_date, total_activity_goal)
VALUES ('Mission to the Moon', 'Can all of us together cover the distance to the moon during 2022? Run, walk, or bike your way across space with us!', '2022-01-01', '2022-12-31', 238900);


INSERT INTO activity_type (activity_type) VALUES ('Running');
INSERT INTO activity_type (activity_type) VALUES ('Walking');
INSERT INTO activity_type (activity_type) VALUES ('Cycling');
INSERT INTO activity_type (activity_type) VALUES ('Swimming');
INSERT INTO activity_type (activity_type) VALUES ('Other');

INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (1, 1);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (1, 2);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (2, 3);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (3, 2);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (4, 1);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (5, 4);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (6, 1);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (6, 2);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (6, 3);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (6, 4);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (6, 5);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (7, 3);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (8, 1);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (9, 1);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (9, 2);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (9, 3);

COMMIT TRANSACTION;

