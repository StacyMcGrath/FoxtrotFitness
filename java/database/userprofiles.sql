START TRANSACTION;

DROP TABLE IF EXISTS user_profile;
DROP SEQUENCE IF EXISTS seq_user_profile_id;

CREATE SEQUENCE seq_user_profile_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE TABLE user_profile (
        user_profile_id int NOT NULL,
        user_id int NOT NULL,
        first_name varchar(50) NOT NULL,
        last_name varchar(50) NOT NULL,
        email_address varchar(200) NOT NULL,
        username varchar(100) NOT NULL,
        CONSTRAINT pk_user_profile PRIMARY KEY (user_profile_id),
        FOREIGN KEY (user_id) REFERENCES users(user_id)
);

COMMIT TRANSACTION;