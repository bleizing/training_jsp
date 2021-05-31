package com.bleizing.exception;

/**
 * 
 * @author Nuriman
 *
 */
public enum ErrorTypeHost {

	SUKSES										("00", "Sukses"),
	TIMEOUT										("10", "Koneksi Timeout"),
	UNAUTHORIZED_API							("11", "Tidak ada hak akses API"),
	FAILED_CONN_API								("12", "Koneksi ke API gagal"),
	USER_ID_HARUS_ADA							("13", "ID User aplikasi harus ada"),
	PSWD_HARUS_ADA								("14", "Password aplikasi harus ada"),
	CONN_DB_TIMEOUT								("20", "Koneksi database timeout"),
	ERROR_QUERY_DB								("21", "Error query di database"),
	UNDEFINED									("99", "Undefined"),
	INVALID_PARAM								("101", "Invalid param values"),
	IS_ERROR_OK									("1", "Sukses"),
	IS_ERROR_NOT_OK								("0", "Ada kesalahan"),
	BRI_RESPON_SMS_NULL							("-1", "Response notif sms null"),
	BRI_RESPON_EMAIL_NULL						("-2", "Response notif email null"),
	
	;
	
	
	public final String code;
	public final String description;
	
	/**
	 * 
	 * @param code
	 * @param description
	 */
    ErrorTypeHost(final String code, final String description) {
		this.code = code;
		this.description = description;
	}
	
}
