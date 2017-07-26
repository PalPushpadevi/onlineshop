 Create table Category(
 id IDENTITY,
 name VARCHAR(50),
 description VARCHAR(255),
 img_url VARCHAR(50),
 is_active BOOLEAN,
 
 CONSTRAINT pk_category_id PRIMARY KEY (id)
 
 
 );