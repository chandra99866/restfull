package com.example.restfull.restfull.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class FilesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    
    

}
