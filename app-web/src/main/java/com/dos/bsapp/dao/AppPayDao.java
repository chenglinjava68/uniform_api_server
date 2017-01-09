package com.dos.bsapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dos.bsapp.model.AppPay;



public interface AppPayDao
{
    public void newAppPay(AppPay ap);
    public AppPay getByAppOrder(@Param("appId")Integer appId,@Param("order")String orderSeriesNumber);
    public AppPay get(@Param("id")long id);
    public AppPay getByTotalSeriesNumber(@Param("totalSeriesNumber")String seriesNumber);
	public void setPaid(AppPay ap);
	
	//update qt_apppay set wechat_pay_lin = #{wechatPayLink}, total_price=#{totalPrice},show_url=#{showUrl},over_time=#{overTime}
	public void updateWechatPayLink(AppPay ap);
	//update qt_apppay set wechat_prepare_id = #{wechatPrepareId} , wechat_prepare_id_create_time=#{wechatPrepareIdCreateTime}
	public void updateWechatPrepareId(AppPay ap);
	
	/*insert into qt_wehat_prepare_id(prepare_id,created,appid,mch_id,out_trade_no,attach,total_fee,body) values(#{wechatPrepareId},now(),
	#{appid},#{mch_id},#{out_trade_no},#{attach},#{total_fee},#{body});
	*/
	public void addNewPrepareIdRecord(@Param("wechatPrepareId")String wechatPrepareId, 
			@Param("appid")String appid,
			@Param("mch_id")String mch_id,
			@Param("out_trade_no")String out_trade_no,
			@Param("attach")String attach, 
			@Param("total_fee")Integer total_fee,
			@Param("body")String body);
	//updatq qt_wechat_prepare_id set status = "paid" where out_trade_no = #{outTradeNo}
	public void updatePrepareIdPaid(@Param("outTradeNo")String out_trade_no, 
			@Param("transactionId")String transactionId, 
			@Param("totalFee")Integer totalFee, 
			@Param("openId")String openId);
	
	//insert into qt_apppay_need_refund (port,input_data,created) values (#{port},#{inputData},now());
	public void addNewNeedRefund(@Param("port")String port, @Param("inputData")String inputData);
	
	//update qt_apppay set called_back = #{calledBack}, called_back_time=#{calledBackTime} 
	public void updateCalledBack(AppPay ap);
	
	public void addNewNeedReCallbackRecord(@Param("url")String sUrl);
	public void updateNewNeedReCallbackRecord(@Param("url")String sUrl);
	
}
