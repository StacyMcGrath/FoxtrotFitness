SELECT event_id, event_name, description, start_date, end_date, user_activity_goal, total_activity_goal FROM event WHERE event_id = 1;

SELECT logged_activity_id, user_id, activity_type_id, activity_date, distance FROM logged_activity;

--activity by event for all users
SELECT event_user.event_id, event_user.user_id, logged_activity.activity_type_id, logged_activity.distance, logged_activity.activity_date from logged_activity

JOIN event_user ON logged_activity.user_id = event_user.user_id
JOIN event_activity_type ON event_user.event_id = event_activity_type.event_id
JOIN event on event_user.event_id = event.event_id

WHERE event_activity_type.event_id = 1 AND (logged_activity.activity_date >= event.start_date AND logged_activity.activity_date <= event.end_date)
AND logged_activity.activity_type_id IN (SELECT event_activity_type.activity_type_id FROM event_activity_type WHERE event_id = 1)
GROUP BY event_user.event_id, event_user.user_id, logged_activity.activity_type_id, logged_activity.distance, logged_activity.activity_date;

--activity by event for specific user ID
SELECT event_user.event_id, event_user.user_id, logged_activity.activity_type_id, logged_activity.distance, logged_activity.activity_date from logged_activity

JOIN event_user ON logged_activity.user_id = event_user.user_id
JOIN event_activity_type ON event_user.event_id = event_activity_type.event_id
JOIN event on event_user.event_id = event.event_id

WHERE event_activity_type.event_id = 1 AND event_user.user_id = 3 AND (logged_activity.activity_date >= event.start_date AND logged_activity.activity_date <= event.end_date)
AND logged_activity.activity_type_id IN (SELECT event_activity_type.activity_type_id FROM event_activity_type WHERE event_id = 1)
GROUP BY event_user.event_id, event_user.user_id, logged_activity.activity_type_id, logged_activity.distance, logged_activity.activity_date

-- add new event
INSERT INTO event (event_name, description, long_description, start_date, end_date, user_activity_goal, total_activity_goal, image_name) 
VALUES ('Test2', 'Test', 'Test', '2021-08-10', '2021-08-17', 10, 100, 'CoachSteve.jpg');



SELECT activity_type_id FROM activity_type
WHERE activity_type = 'Running'

INSERT INTO event_activity_type (event_id, activity_type_id)
VALUES (14, 1)

-- get user progress by event


SELECT event_id, user_id FROM event_user
WHERE event_id = 3;
