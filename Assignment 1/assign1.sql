--SQL Fake Book Song Data


--CREATE DATABASE TABLES
--=======================

create table if not exists songs(
      id integer primary key not null, --auto increment key 
      songTitle text NOT NULL, --title of the songs
      bookCode text NOT NULL,  --book code for the the fake book the song is from
      page int, --page number in book where song appears
      student_number text NOT NULL  --student who contributed the data
      );

--INSERT DATA
--=======================

begin transaction;

--Insert songs
--RBV-4
insert into songs(songTitle, bookCode, page, student_number) values ('LILLI MARLENE','RBV', 255, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('LI''L DARLIN''','RBV', 258, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('LIVE AND LET DIE','RBV', 256, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('LORELEI, THE','RBV', 259, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('LOST IN MEDITATION','RBV', 260, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('LOVE DANCE','RBV', 262, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('LOVE IS HERE TO STAY','RBV', 261, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('LOVE WALKED IN','RBV', 264, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('LUCKY TO BE ME','RBV', 265, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('LULLABY IN RHYTHEM','RBV', 266, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('LULU''S BACK IN TOWN','RBV', 267, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('MACK THE KNIFE','RBV', 268, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('MAIN STEM','RBV', 270, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('MARIA','RBV', 272, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('MATCHMAKER','RBV', 273, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('MAYBE','RBV', 274, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('ME AND MRS. JONES','RBV', 275, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('MEGGIE''S THEME','RBV', 276, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('MICKEY MOUSE MARCH','RBV', 277, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('MIDNIGHT IN MOSCOW','RBV', 278, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('MILENBERG JOYS','RBV', 279, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('MINNIE THE MOOCHER','RBV', 280, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('MISS OTIS REGRETS (SHE''S UNABLE TO LUNCH TODAY)','RBV', 283, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('MISTER FIVE BY FIVE','RBV', 285, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('MOOD THAT I''M IN','RBV', 290, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('MOONDANCE','RBV', 286, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('MORE TODAY THAN YESTERDAY','RBV', 288, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('MUSIC, MAESTRO, PLEASE','RBV', 291, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('MUSIC ON THE WAY','RBV', 292, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('MY KIND OF GIRL','RBV', 293, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('MY MAN''S GONE NOW','RBV', 294, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('MY MONDAY DATE','RBV', 295, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('MY ONE AND ONLY','RBV', 296, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('MY OWN TRUE LOVE','RBV', 297, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('MY REVERIE','RBV', 298, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('MY YIDDISHE MOMME','RBV', 299, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('NEAR YOU','RBV', 300, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('NEVER MY LOVE','RBV', 301, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('"NEW YORK, NEW YORK", THEME FROM','RBV', 302, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('NICE ''N'' EASY','RBV', 304, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('NO OTHER LOVE','RBV', 305, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('NOREEN''S NOCTURNE','RBV', 306, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('NOTORIOUS','RBV', 308, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('OF THE I SING','RBV', 309, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('OH, GOOD GRIEF','RBV', 314, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('OH HAPPY DAY','RBV', 310, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('OH, LADY BE GOOD!','RBV', 312, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('OLD MASTER PAINTER, THE','RBV', 315, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('ON A LITTLE STREET IN SINGAPORE','RBV', 316, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('ON THE ATCHISON, TOPEKA AND THE SANTA FE','RBV', 317, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('ON THE OTHER SIDE OF THE TRACKS','RBV', 318, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('ON THE SOUTH SIDE OF CHICOGO','RBV', 320, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('ONCE IN A WHILE','RBV', 321, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('ONCE UPON A TIME','RBV', 326, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('ONE O''CLOCK JUMP','RBV', 322, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('OO-SHOO-BE-DOO-BE, THE','RBV', 324, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('ORBIT','RBV', 327, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('OUR LOVE AFFAIR','RBV', 328, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('OVER THE RAINBOW','RBV', 329, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('PENNSYLVANIA 6-5000, THE','RBV', 330, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('PEOPLE GET READY','RBV', 331, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('PERRY MASON THEME','RBV', 334, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('PIANO MAN','RBV', 332, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('PIGALLE','RBV', 335, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('PLACE ST. HENRI','RBV', 338, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('PLAYBOY''S THEME','RBV', 336, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('PLEASE DON''T TALK ABOUT ME WHEN I''M GONE','RBV', 339, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('PREACHER, THE','RBV', 340, '100875046');

insert into songs(songTitle, bookCode, page, student_number) values ('PYRAMID','RBV', 341, '100875046');
insert into songs(songTitle, bookCode, page, student_number) values ('QUALITY TIME','RBV', 342, '100875046');

--END OF INSERTION
end transaction;

-- END OF DB SCRIPT