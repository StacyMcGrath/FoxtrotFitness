BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('katy','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('faisal','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('stacy','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO user_profile (user_id, first_name, last_name, email_address, handle) 
VALUES (1, 'Sample', 'User', 'user@user.com', 'User');
INSERT INTO user_profile (user_id, first_name, last_name, email_address, handle) 
VALUES (2, 'Sample', 'Admin', 'admin@admin.com', 'Admin');
INSERT INTO user_profile (user_id, first_name, last_name, email_address, handle) 
VALUES (3, 'Katy', 'Richardson', 'katy.berkman@gmail.com', 'KatyR');
INSERT INTO user_profile (user_id, first_name, last_name, email_address, handle) 
VALUES (4, 'Faisal', 'Ismail', 'afismail.25@gmail.com', 'Faisal');
INSERT INTO user_profile (user_id, first_name, last_name, email_address, handle) 
VALUES (5, 'Stacy', 'McGrath', 'stacymcgrath23@gmail.com', 'StacyMc');

INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, total_activity_goal, image_name)
VALUES ('Java Green Fun Run', 'Java Green is on the run! Each member will try to run (or walk) 10 miles this month, for 200 total team miles!', '', '2021-08-01', '2021-08-31', 10, 200, 'event_1.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, image_name)
VALUES ('TE Bike-a-thon', 'We are rolling! Set a goal to ride your bike 150 miles this month!', '', '2021-08-01', '2021-08-31', 150, 'event_2.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, total_activity_goal, image_name)
VALUES ('Walk the World', 'Walk around the world with us! Can we walk a total of 24901 miles in three months? Each participant''s goal is 100 miles.', '', '2021-08-01', '2021-10-31', 100, 24901, 'event_3.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, image_name)
VALUES ('Foxtrot 5K', 'Lace up your shoes for a virtual 5K run at your convenience this month!', '', '2021-08-01', '2021-8-31', 3.1, 'event_4.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, image_name)
VALUES ('Swim the Channel', 'The distance across the English Channel is 21 miles. Can you swim that far this month?', '', '2021-08-01', '2021-08-31', 21, 'event_5.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, image_name)
VALUES ('Move it - your way!', 'Run, walk, bike, or swim - even roller skate! Anything goes! Just move your body 50 total miles!', '', '2021-09-01', '2021-09-14', 50, 'event_6.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, image_name)
VALUES ('Pan Ohio Hope Ride - Create Your Own 328', 'Can''t join us to ride 328 miles? Complete the miles on your own during the month of July!', '', '2021-07-01', '2021-07-31', 328, 'event_7.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, image_name)
VALUES ('Virtual C2C Relay Run', 'Run the distance from Cincinnati to Columbus - 139 miles - during the month of August!', '', '2021-08-01', '2021-08-31', 139, 'event_8.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, total_activity_goal, image_name)
VALUES ('Mission to the Moon', 'Can all of us together cover the distance to the moon during 2022? Run, walk, or bike your way across space with us!', '', '2022-01-01', '2022-12-31', 238900, 'event_9.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, image_name)
VALUES ('Sea to Sea Cycling', 'Set a goal to cycle the distance from Portland, Oregon to Portland, Maine in a year!', '', '2022-01-01', '2022-12-31', 3236, 'event_10.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, image_name)
VALUES ('Walk the Wall - together!', 'Can we collectively walk the length of the Great Wall of China in a month? Get your friends to join and lace up your shoes!', '', '2022-09-01', '2022-09-30', 2145, 'event_11.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, total_activity_goal, image_name)
VALUES ('Coach Steve''s Marathon', 'Java Green is going to collectively run a marathon!! That''s just 1.46 miles each!', '', '2022-08-13', '2022-08-13', '1.46', '26.2','event_12.jpg');

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
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (10, 3);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (11, 2);
INSERT INTO event_activity_type (event_id, activity_type_id) VALUES (12, 1);

INSERT INTO event_user (event_id, user_id) VALUES (1, 3);
INSERT INTO event_user (event_id, user_id) VALUES (2, 3);
INSERT INTO event_user (event_id, user_id) VALUES (5, 3);
INSERT INTO event_user (event_id, user_id) VALUES (1, 4);
INSERT INTO event_user (event_id, user_id) VALUES (3, 4);
INSERT INTO event_user (event_id, user_id) VALUES (7, 4);
INSERT INTO event_user (event_id, user_id) VALUES (6, 5);
INSERT INTO event_user (event_id, user_id) VALUES (8, 5);
INSERT INTO event_user (event_id, user_id) VALUES (9, 5);
INSERT INTO event_user (event_id, user_id) VALUES (12, 3);
INSERT INTO event_user (event_id, user_id) VALUES (12, 4);
INSERT INTO event_user (event_id, user_id) VALUES (10, 3);
INSERT INTO event_user (event_id, user_id) VALUES (11, 4);
INSERT INTO event_user (event_id, user_id) VALUES (12, 5);
INSERT INTO event_user (event_id, user_id) VALUES (4, 5);


INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (3, 1, '2021-07-15', 2.5);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance)
VALUES (3, 1, '2021-07-20', 2.2);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (3, 1, '2021-07-23', 3.1);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (3, 1, '2021-08-01', 6.2);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (3, 2, '2021-07-17', 5);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (3, 2, '2021-07-29', 4.8);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (3, 2, '2021-08-05', 2.5);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (3, 3, '2021-07-25', 10);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (3, 4, '2021-07-26', 1);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (4, 1, '2021-07-10', 4);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance)
VALUES (4, 1, '2021-07-22', 6);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (4, 1, '2021-07-29', 3.1);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (4, 1, '2021-08-04', 13.1);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (4, 2, '2021-07-11', 5);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (4, 2, '2021-07-25', 4.8);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (4, 4, '2021-08-01', 1.8);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (4, 3, '2021-07-20', 20);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (5, 4, '2021-07-26', 1);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (5, 3, '2021-07-10', 25);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance)
VALUES (5, 3, '2021-07-22', 40);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (5, 1, '2021-07-27', 3.1);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (5, 1, '2021-08-04', 13.1);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (5, 5, '2021-07-11', 5);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (5, 2, '2021-07-25', 4.8);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (5, 2, '2021-08-03', 10);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance) 
VALUES (5, 3, '2021-07-26', 20);


COMMIT TRANSACTION;

