
package uow.csse.bptzz.model.result;

/**
 * Exception Message and Code
 *
 * @author 	Tab Tu
 * @update	Oct.11 2017
 * @version	1.0
 */

public enum ExceptionMsg {
	SUCCESS("000000", "Operation Succed"),
	FAILED("999999","Operation Failed"),
    ParamError("000001", "Params Error"),
    
    LoginNameOrPassWordError("000100", "Username or Password Invaild."),
    EmailUsed("000101","This email address has already been used."),
    UserNameUsed("000102","This username has already been used."),
    EmailNotRegister("000103","This email address is not registed."),
    LinkOutdated("000104","The link has expired, please request again."),
    PassWordError("000105","Password Invaild."),
    UserNameLengthLimit("000106","Username Length over limit."),
    LoginNameNotExists("000107","This username has not registed."),
    UserNameSame("000108","New username is the same as old one."),

    FileEmpty("000400","Upload file is null."),
    LimitPictureSize("000401","File size must less than 2M"),
    LimitPictureType("000402","File type must be 'jpg', 'png', 'jpge', 'gif', 'bmp'")
    ;
   private ExceptionMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;
    
	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}

    
}

