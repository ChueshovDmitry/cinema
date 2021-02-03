@echo off

psql -U postgres -a -f create_db.sql

psql -U postgres -a -d mydb -f create_table.sql

echo database created

@pause

