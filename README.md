# Keycloak OTP Webhook Authenticator
A Keycloak authentication provider which will generate random OTPs, save them with Keycloak for verification, and trigger an external webhook (for example, of any SMS or Email service which can be used to send these OTPs to the user)

## Step 1 Add Authenticator
<img width="1154" alt="Step 1 Add Authenticator" src="https://user-images.githubusercontent.com/30401200/218395587-b7efec10-4e9a-41c9-9c2b-2a0fb69b9873.png">
<img width="1223" alt="Step 1 1" src="https://user-images.githubusercontent.com/30401200/218395449-4b7807c2-b378-40f1-b699-3a0fb23c61b0.png">

## Step 2 Configure Authenticator
Parameters that can be configured-
1. OTP length: Length of the OTP to be generated, OTP generation is done via org.keycloak.common.util.SecretGenerator.getInstance().randomString()
2. Expiry Seconds: OTP Expiry in seconds after which the OTP will expire and verification must be restarted
3. User Identifying Attribute: The name of the user attribute whose value will be sent to the webhook in request body, (this will be used to identify the user)
4. Allowed OTP Characters: All the OTP Characters allowed, for example: 0123456789 for the OTP to be numeric only
5. OTP Sending Webhook: The url which will be triggered when an OTP is generated for authentication (see Webhook SPI Integration below)
6. Timeout Seconds: Seconds after which the OTP must expire
7. Enable Logging: To enable logging of all webhook requests and responses

Keycloak Auth Notes used-
1. OTP: The OTP which will be used for verification
2. OTP_EXPIRY: The OTP Expiry EPOCH Timestamp, after which the OTP will expire and verification must be restarted

User Parameters used-
1. ENABLE_OTP: Default true, OTP Authenticator can be skipped for a user by setting this parameter as false

<img width="949" alt="Step 2 Configure Authenticator" src="https://user-images.githubusercontent.com/30401200/218395527-0a315c4b-3bb5-4e9e-9c1f-12935aa5b81f.png">

## Step 3 Set User Identifying Attribute
<img width="1206" alt="Step 3 Set User Identifying Attribute" src="https://user-images.githubusercontent.com/30401200/218395536-de3f5870-444b-43d5-b0eb-35a9eb462a1d.png">

## Authnetication UI
<img width="747" alt="Step 4" src="https://user-images.githubusercontent.com/30401200/218395533-fec8b4e7-1aaa-40f4-9737-40a5894a1a96.png">

## Webhook SPI Integration
To send a request to provided webhook, Java 11's internal HttpClient.newHttpClient() is generated on startup and used further
'Timeout Seconds' provided in Authenticator config are configured with every request sent via HttpClient
'Enable Logging' parameter ensures logging of request and response between Keycloak and the webhook
Request Body is a JSON request with the following parameters-
1. otp: The OTP for verification
2. userIdentifier: The value of 'User Identifying Attribute' for the user who is being authenticated
3. otpExpiryTimestamp: The OTP Expiry EPOCH Timestamp after which the OTP will expire
Request Method used is POST

Any response status code >= 400 from the webhook will be considered a failure and an error message will be displayed to the user
