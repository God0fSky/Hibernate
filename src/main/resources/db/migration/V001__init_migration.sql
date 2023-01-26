create schema if not exists school;

create sequence if not exists school.school_id_sequence;

create table if not exists school.student
(
    id              integer not null default nextval('school.school_id_sequence'),
    name            text not null,
    email           text not null,
    primary key(id)
);

create table if not exists school.mark
(
    id              integer not null default nextval('school.school_id_sequence'),
    student_id      integer constraint data_source_fk_connection_id_fkey references school.mark,
    discipline      text not null,
    value           integer not null,
    primary key(id)
);
