package cap_software.hrms.core.results;

public class DataResult<T> extends Result {

	
	private T data;
	public DataResult(T data, boolean success, String message) {
		super(success, message);
	
		this.data=data;
	}

	
	public T getData()
	{
		
		return this.data;
	}

	
	

}
