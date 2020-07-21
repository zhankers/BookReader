package com.ebook.interview;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import java.util.Date;

public class SaleItem {
	private int month;
	private Date date;
	private String transationId;
	private double saleNumbers;
	
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTransationId() {
		return transationId;
	}
	public void setTransationId(String transationId) {
		this.transationId = transationId;
	}
	public double getSaleNumbers() {
		return saleNumbers;
	}
	public void setSaleNumbers(double saleNumbers) {
		this.saleNumbers = saleNumbers;
	}

	public static void main(String[] args) {

		String message = "{\"record\":[" +
				"{\"3日期\":\"2020-01-03 10:27\",\"销售方代码\":\"12430\",\"销售方名称\":\"江苏恒瑞医药股份有限公司\",\"采购方代码\":\"H0100163\",\"采购方名称\":\"北大医药\",\"产品代码\":\"200392\",\"产品名称\":\"美司钠注射液||400毫克 /支\",\"产品规格\":\"400毫克 /支\",\"批号\":\"MS191201\",\"数量\":\"1000\",\"单位\":\"安瓶\",\"单价\":\"7.4\",\"金额\":\"7398.23\",\"生产厂家\":\"江苏恒瑞医药股份有限公司\",\"有效期\":\"2022-11-30\",\"采购类型\":\"采购\",\"批准文号\":\"国药准字H10950290\",\"创建时间\":\"2020-06-30 21:11\"}," +
				"{\"5日期\":\"2020-01-03 10:26\",\"销售方代码\":\"12430\",\"销售方名称\":\"江苏恒瑞医药股份有限公司\",\"采购方代码\":\"H0100163\",\"采购方名称\":\"北大医药\",\"产品代码\":\"200392\",\"产品名称\":\"美司钠注射液||400毫克 /支\",\"产品规格\":\"400毫克 /支\",\"批号\":\"MS191201\",\"数量\":\"1000\",\"单位\":\"安瓶\",\"单价\":\"7.4\",\"金额\":\"7398.23\",\"生产厂家\":\"江苏恒瑞医药股份有限公司\",\"有效期\":\"2022-11-30\",\"采购类型\":\"采购\",\"批准文号\":\"国药准字H10950290\",\"创建时间\":\"2020-06-30 21:11\"}," +
				"{\"2日期\":\"2020-01-03 10:25\",\"销售方代码\":\"12430\",\"销售方名称\":\"江苏恒瑞医药股份有限公司\",\"采购方代码\":\"H0100163\",\"采购方名称\":\"北大医药\",\"产品代码\":\"200392\",\"产品名称\":\"美司钠注射液||400毫克 /支\",\"产品规格\":\"400毫克 /支\",\"批号\":\"MS191201\",\"数量\":\"1000\",\"单位\":\"安瓶\",\"单价\":\"7.4\",\"金额\":\"7398.23\",\"生产厂家\":\"江苏恒瑞医药股份有限公司\",\"有效期\":\"2022-11-30\",\"采购类型\":\"采购\",\"批准文号\":\"国药准字H10950290\",\"创建时间\":\"2020-06-30 21:11\"}," +
				"{\"1日期\":\"2020-01-03 10:24\",\"销售方代码\":\"12430\",\"销售方名称\":\"江苏恒瑞医药股份有限公司\",\"采购方代码\":\"H0100163\",\"采购方名称\":\"北大医药\",\"产品代码\":\"200392\",\"产品名称\":\"美司钠注射液||400毫克 /支\",\"产品规格\":\"400毫克 /支\",\"批号\":\"MS191201\",\"数量\":\"1000\",\"单位\":\"安瓶\",\"单价\":\"7.4\",\"金额\":\"7398.23\",\"生产厂家\":\"江苏恒瑞医药股份有限公司\",\"有效期\":\"2022-11-30\",\"采购类型\":\"采购\",\"批准文号\":\"国药准字H10950290\",\"创建时间\":\"2020-06-30 21:11\",}" +
				"]}";

		JSONObject json = JSON.parseObject(message, JSONObject.class, Feature.OrderedField);

		JSONArray record = json.getJSONArray("record");

		System.out.println("-----");

		System.out.println("== "+record);

		record.forEach(System.out::println);

	}
}
