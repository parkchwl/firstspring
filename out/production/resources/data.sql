INSERT INTO article(id, title, content) VALUES (1, '임시데이터1', 1111);
INSERT INTO article(id, title, content) VALUES (2, '임시데이터2', 2222);
INSERT INTO article(id, title, content) VALUES (3, '임시데이터3', 3333);

-- article 더미 데이터 추가 --
INSERT INTO article(id, title, content) VALUES (4, '당신의 인생 영화는?', '댓글 1');
INSERT INTO article(id, title, content) VALUES (5, '당신의 소울 푸드는?', '댓글 2');
INSERT INTO article(id, title, content) VALUES (6, '당신의 취미는?', '댓글 3');

-- 4번 게시글의 댓글 --
INSERT INTO comment(id, article_id, nickname, body) VALUES (1, 4, 'Park', 'Inception');
INSERT INTO comment(id, article_id, nickname, body) VALUES (2, 4, 'Kim', 'Interstellar');
INSERT INTO comment(id, article_id, nickname, body) VALUES (3, 4, 'Choi', 'TENET');

-- 5번 게시글의 댓글 --
INSERT INTO comment(id, article_id, nickname, body) VALUES (4, 5, 'Park', 'Chicken');
INSERT INTO comment(id, article_id, nickname, body) VALUES (5, 5, 'Kim', 'Rice');
INSERT INTO comment(id, article_id, nickname, body) VALUES (6, 5, 'Choi', 'Meat');

-- 6번 게시글의 댓글 --
INSERT INTO comment(id, article_id, nickname, body) VALUES (7, 6, 'Park', 'Climbing');
INSERT INTO comment(id, article_id, nickname, body) VALUES (8, 6, 'Kim', 'Reading');
INSERT INTO comment(id, article_id, nickname, body) VALUES (9, 6, 'Choi', 'Swim');