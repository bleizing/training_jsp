//package com.bleizing.servlet.json;
//
//import com.google.gson.annotations.Expose;
//
//import com.bleizing.enums.AuditTypeEnum;
//
///**
// * 
// * @By coovy
// * 16-NOV-2017,
// * Menambahkan agent diinduk class
// * 
// * 20-JUN-2018,
// * menambahkan clientReffNo
// * 
// */
//public class ParamDto extends JsonBase {
//	
//	@Expose
//	private String deviceId;
//	
//	@Expose
//	private String deviceName;
//	
//	@Expose
//	private String agent;
//
//	@Expose
//	private String codePromo;
//
//	@Expose
//	private String amountPromo;
//
//	@Expose
//	private AuditTypeEnum auditType;
//
//	@Expose
//	private String usernames;
//
//	@Expose
//	private String deskripsi;
//	
//	@Expose
//	private Long clientReffNo;
//
//	public void setClientReffNo(Long clientReffNo) {
//		this.clientReffNo = clientReffNo;
//	}
//	
//	public Long getClientReffNo() {
//		return clientReffNo;
//	}
//
//	public void setAgent(String agent) {
//		this.agent = agent;
//	}
//	
//	public String getAgent() {
//		return agent;
//	}
//	
//	public String getDeviceName() {
//		return deviceName;
//	}
//
//	public void setDeviceName(String deviceName) {
//		this.deviceName = deviceName;
//	}
//
//	public String getDeviceId() {
//		return deviceId;
//	}
//
//	public void setDeviceId(String deviceId) {
//		this.deviceId = deviceId;
//	}
//
//	public String getCodePromo() {
//		return codePromo;
//	}
//
//	public void setCodePromo(String codePromo) {
//		this.codePromo = codePromo;
//	}
//
//	public String getAmountPromo() {
//		return amountPromo;
//	}
//
//	public void setAmountPromo(String amountPromo) {
//		this.amountPromo = amountPromo;
//	}
//
//	public AuditTypeEnum getAuditType() {
//		return auditType;
//	}
//
//	public void setAuditType(AuditTypeEnum auditType) {
//		this.auditType = auditType;
//	}
//
//    public String getUsernames() {
//        return usernames;
//    }
//
//    public void setUsernames(String usernames) {
//        this.usernames = usernames;
//    }
//
//    public String getDeskripsi() {
//        return deskripsi;
//    }
//
//    public void setDeskripsi(String deskripsi) {
//        this.deskripsi = deskripsi;
//    }
//}
