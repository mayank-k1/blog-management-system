CREATE DATABASE hondb;

USE hondb;

DROP TABLE IF EXISTS hondb.blog;
CREATE TABLE  hondb.blog (
  blogId int(11) NOT NULL auto_increment,
  content varchar(255) default NULL,
  email varchar(255) default NULL,
  themes varchar(255) default NULL,
  title varchar(255) default NULL,
  PRIMARY KEY  (`blogId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO blog (blogId, content, email, themes, title) VALUES
	(1, 'Digital Citizens', 'alexa@gmail.com', 'Daily Journal', 'Digital Citizenship'),
	(2, 'Persons ambition or effort', 'jack@gmail.com', 'CheerUp', 'Goals'),
	(3, 'An extended period of recreation', 'lisa@gmail.com', 'Daily Journal', 'Holiday');
commit;

SELECT * FROM blog b;
m