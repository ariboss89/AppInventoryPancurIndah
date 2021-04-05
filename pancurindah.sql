# Host: localhost  (Version: 5.5.8)
# Date: 2020-11-04 21:12:02
# Generator: MySQL-Front 5.3  (Build 4.81)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "dt_masuk"
#

DROP TABLE IF EXISTS `dt_masuk`;
CREATE TABLE `dt_masuk` (
  `iddetailmasuk` int(11) NOT NULL AUTO_INCREMENT,
  `idmasuk` varchar(20) DEFAULT NULL,
  `idbarang` varchar(20) DEFAULT NULL,
  `namabarang` varchar(255) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`iddetailmasuk`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

#
# Data for table "dt_masuk"
#

INSERT INTO `dt_masuk` VALUES (4,'IN-0001','B0001','Kertas A4 Sidu',50,'Selesai'),(5,'IN-0001','B0002','Kertas F4 Sidu',40,'Selesai'),(6,'IN-0002','B0003','Pena Snowman',50,'Selesai'),(7,'IN-0003','B0003','Pena Snowman',50,'Proses'),(8,'IN-0004','B0003','Pena Snowman',100,'Proses'),(9,'IN-0004','B0001','Kertas A4 Sidu',40,'Proses'),(10,'IN-0005','B0003','Pena Snowman',120,'Proses'),(11,'IN-0006','B0003','Pena Snowman',40,'Proses'),(12,'IN-0006','B0001','Kertas A4 Sidu',50,'Proses');

#
# Structure for table "tb_barang"
#

DROP TABLE IF EXISTS `tb_barang`;
CREATE TABLE `tb_barang` (
  `idbarang` varchar(11) NOT NULL DEFAULT '',
  `nama` varchar(255) DEFAULT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `satuan` varchar(255) DEFAULT NULL,
  `hargabeli` int(11) DEFAULT NULL,
  `hargajual` int(11) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `minstok` int(11) DEFAULT NULL,
  PRIMARY KEY (`idbarang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tb_barang"
#

INSERT INTO `tb_barang` VALUES ('B0001','Kertas A4 Sidu','ATK','RIM',30000,50000,50,20),('B0002','Kertas F4 Sidu','ATK','RIM',40000,55000,40,10),('B0003','Pena Snowman','ATK','BOX',8000,10000,50,5);

#
# Structure for table "tb_pengguna"
#

DROP TABLE IF EXISTS `tb_pengguna`;
CREATE TABLE `tb_pengguna` (
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "tb_pengguna"
#

/*!40000 ALTER TABLE `tb_pengguna` DISABLE KEYS */;
INSERT INTO `tb_pengguna` VALUES ('anton123','123456','ADMIN'),('han123','123456','SUPERADMIN');
/*!40000 ALTER TABLE `tb_pengguna` ENABLE KEYS */;

#
# Structure for table "tb_supplier"
#

DROP TABLE IF EXISTS `tb_supplier`;
CREATE TABLE `tb_supplier` (
  `idsupplier` varchar(11) NOT NULL DEFAULT '0',
  `nama` varchar(50) DEFAULT NULL,
  `kontak` varchar(12) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idsupplier`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tb_supplier"
#

INSERT INTO `tb_supplier` VALUES ('S0001','Cv. Tuah Jaya Perdana','081277618851','Jl. Ganet Perum Catur No,208'),('S0002','PT. Utama Karya','081218118888','Jl. D.I. Panjaitan');

#
# Structure for table "tr_barang"
#

DROP TABLE IF EXISTS `tr_barang`;
CREATE TABLE `tr_barang` (
  `idtransaksibarang` varchar(11) NOT NULL DEFAULT '',
  `idbarang` varchar(11) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtransaksibarang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tr_barang"
#

INSERT INTO `tr_barang` VALUES ('TRB0001','B0001','2020-11-01',50),('TRB0002','B0002','2020-11-04',40),('TRB0003','B0003','2020-11-04',50);

#
# Structure for table "tr_masuk"
#

DROP TABLE IF EXISTS `tr_masuk`;
CREATE TABLE `tr_masuk` (
  `idmasuk` varchar(11) NOT NULL DEFAULT '',
  `tanggal` date DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `idsupplier` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`idmasuk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tr_masuk"
#

INSERT INTO `tr_masuk` VALUES ('IN-0001','2020-10-31',90,'S0001'),('IN-0002','2020-10-31',50,'S0002'),('IN-0003','2020-11-01',50,'S0001'),('IN-0004','2020-11-01',140,'S0001'),('IN-0005','2020-11-01',120,'S0002'),('IN-0006','2020-11-04',90,'S0001');
