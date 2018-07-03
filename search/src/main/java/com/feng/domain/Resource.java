package com.feng.domain;


/**
 * 资源实体类
 * @author Administrator
 *
 */
public class Resource {
	private String recordTime;
	private String size;
	private String fileCount;
	private String magent;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getFileCount() {
		return fileCount;
	}
	public void setFileCount(String fileCount) {
		this.fileCount = fileCount;
	}
	public String getMagent() {
		return magent;
	}
	public void setMagent(String magent) {
		this.magent = magent;
	}
	@Override
	public String toString() {
		return "Resource [recordTime=" + recordTime + ", size=" + size + ", fileCount=" + fileCount + ", magent="
				+ magent + ", name=" + name + "]";
	}
	
}
