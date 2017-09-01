package com.zhiyou100.video.model;

/**  
* @ClassName: Statistics  
* @Description: TODO
* @author lyb  
* @date 2017年8月28日  下午8:34:21
*  
*/
public class Statistics {

	private String courseName;
	private Integer avgTime;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getAvgTime() {
		return avgTime;
	}
	public void setAvgTime(Integer avgTime) {
		this.avgTime = avgTime;
	}
	@Override
	public String toString() {
		return "Statistics [courseName=" + courseName + ", avgTime=" + avgTime + "]";
	}
	
	
	
}
