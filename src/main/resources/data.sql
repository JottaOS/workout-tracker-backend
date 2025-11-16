-- ==========================
-- MUSCLES
-- ==========================
INSERT INTO muscle (id, name)
VALUES (1, 'Chest'),
       (2, 'Back'),
       (3, 'Legs'),
       (4, 'Shoulders'),
       (5, 'Biceps'),
       (6, 'Triceps'),
       (7, 'Abs');

-- ==========================
-- EXERCISES
-- ==========================
INSERT INTO exercise (id, name, image_url, muscle_id, type)
VALUES (1, 'Bench Press', 'https://example.com/images/bench_press.jpg', 1, 'WEIGHT'),
       (2, 'Push-Ups', 'https://example.com/images/pushups.jpg', 1, 'BODYWEIGHT'),
       (3, 'Pull-Ups', 'https://example.com/images/pullups.jpg', 2, 'BODYWEIGHT'),
       (4, 'Deadlift', 'https://example.com/images/deadlift.jpg', 2, 'WEIGHT'),
       (5, 'Squats', 'https://example.com/images/squats.jpg', 3, 'WEIGHT'),
       (6, 'Lunges', 'https://example.com/images/lunges.jpg', 3, 'BODYWEIGHT'),
       (7, 'Shoulder Press', 'https://example.com/images/shoulder_press.jpg', 4, 'WEIGHT'),
       (8, 'Bicep Curls', 'https://example.com/images/bicep_curls.jpg', 5, 'WEIGHT'),
       (9, 'Tricep Dips', 'https://example.com/images/tricep_dips.jpg', 6, 'BODYWEIGHT'),
       (10, 'Plank', 'https://example.com/images/plank.jpg', 7, 'BODYWEIGHT'),
       (11, 'Running', 'https://example.com/images/running.jpg', 3, 'CARDIO_WITH_DISTANCE'),
       (12, 'Cycling', 'https://example.com/images/cycling.jpg', 3, 'CARDIO_WITH_DISTANCE');

-- ==========================
-- WORKOUTS
-- ==========================
INSERT INTO workout (id, title, sets, volume, started_at, finished_at, is_template)
VALUES (1, 'Chest Day', 12, 8500, '2025-10-31 18:00:00-03', '2025-10-31 19:15:00-03', false),
       (2, 'Legs and Core', 10, 10200, '2025-11-01 17:00:00-03', '2025-11-01 18:10:00-03', false),
       (3, 'Back & Biceps', 11, 9300, null, null, true);

-- ==========================
-- WORKOUT_EXERCISES
-- ==========================
INSERT INTO workout_exercise (workout_id, exercise_id, rest_seconds, notes)
VALUES
-- Workout 1: Chest Day
(1, 1, 120, 'Focus on full range of motion'),
(1, 2, 60, 'Keep core tight'),
(1, 9, 90, 'Finish with dips to failure'),

-- Workout 2: Legs and Core
(2, 5, 150, 'Heavy squats'),
(2, 6, 60, 'Bodyweight lunges, good posture'),
(2, 10, 45, 'Hold as long as possible'),

-- Workout 3: Back & Biceps
(3, 3, 120, 'Wide grip for more lat engagement'),
(3, 4, 150, 'Watch lower back form'),
(3, 8, 90, 'Slow negative reps');

-- ==========================
-- WORKOUT_EXERCISE_DETAIL
-- ==========================
INSERT INTO workout_exercise_detail
(exercise_id, workout_id, item, type, reps, weight, distance_meters, duration_seconds)
VALUES
-- ===== Workout 1 =====
-- Bench Press
(1, 1,  1, 'WARMUP', 10, 40, NULL, NULL),
(1, 1,  2, 'NORMAL', 8, 60, NULL, NULL),
(1, 1,  3, 'NORMAL', 6, 70, NULL, NULL),
(1, 1,  4, 'FAILURE', 4, 75, NULL, NULL),

-- Push-Ups
(2, 1,  1, 'NORMAL', 20, NULL, NULL, NULL),
(2, 1,  2, 'NORMAL', 18, NULL, NULL, NULL),
(2, 1,  3, 'FAILURE', 15, NULL, NULL, NULL),

-- Tricep Dips
(9, 1,  1, 'NORMAL', 12, NULL, NULL, NULL),
(9, 1,  2, 'FAILURE', 10, NULL, NULL, NULL),

-- ===== Workout 2 =====
-- Squats
(5, 2,  1, 'WARMUP', 10, 60, NULL, NULL),
(5, 2,  2, 'NORMAL', 8, 90, NULL, NULL),
(5, 2,  3, 'NORMAL', 6, 100, NULL, NULL),

-- Lunges
(6, 2,  1, 'NORMAL', 10, NULL, NULL, NULL),
(6, 2,  2, 'NORMAL', 10, NULL, NULL, NULL),

-- Plank
(10, 2,  1, 'NORMAL', NULL, NULL, NULL, 60),
(10, 2,  2, 'FAILURE', NULL, NULL, NULL, 45),

-- ===== Workout 3 =====
-- Pull-Ups
(3, 3,  1, 'NORMAL', 10, NULL, NULL, NULL),
(3, 3,  2, 'NORMAL', 8, NULL, NULL, NULL),
(3, 3,  3, 'FAILURE', 6, NULL, NULL, NULL),

-- Deadlift
(4, 3,  1, 'WARMUP', 8, 60, NULL, NULL),
(4, 3,  2, 'NORMAL', 6, 90, NULL, NULL),
(4, 3,  3, 'NORMAL', 5, 100, NULL, NULL),

-- Bicep Curls
(8, 3,  1, 'NORMAL', 10, 12, NULL, NULL),
(8, 3,  2, 'NORMAL', 8, 14, NULL, NULL),
(8, 3,  3, 'FAILURE', 6, 16, NULL, NULL);
