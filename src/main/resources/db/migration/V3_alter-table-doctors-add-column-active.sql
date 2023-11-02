alter table tb_doctors add active tinyint;
update tb_doctors set active = 1;