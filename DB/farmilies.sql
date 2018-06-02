DROP TABLE REVIEWS CASCADE CONSTRAINTS;
DROP TABLE PAGES CASCADE CONSTRAINTS;
DROP TABLE USERS CASCADE CONSTRAINTS;
DROP TABLE PICTURES CASCADE CONSTRAINTS;
DROP TABLE USER_GROUPS CASCADE CONSTRAINTS;
DROP TABLE LOCATIONS CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: LOCATIONS */
/**********************************/
CREATE TABLE LOCATIONS(
		id                            		NUMBER(10)		 NOT NULL,
		address_name                  		VARCHAR2(500)		 NOT NULL,
		address_type                  		VARCHAR2(11)		 NOT NULL,
		x                             		DOUBLE PRECISION		 NOT NULL,
		y                             		DOUBLE PRECISION		 NOT NULL,
		region_address                		VARCHAR2(500)		 NOT NULL,
		road_address                  		VARCHAR2(500)		 NULL 
);

COMMENT ON TABLE LOCATIONS is 'LOCATIONS';
COMMENT ON COLUMN LOCATIONS.id is 'id';
COMMENT ON COLUMN LOCATIONS.address_name is 'address_name';
COMMENT ON COLUMN LOCATIONS.address_type is 'address_type';
COMMENT ON COLUMN LOCATIONS.x is 'x';
COMMENT ON COLUMN LOCATIONS.y is 'y';
COMMENT ON COLUMN LOCATIONS.region_address is 'region_address';
COMMENT ON COLUMN LOCATIONS.road_address is 'road_address';


/**********************************/
/* Table Name: USER_GROUPS */
/**********************************/
CREATE TABLE USER_GROUPS(
		id                            		NUMBER(3)		 NOT NULL,
		name                          		VARCHAR2(50)		 NOT NULL,
		update_at                     		DATE		 DEFAULT sysdate		 NOT NULL,
		create_at                     		DATE		 DEFAULT sysdate		 NOT NULL,
		location_id                   		NUMBER(10)		 NOT NULL
);

COMMENT ON TABLE USER_GROUPS is 'USER_GROUPS';
COMMENT ON COLUMN USER_GROUPS.id is 'id';
COMMENT ON COLUMN USER_GROUPS.name is 'name';
COMMENT ON COLUMN USER_GROUPS.update_at is 'update_at';
COMMENT ON COLUMN USER_GROUPS.create_at is 'create_at';
COMMENT ON COLUMN USER_GROUPS.location_id is 'location_id';


/**********************************/
/* Table Name: PICTURES */
/**********************************/
CREATE TABLE PICTURES(
		id                            		NUMBER(12)		 NOT NULL,
		picname                       		VARCHAR2(50)		 NULL ,
		picture                       		BLOB		 NULL 
);

COMMENT ON TABLE PICTURES is 'PICTURES';
COMMENT ON COLUMN PICTURES.id is 'id';
COMMENT ON COLUMN PICTURES.picname is 'picname';
COMMENT ON COLUMN PICTURES.picture is 'picture';


/**********************************/
/* Table Name: USERS */
/**********************************/
CREATE TABLE USERS(
		id                            		VARCHAR2(50)		 NOT NULL,
		update_at                     		DATE		 DEFAULT sysdate		 NOT NULL,
		create_at                     		DATE		 DEFAULT sysdate		 NOT NULL,
		email                         		VARCHAR2(50)		 NULL ,
		password                      		VARCHAR2(50)		 NOT NULL,
		first_name                    		VARCHAR2(50)		 NOT NULL,
		last_name                     		VARCHAR2(50)		 NOT NULL,
		group_id                      		NUMBER(3)		 NOT NULL,
		picture_id                    		NUMBER(12)		 NULL 
);

COMMENT ON TABLE USERS is 'USERS';
COMMENT ON COLUMN USERS.id is 'id';
COMMENT ON COLUMN USERS.update_at is 'update_at';
COMMENT ON COLUMN USERS.create_at is 'create_at';
COMMENT ON COLUMN USERS.email is 'email';
COMMENT ON COLUMN USERS.password is 'password';
COMMENT ON COLUMN USERS.first_name is 'first_name';
COMMENT ON COLUMN USERS.last_name is 'last_name';
COMMENT ON COLUMN USERS.group_id is 'group_id';
COMMENT ON COLUMN USERS.picture_id is 'picture_id';


/**********************************/
/* Table Name: PAGES */
/**********************************/
CREATE TABLE PAGES(
		id                            		NUMBER(10)		 NOT NULL,
		user_id                       		VARCHAR2(50)		 NOT NULL,
		title                         		VARCHAR2(100)		 NOT NULL,
		description                   		VARCHAR2(1000)		 NOT NULL
);

COMMENT ON TABLE PAGES is 'PAGES';
COMMENT ON COLUMN PAGES.id is 'id';
COMMENT ON COLUMN PAGES.user_id is 'user_id';
COMMENT ON COLUMN PAGES.title is 'title';
COMMENT ON COLUMN PAGES.description is 'description';


/**********************************/
/* Table Name: REVIEWS */
/**********************************/
CREATE TABLE REVIEWS(
		id                            		NUMBER(10)		 NOT NULL,
		rating                        		NUMBER(10,2)		 NULL ,
		comments                      		VARCHAR2(4000)		 NOT NULL,
		user_id                       		VARCHAR2(50)		 NOT NULL,
		page_id                       		NUMBER(10)		 NOT NULL,
		host_user_id                  		VARCHAR2(50)		 NOT NULL
);

COMMENT ON TABLE REVIEWS is 'REVIEWS';
COMMENT ON COLUMN REVIEWS.id is 'id';
COMMENT ON COLUMN REVIEWS.rating is 'rating';
COMMENT ON COLUMN REVIEWS.comments is 'comments';
COMMENT ON COLUMN REVIEWS.user_id is 'user_id';
COMMENT ON COLUMN REVIEWS.page_id is 'page_id';
COMMENT ON COLUMN REVIEWS.host_user_id is 'host_user_id';



ALTER TABLE LOCATIONS ADD CONSTRAINT IDX_LOCATIONS_PK PRIMARY KEY (id);

ALTER TABLE USER_GROUPS ADD CONSTRAINT IDX_USER_GROUPS_PK PRIMARY KEY (id);
ALTER TABLE USER_GROUPS ADD CONSTRAINT IDX_USER_GROUPS_FK0 FOREIGN KEY (location_id) REFERENCES LOCATIONS (id);

ALTER TABLE PICTURES ADD CONSTRAINT IDX_PICTURES_PK PRIMARY KEY (id);

ALTER TABLE USERS ADD CONSTRAINT IDX_USERS_PK PRIMARY KEY (id);
ALTER TABLE USERS ADD CONSTRAINT IDX_USERS_FK0 FOREIGN KEY (group_id) REFERENCES USER_GROUPS (id);
ALTER TABLE USERS ADD CONSTRAINT IDX_USERS_FK1 FOREIGN KEY (picture_id) REFERENCES PICTURES (id);

ALTER TABLE PAGES ADD CONSTRAINT IDX_PAGES_PK PRIMARY KEY (id);
ALTER TABLE PAGES ADD CONSTRAINT IDX_PAGES_FK0 FOREIGN KEY (user_id) REFERENCES USERS (id);

ALTER TABLE REVIEWS ADD CONSTRAINT IDX_REVIEWS_PK PRIMARY KEY (id);
ALTER TABLE REVIEWS ADD CONSTRAINT IDX_REVIEWS_FK0 FOREIGN KEY (page_id) REFERENCES PAGES (id);
ALTER TABLE REVIEWS ADD CONSTRAINT IDX_REVIEWS_FK1 FOREIGN KEY (user_id) REFERENCES USERS (id);
ALTER TABLE REVIEWS ADD CONSTRAINT IDX_REVIEWS_FK2 FOREIGN KEY (host_user_id) REFERENCES USERS (id);

