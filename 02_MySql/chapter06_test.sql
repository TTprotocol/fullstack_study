use speed_quiz;

DELETE FROM quiz_words
WHERE word IN (
  SELECT word FROM (
    SELECT
      word,
      ROUND(SUM(CASE WHEN is_correct = 'O' THEN 1 ELSE 0 END) / COUNT(*) * 100, 1) AS correct_rate
    FROM quiz_logs
    GROUP BY word
    HAVING correct_rate < (
      SELECT ROUND(SUM(CASE WHEN is_correct = 'O' THEN 1 ELSE 0 END) / COUNT(*) * 100, 1)
      FROM quiz_logs
    )
  ) AS low_accuracy_words
);


start transaction;
insert into quiz_words(word) values('포켓몬빵');
select * from quiz_words;
rollback;

select created_at, count(*) as count
from quiz_words
group by created_at
having count(*) >= 1;

select * from quiz_words;



