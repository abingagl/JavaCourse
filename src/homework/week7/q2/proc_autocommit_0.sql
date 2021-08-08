DROP PROCEDURE IF EXISTS proc_autocommit_0;
DELIMITER ;
CREATE PROCEDURE proc_autocommit_0()
BEGIN
    DECLARE i INT DEFAULT 1;
    set autocommit=0;
    WHILE i<=1000000 DO
            insert into t_order (user_id, amount, status, create_time, modify_time, version)
            VALUES (CEILING(rand()*100), CEILING(rand()*10000), 1, now(), now(), 0);
        SET i = i+1;
    END WHILE;
    commit;
END ;
