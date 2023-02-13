package com.akshatsachdeva.keycloak.authenticator.models;

public enum OTPWebhookAuthenticatorConfigEnums {
	// @formatter:off
	OTP_LENGTH("otpLength"),
	OTP_EXPIRY_SECONDS("otpExpirySeconds"),
	USER_IDENT_ATTR("userIdentifyingAttribute"),
	ALLOWED_CHARS("allowedChars"),	
	WEBHOOK("webhook"),
	TIMEOUT_SECONDS("timeoutSeconds"),
	ENABLE_LOGGING("enableLogging"),
	;
	// @formatter:on
	
	private String key;

	public String getKey() {
		return key;
	}

	private OTPWebhookAuthenticatorConfigEnums(String key) {
		this.key = key;
	}

}
