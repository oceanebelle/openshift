
insert into word (id, en_single, en_plural, es_single, es_plural) values('apple', 'apple', 'apples', 'la manzana', 'las manzanas');
insert into word (id, en_single, en_plural, es_single, es_plural) values('pizza', 'pizza', 'pizzas', 'el pizza', 'el pizza');
insert into word (id, en_single, en_plural, es_single, es_plural) values('music', 'music', 'music', 'la musica', 'las musica');
insert into word (id, en_single, en_plural, es_single, es_plural) values('here', 'here', 'here', 'aquí', 'aquí');

insert into word (type, id, en_single, en_plural, en_past, ing)
values
('VERB', 'gustar', 'likes', 'like', 'liked', 'liking'),
('VERB', 'encantar', 'loves', 'love', 'loved', 'loving'),
('VERB', 'costar', 'costs', 'cost', 'cost', 'costing'),
('VERB', 'preocupar', 'worries', 'worry', 'worried', 'worrying'),
('VERB', 'vivir', 'lives', 'live', 'lived', 'living'),
('VERB', 'caminar', 'walks', 'walk', 'walked', 'walking'),
('VERB', 'comer', 'eats', 'eat', 'ate', 'eating'),
('VERB', 'ser', 'be', 'are', 'was', 'being'),
('VERB', 'ir', 'goes', 'go', 'went', 'going'),
('VERB', 'dar', 'gives', 'give', 'gave', 'giving'),
('VERB', 'decir', 'says', 'say', 'said', 'saying'),
('VERB', 'tener', 'has', 'have', 'had', 'having'),
('VERB', 'hacer', 'does', 'do', 'did', 'doing'),
('VERB', 'poder', 'can', 'can', 'could', 'can');

insert into conjugation
    (id, type, first, second, third, first_plural, second_plural, third_plural)
VALUES
    ('decir','IPRESENT'  ,  'digo',  'dices',   'dice',  'decimos',  'decís',     'dicen'),
    ('decir','IPRETERITE',  'dije',  'dijiste', 'dijo',  'dijimos',  'dijisteis', 'dijeron'),
    ('decir','IIMPERFECT',  'decía', 'decías',  'decía', 'decíamos', 'decíais',   'decían'),
    ('decir','ICONDITINAL', 'diría', 'dirías',  'diría', 'diríamos', 'diríais',   'dirían'),
    ('decir','IFUTURE',     'diré',  'dirás',   'dirá',  'diremos',  'diréis',    'dirán');

insert into conjugation
    (id, type, first, second, third, first_plural, second_plural, third_plural)
VALUES
    ('dar','IPRESENT'  , 'doy',   'das',    'da',    'damos',    'dais',    'dan'),
    ('dar','IPRETERITE', 'di',    'diste',  'dio',   'dimos',    'disteis', 'dieron'),
    ('dar','IIMPERFECT', 'daba',  'dabas',  'daba',  'dábamos',  'dabais',  'daban');

insert into conjugation
    (id, type, first, second, third, first_plural, second_plural, third_plural)
VALUES
    ('ir','IPRESENT'  , 'voy', 'vas',    'va',    'vamos',   'vais',     'van'),
    ('ir','IPRETERITE', 'fui', 'fuiste', 'fue',   'fuimos',  'fuisteis', 'fueron'),
    ('ir','IIMPERFECT', 'iba', 'ibas',   'iba',   'íbamos',  'ibais',    'iban');

insert into conjugation
    (id, type, first, second, third, first_plural, second_plural, third_plural)
VALUES
    ('ser','IPRESENT'  , 'soy', 'eres',   'es',  'somos',  'sois',     'son'),
    ('ser','IPRETERITE', 'fui', 'fuiste', 'fue', 'fuimos', 'fuisteis', 'fueron'),
    ('ser','IIMPERFECT', 'era', 'eras',   'era', 'éramos', 'erais',    'eran');


insert into conjugation
    (id, type, first, second, third, first_plural, second_plural, third_plural)
VALUES
    ('tener','IPRESENT'  ,  'tengo',  'tienes',   'tiene',  'tenemos',  'tenéis',     'tienen'),
    ('tener','IPRETERITE',  'tuve',  'tuviste', 'tuvo',  'tuvimos',  'tuvisteis', 'tuvieron'),
    ('tener','IIMPERFECT',  'tenía', 'tenías',  'tenía', 'teníamos', 'teníais',   'tenían'),
    ('tener','ICONDITINAL', 'tendría', 'tendrías',  'tendría', 'tendríamos', 'tendríais',   'tendrían'),
    ('tener','IFUTURE',     'tendré',  'tendrás',   'tendrá',  'tendremos',  'tendréis',    'tendrán');

insert into conjugation
    (id, type, first, second, third, first_plural, second_plural, third_plural)
VALUES
    ('hacer','IPRESENT'  ,  'hago',  'haces',   'hace',  'hacemos',  'hacéis',     'hacen'),
    ('hacer','IPRETERITE',  'hice',  'hiciste', 'hizo',  'hicimos',  'hicisteis', 'hicieron'),
    ('hacer','IIMPERFECT',  'hacía', 'hacías',  'hacía', 'hacíamos', 'hacíais',   'hacían'),
    ('hacer','ICONDITINAL', 'haría', 'harías',  'haría', 'haríamos', 'haríais',   'harían'),
    ('hacer','IFUTURE',     'haré',  'harás',   'hará',  'haremos',  'haréis',    'harán');

insert into conjugation
    (id, type, first, second, third, first_plural, second_plural, third_plural)
VALUES
    ('poder','IPRESENT'  ,  'puedo',  'puedes',   'puede',  'podemos',  'podéis',     'pueden'),
    ('poder','IPRETERITE',  'pude',  'pudiste', 'pudo',  'pudimos',  'pudisteis', 'pudieron'),
    ('poder','IIMPERFECT',  'podía', 'podías',  'podía', 'podíamos', 'podíais',   'podían'),
    ('poder','ICONDITINAL', 'podría', 'podrías',  'podría', 'podríamos', 'podríais',   'podrían'),
    ('poder','IFUTURE',     'podré',  'podrás',   'podrá',  'podremos',  'podréis',    'podrán');