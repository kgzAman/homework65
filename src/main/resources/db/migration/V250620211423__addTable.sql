use `shop`;

create table orders_review (order_id integer not null, review_id integer not null) engine=InnoDB;
create table review (id integer not null auto_increment, local_date_time datetime(6), rating varchar(255), review_content varchar(255), order_for_review_id integer, user_id integer, primary key (id)) engine=InnoDB;
alter table orders_review add constraint UK_hwkjtuyjbiv2524fko5vjpto unique (review_id);
alter table orders_review add constraint FKmdrwk7c26odeuci8wuowy4wwx foreign key (review_id) references review (id);
alter table orders_review add constraint FKhq7ylp4on14umwncjum88vj5k foreign key (order_id) references orders (id);
alter table review add constraint FK3weia5objymn8dvw85q016po6 foreign key (order_for_review_id) references orders (id);
alter table review add constraint FKry50ih2km72vif9ogwcjkfo2y foreign key (user_id) references clients (id);