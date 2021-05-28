//package com.bleizing.servlet.json;
//
//import java.util.Date;
//
//import com.google.gson.annotations.Expose;
//
///**
// * 
// * @author Nuriman
// * 
// * 24-NOV-2017,
// * Menambahkan informasi 
// * 
// * 20-JUN-2018,
// * Menambahkan informasi clientReffNo
// *
// */
//public class ResultDto extends JsonBase { // NOPMD by Nuriman on 7/28/17 6:37 PM
//	
//	/**
//	 * 
//	 */
//	@Expose
//	private String sessionId;
//	
//	@Expose
//	private String transType;
//	
//	@Expose
//	private String channelRef;
//	
//	@Expose
//	private String refNumb;
//	
//	@Expose
//	private String errorCode;
//	
//	@Expose
//	private String errorDesc;
//		
//	
//	@Expose
//	private String transDateTime;
//
//	private Date transDate;
//	
//	@Expose
//	private String adminBank;
//	
//	@Expose
//    private String totalAmount;
//
//    private String detailReq;
//
//    private String detailResp;
//
//	@Expose
//    private String totalAmountDb;
//
//	@Expose
//	private String promoAmount;
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
//    public String getPromoAmount() {
//        return promoAmount;
//    }
//
//    public void setPromoAmount(String promoAmount) {
//        this.promoAmount = promoAmount;
//    }
//
//    public String getSessionId() {
//		return sessionId;
//	}
//
//	public void setSessionId(String sessionId) {
//		this.sessionId = sessionId;
//	}
//
//	/**
//	 * 
//	 */
//	@Expose
//	private Integer code;
//
//	/**
//	 * 
//	 */
//	@Expose
//	private String message;
//
//	/**
//	 * 
//	 * @return
//	 */
//	public final Integer getCode() {
//		return code;
//	}
//
//	/**
//	 * 
//	 * @param code
//	 */
//	public final void setCode(final Integer code) {
//		this.code = code;
//	}
//
//	/**
//	 * 
//	 * @return
//	 */
//	public final String getMessage() {
//		return message;
//	}
//
//	/**
//	 * 
//	 * @param message
//	 */
//	public final void setMessage(final String message) {
//		this.message = message;
//	}
//
//	public String getTransType() {
//		return transType;
//	}
//
//	public void setTransType(String transType) {
//		this.transType = transType;
//	}
//
//	public String getChannelRef() {
//		return channelRef;
//	}
//
//	public void setChannelRef(String channelRef) {
//		this.channelRef = channelRef;
//	}
//
//	public String getRefNumb() {
//		return refNumb;
//	}
//
//	public void setRefNumb(String refNumb) {
//		this.refNumb = refNumb;
//	}
//
//	
//
//	public String getErrorCode() {
//		return errorCode;
//	}
//
//	public void setErrorCode(String errorCode) {
//		this.errorCode = errorCode;
//	}
//
//	public String getErrorDesc() {
//		return errorDesc;
//	}
//
//	public void setErrorDesc(String errorDesc) {
//		this.errorDesc = errorDesc;
//	}
//
//	public String getAdminBank() {
//		return adminBank;
//	}
//
//	public void setAdminBank(String adminBank) {
//		this.adminBank = adminBank;
//	}
//
//	public String getTransDateTime() {
//		return transDateTime;
//	}
//
//	public void setTransDateTime(String transDateTime) {
//		this.transDateTime = transDateTime;
//	}
//
//	public String getTotalAmount() {
//		return totalAmount;
//	}
//
//	public void setTotalAmount(String totalAmount) {
//		this.totalAmount = totalAmount;
//	}
//
//	public Date getTransDate() {
//		return transDate;
//	}
//
//	public void setTransDate(Date transDate) {
//		this.transDate = transDate;
//	}
//
//    public String getDetailReq() {
//        return detailReq;
//    }
//
//    public void setDetailReq(String detailReq) {
//        this.detailReq = detailReq;
//    }
//
//    public String getDetailResp() {
//        return detailResp;
//    }
//
//    public void setDetailResp(String detailResp) {
//        this.detailResp = detailResp;
//    }
//
//    public String getTotalAmountDb() {
//        return totalAmountDb;
//    }
//
//    public void setTotalAmountDb(String totalAmountDb) {
//        this.totalAmountDb = totalAmountDb;
//    }
//}