DROP TABLE IF EXISTS word;

CREATE TABLE word (
  id VARCHAR(30) PRIMARY KEY,
  en_single VARCHAR(100),
  en_plural VARCHAR(100),
  en_past VARCHAR(100),
  ing VARCHAR(100),
  es_single VARCHAR(100),
  es_plural VARCHAR(100),
  subject VARCHAR(100),
  type VARCHAR(50),
  FOREIGN KEY (subject) REFERENCES word(id)
);

DROP TABLE IF EXISTS conjugation;

CREATE TABLE conjugation (
  id VARCHAR(30) NOT NULL,
  type VARCHAR(50) ,
  first VARCHAR(100),
  second VARCHAR(100),
  third VARCHAR(100),
  first_plural VARCHAR(100),
  second_plural VARCHAR(100),
  third_plural VARCHAR(100),
  FOREIGN KEY (id) REFERENCES word(id)
);