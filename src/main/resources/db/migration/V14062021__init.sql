use `shop`;

create table clients (
id integer not null auto_increment,
 address varchar(224),
 email varchar(255),
 name varchar(128),
 password varchar(1000),
 primary key (id))
  engine=InnoDB;

create table orders (
id integer not null auto_increment,
local_time time,
client_id integer,
primary key (id))
engine=InnoDB;

create table orders_products (
order_id integer not null,
products_id integer not null)
engine=InnoDB;

create table products (
id integer not null auto_increment,
amount integer,
description varchar(224),
image varchar(255),
name varchar(128),
price decimal(19,2),
types varchar(255),
primary key (id))
engine=InnoDB;


alter table clients add constraint UK_email unique (email);
alter table orders_products add constraint UK_products_id unique (products_id);
alter table orders add constraint FKclient_id foreign key (client_id) references clients (id);
alter table orders_products add constraint products_id foreign key (products_id) references products (id);
alter table orders_products add constraint order_id foreign key (order_id) references orders (id);