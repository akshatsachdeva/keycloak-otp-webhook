package com.akshatsachdeva.keycloak.authenticator.models;

import java.net.URI;
import java.util.Arrays;

public class OTPWebhookAuthenticatorConfig {

	int otpLength;
	long otpExpirySeconds;
	String userIdentifyingAttribute;
	char[] allowedChars;
	URI webhook;
	long timeoutSeconds;
	boolean enableLogging;

	public int getOtpLength() {
		return otpLength;
	}

	public void setOtpLength(int otpLength) {
		this.otpLength = otpLength;
	}

	public long getOtpExpirySeconds() {
		return otpExpirySeconds;
	}

	public void setOtpExpirySeconds(long otpExpirySeconds) {
		this.otpExpirySeconds = otpExpirySeconds;
	}

	public String getUserIdentifyingAttribute() {
		return userIdentifyingAttribute;
	}

	public void setUserIdentifyingAttribute(String userIdentifyingAttribute) {
		this.userIdentifyingAttribute = userIdentifyingAttribute;
	}

	public char[] getAllowedChars() {
		return allowedChars;
	}

	public void setAllowedChars(char[] allowedChars) {
		this.allowedChars = allowedChars;
	}

	public URI getWebhook() {
		return webhook;
	}

	public void setWebhook(URI webhook) {
		this.webhook = webhook;
	}

	public long getTimeoutSeconds() {
		return timeoutSeconds;
	}

	public void setTimeoutSeconds(long timeoutSeconds) {
		this.timeoutSeconds = timeoutSeconds;
	}

	public boolean isEnableLogging() {
		return enableLogging;
	}

	public void setEnableLogging(boolean enableLogging) {
		this.enableLogging = enableLogging;
	}

	@Override
	public String toString() {
		return "OTPWebhookAuthenticatorConfig [length=" + otpLength + ", expirySeconds=" + otpExpirySeconds
				+ ", userIdentifyingAttribute="
				+ userIdentifyingAttribute + ", allowedChars=" + Arrays.toString(allowedChars) + ", webhook=" + webhook
				+ ", timeoutSeconds=" + timeoutSeconds + ", enableLogging=" + enableLogging + "]";
	}

}
