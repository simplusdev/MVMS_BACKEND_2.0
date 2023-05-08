package sg.com.simplus.mvms.framework.response;

 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseMvms<T> {
	

	private String resultCode;

	private Integer httpStatus;

	private String message;

	private T resultData;
	
	public static <T> ResponseEntity<Object> buildResponse(T resultData, String resultCode, HttpStatus httpStatus, String message){
		ResponseMvms<T> response = new ResponseMvms<>();
		response.setResultData(resultData);
		response.setMessage(message);
		response.setResultCode(resultCode);
		response.setHttpStatus( httpStatus.value());
		return  new ResponseEntity<Object>(response,httpStatus);
		
	}

	   public String getResultCode() {
	        return resultCode;
	    }

	    public void setResultCode(String resultCode) {
	        this.resultCode = resultCode;
	    }

	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public T getResultData() {
	        return resultData;
	    }

	    public void setResultData(T resultData) {
	        this.resultData = resultData;
	    }
	    
}
