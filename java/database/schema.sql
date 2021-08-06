BEGIN TRANSACTION;

DROP TABLE IF EXISTS logged_activity;
DROP TABLE IF EXISTS event_user;
DROP TABLE IF EXISTS user_profile;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS event_activity_type;
DROP TABLE IF EXISTS activity_type;
DROP TABLE IF EXISTS event;

DROP SEQUENCE IF EXISTS seq_logged_activity_id;
DROP SEQUENCE IF EXISTS seq_user_profile_id;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP SEQUENCE IF EXISTS seq_activity_type_id;
DROP SEQUENCE IF EXISTS seq_event_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE seq_user_profile_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE TABLE user_profile (
        user_profile_id int DEFAULT nextval('seq_user_profile_id'::regclass) NOT NULL,
        user_id int NOT NULL,
        first_name varchar(50) NOT NULL,
        last_name varchar(50) NOT NULL,
        email_address varchar(200) NOT NULL,
        handle varchar(100) NOT NULL,
        CONSTRAINT pk_user_profile PRIMARY KEY (user_profile_id),
        FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE SEQUENCE seq_event_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE event (
	event_id int DEFAULT nextval('seq_event_id'::regclass) NOT NULL,
	event_name varchar(50) NOT NULL,
	description varchar(1000),
        long_description varchar(5000),
	start_date date,
	end_date date,
	user_activity_goal float,
	total_activity_goal float,
        image_name varchar(50),
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
	CONSTRAINT pk_event_activity_type_id PRIMARY KEY (event_id, activity_type_id),
	FOREIGN KEY(event_id) REFERENCES event(event_id),
	FOREIGN KEY(activity_type_id) REFERENCES activity_type(activity_type_id)
);

CREATE TABLE event_user (
	event_id int NOT NULL,
	user_id int NOT NULL,
	CONSTRAINT pk_event_user_id PRIMARY KEY (event_id, user_id),
	FOREIGN KEY(event_id) REFERENCES event(event_id),
	FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE SEQUENCE seq_logged_activity_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE logged_activity (
        logged_activity_id int DEFAULT nextval('seq_logged_activity_id'::regclass) NOT NULL,
        user_id int NOT NULL,
        activity_type_id int NOT NULL,
        activity_date date NOT NULL,
        distance float NOT NULL,
        CONSTRAINT pk_logged_activity PRIMARY KEY (logged_activity_id),
        FOREIGN KEY (user_id) REFERENCES users(user_id),
        FOREIGN KEY (activity_type_id) REFERENCES activity_type(activity_type_id)
        );
        
COMMIT TRANSACTION;


