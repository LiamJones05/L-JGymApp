-- Create the users table
CREATE TABLE users (
  id INT PRIMARY KEY IDENTITY(1,1),  -- auto-incrementing id
  username VARCHAR(255) UNIQUE,
  email VARCHAR(255),
  member_type VARCHAR(10) CHECK (member_type IN ('standard', 'premium')), --users can have a standard or premium account
  password VARCHAR(64)
);

-- Create the food_log table
CREATE TABLE food_log (
  id INT PRIMARY KEY IDENTITY(1,1),  -- auto-incrementing id -Primary Key
  food_name VARCHAR(255),
  calories INT,
  carbs INT,
  protein INT,
  fats INT,
  date_logged DATETIME,
  meal_type VARCHAR(10) CHECK (meal_type IN ('undefined', 'breakfast', 'lunch', 'dinner', 'snack')),
  user_id INT,
  FOREIGN KEY (user_id) REFERENCES users(id)--Linked to a user with specified id
);

-- Create the workout_session table
CREATE TABLE workout_session (
  id INT PRIMARY KEY IDENTITY(1,1),  -- auto-incrementing id -Primary Key
  user_id INT,
  date_logged DATETIME,
  FOREIGN KEY (user_id) REFERENCES users(id)--Linked to a useer with specified id
);

-- Create the sets table
CREATE TABLE sets (
  id INT PRIMARY KEY IDENTITY(1,1),  -- auto-incrementing id -Primary Key
  workout_name VARCHAR(255),
  workout_session_id INT,
  FOREIGN KEY (workout_session_id) REFERENCES workout_session(id)--Linked to a workout with specified id
);

-- Create the reps table
CREATE TABLE reps (
  id INT PRIMARY KEY IDENTITY(1,1),  -- auto-incrementing id -Primary Key
  rep_count INT,
  set_id INT,
  FOREIGN KEY (set_id) REFERENCES sets(id) --Linked to a set with specified id
);
