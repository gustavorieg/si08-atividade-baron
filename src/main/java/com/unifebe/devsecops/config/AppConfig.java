package com.unifebe.devsecops.config;

/**
 * Configuracoes sensiveis sao lidas do ambiente em tempo de execucao.
 * Em producao, essas variaveis devem ser fornecidas por um cofre de
 * segredos (como Vault ou AWS Secrets Manager), e nao pelo codigo-fonte.
 */
public final class AppConfig {

    private AppConfig() {
    }

    public static String getDbPassword() {
        return System.getenv("DB_PASSWORD");
    }

    public static String getAwsAccessKeyId() {
        return System.getenv("AWS_ACCESS_KEY_ID");
    }

    public static String getAwsSecretAccessKey() {
        return System.getenv("AWS_SECRET_ACCESS_KEY");
    }

    public static String getPaymentGatewayApiKey() {
        return System.getenv("PAYMENT_GATEWAY_API_KEY");
    }
}
