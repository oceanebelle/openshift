DROP TABLE IF EXISTS word;

CREATE TABLE word (
  id VARCHAR(30) PRIMARY KEY,
  en_single VARCHAR(100),
  en_plural VARCHAR(100),
  en_past VARCHAR(100),
  ing VARCHAR(100),
  es_single VARCHAR(100),
  es_plural VARCHAR(100),
  type VARCHAR(50)
);
