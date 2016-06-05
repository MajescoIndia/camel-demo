## Links for procedure call

http://stackoverflow.com/questions/15666856/calling-oracle-stored-procedures-with-mybatis

http://www.mkyong.com/oracle/oracle-stored-procedure-cursor-example/

http://forums.enterprisedb.com/posts/list/1374.page


## Procedure Examples




        create or replace 
        PROCEDURE get_max_sal_job_id(
        	   p_job_id IN HR.employees.job_id%TYPE,
        	   max_sal OUT number)
        IS
        BEGIN
        
          SELECT max(salary) into max_sal  FROM HR.employees WHERE job_id = p_job_id;
         
        END;
        
        =======================

        SET SERVEROUTPUT ON;

        declare 
        max_sal number;
        
        begin
        get_max_sal_job_id('IT_PROG', max_sal);
        
        dbms_output.put_line('MAX SALARY : ' || max_sal);
        
        end;
