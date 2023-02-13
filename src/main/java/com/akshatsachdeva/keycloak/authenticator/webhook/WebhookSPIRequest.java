package com.akshatsachdeva.keycloak.authenticator.webhook;

public class WebhookSPIRequest {
	private String userIdentifier;
	private String otp;
	private long otpExpiryTimestamp;

	public WebhookSPIRequest(String userIdentifier, String otp, long otpExpiryTimestamp) {
		super();
		this.userIdentifier = userIdentifier;
		this.otp = otp;
		this.otpExpiryTimestamp = otpExpiryTimestamp;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public String getOtp() {
		return otp;
	}

	public long getOtpExpiryTimestamp() {
		return otpExpiryTimestamp;
	}

	@Override
	public String toString() {
		return "WebhookSPIRequest [userIdentifier=" + userIdentifier + ", otp=" + otp + ", otpExpiryTimestamp="
				+ otpExpiryTimestamp + "]";
	}

}
