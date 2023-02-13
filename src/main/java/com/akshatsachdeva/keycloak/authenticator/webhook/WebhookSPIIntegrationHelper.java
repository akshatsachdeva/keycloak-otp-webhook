package com.akshatsachdeva.keycloak.authenticator.webhook;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import org.jboss.logging.Logger;

public class WebhookSPIIntegrationHelper {
	private WebhookSPIIntegrationHelper() {
	}

	private static final Logger LOGGER = Logger.getLogger(WebhookSPIIntegrationHelper.class);
	private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

	public static HttpResponse<String> trigger(URI uri, long timeoutSeconds, String requestBody, boolean enableLogging)
			throws IOException, InterruptedException {
		if (enableLogging) {
			LOGGER.info("Sending request: " + requestBody + ", to url: " + uri);
		}

		// @formatter:off
		HttpRequest request = HttpRequest.newBuilder()
				.uri(uri)
				.timeout(Duration.ofSeconds(timeoutSeconds))
				.header("Content-Type", "application/json")
				.POST(BodyPublishers.ofString(requestBody))
			.build();
		// @formatter:on

		HttpResponse<String> response = HTTP_CLIENT.send(request, BodyHandlers.ofString());
		if (enableLogging) {
			LOGGER.info("Response from Webhook- HTTP Status: " + response.statusCode() + ", body: " + response.body());
		}
		return response;

	}

}
