package cap_software.hrms.core.results;

public class SuccesResult extends Result{

	public SuccesResult() {
		
		super(true);
	}

	public SuccesResult(String message)
	{
		super(true,message);
	}
	
}
