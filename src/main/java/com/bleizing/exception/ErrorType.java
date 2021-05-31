package com.bleizing.exception;

/**
 *
 * @author Nuriman
 *
 */
public enum ErrorType {

	OK										(0, "OK"),
	OK_PORTAL								(0, "Berhasil"),
	DATA_NOT_FOUND							(-1, "Data not found"),
	METHOD_NOT_ALLOWED						(-2, "Method not allowed"),
	CAPTCHA_FAILED							(-3, "Captcha salah"),
    DOMAIN_NOT_ALLOWED						(-4, "Domain not allowed"),
	UNDER_CONSTRUCTION						(-400, "Service Under Construction"),

	SERVICE_INFO_TBANK_FULL			   		(-100, "Service info tbank not success"),

	//-1000
	AUTH_UNAME_PASS_INVALID					(-1000, "Auth username or pass invalid"),
	AUTH_USER_LOCKED						(-1001, "Auth user Blocked"),
	AUTH_USER_EXIST							(-1002, "Username already exist"),
	AUTH_OTP_INVALID						(-1003, "OTP invalid"),
	AUTH_USER_NOT_LOGGED_IN					(-1004, "User not logged in"),
	AUTH_OTP_MAX_RETRY						(-1005, "OTP input max retries"),
	AUTH_USER_NOT_EXIST						(-1006, "User not exist"),
	AUTH_UPDATE_EMAIL_NOT_FOUND				(-1007, "Update Email Failed - Not Found on DB, "),
	AUTH_UPDATE_EMAIL_FAILED				(-1008, "Update Email Failed - Service Failed, "),
	AUTH_UPDATE_USERNAME					(-1009, "Username is not updated - Go to Update Username"),
	
	AUTH_USER_HP_EMAIL_EXIST				(-1014, "Email / No HP Anda telah terdaftar, silakan login dengan user ID Internet Banking BRI Anda"),

	AUTH_LOGIN_TBANK_VALIDATION				(-1021, "Go to Tbank Validation"),
	AUTH_USER_NOT_FOUND						(-1022, "Auth username not found"),
	AUTH_USER_DEVICE_NOT_FOUND				(-1023, "Auth device not found"),
	AUTH_USER_INVALID						(-1024, "Auth username invalid"),
	AUTH_USER_DEVICEID_INVALID				(-1025, "Auth device invalid"),
	AUTH_UNAME_DEVICEID_INVALID				(-1026, "Auth username or device invalid"),

	AUTH_EV_EMAIL_NOT_VERIFIED				(-1096, "Email not verified - Go to User Verification Email (Form Resend link)"),
	AUTH_EMAIL_IS_EMPTY						(-1097, "Email is empty - Go to User Form Email (Form input email only)"),
	AUTH_EMAIL_IS_EXIST						(-1098, "Email exist - insert a new one"),
	AUTH_EV_EMAIL_NOT_VERIFIED_AND_NOT_FOUND(-1099, "Email not verified - Go to User Verification Email (Form Email without button)"),

	AUTH_GET_SESSION_USERNAME_EXIST			(-1990, "Username and device are found! - Go to DoHomeAction Screen"),
	AUTH_LOGIN_INVALID						(-1999, "Auth DoHomeAction Invalid"),
	AUTH_LINK_EXPIRED						(-1887, "Auth Link Expired"),
	AUTH_INVALID							(-1888, "Auth Invalid"),
	AUTH_HP_IS_EXIST						(-1889, "Handphone is exist - insert a new one"),

	AUTH_PASS_INVALID_LENGTH				(-1022,"Password minimal 8 chars"),
	AUTH_PASS_INVALID_MX_LENGTH				(-1023,"Password maximal 12 chars"),
	AUTH_PASS_NO_NORMAL_CHAR				(-1024,"Minimal 1 normal char"),
	AUTH_PASS_NO_CAPITAL_CHAR				(-1025,"Minimal 1 capital char"),
	AUTH_PASS_NO_NUMERIC_CHAR				(-1026,"Minimal 1 numeric char"),
	AUTH_PASS_CONTAIN_SUBSET				(-1027,"Password contains subset chars"),
	AUTH_PASS_NO_SPECIAL_CHAR				(-1028,"Minimal 1 special char"),
	AUTH_PASS_VALID							(-1029,"Password valid input OTP"),
	AUTH_REG_FINGER_PRINT					(-1030,"Process finger print"),
	AUTH_REG_CREATE_USER_FAILED				(-1031,"Create user failed"),
	AUTH_NOT_ALLOWED_LOGIN					(-1032,"Anda tidak diizinkan untuk login"),
	AUTH_LOGIN_FINGER_PRINT_FALSE			(-1033,"Login with finger not allowed"),
	AUTH_TRX_FAILED_DIFERRENT_DEVICE		(-1998,"Transaction Cannot be done. Device not same"),

	//-2000
	PARAM_INVALID_VALUES					(-2001, "Invalid param values"),

	//-3000
	RESULT_USERNAME_NOT_EXIST				(-3000, "Result username not exist"),
	RESULT_USER_FULLREG						(-3001, "Result username full reg"),
	RESULT_USER_SEMIREG						(-3002, "Result username semi reg"),
	RESULT_LOGOUT_DEVICEID_NOT_SAME			(-3003, "Result logout device id not same"),
	RESULT_LOGIN_DEVICEID_NOT_SAME			(-3004, "Result login device id not same"),
	RESULT_CHANGE_DEVICE_OTP_NOT_SAME		(-3005, "Result change device otp not same"),
	RESULT_CHANGE_DEVICE_USER_NOT_FOUND		(-3006, "Result change device user not found"),
	RESULT_ALIAS_EXIST						(-3007, "Result alias exist"),

	//-4000
	SERVICE_USERNAME_ALREADY_LOGIN			(-4000, "Username already login"),
	SERVICE_LOGIN_NULL						(-4001, "Service login null"),

	SERVICE_USERNAME_LOGOUT_NOT_SUCCESS		(-4006, "Service username logout not success"),
	
	SERVICE_SEND_SMS_NOT_SUCCESS   			(-4009, "Service send sms not success"),

	SERVICE_BLOCK_USER_NULL					(-4024, "Service block user null"),
	SERVICE_LOGOUT_NULL						(-4025, "Service logout user null"),

	SERVICE_LOGIN_PROFILE_NULL				(-4054, "Service login -  profile is null"),
	
	INVALID_MESSAGE_ID						(-4080, "Invalid Message ID"),

	SERVICE_AUTH_EMAIL_NOT_VERIFIED			(-4100, "Email has not been verified"),
	SERVICE_VERIFICATION_NOT_FOUND			(-4101, "Verification data not found"),
	SERVICE_VERIFICATION_INVALID_DATA		(-4102, "Verification email or phone invalid"),
	SERVICE_EMAIL_VERIFICATION_FAILED		(-4103, "Verification email failed"),
	SERVICE_EMAIL_ALREADY_VERIFIED			(-4104, "Email already verified"),

	SERVICE_RESPONSE_DATA_IS_NULL			(-4900, "Service Response Data is Null"),
	SERVICE_RESPONSE_NOT_SUCCESS			(-4901, "Service Response Data Not Success"), // RC != "00"
	SERVICE_COULD_NOT_GET_ANY_RESPONSE		(-4999, "Service Could not get any response"),

	
	//-5000
	GENERATOR_STRUK_FAILURE					(-5001, "Generate struk failure"),
	TEMPLATE_NOT_FOUND						(-5002, "Generate struk failure"),




	//-8000
	HB_UNABLE_TO_READ_CLOACKS				(-8000, "Unable to read cloacks"),
	HB_SESSION_FACTORY_INVALID				(-8000, "Hibernate invalid session factory"),
	HB_SESSION_FACTORY_CLOSED				(-8001, "Hibernate session factory closed"),
	HB_UNABLE_CREATE_SESSION				(-8002, "Unable create new session"),
	HB_UNABLE_CREATE_STATELESS_SESSION		(-8002, "Unable create new stateless session"),
	HB_UNABLE_CREATE_TRANSACTION			(-8002, "Unable create new transaction"),
	HB_NULL_ENTITY_VIOLATION				(-8002, "Null entity violation"),
	HB_INVALID_ENTITY_TYPE					(-8002, "Invalid entity type"),

	CRYPTO_METHOD_NOT_SUPPORTED				(-8002, "Invalid entity type"),
	ENC_INVALID_KEY							(-8002, "Invalid entity type"),
	ENC_INVALID_CIPHER						(-8002, "Invalid entity type"),

	INVALID_REQUEST_MODEL					(-1400, "Invalid request model"),
	PATH_NOT_FOUND							(-1404, "Path not found"),
	ORM_CRITERION_REQUIRED					(-1906, "Criterion required"),

	CONNECTION_REFUSED						(-9000, "Connection Backend Refused To Connect"),
	BACKEND_SERVICE_06						(-9001, "Terjadi Kesalahan. Silakan coba lagi. Kode : 06"),
	IS_EOD_TIME								(-9002, "Transaksi tidak dapat dilakukan, silahkan coba beberapa saat kembali"),
	CONNECTION_READ_TIMEOUT					(-9068, "Connection read timeout"),
	RESPONSE_PARSING_FAILED					(-9005, "Parsing response failed"),
	CLASS_IMPLEMENT_NOT_FOUND				(-9998, "Class Implement not found"),
	UNEXPECTED_ERROR						(-9999, "Unexpected error"),

	//-7000 PORTAL
	MANDATORY_FIELD						(-7001, "Mandatory field harus diisi"),
	FAILED_LOGIN						(-7100, "Username atau Password salah"),
	FAILED_LOGIN_ALREADY_LOGIN			(-7101, "Username ini telah login dikomputer lain"),
	FAILED_LOGIN_LDAP					(-7102, "Username atau Password LDAP salah"),
	FAILED_PORTAL_ROLE_PRIVILEGE		(-7199, "Tidak memiliki role"),
	SYSCONFIG_ADD_KEY_ALREADY_USE		(-7200, "Code dan module telah digunakan"),
	SYSCONFIG_ADD_KEY_NOT_FOUND			(-7201, "Code dan module tidak ditemukan"),
	FAILED_CHANGE_PASSWORD_NOT_SAME		(-7202, "Password lama tidak sama"),
	FAILED_CHANGE_PASSWORD_NEW_AND_OLD	(-7202, "Password baru tidak boleh dengan password lama"),
	USERNAME_ALREADY_USED				(-7203, "Username telah digunakan"),

	RESP_CODE_ALREADY_USED				(-7900, "Response Code telah digunakan"),
	RESP_CODE_IS_SYSGROUP				(-7901, "Response Code tidak dapat dihapus atau diubah karena termasuk System Group"),
	GROUP_NAME_ALREADY_USED				(-7910, "Nama Response Group telah digunakan"),
	RESP_ID_ALREADY_USED				(-7920, "Handler dan Response Code telah digunakan"),
	PATH_ALREADY_USED					(-7930, "Path telah digunakan"),
	HANDLER_CODE_ALREADY_USED				(-7931, "Handler Code telah digunakan");



	public final int code;
	public final String description;

	/**
	 *
	 * @param code
	 * @param description
	 */
    ErrorType(final int code, final String description) {
		this.code = code;
		this.description = description;
	}

}
