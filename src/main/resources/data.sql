

INSERT INTO blog (title, content, blogged_date,blogged_by,blog_img,read_time,user_id,claps_count,updated_date) VALUES ( 'title', 'this is the content', '2020-01-20 05:10:00', 'dhana' , 'image','2 min' , 122 , 0, null);

INSERT INTO blog (title, content, blogged_date,blogged_by,blog_img,read_time,user_id,claps_count,updated_date) VALUES ( 'title2', 'this is the content2', '2020-02-20 05:10:00', 'dhanatontanahal' , 'image2','4 min' , 122 , 0, null);
 
INSERT INTO tag(tag_id , tag_name) values (1,'React');

INSERT INTO blogtag(blogtag_id ,blog_id, tag_id) values (1,1001,1);

INSERT INTO comment(COMMENT_ID,BLOG_ID,COMMENT_VALUE,CREATED_DATE,USER_ID  ) values (1,1,'Thank you' ,'2020-02-20 05:10:00',122);

INSERT INTO followusermap(followusermap_id ,FOLLOWBY_USERID, FOLLOWTO_USERID , FOLLOWED_TIME_STAMP , 	UN_FOLLOWED_TIME_STAMP  ) values (1,1,2,'2020-02-20 05:10:00', null);


	
