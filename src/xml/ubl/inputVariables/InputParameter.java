package xml.ubl.inputVariables;

public class InputParameter {
	private String CustomizationId;

	public String getCustomizationId() {
		return CustomizationId;
	}

	public void setCustomizationId(String customizationId) {
		CustomizationId = customizationId;
	}

	@Override
	public String toString() {
		return "InputParameter [CustomizationId=" + CustomizationId + "]";
	}
	

}
