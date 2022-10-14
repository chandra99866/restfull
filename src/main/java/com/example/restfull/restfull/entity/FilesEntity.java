package com.example.restfull.restfull.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "filesInfo")
public class FilesEntity {
   

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "file_serial")
	@SequenceGenerator(name = "file_serial",sequenceName = "fileCount",allocationSize = 1)
    Long slNo;

    private String fileName;

    private Long fileSize;

    private Date updateDate;

	public Long getSlNo() {
		return slNo;
	}

	public void setSlNo(Long slNo) {
		this.slNo = slNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	 @Override
		public String toString() {
			return "FilesEntity [slNo=" + slNo + ", fileName=" + fileName + ", fileSize=" + fileSize + ", updateDate="
					+ updateDate + ", getSlNo()=" + getSlNo() + ", getFileName()=" + getFileName() + ", getFileSize()="
					+ getFileSize() + ", getUpdateDate()=" + getUpdateDate() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}


}
