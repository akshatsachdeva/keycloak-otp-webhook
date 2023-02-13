# Keycloak OTP Webhook Authenticator
A Keycloak authentication provider which will generate random OTPs, save them with Keycloak for verification, and trigger an external webhook (for example, of any SMS or Email service which can be used to send these OTPs to the user)
