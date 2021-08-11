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
VALUES ('Java Green Fun Run', 'Java Green is on the run! Each member will try to run (or walk) 10 miles this month, for 200 total team miles!', 'For the Virtual Run, get awesome swag, and learn and experience places around the world virtually! We will send you a virtual packet with 12 digital tools to make your run awesome. With Premium packets, we will include a souvenir from your destination! First 10 participants for the Premium packets will get upgraded Tech shirts for free!
We will also send you a complete Training plan with an optional Warrior Fit Game to help you train for your race! Run a 5K, 10K, Half-Marathon, Marathon, or any other run distance anywhere, any place on your own time and route. If you are looking for a fun run, look no further!', '2021-08-01', '2021-08-31', 10, 200, 'event_1.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, image_name)
VALUES ('TE Bike-a-thon', 'We are rolling! Set a goal to ride your bike 150 miles this month!', 'A solid cyclist can comfortably bike 150 miles a month, so let us prove them right!  What is 150 miles, you ask?  About Columbus to Cleveland.  The entire distance (North to South) of Pennsylvania.  ', '2021-08-01', '2021-08-31', 150, 'event_2.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, total_activity_goal, image_name)
VALUES ('Walk the World', 'Walk around the world with us! Can we walk a total of 24,901 miles in three months? Each participant''s goal is 100 miles.', 'How many pairs of shoes does it take to walk around the world? According to Dave Kunst, the first verified man to do so, the answer is 21.
Over the course of four years, three months, and sixteen days, Kunst travelled across thirteen countries by foot, including the U.S., Portugal, India, Afghanistan, and Australia. But he didn’t walk the 14,450 miles alone. During different segments of his journey, he had the help of his two brothers, John and Pete, two dogs, four mules, and an Australian schoolteacher named Jenni Samuel who he later married. While Kunst joined a small list of pedestrian circumnavigators before him who claimed to walk around the land mass of the world, his walk is the first with proof on record.', '2021-08-01', '2021-10-31', 100, 24901, 'event_3.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, total_activity_goal, image_name)
VALUES ('Foxtrot 5K', 'Lace up your shoes for a virtual 5K run at your convenience this month!', 'We are not talking about the dance, we are talking about a run!  The foxtrot is a smooth, progressive dance characterized by long, continuous flowing movements across the dance floor. It is danced to big band (usually vocal) music. The dance is similar in its look to waltz, although the rhythm is in a 4/4 time signature instead of 3/4. Developed in the 1910s, the foxtrot reached its height of popularity in the 1930s and remains practiced today.', '2021-08-01', '2021-8-31', 3.1, 310, 'event_4.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, total_activity_goal, image_name)
VALUES ('Swim the Channel', 'The distance across the English Channel is 21 miles. Can you swim that far this month?', 'Matthew Webb, a 27-year-old merchant navy captain, becomes the first known person to successfully swim the English Channel. Captain Webb accomplished the grueling 21-mile crossing, which really entailed 39 miles of swimming because of tidal currents, in 21 hours and 45 minutes.  We are not asking you to swim the entire channel in one go, but maybe try to do the whole distance in one month.  Good luck, God Speed, and God Save the Queen!', '2021-08-01', '2021-08-31', 21, 2100, 'event_5.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, total_activity_goal, image_name)
VALUES ('Move it - your way!', 'Run, walk, bike, or swim - even roller skate! Anything goes! Just move your body 50 total miles!', 'In the world of traditional cardio, running, swimming and cycling reign supreme. They all build cardiovascular fitness, but each activity offers unique benefits. Surely, one must be better than the others, right?  Actually, the best cardio workout is the one that works for you. And the best cardio workout for you depends on your goals and experience level.', '2021-09-01', '2021-09-14', 50, 5000, 'event_6.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, total_activity_goal, image_name)
VALUES ('Pan Ohio Hope Ride - Create Your Own 328', 'Unable to join us to ride 328 miles? Complete the miles on your own during the month of July!', 'This option creates the flexibility to structure rides when and how you prefer. You can ride 328 miles over the traditional four-day period, or ride a little bit every day of the month - whatever works for you! Zwift, Peloton, and other indoor trainer miles count in addition to any outdoor miles. Details on how to track your mileage will be released as the event draws near. Create Your Own 328 participants will receive a custom bib and finisher medal, are eligible for all fundraising incentives, and are welcome to join us for celebrations and other events.', '2021-07-01', '2021-07-31', 328, 4920, 'event_7.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, total_activity_goal, image_name)
VALUES ('Virtual C2C Relay Run', 'Run the distance from Cincinnati to Columbus - 139 miles - during the month of August!', '', '2021-08-01', '2021-08-31', 139, 1390,'event_8.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, total_activity_goal, image_name)
VALUES ('Mission to the Moon', 'Can all of us together cover the distance to the moon during 2022? Run, walk, or bike your way across space with us!', 'That’s right, we’ll tally yours and other relay participants’ distance with the hope of virtually covering this huge expanse! It’s an audacious challenge, but with your help and the power of the global running community, we think we can make it!', '2022-01-01', '2022-12-31', 2389, 238900, 'event_9.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, total_activity_goal, image_name)
VALUES ('Sea to Sea Cycling', 'Set a goal to cycle the distance from Portland, Oregon to Portland, Maine in a year!', 'The Shining Sea Bikeway (SSB) was named for a line in the song America The Beautiful, written by Falmouth native Katharine Lee Bates. It follows the original route of the New York, New Haven and Hartford Railroad that used to run from Buzzards Bay, through North and West Falmouth, around Woods Hole and into Falmouth Station. In the early 1970’s the Town of Falmouth purchased the right of way, tore up the tracks and officially opened the 3.3-mile Shining Sea Bikeway in 1975.', '2022-01-01', '2022-12-31', 3236, 32360, 'event_10.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, total_activity_goal, image_name)
VALUES ('Walk the Wall - together!', 'Can we collectively walk the length of the Great Wall of China in a month? Get your friends to join and lace up your shoes!', '', '2022-09-01', '2022-09-30', 30, 2145, 'event_11.jpg');
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, total_activity_goal, image_name)
VALUES ('Coach Steve''s Marathon', 'Java Green is going to collectively run a marathon!! That''s just 1.46 miles each!', '', '2022-08-13', '2022-08-13', 1.46, 26.2,'event_12.jpg');


INSERT INTO premade_goals (premade_goal_name, premade_goal_description, premade_user_activity_goal, premade_goal_units) 
VALUES ('Weekly Exercise Time', 'It is recommended that you get 150 minutes of exercise per week! Suggested duration: 1 week', 150, 'minutes');
INSERT INTO premade_goals (premade_goal_name, premade_goal_description, premade_user_activity_goal, premade_goal_units) 
VALUES ('Daily Exercise Time', 'It is recommended that you get 30 minutes of exercise per day! Suggested duration: 1 day', 30, 'minutes');
INSERT INTO premade_goals (premade_goal_name, premade_goal_description, premade_user_activity_goal, premade_goal_units) 
VALUES ('Monthly Cycling Goal', 'Suggested duration: 1 month', 200, 'miles');


INSERT INTO goals (goal_name, start_date, end_date, user_activity_goal, goal_units, user_id) 
VALUES ('Weekly Exercise Time', '2021-08-09', '2021-08-15', 150, 'minutes', 5);
INSERT INTO goals (goal_name, start_date, end_date, user_activity_goal, goal_units, user_id) 
VALUES ('Monthly Cycling Goal', '2021-08-01', '2021-08-31', 200, 'miles', 5);

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

INSERT INTO goal_activity_type (goal_id, activity_type_id) VALUES (1, 1);
INSERT INTO goal_activity_type (goal_id, activity_type_id) VALUES (1, 2);
INSERT INTO goal_activity_type (goal_id, activity_type_id) VALUES (1, 3);
INSERT INTO goal_activity_type (goal_id, activity_type_id) VALUES (1, 4);
INSERT INTO goal_activity_type (goal_id, activity_type_id) VALUES (1, 5);
INSERT INTO goal_activity_type (goal_id, activity_type_id) VALUES (2, 3);

INSERT INTO premade_goal_activity_type (premade_goal_id, activity_type_id) VALUES (1, 1);
INSERT INTO premade_goal_activity_type (premade_goal_id, activity_type_id) VALUES (1, 2);
INSERT INTO premade_goal_activity_type (premade_goal_id, activity_type_id) VALUES (1, 3);
INSERT INTO premade_goal_activity_type (premade_goal_id, activity_type_id) VALUES (1, 4);
INSERT INTO premade_goal_activity_type (premade_goal_id, activity_type_id) VALUES (1, 5);
INSERT INTO premade_goal_activity_type (premade_goal_id, activity_type_id) VALUES (2, 1);
INSERT INTO premade_goal_activity_type (premade_goal_id, activity_type_id) VALUES (2, 2);
INSERT INTO premade_goal_activity_type (premade_goal_id, activity_type_id) VALUES (2, 3);
INSERT INTO premade_goal_activity_type (premade_goal_id, activity_type_id) VALUES (2, 4);
INSERT INTO premade_goal_activity_type (premade_goal_id, activity_type_id) VALUES (2, 5);
INSERT INTO premade_goal_activity_type (premade_goal_id, activity_type_id) VALUES (3, 3);

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


INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (3, 1, '2021-07-15', 2.5, 25);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes)
VALUES (3, 1, '2021-07-20', 2.2, 15);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (3, 1, '2021-07-23', 3.1, 30);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (3, 1, '2021-08-01', 6.2, 45);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (3, 2, '2021-07-17', 5, 60);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (3, 2, '2021-07-29', 4.8, 60);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (3, 2, '2021-08-05', 2.5, 45);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (3, 3, '2021-07-25', 10, 60);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (3, 4, '2021-07-26', 1, 35);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (4, 1, '2021-07-10', 4, 30);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes)
VALUES (4, 1, '2021-07-22', 6, 50);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (4, 1, '2021-07-29', 3.1, 19);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (4, 1, '2021-08-04', 13.1, 120);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (4, 2, '2021-07-11', 5, 45);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (4, 2, '2021-07-25', 4.8, 40);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (4, 4, '2021-08-01', 1.8, 120);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (4, 3, '2021-07-20', 20, 90);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (5, 4, '2021-07-26', 1, 35);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (5, 3, '2021-07-10', 25, 120);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes)
VALUES (5, 3, '2021-07-22', 40, 120);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (5, 1, '2021-07-27', 3.1, 60);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (5, 1, '2021-08-04', 13.1, 200);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (5, 5, '2021-07-11', 5, 25);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (5, 2, '2021-07-25', 4.8, 75);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (5, 2, '2021-08-03', 10, 100);
INSERT INTO logged_activity (user_id, activity_type_id, activity_date, distance, number_of_minutes) 
VALUES (5, 3, '2021-07-26', 20, 75);


COMMIT TRANSACTION;



SELECT premade_goal_id, premade_goal_name, premade_goal_description, premade_user_activity_goal, premade_goal_units 
FROM premade_goals;
