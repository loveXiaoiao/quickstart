package org.weichart.quickstart.util;

import java.util.List;

public class DataTableObject {
	int iTotalRecords;
	int iTotalDisplayRecords;
	String sEcho;
	String sColumns;
	/** 
	 * @return iTotalRecords
	 */
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	/** 
	 * @param iTotalRecords 要设置的 iTotalRecords
	 */
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	/** 
	 * @return iTotalDisplayRecords
	 */
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	/** 
	 * @param iTotalDisplayRecords 要设置的 iTotalDisplayRecords
	 */
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	/** 
	 * @return sEcho
	 */
	public String getsEcho() {
		return sEcho;
	}
	/** 
	 * @param sEcho 要设置的 sEcho
	 */
	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}
	/** 
	 * @return sColumns
	 */
	public String getsColumns() {
		return sColumns;
	}
	/** 
	 * @param sColumns 要设置的 sColumns
	 */
	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}
	
}
