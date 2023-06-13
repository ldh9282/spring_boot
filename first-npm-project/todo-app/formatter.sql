INSERT INTO
    todo (
        todo_id,
        username,
        description,
        done,
        target_date
    )
VALUES
    (
        todo_seq.NEXTVAL,
        #{username}, #{description}, #{done}, systimestamp
    );