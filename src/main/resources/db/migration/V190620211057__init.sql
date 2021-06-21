use `shop`;


create table clients (id integer not null auto_increment, address varchar(255), email varchar(255), enabled bit, name varchar(255), password varchar(255), role varchar(255), primary key (id)) engine=InnoDB;
create table orders (id integer not null auto_increment, local_time time, client_id integer, primary key (id)) engine=InnoDB;
create table orders_products (order_id integer not null, products_id integer not null) engine=InnoDB;
create table products (id integer not null auto_increment, amount integer, description varchar(224), image varchar(255), name varchar(128), price decimal(19,2), types varchar(255), primary key (id)) engine=InnoDB;
alter table clients add constraint UK_srv16ica2c1csub334bxjjb59 unique (email);
alter table orders_products add constraint UK_qmviv5y7625wak8tjq4nirybh unique (products_id);
alter table orders add constraint FKm2dep9derpoaehshbkkatam3v foreign key (client_id) references clients (id);
alter table orders_products add constraint FKqgxvu9mvqx0bv2ew776laoqvv foreign key (products_id) references products (id);
alter table orders_products add constraint FKe4y1sseio787e4o5hrml7omt5 foreign key (order_id) references orders (id);