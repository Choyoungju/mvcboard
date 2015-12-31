drop table MVC_BOARD;
DROP SEQUENCE MVC_BOARD_SEQ;

CREATE TABLE mvc_board(
bId number(4) primary key,
bName varchar2 (20),
bTitle varchar2(100),
bContent varchar2 (300),
bDate DATE DEFAULT SYSDATE,
bHit NUMBER(4) DEFAULT 0,
bGroup NUMBER(4),
bStep number(4),
bIndent number(4)
);

create sequence mvc_board_seq;