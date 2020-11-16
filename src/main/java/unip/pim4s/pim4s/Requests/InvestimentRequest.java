package unip.pim4s.pim4s.Requests;

public class InvestimentRequest {

	private String value;
	private String time;
	private String description;
	private String clientId;
	private String returnSpectValue;

	public InvestimentRequest(String value, String time, String description, String clientId) {
		super();
		this.value = value;
		this.time = time;
		this.description = description;
		this.clientId = clientId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getReturnSpectValue() {
		return returnSpectValue;
	}

	public void setReturnSpectValue(String returnSpectValue) {
		this.returnSpectValue = returnSpectValue;
	}

}
