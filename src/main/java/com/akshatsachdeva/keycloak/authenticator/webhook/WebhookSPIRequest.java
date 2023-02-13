package com.akshatsachdeva.keycloak.authenticator.webhook;

public class WebhookSPIRequest {
	private String userIdentifier;
	private String otp;

	public WebhookSPIRequest(String userIdentifier, String otp) {
		super();
		this.userIdentifier = userIdentifier;
		this.otp = otp;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public String getOtp() {
		return otp;
	}

	@Override
	public String toString() {
		return "WebhookRequest [userIdentifier=" + userIdentifier + ", otp=" + otp + "]";
	}

}
