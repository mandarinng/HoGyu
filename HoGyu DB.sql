create database if not exists pjt;
use pjt;

create table `user` (
    `id` varchar(50) not null primary key,
    `password` varchar(50) not null,
    `name` varchar(50) not null,
    `phoneNum` varchar(70) not null,
    `address` varchar(100) not null
);

insert into user
values ('ssafy', '1234', '김싸피', '01012345678', '대전시 유성구 동서대로');
insert into user
values ('ssafy2', '3333', '박싸피', '01098765432', '대전시 서구 한밭대로');

select * from user;


create table `product`(
	`productId` varchar(50) not null primary key,
    `productName` varchar(50) not null,
    `price` int not null,
    `category` varchar(30) not null,
    `img` varchar(1000) not null,
    `detail` varchar(1000)
    
);

INSERT INTO product
VALUES ('mach01', '접이식 실내자전거', 150000, '기구', '실내자전거.PNG', '실내자전거_상세.jpg'),
	   ('mach02', '스마트 인바디 체중계', 90000, '기구', '체중계.PNG', '체중계_상세.jpg'),
       ('mach03', '프리미엄 요가매트', 37500, '기구', '요가매트.PNG', '요가매트_상세.jpg'),
       ('mach04', '아리프 옥타곤 아령', 47000, '기구', '아령.PNG', '아령_상세.jpg'),
       ('mach05', '이고진 메리 케틀벨', 62000, '기구', '케틀벨.PNG', '케틀벨_상세.jpg'),
       ('mach06', '마이웨잇 EVA 폼롤러', 20900, '기구', '폼롤러.PNG', '폼롤러_상세.jpg'),
       ('mach07', '잠스트 무릎 보호대', 47500, '기구', '무릎보호대.PNG', '무릎보호대_상세.jpg'),
       ('mach08', '이고진 짐볼 + 발 펌프', 12500, '기구', '짐볼.PNG', '짐볼_상세.jpg'),
       ('mach09', '로베라 트위스트 스텝퍼', 54000, '기구', '스텝퍼.PNG', '스템퍼_상세.jpg'),
       ('mach10', 'OLC PUB01 철봉 치닝디핑 턱걸이 실내운동기구', 72000, '기구', '철봉.PNG', '철봉_상세.jpg'),
       ('wear01', '나이키 우먼스 파크 7 저지', 22300, '의류', '나이키상의.PNG', '나이키상의_상세.jpg'),
       ('wear02', '이프노스 콘트 여성용 레깅스 필라테스 요가복', 14300, '의류', '레깅스.PNG', '레깅스_상세.jpg'),
       ('wear03', '몽키그립 미끌림방지 골프장갑', 19000, '의류', '골프장갑.PNG', '골프장갑_상세.jpg'),
       ('wear04', '머렐 여성 배색 포인트 반집업 반팔티셔츠', 10000, '의류', '반팔등산복.jpg', '반팔등산복_상세.jpg'),
       ('wear05', 'snrd 런닝화', 38700, '의류', '런닝화.PNG', '런닝화_상세.jpg'),
			 ('wear06','SABU 여성용 요가 필라테스 크롭 집업 자켓', 12400, '의류','크롭집업.png','크롭집업_상세.jpg'),
		('wear07','뉴팬덤 기모 남여공용 맨투맨 트레이닝 SET', 50000, '의류','뉴팬덤.jpg','뉴팬덤_상세.jpg'),
		('wear08','남성 트레이닝 패딩 세트 기모 상하의', 39000, '의류','패딩.jpg','패딩_상세.jpg'),
		('wear09','SABU 여성용 요가 필라테스 반팔 티셔츠', 10000, '의류','반팔.jpg','반팔_상세.jpg'),
       ('wear10', '에어워크서프 여성 래쉬가드', 38700, '의류', '래쉬가드.jpg', '래쉬가드_상세.jpg'),
       ('food01','곰곰 단백질바 미니사이즈', 10000, '식품','프로틴바.png','프로틴바_상세.jpg'),
    ('food02','마이밀 마시는 뉴프로틴', 18000, '식품','뉴프로틴.png','뉴프로틴_상세.jpg'),
    ('food03','노티프 버닝부스트 MCT 운동오일', 26000, '식품','노티프.png','노티프_상세.png'),
    ('food04','머슬팜 컴뱃 프로틴 파우더 드링크 믹스 초콜릿 밀크', 56000, '식품','프로틴파우더.PNG','프로틴파우더_상세.jpg'),
    ('food05','다이어트 바이탈뷰티 메타그린 슬림업', 31000, '식품','메타그린.jpg','메타그린_상세.jpg'),
    ('food06','오늘부터 슬림핑크 복숭아맛', 12000, '식품','슬림핑크.png','슬림핑크_상세.jpg'),
    ('food07','에버틴 다이어트톡 발포다이어트', 7900, '식품','에버틴.png','에버틴_상세.jpg'),
    ('food08','허닭 스팀 닭가슴살 슬라이스', 47000, '식품','허닭.png','허닭_상세.jpg'),
    ('food09','시그니처벨 다이어트 4주 식단', 45900, '식품','도시락.png','도시락_상세.jpg'),
    ('food10','라이틀리 청양닭가슴살 곤약김밥', 4600, '식품','곤약김밥.png','곤약김밥_상세.jpg');


select * from product;


create table `review` (
    `reviewId` int AUTO_INCREMENT not null primary key,
    `writer` varchar(50) not null ,
    `productId` varchar(50) not null,
    `content` varchar(2000) not null,
    `star` int not null,
    `regDate` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `img` varchar(100),
    `orgImg` varchar(100),
    foreign key(writer) references user(id),
    foreign key(productId) references product (productId)
);

insert into review (writer, productId, content, star)
values ('ssafy2', 'food01', '좋아용.', 3);

select * from review;

select * from user
inner join review
on id=writer;


CREATE TABLE `client` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `userId` varchar(50) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `phoneNum` VARCHAR(20) NOT NULL,
    `zipcode` VARCHAR(10) NOT NULL,
    `addr1` VARCHAR(255) NOT NULL,
    `addr2` VARCHAR(255) NOT NULL,
    `productId` varchar(50) NOT NULL,
    `productName` varchar(50) NOT NULL,
    `cnt` INT NOT NULL,
    `totalPrice` INT NOT NULL,
    foreign key(productId) references product (productId),
    foreign key(userId) references user (id)
);

INSERT INTO `client` 
    (`userId`, `name`, `phoneNum`, `zipcode`, `addr1`, `addr2`, `productId`,`productName`, `cnt`, `totalPrice`)
VALUES 
    ('ssafy', 'John Doe', '123-456-7890', '12345', '123 Main St', 'Apt 2B', 'food01','곰곰 단백질바 미니사이즈', 2, 5000),
    ( 'ssafy2','Jane Smith', '987-654-3210', '54321', '456 Oak St', 'Unit 5C', 'food01','곰곰 단백질바 미니사이즈', 1, 3000),
    ('ssafy','Alice Johnson', '555-123-4567', '67890', '789 Pine St', 'Suite 10', 'food02','마이밀 마시는 뉴프로틴', 3, 8000);

select * from client;

CREATE TABLE `clients` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `orderId` varchar(50) NOT NULL,
    `userId` varchar(50) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `phoneNum` VARCHAR(20) NOT NULL,
    `address` VARCHAR(255) NOT NULL,
    `productId` varchar(50) NOT NULL,
    `productName` varchar(50) NOT NULL,
    `cnt` INT NOT NULL,
    `totalPrice` INT NOT NULL,
    `partner` Int Not NULL,
    foreign key(productId) references product (productId),
    foreign key(userId) references user (id)
);

INSERT INTO `clients` 
    (`orderId`, `userId`, `name`, `phoneNum`, `address`, `productId`,`productName`,  `cnt`, `totalPrice`,`partner`)
VALUES 
    ('food011', 'ssafy','John Doe', '123-456-7890', '123 Main St', 'food01','곰곰 단백질바 미니사이즈', 2, 5000,2),
        ('food012', 'ssafy2','Jane Smith', '987-654-3210', '456 Oak St', 'food01','곰곰 단백질바 미니사이즈', 1, 3000,1),
    ('food021', 'ssafy','Alice Johnson', '555-123-4567', '789 Pine St','food02','마이밀 마시는 뉴프로틴', 3, 8000,1),
    ('food011', 'ssafy2','Jane Smith', '987-654-3210', '456 Oak St', 'food01','곰곰 단백질바 미니사이즈', 1, 10000,2);


select * from clients;

update clients
set partner = partner+1
where orderId='food011';



create table `cart` (
    `id` int AUTO_INCREMENT primary key,
    `productId` varchar(50) not null,
    `productName` varchar(50) not null,
    `cnt` int not null,
    `price` int not null,
    `img` varchar(100) not null,
    `userId` varchar(50) not null,
     foreign key(userId) references user (id)
);

INSERT INTO cart (productId, productName, cnt, price, img, userId)
VALUES ('food01', '곰곰 단백질바 미니사이즈',1, 10000, '프로틴바.png', 'ssafy'),
('food02', '마이밀 마시는 뉴프로틴', 10000,2, '뉴프로틴.png', 'ssafy'),
('food01', '곰곰 단백질바 미니사이즈', 10000,1, '프로틴바.png', 'ssafy2');

select * from cart;