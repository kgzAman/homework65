use `shop`;

create table bath_order (id integer not null auto_increment, user_id integer, primary key (id)) engine=InnoDB;
create table bath_order_product_list (bath_order_id integer not null, product_list_id integer not null) engine=InnoDB;

alter table bath_order add constraint FKepyp1tbuf80kujisfs5joyq5p foreign key (user_id) references clients (id);
alter table bath_order_product_list add constraint FKfpldk384yra3yvkeyj1wa7fis foreign key (product_list_id) references products (id);
alter table bath_order_product_list add constraint FKs4avekfag9e3jgmk4ycgkmdfe foreign key (bath_order_id) references bath_order (id);
