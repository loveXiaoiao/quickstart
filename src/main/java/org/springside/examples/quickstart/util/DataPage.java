package org.springside.examples.quickstart.util;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName: DataPage
 * @Description: TODO(jquery.datatable分页模型)
 * @author liyi
 * @date 2014-11-21 下午4:43:53
 * 
 * @param <T>
 */
public class DataPage <T> implements Serializable {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 当前页数
	 */
	//private String sEcho;

	/**
	 * 总记录数目
	 */
	private long iTotalRecords = 0;
	
	/**
	 * 过滤获取的总数
	 */
	private long iTotalDisplayRecords=0;
	
//	private long iDisplayStart = 0;
	
	//private long iDisplayLength = 0;
	

	/** 
	 * @return iDisplayStart
	 */
	

	/**
	 * 查询结果集合
	 */
	private List<T> aaData = null;
	
	/**
	 * 构造函数
	 * Creates a new instance of Page.
	 *
	 */
	public DataPage() {
		super();
	}

	/**
	 * 构造函数
	 * Creates a new instance of Page.
	 *
	 * @param iTotalRecords 记录数目
	 * @param aaData 查询结果集合
	 */
	public DataPage(long iTotalRecords, List<T> aaData) {
		super();
		this.iTotalRecords = iTotalRecords;
		this.aaData = aaData;
	}
	
	/**
	 * 
	 * Title:
	 * Description:
	 * @param sEcho 当前页数
	 * @param iTotalRecords 总记录数
	 * @param iTotalDisplayRecords 过滤后的总数
	 * @param aaData 数据集合
	 */
	public DataPage( long iTotalRecords,long iTotalDisplayRecords, List<T> aaData) {
		super();
		this.iTotalRecords = iTotalRecords;
		this.iTotalDisplayRecords = iTotalDisplayRecords;
		this.aaData = aaData;
	}

	

	/** 
	 * @return iTotalRecords
	 */
	public long getiTotalRecords() {
		return iTotalRecords;
	}

	/** 
	 * @param iTotalRecords 要设置的 iTotalRecords
	 */
	public void setiTotalRecords(long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	/** 
	 * @return iTotalDisplayRecords
	 */
	public long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	/** 
	 * @param iTotalDisplayRecords 要设置的 iTotalDisplayRecords
	 */
	public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	/** 
	 * @return aaData
	 */
	public List<T> getAaData() {
		return aaData;
	}

	/** 
	 * @param aaData 要设置的 aaData
	 */
	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}

	
}
