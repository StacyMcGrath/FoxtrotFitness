SELECT event_id, event_name, description, start_date, end_date, user_activity_goal, total_activity_goal FROM event WHERE event_id = 1;


INSERT INTO logged_activity (logged_activity_id, user_id, activity_type_id, activity_date, distance) 
VALUES (DEFAULT, 3, 1, '2021-08-03', 5);

INSERT INTO logged_activity (logged_activity_id, user_id, activity_type_id, activity_date, distance) 
VALUES (DEFAULT, 4, 2, '2021-08-03', 10);


INSERT INTO logged_activity (logged_activity_id, user_id, activity_type_id, activity_date, distance) 
VALUES (DEFAULT, 5, 3, '2021-08-02', 15);

