-- 20. The titles, lengths, and release dates of the 5 longest movies in the "Action" genre.
-- Order the movies by length (highest first), then by release date (latest first).
-- (5 rows, expected lengths around 180 - 200)

SELECT m.title, m.length_minutes, m.release_date
FROM movie m
INNER JOIN movie_genre mg USING(movie_id)
INNER JOIN genre g USING(genre_id)
WHERE g.genre_name = 'Action'
ORDER BY m.length_minutes DESC, m.release_date DESC
LIMIT 5
;