use `shoponline`;
#
# create table clients (
# id integer not null auto_increment,
# address varchar(224),
#  email varchar(255),
#  name varchar(128),
#  primary key (id)
#  );
#
# create table orders (
# id integer not null auto_increment,
#  local_time time,
#   client_id integer,
#    primary key (id)
#    );
#
#
# create table orders_products (
# order_id integer not null,
#  products_id integer not null);
#
# create table products (
# id integer not null auto_increment,
#  amount integer,
#  description varchar(224),
#  name varchar(128),
#  price decimal(19,2),
#  primary key (id)
#  );