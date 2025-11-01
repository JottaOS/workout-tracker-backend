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
