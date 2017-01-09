-- phpMyAdmin SQL Dump
-- version 4.4.15.6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2016-08-09 17:22:17
-- 服务器版本： 5.5.48-log
-- PHP Version: 5.5.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `s_app_db`
--

-- --------------------------------------------------------

--
-- 表的结构 `bs_alipay_callback_log`
--

CREATE TABLE IF NOT EXISTS `bs_alipay_callback_log` (
  `id` int(11) NOT NULL,
  `from_method` varchar(45) DEFAULT 'notify_url' COMMENT 'notify_url/return_url',
  `input_param` text,
  `out_trade_no` varchar(256) DEFAULT NULL,
  `app_id` int(11) DEFAULT NULL,
  `app_series_number` varchar(45) DEFAULT NULL,
  `unit_id` int(11) DEFAULT NULL,
  `unit_series_number` varchar(45) DEFAULT NULL,
  `trade_no` varchar(256) DEFAULT NULL,
  `trade_status` varchar(45) DEFAULT NULL,
  `buyer_email` varchar(45) DEFAULT NULL,
  `buyer_id` varchar(45) DEFAULT NULL,
  `back_sign` varchar(256) DEFAULT NULL,
  `return_url` varchar(512) DEFAULT NULL,
  `notify_url` varchar(512) DEFAULT NULL,
  `error_exception` varchar(256) DEFAULT NULL,
  `need_refund` int(11) DEFAULT '0',
  `call_client_url` varchar(512) DEFAULT NULL,
  `call_client_return` varchar(512) DEFAULT NULL,
  `created` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `bs_alipay_callback_log`
--

INSERT INTO `bs_alipay_callback_log` (`id`, `from_method`, `input_param`, `out_trade_no`, `app_id`, `app_series_number`, `unit_id`, `unit_series_number`, `trade_no`, `trade_status`, `buyer_email`, `buyer_id`, `back_sign`, `return_url`, `notify_url`, `error_exception`, `need_refund`, `call_client_url`, `call_client_return`, `created`) VALUES
(1, 'notifyCall', 'payment_type:1subject:法国个人旅游trade_no:2016072921001004060271901892buyer_email:963480@163.comgmt_create:2016-07-29 14:35:34notify_type:trade_status_syncquantity:1out_trade_no:1606298hix251607298ft1notify_time:2016-07-29 14:35:35seller_id:2088121608978301trade_status:TRADE_SUCCESSis_total_fee_adjust:Ntotal_fee:0.01gmt_payment:2016-07-29 14:35:35seller_email:pay@woigo.cnprice:0.01buyer_id:2088002450730063notify_id:f13acf059bc0877add3408874fde039ggquse_coupon:Nsign_type:RSAsign:guoR+940WYsHhHtfehfBNHNDy3zSKSLTbEZNVG0P7U0PFMNHanXmBsp61YWqPvzFdgmFZAWEE1r/6W0CfLuawp+KVRIa6h4qKpqWh1jIlVQjUi0fw/x+TCKXuSA8sKHPOnTp/qa0xH0gpA3jeArAsJIaGpxr/WO8kCrrGiY2hhs=', '1606298hix251607298ft1', 1, '1606298hix25', 1, '160629f8v1ul', '2016072921001004060271901892', 'TRADE_SUCCESS', '963480@163.com', '2088002450730063', 'f2493b877c623cc046768aa28cb539be', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url?back_sign=f2493b877c623cc046768aa28cb539be&buyer_id=2088002450730063&buyer_email=963480@163.com&trade_status=TRADE_SUCCESS&trade_no=2016072921001004060271901892&out_trade_no=1607298ft1', 'success', '2016-07-29 14:35:35'),
(2, 'returnCall', 'is_success:Tnotify_id:RqPnCoPT3K9%2Fvwbh3InXQBiGhELs5gM%2B4xoTRzLvfi6yZyDojL7%2B4ZCnt5ZO85QuqTAPnotify_time:2016-07-29 14:35:35notify_type:trade_status_syncout_trade_no:1606298hix251607298ft1payment_type:1seller_id:2088121608978301service:alipay.wap.create.direct.pay.by.usersubject:法国个人旅游total_fee:0.01trade_no:2016072921001004060271901892trade_status:TRADE_SUCCESSsign:EVwEre+0tpUjiUcrNAFMMQap4vV8zLEJYmK5sATFMe/ooQPK4JDCaH/xs9HdnKrCGwQfOchuc2edzInJi8sUArcu3kiHWwqUBDRMqh6a5WdUX5fKa3RDAuWXgV2NLZJ89yazf2cFYOjEGRWiXrA+a9XJko1QtQVaeHsOti+qqjc=sign_type:RSA', '1606298hix251607298ft1', 1, '1606298hix25', 1, '160629f8v1ul', '2016072921001004060271901892', 'TRADE_SUCCESS', '', '', 'f2493b877c623cc046768aa28cb539be', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/return_url?back_sign=f2493b877c623cc046768aa28cb539be&buyer_id=&buyer_email=&trade_status=TRADE_SUCCESS&trade_no=2016072921001004060271901892&out_trade_no=1607298ft1', '', '2016-07-29 14:35:47'),
(3, 'notifyCall', 'payment_type:1subject:美国旅游签证trade_no:2016072921001004060278020583buyer_email:963480@163.comgmt_create:2016-07-29 13:14:10notify_type:trade_status_syncquantity:1out_trade_no:1606298hix251607299lwanotify_time:2016-07-29 14:39:42seller_id:2088121608978301trade_status:TRADE_SUCCESSis_total_fee_adjust:Ntotal_fee:0.01gmt_payment:2016-07-29 13:14:11seller_email:pay@woigo.cnprice:0.01buyer_id:2088002450730063notify_id:e861828be5979ee4de5ae2cc74ad7f6ggquse_coupon:Nsign_type:RSAsign:e6M7Um42cl6g95Qm3kstRW5FrJKWhHLHbZwrEVXcG3sU/RWghX0heMDmBAw/lUmLMXWMU05xyaOWyK6UpG5OxcTPj5kxb3pU+hweJWO8zLd5t83eetM2dIOPaJlwRTwWoLr2P9av8Z3xo42f+V746GDnPNcu1leLnJXKXZEv7Jc=', '1606298hix251607299lwa', 1, '1606298hix25', 1, '160629f8v1ul', '2016072921001004060278020583', 'TRADE_SUCCESS', '963480@163.com', '2088002450730063', 'e8e6808d13e4d34609e3c7a8d9e79c7e', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url?back_sign=e8e6808d13e4d34609e3c7a8d9e79c7e&buyer_id=2088002450730063&buyer_email=963480@163.com&trade_status=TRADE_SUCCESS&trade_no=2016072921001004060278020583&out_trade_no=1607299lwa', 'fail', '2016-07-29 14:39:42'),
(4, 'notifyCall', 'payment_type:1subject:加拿大个人旅游签证trade_no:2016072921001004060270153366buyer_email:963480@163.comgmt_create:2016-07-29 15:14:07notify_type:trade_status_syncquantity:1out_trade_no:1606298hix251607291xyonotify_time:2016-07-29 15:14:08seller_id:2088121608978301trade_status:TRADE_SUCCESSis_total_fee_adjust:Ntotal_fee:0.01gmt_payment:2016-07-29 15:14:08seller_email:pay@woigo.cnprice:0.01buyer_id:2088002450730063notify_id:604dbb30e9617d80e1a86c3e76b01c6ggquse_coupon:Nsign_type:RSAsign:HnBDZcNDE53/58gO3Ux5Opi+JTyJhoBfTXp1g0XqzXE4skg+bLJR3K1erzroiACF0JpEMjrLzLzXdQLJ/a6Cvyros1rCeETfTzqRGiwFSLGT1BnEt+4w2bnp0lF8+3upD2MU3sdalCG6MGfALiqiB2zk37XIjRH+mOXzNMNYXic=', '1606298hix251607291xyo', 1, '1606298hix25', 1, '160629f8v1ul', '2016072921001004060270153366', 'TRADE_SUCCESS', '963480@163.com', '2088002450730063', '66215df5240617b60f32e1589bb1fc94', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url?back_sign=66215df5240617b60f32e1589bb1fc94&buyer_id=2088002450730063&buyer_email=963480@163.com&trade_status=TRADE_SUCCESS&trade_no=2016072921001004060270153366&out_trade_no=1607291xyo', 'success', '2016-07-29 15:14:09'),
(5, 'returnCall', 'is_success:Tnotify_id:RqPnCoPT3K9%2Fvwbh3InXQBiGhrEgbhjDBmokdkjbbg9%2BX1i1ExQKQHvkE3mKTORr7bfynotify_time:2016-07-29 15:14:09notify_type:trade_status_syncout_trade_no:1606298hix251607291xyopayment_type:1seller_id:2088121608978301service:alipay.wap.create.direct.pay.by.usersubject:加拿大个人旅游签证total_fee:0.01trade_no:2016072921001004060270153366trade_status:TRADE_SUCCESSsign:WybYj1yn6TtFGHFr1iqRrYAD61U1qpN9H8lbYMrdAvUX9+VuTT7kfFh4uzxJKOJDsvnxd50HVujLoqLHLSuBoKFL8+YTi3dWm1QbGFyaZ30aummscQy7vFy7RByaRM9A9eATdiZR38y7Dil0I4v+9816KOghti2xfPovPxS82fI=sign_type:RSA', '1606298hix251607291xyo', 1, '1606298hix25', 1, '160629f8v1ul', '2016072921001004060270153366', 'TRADE_SUCCESS', '', '', '66215df5240617b60f32e1589bb1fc94', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/return_url?back_sign=66215df5240617b60f32e1589bb1fc94&buyer_id=&buyer_email=&trade_status=TRADE_SUCCESS&trade_no=2016072921001004060270153366&out_trade_no=1607291xyo', '', '2016-07-29 15:14:11'),
(6, 'notifyCall', 'payment_type:1subject:土耳其个人旅游签证trade_no:2016072921001004060273088224buyer_email:963480@163.comgmt_create:2016-07-29 11:52:28notify_type:trade_status_syncquantity:1out_trade_no:1606298hix251607297dfunotify_time:2016-07-29 15:16:23seller_id:2088121608978301trade_status:TRADE_SUCCESSis_total_fee_adjust:Ntotal_fee:0.01gmt_payment:2016-07-29 11:52:29seller_email:pay@woigo.cnprice:0.01buyer_id:2088002450730063notify_id:d1c3d5e30e30b647d87dd119002e5f6ggquse_coupon:Nsign_type:RSAsign:YjiIV18EuHDeN+BlVIYBYvunG/kVe+EUMfOiRJWJ5vPJhyoDvQXV/KIPd5D4Ikq78Pna4seZjFYUNa0+OZFo4O0t2zPSVvz8r33iUhlRW6jjQtCGngvZw/OC36sYAWX1fYu20+ucYcxZgyparTmZ+DVqieM7pxSP0UlB08RXrHE=', '1606298hix251607297dfu', 1, '1606298hix25', 1, '160629f8v1ul', '2016072921001004060273088224', 'TRADE_SUCCESS', '963480@163.com', '2088002450730063', '153e2bd54a95b7a0f6e859602243bfa4', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url?back_sign=153e2bd54a95b7a0f6e859602243bfa4&buyer_id=2088002450730063&buyer_email=963480@163.com&trade_status=TRADE_SUCCESS&trade_no=2016072921001004060273088224&out_trade_no=1607297dfu', 'fail', '2016-07-29 15:16:23'),
(7, 'notifyCall', 'payment_type:1subject:美国旅游签证trade_no:2016072921001004060279683425buyer_email:963480@163.comgmt_create:2016-07-29 16:15:07notify_type:trade_status_syncquantity:1out_trade_no:1606298hix25160729iol3notify_time:2016-07-29 16:15:09seller_id:2088121608978301trade_status:TRADE_SUCCESSis_total_fee_adjust:Ntotal_fee:0.01gmt_payment:2016-07-29 16:15:09seller_email:pay@woigo.cnprice:0.01buyer_id:2088002450730063notify_id:f95b093fcf5b9c4b31382ec3e34ce32ggquse_coupon:Nsign_type:RSAsign:L9tn7Zg6hzS1XXJKjt7p7IG2IGLwhcA/9xbLUWk8EOMYcZsTk+YZwN0cPg516vLrhRvIPz3CWVyx97cgPWYkWw64TCF5+ZlRgKg+rYi2TVtO+5MX3bemKv63+RpHXmeVV2MmUtByKxfvkOW/exUFJh9ekCFouUBpdQDWCWS9WQk=', '1606298hix25160729iol3', 1, '1606298hix25', 1, '160629f8v1ul', '2016072921001004060279683425', 'TRADE_SUCCESS', '963480@163.com', '2088002450730063', '9ba133a35ad86462c949f88cfc3bc857', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url?back_sign=9ba133a35ad86462c949f88cfc3bc857&buyer_id=2088002450730063&buyer_email=963480@163.com&trade_status=TRADE_SUCCESS&trade_no=2016072921001004060279683425&out_trade_no=160729iol3', 'success', '2016-07-29 16:15:09'),
(8, 'returnCall', 'is_success:Tnotify_id:RqPnCoPT3K9%2Fvwbh3InXQBiJY10fUxdQTSPNtM4mB%2BLyddTOsRDh3coFGAAeNJm4%2Bnotnotify_time:2016-07-29 16:15:09notify_type:trade_status_syncout_trade_no:1606298hix25160729iol3payment_type:1seller_id:2088121608978301service:alipay.wap.create.direct.pay.by.usersubject:美国旅游签证total_fee:0.01trade_no:2016072921001004060279683425trade_status:TRADE_SUCCESSsign:FOeLQh0BrOiSO0s3DdNG6qFEAUuQpIfAs6COmtdBdf3n53TV52feRaFUYQZ1d+WER0AVxGi2UOg9OOztMWekqXALbRFqvt/xYpRaGP05ZJJkEh2kc8Tplv4j9r5wUgQ4qN/4p6nWwpqaKRvbp65kav+EEHGsqox4t90kc8kiyfw=sign_type:RSA', '1606298hix25160729iol3', 1, '1606298hix25', 1, '160629f8v1ul', '2016072921001004060279683425', 'TRADE_SUCCESS', '', '', '9ba133a35ad86462c949f88cfc3bc857', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/return_url?back_sign=9ba133a35ad86462c949f88cfc3bc857&buyer_id=&buyer_email=&trade_status=TRADE_SUCCESS&trade_no=2016072921001004060279683425&out_trade_no=160729iol3', '', '2016-07-29 16:15:11'),
(9, 'notifyCall', 'payment_type:1subject:美国旅游签证trade_no:2016072921001004060278020583buyer_email:963480@163.comgmt_create:2016-07-29 13:14:10notify_type:trade_status_syncquantity:1out_trade_no:1606298hix251607299lwanotify_time:2016-07-29 16:38:18seller_id:2088121608978301trade_status:TRADE_SUCCESSis_total_fee_adjust:Ntotal_fee:0.01gmt_payment:2016-07-29 13:14:11seller_email:pay@woigo.cnprice:0.01buyer_id:2088002450730063notify_id:e861828be5979ee4de5ae2cc74ad7f6ggquse_coupon:Nsign_type:RSAsign:P+zHCO8IaDxISLuDqfDtqmDvCVJTkfRL5vfKnkCw2evlCzmDH5TImhpFcF1jqogsEoLz+Iy0JV40VdAKa/AZptb6rh44UQSPS1csYawyYGxqBxSxU3vqc546esUKzqgpj0vXUHzxhhR9Ga3SPm8N/MOQfQRwV1ZUi0cWsd/hbIw=', '1606298hix251607299lwa', 1, '1606298hix25', 1, '160629f8v1ul', '2016072921001004060278020583', 'TRADE_SUCCESS', '963480@163.com', '2088002450730063', 'e8e6808d13e4d34609e3c7a8d9e79c7e', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url?back_sign=e8e6808d13e4d34609e3c7a8d9e79c7e&buyer_id=2088002450730063&buyer_email=963480@163.com&trade_status=TRADE_SUCCESS&trade_no=2016072921001004060278020583&out_trade_no=1607299lwa', 'fail', '2016-07-29 16:38:18'),
(10, 'notifyCall', 'payment_type:1subject:美国旅游签证trade_no:2016073021001004060279112402buyer_email:963480@163.comgmt_create:2016-07-30 01:44:15notify_type:trade_status_syncquantity:1out_trade_no:1606298hix25160730u8jtnotify_time:2016-07-30 01:44:17seller_id:2088121608978301trade_status:TRADE_SUCCESSis_total_fee_adjust:Ntotal_fee:0.01gmt_payment:2016-07-30 01:44:16seller_email:pay@woigo.cnprice:0.01buyer_id:2088002450730063notify_id:46341fbd44fcc99b05bad2590066706ggquse_coupon:Nsign_type:RSAsign:J/AuHtkH3yhca1B3KtZa4c3rETZBUr0R2JVj2bTavpIPj+Ghqu/WEv11Hj9oI3rycQ67/cfLW+JE1jfeMkHsL+At9w3x6urJpdEIVKOn0bpHIqIG33qjJ/dReUzrEWjXQ3N0EINjK1b3rMUmcWAScwdJf7vPVx3LduyJ9YivUb4=', '1606298hix25160730u8jt', 1, '1606298hix25', 1, '160629f8v1ul', '2016073021001004060279112402', 'TRADE_SUCCESS', '963480@163.com', '2088002450730063', 'fb00022d20aa931677f2b3766cc089d2', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url?back_sign=fb00022d20aa931677f2b3766cc089d2&buyer_id=2088002450730063&buyer_email=963480@163.com&trade_status=TRADE_SUCCESS&trade_no=2016073021001004060279112402&out_trade_no=160730u8jt', 'success', '2016-07-30 01:44:18'),
(11, 'returnCall', 'is_success:Tnotify_id:RqPnCoPT3K9%2Fvwbh3InXQBepW%2FzAJpZOU3spV3YWEk2u4SG5EoEArNox1vL8GKUQWxXJnotify_time:2016-07-30 01:44:17notify_type:trade_status_syncout_trade_no:1606298hix25160730u8jtpayment_type:1seller_id:2088121608978301service:alipay.wap.create.direct.pay.by.usersubject:美国旅游签证total_fee:0.01trade_no:2016073021001004060279112402trade_status:TRADE_SUCCESSsign:CmTWvh16wiwfi/2PHGBjn5wRSF8Nv+lckej6uYi1aZ1EW/4rd4wPnop+7G1wkvW+rSDe2hVz77hoKaE4lCNkSn/jJiUB2PBje05xlxQXgEhZMF5uKJl0WDXu8iiIpmzjFcFhclpVdPtoOTkLS4uJCQMHo+7qsSniWyRG52un9po=sign_type:RSA', '1606298hix25160730u8jt', 1, '1606298hix25', 1, '160629f8v1ul', '2016073021001004060279112402', 'TRADE_SUCCESS', '', '', 'fb00022d20aa931677f2b3766cc089d2', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/return_url?back_sign=fb00022d20aa931677f2b3766cc089d2&buyer_id=&buyer_email=&trade_status=TRADE_SUCCESS&trade_no=2016073021001004060279112402&out_trade_no=160730u8jt', '', '2016-07-30 01:44:19'),
(12, 'notifyCall', 'payment_type:1subject:美国旅游签证trade_no:2016073021001004060273158765buyer_email:963480@163.comgmt_create:2016-07-30 06:17:44notify_type:trade_status_syncquantity:1out_trade_no:1606298hix2516073041rynotify_time:2016-07-30 06:17:45seller_id:2088121608978301trade_status:TRADE_SUCCESSis_total_fee_adjust:Ntotal_fee:0.01gmt_payment:2016-07-30 06:17:45seller_email:pay@woigo.cnprice:0.01buyer_id:2088002450730063notify_id:0c29d8214cb930543257bdeceaf5761ggquse_coupon:Nsign_type:RSAsign:jENqei6zJ7FKXnyzDcXqWaHmKwKb9wQqOApmB3D9ina7wPchaqiZ1sBMbZetgK/nMdctqfYtbbOPfUjTkgXUgciBqnTHhMfuD9gxCi7EwBfrngJmvB4kIAC2nHQB1T0L9J6YlDx/Ga8M93N++McSwmTIW0XglPrn8w06xl3ZNFk=', '1606298hix2516073041ry', 1, '1606298hix25', 1, '160629f8v1ul', '2016073021001004060273158765', 'TRADE_SUCCESS', '963480@163.com', '2088002450730063', '0bfc5135e1a0ea9d70c78a97e892a0e6', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url?back_sign=0bfc5135e1a0ea9d70c78a97e892a0e6&buyer_id=2088002450730063&buyer_email=963480@163.com&trade_status=TRADE_SUCCESS&trade_no=2016073021001004060273158765&out_trade_no=16073041ry', 'success', '2016-07-30 06:17:45'),
(13, 'returnCall', 'is_success:Tnotify_id:RqPnCoPT3K9%2Fvwbh3InXQBerXBl457bKci6jibChm%2B9eQU1K8qY0f4ERE0lldZP78IA2notify_time:2016-07-30 06:17:45notify_type:trade_status_syncout_trade_no:1606298hix2516073041rypayment_type:1seller_id:2088121608978301service:alipay.wap.create.direct.pay.by.usersubject:美国旅游签证total_fee:0.01trade_no:2016073021001004060273158765trade_status:TRADE_SUCCESSsign:OoAQu/S3ZajBGeKfha4ZYYj9FNbGzakRWpA71ovZYfk0GzOVEzGOpXnKANtgi8+miGt/m2CxBNnb7cMWddHfj6vju2IPWIMLFYkLkmPucjoj2QV4iXNgcQpszYZGeD98kPirrhSgFCBvEHe10QfjqZCQrE/4Ud7I7+CyWmQu03Q=sign_type:RSA', '1606298hix2516073041ry', 1, '1606298hix25', 1, '160629f8v1ul', '2016073021001004060273158765', 'TRADE_SUCCESS', '', '', '0bfc5135e1a0ea9d70c78a97e892a0e6', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/return_url?back_sign=0bfc5135e1a0ea9d70c78a97e892a0e6&buyer_id=&buyer_email=&trade_status=TRADE_SUCCESS&trade_no=2016073021001004060273158765&out_trade_no=16073041ry', '', '2016-07-30 06:17:54'),
(14, 'notifyCall', 'payment_type:1subject:美国旅游签证trade_no:2016073021001004150262786312buyer_email:13701363407gmt_create:2016-07-30 11:52:22notify_type:trade_status_syncquantity:1out_trade_no:65Cok4jXHspn160730jxxknotify_time:2016-07-30 11:52:42seller_id:2088121608978301trade_status:TRADE_SUCCESSis_total_fee_adjust:Ntotal_fee:9.00gmt_payment:2016-07-30 11:52:42seller_email:pay@woigo.cnprice:9.00buyer_id:2088702751336156notify_id:99eeca72015b366c34f9199641ef3eah5quse_coupon:Nsign_type:RSAsign:otux9mi/cj9AxFgg2I7Zwj77A7IkfbYBLVx32AkTLk1kh0usuZJ21//10loozzkm3Ri9cpNqKfGVss6B/uDFyLoW/C8R4PRpToEwvI2jIZSLUW3flXzSSUcsZEz9Jz4ObJTWaGYD8+ItptKYX9QoMXy1l8QUjg4HcKgEdrqhbjQ=', '65Cok4jXHspn160730jxxk', 2, '65Cok4jXHspn', 3, 'hqey8b930pvo', '2016073021001004150262786312', 'TRADE_SUCCESS', '13701363407', '2088702751336156', '9b2a68d15204bb715fec8245d5e76bef', 'http://www.woigo.cn/qqvisa/api/alipay/return_url', 'http://www.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://www.woigo.cn/qqvisa/api/alipay/notify_url?back_sign=9b2a68d15204bb715fec8245d5e76bef&buyer_id=2088702751336156&buyer_email=13701363407&trade_status=TRADE_SUCCESS&trade_no=2016073021001004150262786312&out_trade_no=160730jxxk', 'success', '2016-07-30 11:52:43'),
(15, 'returnCall', 'is_success:Tnotify_id:RqPnCoPT3K9%2Fvwbh3InXQBetonwUsPRtKdp93zpm2OWIW2GjQh6cBEFlNAQtErsbtByQnotify_time:2016-07-30 11:52:43notify_type:trade_status_syncout_trade_no:65Cok4jXHspn160730jxxkpayment_type:1seller_id:2088121608978301service:alipay.wap.create.direct.pay.by.usersubject:美国旅游签证total_fee:9.00trade_no:2016073021001004150262786312trade_status:TRADE_SUCCESSsign:JIJ7mR4aODfUiivwjrQjKDMwjkvn+2DNHBhdCcfIBR9H3JY/PSA7o1/eA3YL5kMJFYyT8ORqcP/95UbXD4orCu5+YJgIiPcBd3NtQiQTIP9T7IL9kf8FdvPxf3BYVw22NTiLJMPx5gprvUhPEcLWRYetr38CxKF41+SxbqM2/bg=sign_type:RSA', '65Cok4jXHspn160730jxxk', 2, '65Cok4jXHspn', 3, 'hqey8b930pvo', '2016073021001004150262786312', 'TRADE_SUCCESS', '', '', '9b2a68d15204bb715fec8245d5e76bef', 'http://www.woigo.cn/qqvisa/api/alipay/return_url', 'http://www.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://www.woigo.cn/qqvisa/api/alipay/return_url?back_sign=9b2a68d15204bb715fec8245d5e76bef&buyer_id=&buyer_email=&trade_status=TRADE_SUCCESS&trade_no=2016073021001004150262786312&out_trade_no=160730jxxk', '', '2016-07-30 11:52:51'),
(16, 'notifyCall', 'payment_type:1subject:土耳其个人旅游签证trade_no:2016072921001004060273088224buyer_email:963480@163.comgmt_create:2016-07-29 11:52:28notify_type:trade_status_syncquantity:1out_trade_no:1606298hix251607297dfunotify_time:2016-07-30 12:16:32seller_id:2088121608978301trade_status:TRADE_SUCCESSis_total_fee_adjust:Ntotal_fee:0.01gmt_payment:2016-07-29 11:52:29seller_email:pay@woigo.cnprice:0.01buyer_id:2088002450730063notify_id:d1c3d5e30e30b647d87dd119002e5f6ggquse_coupon:Nsign_type:RSAsign:J1dQzjZ1ZrDJcpij32NVHfTFZWMsas1fjXzn8kQTCwRcDEIiEQITvBtKipk1FU0O97kXSa9eKMSpzI2lyzzmBuDliK4yVjMWzftMQcoNwwHlgLvlhitLeoJUF3+DLLlaha0lY0jnKbCwSc/A+hE1WQcYVsT3xlY1LNTcQEQNBSw=', '1606298hix251607297dfu', 1, '1606298hix25', 1, '160629f8v1ul', '2016072921001004060273088224', 'TRADE_SUCCESS', '963480@163.com', '2088002450730063', '153e2bd54a95b7a0f6e859602243bfa4', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url?back_sign=153e2bd54a95b7a0f6e859602243bfa4&buyer_id=2088002450730063&buyer_email=963480@163.com&trade_status=TRADE_SUCCESS&trade_no=2016072921001004060273088224&out_trade_no=1607297dfu', 'fail', '2016-07-30 12:16:33'),
(17, 'notifyCall', 'payment_type:1subject:美国旅游签证trade_no:2016073021001004060278121416buyer_email:963480@163.comgmt_create:2016-07-30 13:33:37notify_type:trade_status_syncquantity:1out_trade_no:1606298hix25160730x8eunotify_time:2016-07-30 13:33:39seller_id:2088121608978301trade_status:TRADE_SUCCESSis_total_fee_adjust:Ntotal_fee:0.01gmt_payment:2016-07-30 13:33:39seller_email:pay@woigo.cnprice:0.01buyer_id:2088002450730063notify_id:0d5783b1c39885205c269055c9eecfeggquse_coupon:Nsign_type:RSAsign:jFLBO5vOILE7mKYbSpRo6BYd+p4Sl4JKpx02+HKX/xa4cTuQfVebZH6RDP/c8d0mAWcuHGTfiFFK6NoEfdT/cME1+kf6C1j+gdbUx+WJRLvDxCKkRo87JsPLrQJEcdjiN1zkiq1VQMlgP1aEQKemQAIgCpPkQsp8U4frCnHkaWc=', '1606298hix25160730x8eu', 1, '1606298hix25', 1, '160629f8v1ul', '2016073021001004060278121416', 'TRADE_SUCCESS', '963480@163.com', '2088002450730063', 'f9214a7539d532a8b55122d707ca7d3a', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url?back_sign=f9214a7539d532a8b55122d707ca7d3a&buyer_id=2088002450730063&buyer_email=963480@163.com&trade_status=TRADE_SUCCESS&trade_no=2016073021001004060278121416&out_trade_no=160730x8eu', 'success', '2016-07-30 13:33:39'),
(18, 'returnCall', 'is_success:Tnotify_id:RqPnCoPT3K9%2Fvwbh3InXQBetpJRbr1JdPgLzUMXM0vbYcmhS3JKY9Djs5%2ByC2F89HSRynotify_time:2016-07-30 13:33:39notify_type:trade_status_syncout_trade_no:1606298hix25160730x8eupayment_type:1seller_id:2088121608978301service:alipay.wap.create.direct.pay.by.usersubject:美国旅游签证total_fee:0.01trade_no:2016073021001004060278121416trade_status:TRADE_SUCCESSsign:j71aM9qBMBu/Rv34RE7DDx/MP3clz/BDxsECvLik1S653dsAuOXZMT2b7yLfSuph2z9WuE63zhJf7+eTKyqrsDUNmaCXr2hqUGoJTWXDtpmU1w3ZR3DIqTU84rtIB0IqxoiRs66lns/j9ybTAjBlA5AmE033goSBgCkYQrwOKKQ=sign_type:RSA', '1606298hix25160730x8eu', 1, '1606298hix25', 1, '160629f8v1ul', '2016073021001004060278121416', 'TRADE_SUCCESS', '', '', 'f9214a7539d532a8b55122d707ca7d3a', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/return_url?back_sign=f9214a7539d532a8b55122d707ca7d3a&buyer_id=&buyer_email=&trade_status=TRADE_SUCCESS&trade_no=2016073021001004060278121416&out_trade_no=160730x8eu', '', '2016-07-30 13:33:47'),
(19, 'notifyCall', 'payment_type:1subject:美国旅游签证trade_no:2016072921001004060278020583buyer_email:963480@163.comgmt_create:2016-07-29 13:14:10notify_type:trade_status_syncquantity:1out_trade_no:1606298hix251607299lwanotify_time:2016-07-30 13:38:40seller_id:2088121608978301trade_status:TRADE_SUCCESSis_total_fee_adjust:Ntotal_fee:0.01gmt_payment:2016-07-29 13:14:11seller_email:pay@woigo.cnprice:0.01buyer_id:2088002450730063notify_id:e861828be5979ee4de5ae2cc74ad7f6ggquse_coupon:Nsign_type:RSAsign:cS7h8TJ32bJ7xv3WfJjK2iVBT/VklthMI504+ms7nYNfDnTgUv7cFuLXohKU9ICWpvWAO85UwoFMn9PKDNRHVv32nZVSgMSmqhc2X5KM9BaDr0pba34NhPddTk8ryGTDriiO8lrd680l1utbpebM2xHcojs7G5xN56tkIEQNyQY=', '1606298hix251607299lwa', 1, '1606298hix25', 1, '160629f8v1ul', '2016072921001004060278020583', 'TRADE_SUCCESS', '963480@163.com', '2088002450730063', 'e8e6808d13e4d34609e3c7a8d9e79c7e', 'http://beta.woigo.cn/qqvisa/api/alipay/return_url', 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://beta.woigo.cn/qqvisa/api/alipay/notify_url?back_sign=e8e6808d13e4d34609e3c7a8d9e79c7e&buyer_id=2088002450730063&buyer_email=963480@163.com&trade_status=TRADE_SUCCESS&trade_no=2016072921001004060278020583&out_trade_no=1607299lwa', 'fail', '2016-07-30 13:38:40'),
(20, 'notifyCall', 'payment_type:1subject:美国旅游签证trade_no:2016073021001004060272167211buyer_email:963480@163.comgmt_create:2016-07-30 20:49:29notify_type:trade_status_syncquantity:1out_trade_no:65Cok4jXHspn1607309m1anotify_time:2016-07-30 20:49:30seller_id:2088121608978301trade_status:TRADE_SUCCESSis_total_fee_adjust:Ntotal_fee:9.00gmt_payment:2016-07-30 20:49:30seller_email:pay@woigo.cnprice:9.00buyer_id:2088002450730063notify_id:632e87dea45c81109d55fd9616dfdb0ggquse_coupon:Nsign_type:RSAsign:bTIuZlEflOCaMOdUB32DC5I1oAGiAsVl/j6PToZnhHeQgjIsc8X4R4azql7v2eOELQiNNBBfUGOzkYuLY5WbRUc92dFpjgpAgIUHAEwXvaEa3poB2/RRFC8fvxvKX3+preBmy/7LpbL4kuzr2DLBqPAazXfGYUAkyAbwAY1b5KE=', '65Cok4jXHspn1607309m1a', 2, '65Cok4jXHspn', 3, 'hqey8b930pvo', '2016073021001004060272167211', 'TRADE_SUCCESS', '963480@163.com', '2088002450730063', 'c30179790d0f03fe44adf3b2d0028886', 'http://www.woigo.cn/qqvisa/api/alipay/return_url', 'http://www.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://www.woigo.cn/qqvisa/api/alipay/notify_url?back_sign=c30179790d0f03fe44adf3b2d0028886&buyer_id=2088002450730063&buyer_email=963480@163.com&trade_status=TRADE_SUCCESS&trade_no=2016073021001004060272167211&out_trade_no=1607309m1a', 'success', '2016-07-30 20:49:31'),
(21, 'returnCall', 'is_success:Tnotify_id:RqPnCoPT3K9%2Fvwbh3InXQBegghh6HjPXxybkf0gkjTaFN9PiQJxhK4XFNMaiE12poPyWnotify_time:2016-07-30 20:49:30notify_type:trade_status_syncout_trade_no:65Cok4jXHspn1607309m1apayment_type:1seller_id:2088121608978301service:alipay.wap.create.direct.pay.by.usersubject:美国旅游签证total_fee:9.00trade_no:2016073021001004060272167211trade_status:TRADE_SUCCESSsign:pfUAxwkJYTx/SVDG+68sM2lfBYi9QfjTmbtro9HLgf440jx7oRA/r4fMh1aEpgL0eQtQF6kJ0Bs/lRG5Mu64jeVVVwZwRQLt3SmEjIpJc4t/LhSbexqmqcfsDS/j9ALZ/SfGHoIvG2yp6bOyIjbbeVaIjs9HtPGzaf3e198EEMU=sign_type:RSA', '65Cok4jXHspn1607309m1a', 2, '65Cok4jXHspn', 3, 'hqey8b930pvo', '2016073021001004060272167211', 'TRADE_SUCCESS', '', '', 'c30179790d0f03fe44adf3b2d0028886', 'http://www.woigo.cn/qqvisa/api/alipay/return_url', 'http://www.woigo.cn/qqvisa/api/alipay/notify_url', '', 0, 'http://www.woigo.cn/qqvisa/api/alipay/return_url?back_sign=c30179790d0f03fe44adf3b2d0028886&buyer_id=&buyer_email=&trade_status=TRADE_SUCCESS&trade_no=2016073021001004060272167211&out_trade_no=1607309m1a', '', '2016-07-30 20:49:33'),
(22, 'returnCall', '', '', 0, '', 0, '', '', '', '', '', '', '', '', 'out_trade_no 未发现，非法的返回信息？:', 0, '', '', '2016-07-31 02:01:36'),
(23, 'notifyCall', '', '', 0, '', 0, '', '', '', '', '', '', '', '', 'out_trade_no 未发现，非法的返回信息？:', 0, '', '', '2016-07-31 02:01:36');

-- --------------------------------------------------------

--
-- 表的结构 `bs_app`
--

CREATE TABLE IF NOT EXISTS `bs_app` (
  `id` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `series_number` varchar(45) NOT NULL,
  `is_lock` int(11) DEFAULT '0',
  `created` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `bs_app`
--

INSERT INTO `bs_app` (`id`, `title`, `series_number`, `is_lock`, `created`) VALUES
(1, 'qqvisa', '1606298hix25', 0, '2016-06-29 17:39:14'),
(2, '四季旅行网', '65Cok4jXHspn', 0, '2016-07-29 00:00:00');

-- --------------------------------------------------------

--
-- 表的结构 `bs_app_pay`
--

CREATE TABLE IF NOT EXISTS `bs_app_pay` (
  `id` int(11) NOT NULL,
  `app_id` int(11) NOT NULL,
  `order_series_number` varchar(256) NOT NULL,
  `created` datetime DEFAULT NULL,
  `is_paid` int(11) NOT NULL DEFAULT '0',
  `reg_unit` int(11) NOT NULL DEFAULT '0',
  `paid_port` varchar(256) DEFAULT '',
  `paid_info` text,
  `paid_time` datetime DEFAULT NULL,
  `total_series_number` varchar(256) DEFAULT NULL,
  `wechat_pay_link` varchar(512) DEFAULT NULL,
  `order_name` varchar(64) DEFAULT NULL,
  `total_price` int(11) DEFAULT '1',
  `show_url` varchar(512) DEFAULT NULL,
  `over_time` varchar(45) DEFAULT NULL,
  `wechat_prepare_id` varchar(256) DEFAULT NULL,
  `wechat_prepare_id_create_time` datetime DEFAULT NULL,
  `called_back` int(11) DEFAULT '0',
  `called_back_time` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `bs_app_pay`
--

INSERT INTO `bs_app_pay` (`id`, `app_id`, `order_series_number`, `created`, `is_paid`, `reg_unit`, `paid_port`, `paid_info`, `paid_time`, `total_series_number`, `wechat_pay_link`, `order_name`, `total_price`, `show_url`, `over_time`, `wechat_prepare_id`, `wechat_prepare_id_create_time`, `called_back`, `called_back_time`) VALUES
(1, 1, '16070756qn', '2016-07-07 06:53:16', 0, 1, '', '', NULL, '1606298hix2516070756qn', NULL, '', 1, NULL, NULL, NULL, NULL, 0, NULL),
(2, 1, '16072357gv', '2016-07-26 04:22:06', 0, 1, '', '', NULL, '1606298hix2516072357gv', NULL, '', 1, NULL, NULL, NULL, NULL, 0, NULL),
(3, 1, '160726wx58', '2016-07-26 06:46:00', 1, 1, 'Alipay', '{"buyer_email":"963480@163.com","buyer_id":"2088002450730063","gmt_create":"2016-07-26 10:57:24","gmt_payment":"2016-07-26 10:57:25","is_total_fee_adjust":"N","notify_id":"4049e130a651186283a07c39cfc01f6ggq","notify_time":"2016-07-27 11:21:34","notify_type":"trade_status_sync","out_trade_no":"1606298hix25160726wx58","payment_type":"1","price":"0.01","quantity":"1","seller_email":"pay@woigo.cn","seller_id":"2088121608978301","sign":"FsKvH7m/NjpEepkBmu6HpccGFQiNIGmd6qC+h9vPQ0r631Ir4CTRr8pjFYwonLPYmRd1kV721yr6sKfhrgN7U8MCl0m3xlhZaesAKPez1IlFZQO1tuG/mS3vxcASaazHyEVAjVDWfO1hTOvuKqENu34sKgFnXopnvGeGjtNyys4=","sign_type":"RSA","subject":"美国旅游签证","total_fee":"0.01","trade_no":"2016072621001004060231264498","trade_status":"TRADE_SUCCESS","use_coupon":"N"}', '2016-07-27 11:21:35', '1606298hix25160726wx58', NULL, '', 1, NULL, NULL, NULL, NULL, 0, NULL),
(4, 1, '1607212fqh', '2016-07-26 10:52:24', 0, 1, '', '', NULL, '1606298hix251607212fqh', NULL, '', 1, NULL, NULL, NULL, NULL, 0, NULL),
(5, 1, '160727dyht', '2016-07-27 16:01:44', 0, 2, '', '', NULL, '1606298hix25160727dyht', NULL, '', 1, NULL, NULL, NULL, NULL, 0, NULL),
(6, 1, '16072758fp', '2016-07-27 21:17:43', 0, 2, '', '', NULL, '1606298hix2516072758fp', NULL, '', 1, NULL, NULL, NULL, NULL, 0, NULL),
(7, 1, '160728tel5', '2016-07-28 05:20:37', 1, 2, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[1606298hix25160728tel5]]></attach>\\n<bank_type><![CDATA[CFT]]></bank_type>\\n<cash_fee><![CDATA[1]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[N]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[tf6l6bwyzmhv]]></nonce_str>\\n<openid><![CDATA[oEiShtwrkzt51F-xcEL2FsVluWgk]]></openid>\\n<out_trade_no><![CDATA[1606298hix25160728tel5qrdqgzfv0]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[83323A96F6E4E808F11C162F77F196A7]]></sign>\\n<time_end><![CDATA[20160729071146]]></time_end>\\n<total_fee>1</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4008372001201607290014662083]]></transaction_id>\\n</xml>"', '2016-07-29 07:11:47', '1606298hix25160728tel5', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469747398&nonce_str=dc4g0tt0f9vb&product_id=1606298hix25160728tel5&sign=FA19CC78B511AC0917CD5AB3671E7714', '美国旅游签证', 120400, '', '30m', 'wx20160729071018a8852995d00503149481', '2016-07-29 07:10:18', 0, NULL),
(8, 1, '160728x6xm', '2016-07-29 06:18:47', 1, 2, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[1606298hix25160728x6xm]]></attach>\\n<bank_type><![CDATA[CFT]]></bank_type>\\n<cash_fee><![CDATA[1]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[N]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[n7ek2plrzrwx]]></nonce_str>\\n<openid><![CDATA[oEiShtwrkzt51F-xcEL2FsVluWgk]]></openid>\\n<out_trade_no><![CDATA[1606298hix25160728x6xmzprhhvjkd]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[5B818736229E785E997293A99652F3A9]]></sign>\\n<time_end><![CDATA[20160729063734]]></time_end>\\n<total_fee>1</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4008372001201607290012234621]]></transaction_id>\\n</xml>"', '2016-07-29 06:41:37', '1606298hix25160728x6xm', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469745339&nonce_str=4z50w834a0s0&product_id=1606298hix25160728x6xm&sign=0FA2864CF15AFDA14897F25B9A387B69', '美国旅游签证', 120400, '', '30m', 'wx20160729062513b315a99cc00670632128', '2016-07-29 06:25:14', 0, NULL),
(9, 1, '1607296ftr', '2016-07-29 11:34:44', 0, 1, '', '', NULL, '1606298hix251607296ftr', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469763292&nonce_str=4ji13fe9z7eu&product_id=1606298hix251607296ftr&sign=C88F4D0D911F83592F524B1C9E3F7702', '德国旅游签证', 88000, '', '30m', 'wx201607291135088dbc60e9a80021630808', '2016-07-29 11:35:09', 0, NULL),
(10, 1, '160729viw1', '2016-07-29 11:36:11', 0, 2, '', '', NULL, '1606298hix25160729viw1', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469763371&nonce_str=5okrmzvp0yt3&product_id=1606298hix25160729viw1&sign=BD77472A53F46CEC43AC22745FCD3232', '美国旅游签证', 120400, '', '30m', 'wx2016072911361561ba37c62c0124997594', '2016-07-29 11:36:15', 0, NULL),
(11, 1, '160729e59w', '2016-07-29 11:36:55', 1, 2, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[1606298hix25160729e59w]]></attach>\\n<bank_type><![CDATA[CFT]]></bank_type>\\n<cash_fee><![CDATA[1]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[Y]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[175lr20t82cf]]></nonce_str>\\n<openid><![CDATA[oEiSht1hvQqWbujfgl38PxK8w_Yw]]></openid>\\n<out_trade_no><![CDATA[1606298hix25160729e59wor5lavz5t]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[1C6C8BC4FD87D0DCEB8E62A02293C21C]]></sign>\\n<time_end><![CDATA[20160729113710]]></time_end>\\n<total_fee>1</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4008202001201607290028979221]]></transaction_id>\\n</xml>"', '2016-07-29 11:37:10', '1606298hix25160729e59w', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469763415&nonce_str=9lnyyaczby1d&product_id=1606298hix25160729e59w&sign=34C32157B9D2C6EF3F76E6BECF632D4A', '美国旅游签证', 120400, '', '30m', 'wx201607291136598a500fddd70151413620', '2016-07-29 11:36:59', 0, NULL),
(12, 1, '160729ymnd', '2016-07-29 11:39:54', 1, 2, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[1606298hix25160729ymnd]]></attach>\\n<bank_type><![CDATA[CFT]]></bank_type>\\n<cash_fee><![CDATA[1]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[Y]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[rque2pgbb7sl]]></nonce_str>\\n<openid><![CDATA[oEiSht1hvQqWbujfgl38PxK8w_Yw]]></openid>\\n<out_trade_no><![CDATA[1606298hix25160729ymndivrom6gy8]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[908E5C647A7DE5590BAC8BB959A6B6DA]]></sign>\\n<time_end><![CDATA[20160729114019]]></time_end>\\n<total_fee>1</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4008202001201607290029085727]]></transaction_id>\\n</xml>"', '2016-07-29 11:40:20', '1606298hix25160729ymnd', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469763594&nonce_str=n0bj15cgafjw&product_id=1606298hix25160729ymnd&sign=1707DE97A155992BE439DEC940CD71D8', '加拿大个人旅游签证', 90700, '', '30m', 'wx20160729114004b6c3e041de0384311809', '2016-07-29 11:40:04', 0, NULL),
(13, 1, '1607297dfu', '2016-07-29 11:51:51', 1, 1, 'Alipay', '{"buyer_email":"963480@163.com","buyer_id":"2088002450730063","gmt_create":"2016-07-29 11:52:28","gmt_payment":"2016-07-29 11:52:29","is_total_fee_adjust":"N","notify_id":"d1c3d5e30e30b647d87dd119002e5f6ggq","notify_time":"2016-07-29 11:52:29","notify_type":"trade_status_sync","out_trade_no":"1606298hix251607297dfu","payment_type":"1","price":"0.01","quantity":"1","seller_email":"pay@woigo.cn","seller_id":"2088121608978301","sign":"atWMe1mBLbRs2/XN+blrYdsSB6kGjBbKSWRtPYOxanVNoI7KkfTXgXVsVLAJ01W26XUx1aiWCvjg1MhcHmSijhBDY4QLLa8Xuu+rtnHJMxLttO3dI3JPJ3c6//ErEdmpI0x3vmJ1GhqdzWHLNcidisZZGtzerepuEBooV1x0+wc=","sign_type":"RSA","subject":"土耳其个人旅游签证","total_fee":"0.01","trade_no":"2016072921001004060273088224","trade_status":"TRADE_SUCCESS","use_coupon":"N"}', '2016-07-29 11:52:29', '1606298hix251607297dfu', NULL, NULL, 1, NULL, NULL, NULL, NULL, 0, NULL),
(14, 1, '1607299lwa', '2016-07-29 13:13:57', 1, 1, 'Alipay', '{"buyer_email":"963480@163.com","buyer_id":"2088002450730063","gmt_create":"2016-07-29 13:14:10","gmt_payment":"2016-07-29 13:14:11","is_total_fee_adjust":"N","notify_id":"e861828be5979ee4de5ae2cc74ad7f6ggq","notify_time":"2016-07-29 13:14:11","notify_type":"trade_status_sync","out_trade_no":"1606298hix251607299lwa","payment_type":"1","price":"0.01","quantity":"1","seller_email":"pay@woigo.cn","seller_id":"2088121608978301","sign":"W4TY9WS2rSX2c84tl4NDIftnbVu9UkQo/NaW1l/e3fm1pEfigBzGfMvnORU33VFemSVtURSudD9XL4Yy/b8V7jsRwX5I1lf/sfDoIQMJJz0Dt7NADTRUqI5QKggl7XlnvtX9dZ6gtAom39Zu5bEhoyupIsclnbFAFJN6uAyKPxE=","sign_type":"RSA","subject":"美国旅游签证","total_fee":"0.01","trade_no":"2016072921001004060278020583","trade_status":"TRADE_SUCCESS","use_coupon":"N"}', '2016-07-29 13:14:11', '1606298hix251607299lwa', NULL, NULL, 1, NULL, NULL, NULL, NULL, 0, NULL),
(15, 1, '1607298ft1', '2016-07-29 14:35:24', 1, 1, 'Alipay', '{"buyer_email":"963480@163.com","buyer_id":"2088002450730063","gmt_create":"2016-07-29 14:35:34","gmt_payment":"2016-07-29 14:35:35","is_total_fee_adjust":"N","notify_id":"f13acf059bc0877add3408874fde039ggq","notify_time":"2016-07-29 14:35:35","notify_type":"trade_status_sync","out_trade_no":"1606298hix251607298ft1","payment_type":"1","price":"0.01","quantity":"1","seller_email":"pay@woigo.cn","seller_id":"2088121608978301","sign":"guoR+940WYsHhHtfehfBNHNDy3zSKSLTbEZNVG0P7U0PFMNHanXmBsp61YWqPvzFdgmFZAWEE1r/6W0CfLuawp+KVRIa6h4qKpqWh1jIlVQjUi0fw/x+TCKXuSA8sKHPOnTp/qa0xH0gpA3jeArAsJIaGpxr/WO8kCrrGiY2hhs=","sign_type":"RSA","subject":"法国个人旅游","total_fee":"0.01","trade_no":"2016072921001004060271901892","trade_status":"TRADE_SUCCESS","use_coupon":"N"}', '2016-07-29 14:35:35', '1606298hix251607298ft1', NULL, NULL, 1, NULL, NULL, NULL, NULL, 0, NULL),
(16, 1, '160729yeo7', '2016-07-29 14:40:04', 1, 2, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[1606298hix25160729yeo7]]></attach>\\n<bank_type><![CDATA[CFT]]></bank_type>\\n<cash_fee><![CDATA[1]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[Y]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[9cobl47ovf43]]></nonce_str>\\n<openid><![CDATA[oEiSht1hvQqWbujfgl38PxK8w_Yw]]></openid>\\n<out_trade_no><![CDATA[1606298hix25160729yeo7l3eymn6du]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[36A2866B83A8EB8E6468BC98BFACA6D5]]></sign>\\n<time_end><![CDATA[20160729144028]]></time_end>\\n<total_fee>1</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4008202001201607290042007146]]></transaction_id>\\n</xml>"', '2016-07-29 14:40:28', '1606298hix25160729yeo7', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469774404&nonce_str=r4rlm3kd1vx4&product_id=1606298hix25160729yeo7&sign=C5466902C85ECACFBDDFE7ED560CBA0E', '加拿大个人旅游签证', 105700, '', '30m', 'wx20160729144017e7413dea6e0404824330', '2016-07-29 14:40:17', 0, NULL),
(17, 1, '1607291xyo', '2016-07-29 15:13:59', 1, 1, 'Alipay', '{"buyer_email":"963480@163.com","buyer_id":"2088002450730063","gmt_create":"2016-07-29 15:14:07","gmt_payment":"2016-07-29 15:14:08","is_total_fee_adjust":"N","notify_id":"604dbb30e9617d80e1a86c3e76b01c6ggq","notify_time":"2016-07-29 15:14:08","notify_type":"trade_status_sync","out_trade_no":"1606298hix251607291xyo","payment_type":"1","price":"0.01","quantity":"1","seller_email":"pay@woigo.cn","seller_id":"2088121608978301","sign":"HnBDZcNDE53/58gO3Ux5Opi+JTyJhoBfTXp1g0XqzXE4skg+bLJR3K1erzroiACF0JpEMjrLzLzXdQLJ/a6Cvyros1rCeETfTzqRGiwFSLGT1BnEt+4w2bnp0lF8+3upD2MU3sdalCG6MGfALiqiB2zk37XIjRH+mOXzNMNYXic=","sign_type":"RSA","subject":"加拿大个人旅游签证","total_fee":"0.01","trade_no":"2016072921001004060270153366","trade_status":"TRADE_SUCCESS","use_coupon":"N"}', '2016-07-29 15:14:08', '1606298hix251607291xyo', NULL, NULL, 1, NULL, NULL, NULL, NULL, 0, NULL),
(18, 1, '160729p2fc', '2016-07-29 15:16:49', 1, 2, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[1606298hix25160729p2fc]]></attach>\\n<bank_type><![CDATA[CFT]]></bank_type>\\n<cash_fee><![CDATA[1]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[Y]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[vx5hbwkv7r7h]]></nonce_str>\\n<openid><![CDATA[oEiSht1hvQqWbujfgl38PxK8w_Yw]]></openid>\\n<out_trade_no><![CDATA[1606298hix25160729p2fccxij14blo]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[D4CF1AEEAD0EC62701D43E19E405C941]]></sign>\\n<time_end><![CDATA[20160729151708]]></time_end>\\n<total_fee>1</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4008202001201607290046932768]]></transaction_id>\\n</xml>"', '2016-07-29 15:17:09', '1606298hix25160729p2fc', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469776609&nonce_str=gezgvy0mxpdb&product_id=1606298hix25160729p2fc&sign=B286ED5ECDCD2D4F9680781937577FAD', '韩国个人旅游签证', 95000, '', '30m', 'wx20160729151702c1c285be990740618309', '2016-07-29 15:17:02', 0, NULL),
(19, 1, '160729cqyd', '2016-07-29 16:07:15', 1, 2, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[1606298hix25160729cqyd]]></attach>\\n<bank_type><![CDATA[CFT]]></bank_type>\\n<cash_fee><![CDATA[1]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[Y]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[2as5sx1ce7cj]]></nonce_str>\\n<openid><![CDATA[oEiSht1hvQqWbujfgl38PxK8w_Yw]]></openid>\\n<out_trade_no><![CDATA[1606298hix25160729cqyd1gwyzbpdv]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[F36417DE4175A49EB3E93D515A3E1FD8]]></sign>\\n<time_end><![CDATA[20160729160734]]></time_end>\\n<total_fee>1</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4008202001201607290050589298]]></transaction_id>\\n</xml>"', '2016-07-29 16:07:35', '1606298hix25160729cqyd', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469779635&nonce_str=uqoskezjnm12&product_id=1606298hix25160729cqyd&sign=ED892F9719E8FADEACB67D08CA3028FC', '韩国个人旅游签证', 55000, '', '30m', 'wx20160729160726c2fb8db2d40449607352', '2016-07-29 16:07:26', 0, NULL),
(20, 1, '160729iol3', '2016-07-29 16:14:58', 1, 1, 'Alipay', '{"buyer_email":"963480@163.com","buyer_id":"2088002450730063","gmt_create":"2016-07-29 16:15:07","gmt_payment":"2016-07-29 16:15:09","is_total_fee_adjust":"N","notify_id":"f95b093fcf5b9c4b31382ec3e34ce32ggq","notify_time":"2016-07-29 16:15:09","notify_type":"trade_status_sync","out_trade_no":"1606298hix25160729iol3","payment_type":"1","price":"0.01","quantity":"1","seller_email":"pay@woigo.cn","seller_id":"2088121608978301","sign":"L9tn7Zg6hzS1XXJKjt7p7IG2IGLwhcA/9xbLUWk8EOMYcZsTk+YZwN0cPg516vLrhRvIPz3CWVyx97cgPWYkWw64TCF5+ZlRgKg+rYi2TVtO+5MX3bemKv63+RpHXmeVV2MmUtByKxfvkOW/exUFJh9ekCFouUBpdQDWCWS9WQk=","sign_type":"RSA","subject":"美国旅游签证","total_fee":"0.01","trade_no":"2016072921001004060279683425","trade_status":"TRADE_SUCCESS","use_coupon":"N"}', '2016-07-29 16:15:09', '1606298hix25160729iol3', NULL, NULL, 1, NULL, NULL, NULL, NULL, 0, NULL),
(21, 1, '160730u8jt', '2016-07-30 01:44:07', 1, 1, 'Alipay', '{"buyer_email":"963480@163.com","buyer_id":"2088002450730063","gmt_create":"2016-07-30 01:44:15","gmt_payment":"2016-07-30 01:44:16","is_total_fee_adjust":"N","notify_id":"46341fbd44fcc99b05bad2590066706ggq","notify_time":"2016-07-30 01:44:17","notify_type":"trade_status_sync","out_trade_no":"1606298hix25160730u8jt","payment_type":"1","price":"0.01","quantity":"1","seller_email":"pay@woigo.cn","seller_id":"2088121608978301","sign":"J/AuHtkH3yhca1B3KtZa4c3rETZBUr0R2JVj2bTavpIPj+Ghqu/WEv11Hj9oI3rycQ67/cfLW+JE1jfeMkHsL+At9w3x6urJpdEIVKOn0bpHIqIG33qjJ/dReUzrEWjXQ3N0EINjK1b3rMUmcWAScwdJf7vPVx3LduyJ9YivUb4=","sign_type":"RSA","subject":"美国旅游签证","total_fee":"0.01","trade_no":"2016073021001004060279112402","trade_status":"TRADE_SUCCESS","use_coupon":"N"}', '2016-07-30 01:44:17', '1606298hix25160730u8jt', NULL, NULL, 1, NULL, NULL, NULL, NULL, 0, NULL),
(22, 1, '160730augk', '2016-07-30 01:45:54', 1, 2, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[1606298hix25160730augk]]></attach>\\n<bank_type><![CDATA[CFT]]></bank_type>\\n<cash_fee><![CDATA[1]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[Y]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[udqyn2vln81x]]></nonce_str>\\n<openid><![CDATA[oEiSht1hvQqWbujfgl38PxK8w_Yw]]></openid>\\n<out_trade_no><![CDATA[1606298hix25160730augkz31j1vz7v]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[FB2400654DD2466898B6516CCA7DCC17]]></sign>\\n<time_end><![CDATA[20160730014617]]></time_end>\\n<total_fee>1</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4008202001201607300086790857]]></transaction_id>\\n</xml>"', '2016-07-30 01:46:18', '1606298hix25160730augk', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469814354&nonce_str=kieo8v8yc3p1&product_id=1606298hix25160730augk&sign=4FA4B262A2A821D335BF2691D851A4F4', '美国旅游签证', 135400, '', '30m', 'wx20160730014612f32e4acc7a0846272929', '2016-07-30 01:46:12', 0, NULL),
(23, 1, '16073041ry', '2016-07-30 06:17:26', 1, 1, 'Alipay', '{"buyer_email":"963480@163.com","buyer_id":"2088002450730063","gmt_create":"2016-07-30 06:17:44","gmt_payment":"2016-07-30 06:17:45","is_total_fee_adjust":"N","notify_id":"0c29d8214cb930543257bdeceaf5761ggq","notify_time":"2016-07-30 06:17:45","notify_type":"trade_status_sync","out_trade_no":"1606298hix2516073041ry","payment_type":"1","price":"0.01","quantity":"1","seller_email":"pay@woigo.cn","seller_id":"2088121608978301","sign":"jENqei6zJ7FKXnyzDcXqWaHmKwKb9wQqOApmB3D9ina7wPchaqiZ1sBMbZetgK/nMdctqfYtbbOPfUjTkgXUgciBqnTHhMfuD9gxCi7EwBfrngJmvB4kIAC2nHQB1T0L9J6YlDx/Ga8M93N++McSwmTIW0XglPrn8w06xl3ZNFk=","sign_type":"RSA","subject":"美国旅游签证","total_fee":"0.01","trade_no":"2016073021001004060273158765","trade_status":"TRADE_SUCCESS","use_coupon":"N"}', '2016-07-30 06:17:45', '1606298hix2516073041ry', NULL, NULL, 1, NULL, NULL, NULL, NULL, 0, NULL),
(24, 2, '160730c2zq', '2016-07-30 08:51:49', 0, 3, '', '', NULL, '65Cok4jXHspn160730c2zq', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469840069&nonce_str=jmyx6wc1bh9j&product_id=65Cok4jXHspn160730c2zq&sign=F6FCF36531352CF983850BB86A645303', '美国旅游签证', 117100, '', '30m', 'wx201607300854550ca7eefdd70858239235', '2016-07-30 08:54:55', 0, NULL),
(25, 2, '160730tmdr', '2016-07-30 11:45:48', 1, 4, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[65Cok4jXHspn160730tmdr]]></attach>\\n<bank_type><![CDATA[CFT]]></bank_type>\\n<cash_fee><![CDATA[900]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[Y]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[zohs3mhwpseu]]></nonce_str>\\n<openid><![CDATA[oEiSht3PHWy-s86HTHmBXEBFEJbg]]></openid>\\n<out_trade_no><![CDATA[65Cok4jXHspn160730tmdryveh2t1ei]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[06B7AA7924A563D211581A8C819CFD73]]></sign>\\n<time_end><![CDATA[20160730114954]]></time_end>\\n<total_fee>900</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4007602001201607300107062134]]></transaction_id>\\n</xml>"', '2016-07-30 11:49:55', '65Cok4jXHspn160730tmdr', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469850348&nonce_str=353ny33imoio&product_id=65Cok4jXHspn160730tmdr&sign=F48D747A7DE0FE693E6F0568E79C0E13', '美国旅游签证', 900, '', '30m', 'wx20160730114946b02302a5ac0755849995', '2016-07-30 11:49:46', 0, NULL),
(26, 2, '160730ndmv', '2016-07-30 11:46:23', 1, 4, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[65Cok4jXHspn160730ndmv]]></attach>\\n<bank_type><![CDATA[CITIC_DEBIT]]></bank_type>\\n<cash_fee><![CDATA[900]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[Y]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[ef41ste9ywkm]]></nonce_str>\\n<openid><![CDATA[oEiShtwwvR_9jAsHhxIDOz2vNfH8]]></openid>\\n<out_trade_no><![CDATA[65Cok4jXHspn160730ndmvey3dm8u3z]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[685D85CC44023E760C52DB95F1FACE1A]]></sign>\\n<time_end><![CDATA[20160730114708]]></time_end>\\n<total_fee>900</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4001692001201607300105059067]]></transaction_id>\\n</xml>"', '2016-07-30 11:47:08', '65Cok4jXHspn160730ndmv', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469850384&nonce_str=93uwmlstjrmr&product_id=65Cok4jXHspn160730ndmv&sign=B991F55B2922D324B3D6ABE062371F33', '美国旅游签证', 900, '', '30m', 'wx201607301146578f80c448440801136892', '2016-07-30 11:46:57', 0, NULL),
(27, 2, '160730jxxk', '2016-07-30 11:52:02', 1, 3, 'Alipay', '{"buyer_email":"13701363407","buyer_id":"2088702751336156","gmt_create":"2016-07-30 11:52:22","gmt_payment":"2016-07-30 11:52:42","is_total_fee_adjust":"N","notify_id":"99eeca72015b366c34f9199641ef3eah5q","notify_time":"2016-07-30 11:52:42","notify_type":"trade_status_sync","out_trade_no":"65Cok4jXHspn160730jxxk","payment_type":"1","price":"9.00","quantity":"1","seller_email":"pay@woigo.cn","seller_id":"2088121608978301","sign":"otux9mi/cj9AxFgg2I7Zwj77A7IkfbYBLVx32AkTLk1kh0usuZJ21//10loozzkm3Ri9cpNqKfGVss6B/uDFyLoW/C8R4PRpToEwvI2jIZSLUW3flXzSSUcsZEz9Jz4ObJTWaGYD8+ItptKYX9QoMXy1l8QUjg4HcKgEdrqhbjQ=","sign_type":"RSA","subject":"美国旅游签证","total_fee":"9.00","trade_no":"2016073021001004150262786312","trade_status":"TRADE_SUCCESS","use_coupon":"N"}', '2016-07-30 11:52:42', '65Cok4jXHspn160730jxxk', NULL, NULL, 1, NULL, NULL, NULL, NULL, 0, NULL),
(28, 1, '160730x8eu', '2016-07-30 13:33:04', 1, 1, 'Alipay', '{"buyer_email":"963480@163.com","buyer_id":"2088002450730063","gmt_create":"2016-07-30 13:33:37","gmt_payment":"2016-07-30 13:33:39","is_total_fee_adjust":"N","notify_id":"0d5783b1c39885205c269055c9eecfeggq","notify_time":"2016-07-30 13:33:39","notify_type":"trade_status_sync","out_trade_no":"1606298hix25160730x8eu","payment_type":"1","price":"0.01","quantity":"1","seller_email":"pay@woigo.cn","seller_id":"2088121608978301","sign":"jFLBO5vOILE7mKYbSpRo6BYd+p4Sl4JKpx02+HKX/xa4cTuQfVebZH6RDP/c8d0mAWcuHGTfiFFK6NoEfdT/cME1+kf6C1j+gdbUx+WJRLvDxCKkRo87JsPLrQJEcdjiN1zkiq1VQMlgP1aEQKemQAIgCpPkQsp8U4frCnHkaWc=","sign_type":"RSA","subject":"美国旅游签证","total_fee":"0.01","trade_no":"2016073021001004060278121416","trade_status":"TRADE_SUCCESS","use_coupon":"N"}', '2016-07-30 13:33:39', '1606298hix25160730x8eu', NULL, NULL, 1, NULL, NULL, NULL, NULL, 0, NULL),
(29, 1, '160730lbph', '2016-07-30 13:37:46', 1, 2, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[1606298hix25160730lbph]]></attach>\\n<bank_type><![CDATA[CFT]]></bank_type>\\n<cash_fee><![CDATA[1]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[Y]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[c8vlzc3f5gwg]]></nonce_str>\\n<openid><![CDATA[oEiSht1hvQqWbujfgl38PxK8w_Yw]]></openid>\\n<out_trade_no><![CDATA[1606298hix25160730lbph4z5cjuirs]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[4422B77430EB069249954E3FC521F999]]></sign>\\n<time_end><![CDATA[20160730133834]]></time_end>\\n<total_fee>1</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4008202001201607300113264380]]></transaction_id>\\n</xml>"', '2016-07-30 13:38:34', '1606298hix25160730lbph', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469857066&nonce_str=a7yn4fr6kgun&product_id=1606298hix25160730lbph&sign=6673EFD3CDBA346EDF68F4E529D9C24E', '美国旅游签证', 160400, '', '30m', 'wx2016073013382702496b02af0997024935', '2016-07-30 13:38:27', 0, NULL),
(30, 2, '160730q77h', '2016-07-30 14:47:14', 0, 4, '', '', NULL, '65Cok4jXHspn160730q77h', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469861234&nonce_str=1db2e66g7g9q&product_id=65Cok4jXHspn160730q77h&sign=99D7B15EE8980EC9D04EB120DB385C5B', '美国旅游签证', 1900, '', '30m', NULL, NULL, 0, NULL),
(31, 2, '160730e93h', '2016-07-30 15:20:32', 1, 4, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[65Cok4jXHspn160730e93h]]></attach>\\n<bank_type><![CDATA[CITIC_DEBIT]]></bank_type>\\n<cash_fee><![CDATA[1900]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[Y]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[zp0r9sr1qel2]]></nonce_str>\\n<openid><![CDATA[oEiShtwwvR_9jAsHhxIDOz2vNfH8]]></openid>\\n<out_trade_no><![CDATA[65Cok4jXHspn160730e93hg50wv9kbc]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[E37FD4C87CD676E00EDEFDD6D28A8CEF]]></sign>\\n<time_end><![CDATA[20160802125217]]></time_end>\\n<total_fee>1900</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4001692001201608020364747734]]></transaction_id>\\n</xml>"', '2016-08-02 12:52:17', '65Cok4jXHspn160730e93h', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469863232&nonce_str=aopvkd1umztl&product_id=65Cok4jXHspn160730e93h&sign=9D240EA4619B4A8D24D785F6A6D50342', '美国旅游签证', 1900, '', '30m', 'wx201608021252099e6be27d770078770344', '2016-08-02 12:52:09', 0, NULL),
(32, 2, '160730bf9y', '2016-07-30 16:35:07', 0, 4, '', '', NULL, '65Cok4jXHspn160730bf9y', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469867707&nonce_str=g2pqrcabhkpu&product_id=65Cok4jXHspn160730bf9y&sign=605506299B0B902DABC726A49EAF78D8', '美国旅游签证', 1900, '', '30m', NULL, NULL, 0, NULL),
(33, 1, '160730mr1m', '2016-07-30 16:42:38', 0, 1, '', '', NULL, '1606298hix25160730mr1m', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469868170&nonce_str=zomqh1njmnm7&product_id=1606298hix25160730mr1m&sign=6ECD50F3DFC9AE54A05D33BBEBCFEABA', '法国个人旅游', 128900, '', '30m', NULL, NULL, 0, NULL),
(34, 2, '1607305x8u', '2016-07-30 20:44:11', 0, 3, '', '', NULL, '65Cok4jXHspn1607305x8u', NULL, NULL, 1, NULL, NULL, NULL, NULL, 0, NULL),
(35, 2, '1607309m1a', '2016-07-30 20:49:17', 1, 3, 'Alipay', '{"buyer_email":"963480@163.com","buyer_id":"2088002450730063","gmt_create":"2016-07-30 20:49:29","gmt_payment":"2016-07-30 20:49:30","is_total_fee_adjust":"N","notify_id":"632e87dea45c81109d55fd9616dfdb0ggq","notify_time":"2016-07-30 20:49:30","notify_type":"trade_status_sync","out_trade_no":"65Cok4jXHspn1607309m1a","payment_type":"1","price":"9.00","quantity":"1","seller_email":"pay@woigo.cn","seller_id":"2088121608978301","sign":"bTIuZlEflOCaMOdUB32DC5I1oAGiAsVl/j6PToZnhHeQgjIsc8X4R4azql7v2eOELQiNNBBfUGOzkYuLY5WbRUc92dFpjgpAgIUHAEwXvaEa3poB2/RRFC8fvxvKX3+preBmy/7LpbL4kuzr2DLBqPAazXfGYUAkyAbwAY1b5KE=","sign_type":"RSA","subject":"美国旅游签证","total_fee":"9.00","trade_no":"2016073021001004060272167211","trade_status":"TRADE_SUCCESS","use_coupon":"N"}', '2016-07-30 20:49:30', '65Cok4jXHspn1607309m1a', NULL, NULL, 1, NULL, NULL, NULL, NULL, 0, NULL),
(36, 2, '1607304i23', '2016-07-30 20:57:10', 1, 4, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[65Cok4jXHspn1607304i23]]></attach>\\n<bank_type><![CDATA[CFT]]></bank_type>\\n<cash_fee><![CDATA[100]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[Y]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[d38j1qqumigj]]></nonce_str>\\n<openid><![CDATA[oEiSht1hvQqWbujfgl38PxK8w_Yw]]></openid>\\n<out_trade_no><![CDATA[65Cok4jXHspn1607304i23c5dhbgtm8]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[E20D43E27860562C3CED508E423C1D26]]></sign>\\n<time_end><![CDATA[20160730210007]]></time_end>\\n<total_fee>100</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4008202001201607300145182134]]></transaction_id>\\n</xml>"', '2016-07-30 21:00:07', '65Cok4jXHspn1607304i23', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469883430&nonce_str=fr77ov9k6pcz&product_id=65Cok4jXHspn1607304i23&sign=4BEACC6B9FBEFC837592524C76A5DD70', '美国旅游签证', 100, '', '30m', 'wx20160730210001315ed1c7af0485323911', '2016-07-30 21:00:02', 0, NULL),
(37, 2, '1607305otq', '2016-07-30 22:13:48', 1, 4, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[65Cok4jXHspn1607305otq]]></attach>\\n<bank_type><![CDATA[CITIC_DEBIT]]></bank_type>\\n<cash_fee><![CDATA[100]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[Y]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[7ge7uzrf8t0s]]></nonce_str>\\n<openid><![CDATA[oEiShtwwvR_9jAsHhxIDOz2vNfH8]]></openid>\\n<out_trade_no><![CDATA[65Cok4jXHspn1607305otq88j0ja5kz]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[137871E6DC783406B42B69465650B38A]]></sign>\\n<time_end><![CDATA[20160730221407]]></time_end>\\n<total_fee>100</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4001692001201607300149830832]]></transaction_id>\\n</xml>"', '2016-07-30 22:14:08', '65Cok4jXHspn1607305otq', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469888028&nonce_str=s3jvcjqzsav4&product_id=65Cok4jXHspn1607305otq&sign=048D6EADB8C6CC36290F39BD8B22C115', '美国旅游签证', 100, '', '30m', 'wx201607302214008a95158e740335962472', '2016-07-30 22:14:00', 0, NULL),
(38, 2, '1607305uo8', '2016-07-30 22:48:14', 1, 4, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[65Cok4jXHspn1607305uo8]]></attach>\\n<bank_type><![CDATA[CFT]]></bank_type>\\n<cash_fee><![CDATA[100]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[Y]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[46x8fqnf7p2d]]></nonce_str>\\n<openid><![CDATA[oEiSht1hvQqWbujfgl38PxK8w_Yw]]></openid>\\n<out_trade_no><![CDATA[65Cok4jXHspn1607305uo8kzwx9xjq1]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[47B9A3ED667418474C7045EB0687A1FB]]></sign>\\n<time_end><![CDATA[20160730224837]]></time_end>\\n<total_fee>100</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4008202001201607300154746498]]></transaction_id>\\n</xml>"', '2016-07-30 22:48:37', '65Cok4jXHspn1607305uo8', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469890094&nonce_str=fdzeond30e9l&product_id=65Cok4jXHspn1607305uo8&sign=20E7B38635016152232675C72CF44CF9', '美国旅游签证', 100, '', '30m', 'wx20160730224830019ad2ac5f0285186372', '2016-07-30 22:48:30', 0, NULL),
(39, 2, '160730tox4', '2016-07-30 22:57:07', 1, 4, 'Wechatpay', '"<xml><appid><![CDATA[wx2b713952a886ea6b]]></appid>\\n<attach><![CDATA[65Cok4jXHspn160730tox4]]></attach>\\n<bank_type><![CDATA[CITIC_DEBIT]]></bank_type>\\n<cash_fee><![CDATA[100]]></cash_fee>\\n<device_info><![CDATA[WEB]]></device_info>\\n<fee_type><![CDATA[CNY]]></fee_type>\\n<is_subscribe><![CDATA[Y]]></is_subscribe>\\n<mch_id><![CDATA[1347657201]]></mch_id>\\n<nonce_str><![CDATA[rsumud0012a0]]></nonce_str>\\n<openid><![CDATA[oEiShtwwvR_9jAsHhxIDOz2vNfH8]]></openid>\\n<out_trade_no><![CDATA[65Cok4jXHspn160730tox4w9x1n6ask]]></out_trade_no>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<sign><![CDATA[11CB0A1116230E91A3D7725ABCB88AED]]></sign>\\n<time_end><![CDATA[20160730231809]]></time_end>\\n<total_fee>100</total_fee>\\n<trade_type><![CDATA[NATIVE]]></trade_type>\\n<transaction_id><![CDATA[4001692001201607300155575410]]></transaction_id>\\n</xml>"', '2016-07-30 23:18:09', '65Cok4jXHspn160730tox4', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469890627&nonce_str=domehitl2cvk&product_id=65Cok4jXHspn160730tox4&sign=FD3D007B53C06B8833F1D69DF8BE3AED', '美国旅游签证', 100, '', '30m', 'wx201607302318003e9b00d2cf0898860633', '2016-07-30 23:18:00', 0, NULL),
(40, 2, '160731qrbx', '2016-07-31 07:09:44', 0, 4, '', '', NULL, '65Cok4jXHspn160731qrbx', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469920184&nonce_str=444574aqz0s9&product_id=65Cok4jXHspn160731qrbx&sign=348260B96AFBC217DFF87CB5DE064222', '法国个人旅游', 83800, '', '30m', NULL, NULL, 0, NULL),
(41, 2, '160731hjfk', '2016-07-31 07:37:59', 0, 4, '', '', NULL, '65Cok4jXHspn160731hjfk', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1469921879&nonce_str=wdjlcrdhf8x6&product_id=65Cok4jXHspn160731hjfk&sign=97E562AE4FDAC6533EDF89D55E2C61CA', '南非个人旅游签证', 97100, '', '30m', NULL, NULL, 0, NULL),
(42, 2, '160801x3m6', '2016-08-01 12:23:07', 0, 3, '', '', NULL, '65Cok4jXHspn160801x3m6', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1470025396&nonce_str=o79xk2dxytjv&product_id=65Cok4jXHspn160801x3m6&sign=4B45980A7FE3407BFB4F182D497A6ACA', '美国旅游签证', 127100, '', '30m', 'wx2016080112404454416be4700151612034', '2016-08-01 12:40:45', 0, NULL),
(43, 2, '160801gxdm', '2016-08-01 12:36:11', 0, 4, '', '', NULL, '65Cok4jXHspn160801gxdm', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1470026171&nonce_str=a1d9bltav084&product_id=65Cok4jXHspn160801gxdm&sign=F27C418A4B88F0B51DCBB9D5DAEFD764', '美国旅游签证', 127100, '', '30m', NULL, NULL, 0, NULL),
(44, 2, '160802mlyc', '2016-08-02 14:30:11', 0, 3, '', '', NULL, '65Cok4jXHspn160802mlyc', NULL, NULL, 1, NULL, NULL, NULL, NULL, 0, NULL),
(45, 2, '1608023dzj', '2016-08-02 14:40:24', 0, 3, '', '', NULL, '65Cok4jXHspn1608023dzj', NULL, NULL, 1, NULL, NULL, NULL, NULL, 0, NULL),
(46, 2, '160803baec', '2016-08-03 14:31:32', 0, 4, '', '', NULL, '65Cok4jXHspn160803baec', 'weixin://wxpay/bizpayurl?appid=wx2b713952a886ea6b&mch_id=1347657201&time_stamp=1470205892&nonce_str=h1zas5ybwpt3&product_id=65Cok4jXHspn160803baec&sign=42EF84DD812DDE8CDF368B67667898E9', '美国旅游签证', 113700, '', '30m', NULL, NULL, 0, NULL),
(47, 2, '160804xnho', '2016-08-04 00:13:21', 0, 3, '', '', NULL, '65Cok4jXHspn160804xnho', NULL, NULL, 1, NULL, NULL, NULL, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `bs_port`
--

CREATE TABLE IF NOT EXISTS `bs_port` (
  `id` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `setting` text NOT NULL,
  `is_lock` int(11) DEFAULT '0',
  `created` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `bs_port`
--

INSERT INTO `bs_port` (`id`, `title`, `setting`, `is_lock`, `created`) VALUES
(1, 'Alipay', '{"partner":"2088121608978301","sellerId":"2088121608978301","privateKey":"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALSXEAG3ddNy6SDtenzYl7P6hw7RgaH7S65fzBDCDE91uPsg1ZZ7IoulCJHPJ+IeSysvOvn2GoBFIhjIqBVpbtxU2wXk/QpstXnAJP1gnOz84yLDkpr2jA24z9GQrUx7zSpZUkp3D3fJGPCq9hOhWPG3E+IKOUUkC/5wuh3HiJU/AgMBAAECgYBBtiId7crS+SI5WBBU818oH0Ybr0JTVaRxO+x+QI3IMBbyUj1F92JXm+KlY9KoZcuGWDZGlDWKbR1+FS2MNQQgTZIVNWo7GzYcLrPVsy8n5gi9u4wu5i9a61mUBmLXtecIZQFDnzpw8bzq1IqnNvVnhtyix5j7UvP0LQdeEj47oQJBAOKvYVmNNQ10kmJEO2fN3gKyPpIGeIe/deLhW9ASAElN3vjWNta4ZcregrB8bo0GLRn1YaU0Yk9pwZhSJLm7MQ8CQQDL8aoyXOxiJlHGaoyWBqTb2MI5fgYWk0x6eUsELL8byNZipWZrv4gex0+dV8y3sbb88F2sviy+E4jZnQZQ4fjRAkEAij+NrpDo9yDOGfIlDMTIDnrooCQkJB4HZmwsk3Q3Cn3ca4Qxg7iIFDaqG7p3rbhDj15Qw/Fzt5z2/c+zKDbazwJAdiCcPF+ma5NWel7s31kp1E1Q8owUaq8W9TmcQebJKwbBZpH3KSHfbjRz4OciJKRDIW74Uz40HESkV6ekKOU6gQJAGuSAZCXbNUGwRL2d9FDTvEjipz/5udtTp5diuyQmwz0TqVEOJwg+ChwRGz69172secqzqgW2iLova/n1FZDBqw==","aliPublicKey":"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB","logPath":"/usr/local/alipaylog/","inputCharset":"utf-8","signType":"RSA","notifyUrl":"http://127.0.0.1:8080/api/alipay/notify_url","returnUrl":"http://127.0.0.1:8080/api/alipay/return_url","isRealMode":false,}', 0, '2016-06-29 17:37:09'),
(2, 'Wechatpay', '{}', 0, '2016-06-29 17:37:36');

-- --------------------------------------------------------

--
-- 表的结构 `bs_unit`
--

CREATE TABLE IF NOT EXISTS `bs_unit` (
  `id` int(11) NOT NULL,
  `app_id` int(11) NOT NULL,
  `port_id` int(11) NOT NULL,
  `series_number` varchar(256) NOT NULL,
  `setting` text NOT NULL,
  `is_lock` int(11) DEFAULT '0',
  `created` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `bs_unit`
--

INSERT INTO `bs_unit` (`id`, `app_id`, `port_id`, `series_number`, `setting`, `is_lock`, `created`) VALUES
(1, 1, 1, '160629f8v1ul', '{"partner":"2088121608978301","seller_id":"2088121608978301","private_key":"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALSXEAG3ddNy6SDtenzYl7P6hw7RgaH7S65fzBDCDE91uPsg1ZZ7IoulCJHPJ+IeSysvOvn2GoBFIhjIqBVpbtxU2wXk/QpstXnAJP1gnOz84yLDkpr2jA24z9GQrUx7zSpZUkp3D3fJGPCq9hOhWPG3E+IKOUUkC/5wuh3HiJU/AgMBAAECgYBBtiId7crS+SI5WBBU818oH0Ybr0JTVaRxO+x+QI3IMBbyUj1F92JXm+KlY9KoZcuGWDZGlDWKbR1+FS2MNQQgTZIVNWo7GzYcLrPVsy8n5gi9u4wu5i9a61mUBmLXtecIZQFDnzpw8bzq1IqnNvVnhtyix5j7UvP0LQdeEj47oQJBAOKvYVmNNQ10kmJEO2fN3gKyPpIGeIe/deLhW9ASAElN3vjWNta4ZcregrB8bo0GLRn1YaU0Yk9pwZhSJLm7MQ8CQQDL8aoyXOxiJlHGaoyWBqTb2MI5fgYWk0x6eUsELL8byNZipWZrv4gex0+dV8y3sbb88F2sviy+E4jZnQZQ4fjRAkEAij+NrpDo9yDOGfIlDMTIDnrooCQkJB4HZmwsk3Q3Cn3ca4Qxg7iIFDaqG7p3rbhDj15Qw/Fzt5z2/c+zKDbazwJAdiCcPF+ma5NWel7s31kp1E1Q8owUaq8W9TmcQebJKwbBZpH3KSHfbjRz4OciJKRDIW74Uz40HESkV6ekKOU6gQJAGuSAZCXbNUGwRL2d9FDTvEjipz/5udtTp5diuyQmwz0TqVEOJwg+ChwRGz69172secqzqgW2iLova/n1FZDBqw==","ali_public_key":"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB","log_path":"D:\\\\","input_charset":"utf-8","sign_type":"RSA","notify_url":"http://101.200.232.199:10000/api/alipay/notify_url","return_url":"http://101.200.232.199:10000/api/alipay/return_url","real_mode":false,"real_notify_url":"http://beta.woigo.cn/qqvisa/api/alipay/notify_url","real_return_url":"http://beta.woigo.cn/qqvisa/api/alipay/return_url"}', 0, '2016-06-29 17:43:41'),
(2, 1, 2, '160629tw3k75', '{"appid":"wx2b713952a886ea6b","mch_id":"1347657201","key":"200b86bd4022635e232bcb5fc80a5baa","local_ip":"","notify_url":"http://101.200.232.199:10000/api/wechatpay/buy_over_notify","real_notify_url":"http://beta.www.woigo.cn/qqvisa/api/Wechatpay/notify_url","is_debug":1}', 0, '2016-06-29 17:44:06'),
(3, 2, 1, 'hqey8b930pvo', '{"partner":"2088121608978301","seller_id":"2088121608978301","private_key":"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALSXEAG3ddNy6SDtenzYl7P6hw7RgaH7S65fzBDCDE91uPsg1ZZ7IoulCJHPJ+IeSysvOvn2GoBFIhjIqBVpbtxU2wXk/QpstXnAJP1gnOz84yLDkpr2jA24z9GQrUx7zSpZUkp3D3fJGPCq9hOhWPG3E+IKOUUkC/5wuh3HiJU/AgMBAAECgYBBtiId7crS+SI5WBBU818oH0Ybr0JTVaRxO+x+QI3IMBbyUj1F92JXm+KlY9KoZcuGWDZGlDWKbR1+FS2MNQQgTZIVNWo7GzYcLrPVsy8n5gi9u4wu5i9a61mUBmLXtecIZQFDnzpw8bzq1IqnNvVnhtyix5j7UvP0LQdeEj47oQJBAOKvYVmNNQ10kmJEO2fN3gKyPpIGeIe/deLhW9ASAElN3vjWNta4ZcregrB8bo0GLRn1YaU0Yk9pwZhSJLm7MQ8CQQDL8aoyXOxiJlHGaoyWBqTb2MI5fgYWk0x6eUsELL8byNZipWZrv4gex0+dV8y3sbb88F2sviy+E4jZnQZQ4fjRAkEAij+NrpDo9yDOGfIlDMTIDnrooCQkJB4HZmwsk3Q3Cn3ca4Qxg7iIFDaqG7p3rbhDj15Qw/Fzt5z2/c+zKDbazwJAdiCcPF+ma5NWel7s31kp1E1Q8owUaq8W9TmcQebJKwbBZpH3KSHfbjRz4OciJKRDIW74Uz40HESkV6ekKOU6gQJAGuSAZCXbNUGwRL2d9FDTvEjipz/5udtTp5diuyQmwz0TqVEOJwg+ChwRGz69172secqzqgW2iLova/n1FZDBqw==","ali_public_key":"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB","log_path":"D:\\\\","input_charset":"utf-8","sign_type":"RSA","notify_url":"http://101.200.232.199:10000/api/alipay/notify_url","return_url":"http://101.200.232.199:10000/api/alipay/return_url","real_mode":true,"real_notify_url":"http://www.woigo.cn/qqvisa/api/alipay/notify_url","real_return_url":"http://www.woigo.cn/qqvisa/api/alipay/return_url"}', 0, '2016-07-29 17:07:41'),
(4, 2, 2, 'vb8nhasiok70', '{"appid":"wx2b713952a886ea6b","mch_id":"1347657201","key":"200b86bd4022635e232bcb5fc80a5baa","local_ip":"","notify_url":"http://101.200.232.199:10000/api/wechatpay/buy_over_notify","real_notify_url":"http://www.woigo.cn/qqvisa/api/Wechatpay/notify_url","is_debug":0}', 0, '2016-07-29 17:08:06');

-- --------------------------------------------------------

--
-- 替换视图以便查看 `bv_unit`
--
CREATE TABLE IF NOT EXISTS `bv_unit` (
`id` int(11)
,`app_id` int(11)
,`port_id` int(11)
,`setting` text
,`is_lock` int(11)
,`created` datetime
,`series_number` varchar(256)
,`app_title` varchar(45)
,`app_series_number` varchar(45)
,`app_is_lock` int(11)
,`port_title` varchar(45)
,`port_is_lock` int(11)
);

-- --------------------------------------------------------

--
-- 表的结构 `qt_apppay_need_refund`
--

CREATE TABLE IF NOT EXISTS `qt_apppay_need_refund` (
  `id` int(11) NOT NULL,
  `port` varchar(45) DEFAULT NULL,
  `input_data` text,
  `created` datetime DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `modified` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `qt_app_pay_recallback`
--

CREATE TABLE IF NOT EXISTS `qt_app_pay_recallback` (
  `id` int(11) NOT NULL,
  `url` varchar(512) NOT NULL,
  `created` datetime DEFAULT NULL,
  `is_called` int(11) NOT NULL DEFAULT '0',
  `called_time` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `qt_app_pay_recallback`
--

INSERT INTO `qt_app_pay_recallback` (`id`, `url`, `created`, `is_called`, `called_time`) VALUES
(1, 'http://beta.www.woigo.cn/qqvisa/api/Wechatpay/notify_url?back_sign=eab94da941bc92cc7c87085244a87393&result_code=SUCCESS&openid=oEiShtwrkzt51F-xcEL2FsVluWgk&out_trade_no=160728tel5&bank_type=CFT&total_fee=1&trade_type=NATIVE&transaction_id=4008372001201607290014662083&cash_fee=1&cash_fee_type=null&coupon_fee=null', '2016-07-29 07:11:47', 0, NULL),
(2, 'http://beta.www.woigo.cn/qqvisa/api/Wechatpay/notify_url?back_sign=dc8c52aa2eb6d59cc05cd05d6f2e0c5d&result_code=SUCCESS&openid=oEiSht1hvQqWbujfgl38PxK8w_Yw&out_trade_no=160729e59w&bank_type=CFT&total_fee=1&trade_type=NATIVE&transaction_id=4008202001201607290028979221&cash_fee=1&cash_fee_type=null&coupon_fee=null', '2016-07-29 11:37:11', 0, NULL),
(3, 'http://beta.www.woigo.cn/qqvisa/api/Wechatpay/notify_url?back_sign=dc18809179b6be6d0e1f10c8f638fa17&result_code=SUCCESS&openid=oEiSht1hvQqWbujfgl38PxK8w_Yw&out_trade_no=160729ymnd&bank_type=CFT&total_fee=1&trade_type=NATIVE&transaction_id=4008202001201607290029085727&cash_fee=1&cash_fee_type=null&coupon_fee=null', '2016-07-29 11:40:20', 0, NULL),
(4, 'http://beta.www.woigo.cn/qqvisa/api/Wechatpay/notify_url?back_sign=6c79182639c04773adeed72dc9a1da27&result_code=SUCCESS&openid=oEiSht1hvQqWbujfgl38PxK8w_Yw&out_trade_no=160729yeo7&bank_type=CFT&total_fee=1&trade_type=NATIVE&transaction_id=4008202001201607290042007146&cash_fee=1&cash_fee_type=null&coupon_fee=null', '2016-07-29 14:40:29', 0, NULL),
(5, 'http://beta.www.woigo.cn/qqvisa/api/Wechatpay/notify_url?back_sign=233ccd8ed16c76974223bafe6941bc94&result_code=SUCCESS&openid=oEiSht1hvQqWbujfgl38PxK8w_Yw&out_trade_no=160729p2fc&bank_type=CFT&total_fee=1&trade_type=NATIVE&transaction_id=4008202001201607290046932768&cash_fee=1&cash_fee_type=null&coupon_fee=null', '2016-07-29 15:17:09', 0, NULL),
(6, 'http://beta.www.woigo.cn/qqvisa/api/Wechatpay/notify_url?back_sign=e2dc4dcd299a8a519a13dc2f9fb83534&result_code=SUCCESS&openid=oEiSht1hvQqWbujfgl38PxK8w_Yw&out_trade_no=160729cqyd&bank_type=CFT&total_fee=1&trade_type=NATIVE&transaction_id=4008202001201607290050589298&cash_fee=1&cash_fee_type=null&coupon_fee=null', '2016-07-29 16:07:35', 0, NULL),
(7, 'http://beta.www.woigo.cn/qqvisa/api/Wechatpay/notify_url?back_sign=e33fb2ba419dda41c31cc10090709a1b&result_code=SUCCESS&openid=oEiSht1hvQqWbujfgl38PxK8w_Yw&out_trade_no=160730augk&bank_type=CFT&total_fee=1&trade_type=NATIVE&transaction_id=4008202001201607300086790857&cash_fee=1&cash_fee_type=null&coupon_fee=null', '2016-07-30 01:46:18', 0, NULL),
(8, 'http://www.woigo.cn/qqvisa/api/Wechatpay/notify_url?back_sign=7af9ae1e79a818193fd8b73feef85779&result_code=SUCCESS&openid=oEiShtwwvR_9jAsHhxIDOz2vNfH8&out_trade_no=160730ndmv&bank_type=CITIC_DEBIT&total_fee=900&trade_type=NATIVE&transaction_id=4001692001201607300105059067&cash_fee=900&cash_fee_type=null&coupon_fee=null', '2016-07-30 11:47:09', 0, NULL),
(9, 'http://www.woigo.cn/qqvisa/api/Wechatpay/notify_url?back_sign=9380baee9a75ad98165699f09c06a108&result_code=SUCCESS&openid=oEiSht3PHWy-s86HTHmBXEBFEJbg&out_trade_no=160730tmdr&bank_type=CFT&total_fee=900&trade_type=NATIVE&transaction_id=4007602001201607300107062134&cash_fee=900&cash_fee_type=null&coupon_fee=null', '2016-07-30 11:49:55', 0, NULL),
(10, 'http://beta.www.woigo.cn/qqvisa/api/Wechatpay/notify_url?back_sign=bb328030e2a840a089b8b18c8d2090c0&result_code=SUCCESS&openid=oEiSht1hvQqWbujfgl38PxK8w_Yw&out_trade_no=160730lbph&bank_type=CFT&total_fee=1&trade_type=NATIVE&transaction_id=4008202001201607300113264380&cash_fee=1&cash_fee_type=null&coupon_fee=null', '2016-07-30 13:38:34', 0, NULL),
(11, 'http://www.woigo.cn/qqvisa/api/Wechatpay/notify_url?back_sign=fe0b4a75a3eea748d588a43e12bfb1b3&result_code=SUCCESS&openid=oEiSht1hvQqWbujfgl38PxK8w_Yw&out_trade_no=1607304i23&bank_type=CFT&total_fee=100&trade_type=NATIVE&transaction_id=4008202001201607300145182134&cash_fee=100&cash_fee_type=null&coupon_fee=null', '2016-07-30 21:00:08', 0, NULL),
(12, 'http://www.woigo.cn/qqvisa/api/Wechatpay/notify_url?back_sign=cdc04bbbe8d219d7a285288df280e40a&result_code=SUCCESS&openid=oEiShtwwvR_9jAsHhxIDOz2vNfH8&out_trade_no=1607305otq&bank_type=CITIC_DEBIT&total_fee=100&trade_type=NATIVE&transaction_id=4001692001201607300149830832&cash_fee=100&cash_fee_type=null&coupon_fee=null', '2016-07-30 22:14:08', 0, NULL),
(13, 'http://www.woigo.cn/qqvisa/api/Wechatpay/notify_url?back_sign=01a60c5120cf8603be0db3402fd52884&result_code=SUCCESS&openid=oEiSht1hvQqWbujfgl38PxK8w_Yw&out_trade_no=1607305uo8&bank_type=CFT&total_fee=100&trade_type=NATIVE&transaction_id=4008202001201607300154746498&cash_fee=100&cash_fee_type=null&coupon_fee=null', '2016-07-30 22:48:37', 0, NULL),
(14, 'http://www.woigo.cn/qqvisa/api/Wechatpay/notify_url?back_sign=c2470bff5c5668c73fa5c2d975588e05&result_code=SUCCESS&openid=oEiShtwwvR_9jAsHhxIDOz2vNfH8&out_trade_no=160730tox4&bank_type=CITIC_DEBIT&total_fee=100&trade_type=NATIVE&transaction_id=4001692001201607300155575410&cash_fee=100&cash_fee_type=null&coupon_fee=null', '2016-07-30 23:18:09', 0, NULL),
(15, 'http://www.woigo.cn/qqvisa/api/Wechatpay/notify_url?back_sign=80b49d45d6db7ab10379e6032211807a&result_code=SUCCESS&openid=oEiShtwwvR_9jAsHhxIDOz2vNfH8&out_trade_no=160730e93h&bank_type=CITIC_DEBIT&total_fee=1900&trade_type=NATIVE&transaction_id=4001692001201608020364747734&cash_fee=1900&cash_fee_type=null&coupon_fee=null', '2016-08-02 12:52:18', 0, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `qt_wechat_prepare_id`
--

CREATE TABLE IF NOT EXISTS `qt_wechat_prepare_id` (
  `out_trade_no` varchar(128) NOT NULL,
  `prepare_id` varchar(128) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `appid` varchar(128) DEFAULT NULL,
  `mch_id` varchar(128) DEFAULT NULL,
  `attach` varchar(45) DEFAULT NULL,
  `total_fee` varchar(45) DEFAULT NULL,
  `body` varchar(512) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `paid_time` varchar(45) DEFAULT NULL,
  `transaction_id` varchar(128) DEFAULT NULL,
  `open_id` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `qt_wechat_prepare_id`
--

INSERT INTO `qt_wechat_prepare_id` (`out_trade_no`, `prepare_id`, `created`, `appid`, `mch_id`, `attach`, `total_fee`, `body`, `status`, `paid_time`, `transaction_id`, `open_id`) VALUES
('1606298hix25160729cqyd1gwyzbpdv', 'wx20160729160726c2fb8db2d40449607352', '2016-07-29 16:07:26', 'wx2b713952a886ea6b', '1347657201', '1606298hix25160729cqyd', '1', '四季旅行网-韩国个人旅游签证', 'paid', '2016-07-29 16:07:35', '4008202001201607290050589298', 'oEiSht1hvQqWbujfgl38PxK8w_Yw'),
('1606298hix25160729p2fccxij14blo', 'wx20160729151702c1c285be990740618309', '2016-07-29 15:17:02', 'wx2b713952a886ea6b', '1347657201', '1606298hix25160729p2fc', '1', '四季旅行网-韩国个人旅游签证', 'paid', '2016-07-29 15:17:09', '4008202001201607290046932768', 'oEiSht1hvQqWbujfgl38PxK8w_Yw'),
('1606298hix25160730augkz31j1vz7v', 'wx20160730014612f32e4acc7a0846272929', '2016-07-30 01:46:12', 'wx2b713952a886ea6b', '1347657201', '1606298hix25160730augk', '1', '四季旅行网-美国旅游签证', 'paid', '2016-07-30 01:46:18', '4008202001201607300086790857', 'oEiSht1hvQqWbujfgl38PxK8w_Yw'),
('1606298hix25160730lbph4z5cjuirs', 'wx2016073013382702496b02af0997024935', '2016-07-30 13:38:27', 'wx2b713952a886ea6b', '1347657201', '1606298hix25160730lbph', '1', '四季旅行网-美国旅游签证', 'paid', '2016-07-30 13:38:34', '4008202001201607300113264380', 'oEiSht1hvQqWbujfgl38PxK8w_Yw'),
('65Cok4jXHspn1607304i23c5dhbgtm8', 'wx20160730210001315ed1c7af0485323911', '2016-07-30 21:00:02', 'wx2b713952a886ea6b', '1347657201', '65Cok4jXHspn1607304i23', '100', '四季旅行网-美国旅游签证', 'paid', '2016-07-30 21:00:07', '4008202001201607300145182134', 'oEiSht1hvQqWbujfgl38PxK8w_Yw'),
('65Cok4jXHspn1607305otq88j0ja5kz', 'wx201607302214008a95158e740335962472', '2016-07-30 22:14:00', 'wx2b713952a886ea6b', '1347657201', '65Cok4jXHspn1607305otq', '100', '四季旅行网-美国旅游签证', 'paid', '2016-07-30 22:14:08', '4001692001201607300149830832', 'oEiShtwwvR_9jAsHhxIDOz2vNfH8'),
('65Cok4jXHspn1607305uo8kzwx9xjq1', 'wx20160730224830019ad2ac5f0285186372', '2016-07-30 22:48:30', 'wx2b713952a886ea6b', '1347657201', '65Cok4jXHspn1607305uo8', '100', '四季旅行网-美国旅游签证', 'paid', '2016-07-30 22:48:37', '4008202001201607300154746498', 'oEiSht1hvQqWbujfgl38PxK8w_Yw'),
('65Cok4jXHspn160730c2zqf2yy3ogmv', 'wx201607300854550ca7eefdd70858239235', '2016-07-30 08:54:55', 'wx2b713952a886ea6b', '1347657201', '65Cok4jXHspn160730c2zq', '117100', '四季旅行网-美国旅游签证', NULL, NULL, NULL, NULL),
('65Cok4jXHspn160730e93hg50wv9kbc', 'wx201608021252099e6be27d770078770344', '2016-08-02 12:52:10', 'wx2b713952a886ea6b', '1347657201', '65Cok4jXHspn160730e93h', '1900', '四季旅行网-美国旅游签证', 'paid', '2016-08-02 12:52:17', '4001692001201608020364747734', 'oEiShtwwvR_9jAsHhxIDOz2vNfH8'),
('65Cok4jXHspn160730ndmvey3dm8u3z', 'wx201607301146578f80c448440801136892', '2016-07-30 11:46:57', 'wx2b713952a886ea6b', '1347657201', '65Cok4jXHspn160730ndmv', '900', '四季旅行网-美国旅游签证', 'paid', '2016-07-30 11:47:08', '4001692001201607300105059067', 'oEiShtwwvR_9jAsHhxIDOz2vNfH8'),
('65Cok4jXHspn160730tmdryveh2t1ei', 'wx20160730114946b02302a5ac0755849995', '2016-07-30 11:49:46', 'wx2b713952a886ea6b', '1347657201', '65Cok4jXHspn160730tmdr', '900', '四季旅行网-美国旅游签证', 'paid', '2016-07-30 11:49:55', '4007602001201607300107062134', 'oEiSht3PHWy-s86HTHmBXEBFEJbg'),
('65Cok4jXHspn160730tox4w9x1n6ask', 'wx201607302318003e9b00d2cf0898860633', '2016-07-30 23:18:00', 'wx2b713952a886ea6b', '1347657201', '65Cok4jXHspn160730tox4', '100', '四季旅行网-美国旅游签证', 'paid', '2016-07-30 23:18:09', '4001692001201607300155575410', 'oEiShtwwvR_9jAsHhxIDOz2vNfH8'),
('65Cok4jXHspn160801x3m6dzcn969cu', 'wx2016080112404454416be4700151612034', '2016-08-01 12:40:45', 'wx2b713952a886ea6b', '1347657201', '65Cok4jXHspn160801x3m6', '127100', '四季旅行网-美国旅游签证', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- 视图结构 `bv_unit`
--
DROP TABLE IF EXISTS `bv_unit`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `bv_unit` AS select `bs_unit`.`id` AS `id`,`bs_unit`.`app_id` AS `app_id`,`bs_unit`.`port_id` AS `port_id`,`bs_unit`.`setting` AS `setting`,`bs_unit`.`is_lock` AS `is_lock`,`bs_unit`.`created` AS `created`,`bs_unit`.`series_number` AS `series_number`,`bs_app`.`title` AS `app_title`,`bs_app`.`series_number` AS `app_series_number`,`bs_app`.`is_lock` AS `app_is_lock`,`bs_port`.`title` AS `port_title`,`bs_port`.`is_lock` AS `port_is_lock` from ((`bs_unit` join `bs_app`) join `bs_port`) where ((`bs_unit`.`app_id` = `bs_app`.`id`) and (`bs_unit`.`port_id` = `bs_port`.`id`));

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bs_alipay_callback_log`
--
ALTER TABLE `bs_alipay_callback_log`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bs_app`
--
ALTER TABLE `bs_app`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bs_app_pay`
--
ALTER TABLE `bs_app_pay`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bs_port`
--
ALTER TABLE `bs_port`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bs_unit`
--
ALTER TABLE `bs_unit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `qt_apppay_need_refund`
--
ALTER TABLE `qt_apppay_need_refund`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `qt_app_pay_recallback`
--
ALTER TABLE `qt_app_pay_recallback`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `qt_wechat_prepare_id`
--
ALTER TABLE `qt_wechat_prepare_id`
  ADD PRIMARY KEY (`out_trade_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bs_alipay_callback_log`
--
ALTER TABLE `bs_alipay_callback_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `bs_app`
--
ALTER TABLE `bs_app`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `bs_app_pay`
--
ALTER TABLE `bs_app_pay`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=48;
--
-- AUTO_INCREMENT for table `bs_port`
--
ALTER TABLE `bs_port`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `bs_unit`
--
ALTER TABLE `bs_unit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `qt_apppay_need_refund`
--
ALTER TABLE `qt_apppay_need_refund`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `qt_app_pay_recallback`
--
ALTER TABLE `qt_app_pay_recallback`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
