use master
go
	drop database Java5_ASM
	go
	create database Java5_ASM
	go
	use Java5_ASM
	go
create table Users(
	Username nvarchar(20) primary key,
	Password nvarchar(20),
	Fullname nvarchar(50),
	role nvarchar(20)
)
go
create table Departs(
	Id int IDENTITY(1,1)  primary key,
	Name nvarchar(50) 
)
go

create table Staffs(
	Id int IDENTITY(1,1)  primary key,
	Name nvarchar(50),
	Gender bit,
	Birthday date,
	Photo nvarchar(50),
	Email nvarchar(50),
	Phone nvarchar(20),
	Salary float,
	Notes nvarchar(100),
	DepartId int,
	foreign key (DepartId) references Departs(id) ON DELETE CASCADE
)
go
create table Records(
	Id int IDENTITY(1,1)  primary key,
	Type bit,
	Reason nvarchar(100),
	Date date,
	StaffId int,
	foreign key (StaffId) references Staffs(Id) ON DELETE CASCADE
)
go

insert into Users
	values('Anh','123',N'Phạm Anh','admin')
insert into Users
	values('teo','123',N'Lê Tèo','user')
insert into Users
	values('Em','123',N'Phạm Em','admin')
insert into Users
	values('ti','123',N'Lê Tí','user')
	
	--đ đasadddddddddddđ
insert into Departs
	values(N'Quản lí nhân sự')
insert into Departs
	values(N'Tài chính và marketing')
insert into Departs
	values(N'Kế Toán')
insert into Departs
	values(N'Văn phòng đại diện')
	--select * from Staffs
	--ddddddddddddddddddd
insert into Staffs
	values(N'Lê Nam',1,'10/10/1990','nam.jpg','namlat@gmail.com','0985268751',6500000,N'Siêng năng',1)
insert into Staffs
	values(N'Nguyễn Trang',0,'05/10/1995','trang.jpg','trangdd@gmail.com','0585268751',10000000,N'Siêng',2)
insert into Staffs
	values(N'Nguyễn Thành',1,'01/10/1995','thanh.jpg','thanhne@gmail.com','0945268751',5000000,N'Ghi chú nè',1)
insert into Staffs
	values(N'Võ Lễ',1,'05/10/1984','le.jpg','thanhndd@gmail.com','0965268751',7000000,N'Ghi chú nè',4)
insert into Staffs
	values(N'Đoàn Dự',1,'01/05/1994','du.jpg','doandu@gmail.com','0985268751',6500000,N'Siêng năng',3)
insert into Staffs
	values(N'Bao thị Công',0,'06/11/1980','cong.jpg','congbao4@gmail.com','0585268751',8000000,N'Siêng',4)
insert into Staffs
	values(N'Trần Nhi',0,'01/05/1992','nhi.jpg','nhitran55@gmail.com','0945268751',6700000,N'Ghi chú nè',4)
insert into Staffs
	values(N'Lê Luyện',1,'05/09/1989','luyen.jpg','luyendaica@gmail.com','0965268751',7500000,N'Ghi chú nè',1)
insert into Staffs
	values(N'Trần Văn Minh',1,'01/10/1994','minh.jpg','minhdayt@gmail.com','0985268751',6500000,N'Siêng năng',1)
insert into Staffs
	values(N'Nguyễn thị Trang',0,'05/10/1991','trang1.jpg','trang1day@gmail.com','0585268751',10000000,N'Siêng',2)
insert into Staffs
	values(N'Nguyễn Thành Luân',1,'07/02/1985','minh.jpg','luannt@gmail.com','0945268751',5000000,N'Ghi chú nè',3)
insert into Staffs
	values(N'Võ Duy Nhất',1,'05/01/1984','nhat.jpg','duynhat@gmail.com','0965268751',7000000,N'Ghi chú nè',4)
insert into Staffs
	values(N'Đoàn Ngọc Hải',1,'01/05/1994','hai.jpg','haidn@gmail.com','0985268751',6500000,N'Siêng năng',3)
insert into Staffs
	values(N'Nguyện Thị Kim',0,'06/05/1980','kim.jpg','kimnt@gmail.com','0585268751',8000000,N'Siêng',2)
insert into Staffs
	values(N'Trần thị Trinh',0,'11/05/1992','trinh.jpg','trinhnt@gmail.com','0945268751',6700000,N'Ghi chú nè',4)
insert into Staffs
	values(N'Lê Văn Đại',1,'05/10/1980','dai.jpg','dailv@gmail.com','0965268751',7500000,N'Ghi chú nè',1)
	
	--ddddddddddddddddddddddddddđ
	--delete Staffs where id=1
	--update Staffs set name=N'VÕ QUANG NE', gender=0, birthday='01/01/2001', photo='quang.png', email='quang@gmail.com', phone='0982165398', salary=600, notes='thu update', DepartId=2 where id=1
insert into Records
	values(1,N'Tăng ca','01/15/2020',2)
insert into Records
	values(0,N'Đi trễ','01/11/2020',1)
insert into Records
	values(1,N'Tăng ca','01/15/2020',3)
insert into Records
	values(0,N'Đi trễ','01/11/2020',4)
insert into Records
	values(1,N'Tăng ca','01/15/2020',5)
insert into Records
	values(0,N'Đi trễ','01/11/2020',6)
insert into Records
	values(1,N'Tăng ca','01/15/2020',7)
insert into Records
	values(0,N'Nghĩ không phép','01/11/2020',8)
insert into Records
	values(1,N'Tăng ca','01/15/2020',9)
insert into Records
	values(0,N'Đi trễ','01/11/2020',10)
insert into Records
	values(1,N'Tăng ca','01/15/2020',11)
insert into Records
	values(0,N'Đi trễ','01/11/2020',12)
insert into Records
	values(1,N'Tăng ca','01/15/2020',13)
insert into Records
	values(0,N'Nghĩ không phép','01/11/2020',14)
insert into Records
	values(1,N'Tăng ca','01/15/2020',15)
insert into Records
	values(0,N'Nghĩ không phép','01/11/2020',16)
insert into Records
	values(1,N'Tăng ca','01/15/2020',16)
insert into Records
	values(0,N'Đi trễ','01/11/2020',15)
insert into Records
	values(1,N'Tăng ca','01/15/2020',14)
insert into Records
	values(0,N'Nghĩ không phép','01/11/2020',13)
insert into Records
	values(1,N'Tăng ca','01/15/2020',12)
insert into Records
	values(0,N'Đi trễ','01/11/2020',11)
insert into Records
	values(1,N'Tăng ca','01/15/2020',7)
insert into Records
	values(0,N'Đi trễ','01/11/2020',8)
insert into Records
	values(1,N'Tăng ca','01/15/2020',9)
insert into Records
	values(0,N'Nghĩ không phép','01/11/2020',10)
insert into Records
	values(1,N'Tăng ca','01/15/2020',6)
insert into Records
	values(0,N'Đi trễ','01/11/2020',4)
insert into Records
	values(1,N'Tăng ca','01/15/2020',3)
insert into Records
	values(0,N'Nghĩ không phép','01/11/2020',14)
insert into Records
	values(1,N'Tăng ca','01/15/2020',15)
insert into Records
	values(0,N'Nghĩ không phép','01/11/2020',16)
	--select * from Records
	-- tông hop theo ca nhan
	--SELECT r.StaffId, SUM(case when r.type=1 then 1 else 0 end),
 --               SUM(case when r.type=0 then 1 else 0 end),
	--			SUM((case when r.type=1 then 1 else 0 end)- (case when r.type=0 then 1 else 0 end))
 --               FROM Records r, Staffs
 --               GROUP BY r.StaffId
				-- tong hop theo phjong ban
--select Departs.name, SUM(case when r.type=1 then 1 else 0 end),
--                SUM(case when r.type=0 then 1 else 0 end),
--				SUM((case when r.type=1 then 1 else 0 end)- (case when r.type=0 then 1 else 0 end)) from Departs, Staffs, Records r
--where Staffs.DepartId = Departs.id and Staffs.id = r.StaffId
--GROUP BY Departs.name

select * from Staffs
select top 10 * from Staffs