package com.akshatsachdeva.keycloak.authenticator;

import java.util.List;

import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.provider.ProviderConfigurationBuilder;

import com.akshatsachdeva.keycloak.authenticator.models.OTPWebhookAuthenticatorConfigEnums;

public class OTPWebhookAuthenticatorFactory implements AuthenticatorFactory {

	public static final String PROVIDER_ID = "otp-webhook-authenticator";

	@Override
	public String getId() {
		return PROVIDER_ID;
	}

	@Override
	public String getDisplayType() {
		return "OTP Webhook Authenticator";
	}

	@Override
	public String getHelpText() {
		return "Validate OTP sent via Webhook";
	}

	@Override
	public String getReferenceCategory() {
		return "otp";
	}

	@Override
	public boolean isConfigurable() {
		return true;
	}

	@Override
	public boolean isUserSetupAllowed() {
		return true;
	}

	@Override
	public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
		return REQUIREMENT_CHOICES;
	}


	@Override
	public List<ProviderConfigProperty> getConfigProperties() {
		// @formatter:off
		return ProviderConfigurationBuilder.create()
				.property()
					.name(OTPWebhookAuthenticatorConfigEnums.OTP_LENGTH.getKey())
					.label("OTP length")
					.helpText("The number of digits of the generated code")
					.type(ProviderConfigProperty.STRING_TYPE)
					.defaultValue("6")
				.add()
				
				.property()
					.name(OTPWebhookAuthenticatorConfigEnums.OTP_EXPIRY_SECONDS.getKey())
					.label("Expiry Seconds")
					.helpText("The time in seconds for which the OTP will be valid")
					.type(ProviderConfigProperty.STRING_TYPE)
					.defaultValue("300")
				.add()
				
				.property()
					.name(OTPWebhookAuthenticatorConfigEnums.USER_IDENT_ATTR.getKey())
					.label("User Identifying Attribute")
					.helpText("The User Attribute to be sent in Webhook to identify user")
					.type(ProviderConfigProperty.STRING_TYPE)
				.add()
				
				.property()
					.name(OTPWebhookAuthenticatorConfigEnums.ALLOWED_CHARS.getKey())
					.label("Allowed OTP Characters")
					.helpText("The Characters to be used to generate the OTP")
					.type(ProviderConfigProperty.STRING_TYPE)
				.add()
				
				.property()
					.name(OTPWebhookAuthenticatorConfigEnums.WEBHOOK.getKey())
					.label("OTP Sending Webhook")
					.helpText("The webhook which will be triggered to send a generated OTP")
					.type(ProviderConfigProperty.STRING_TYPE)
				.add()
				
				.property()
					.name(OTPWebhookAuthenticatorConfigEnums.TIMEOUT_SECONDS.getKey())
					.label("Timeout Seconds")
					.helpText("The Webhook Timeout in seconds")
					.type(ProviderConfigProperty.STRING_TYPE)
				.add()
				
				.property()
					.name(OTPWebhookAuthenticatorConfigEnums.ENABLE_LOGGING.getKey())
					.label("Enable Logging")
					.helpText("Enable logs for debugging")
					.type(ProviderConfigProperty.BOOLEAN_TYPE)
				.add()
				
			.build();
		// @formatter:on
	}


	@Override
	public Authenticator create(KeycloakSession session) {
		return new OTPWebhookAuthenticator();
	}

	@Override
	public void init(Config.Scope config) { // no action
	}

	@Override
	public void postInit(KeycloakSessionFactory factory) { // no action
	}

	@Override
	public void close() { // no action
	}

}
