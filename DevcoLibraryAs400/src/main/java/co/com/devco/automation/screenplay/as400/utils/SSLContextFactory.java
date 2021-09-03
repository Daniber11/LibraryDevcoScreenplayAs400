package co.com.devco.automation.screenplay.as400.utils;

import org.apache.jmeter.util.CustomX509TrustManager;

import javax.net.ssl.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;

public class SSLContextFactory {

    private static final SecureRandom RAND = new SecureRandom();


    public static SSLContext buildSSLContext(String sslType) throws GeneralSecurityException, IOException {
        SSLContext context = SSLContext.getInstance(sslType);
        KeyManager[] keyManagers = buildKeyManagerFactory().getKeyManagers();
        TrustManager[] trustManagers = buildTrustManagerFactory().getTrustManagers();

        for (int i = 0; i < trustManagers.length; ++i) {
            if (trustManagers[i] instanceof X509TrustManager) {
                trustManagers[i] = new CustomX509TrustManager((X509TrustManager) trustManagers[i]);
            }
        }

        context.init(keyManagers, trustManagers, RAND);
        return context;
    }

    private static KeyManagerFactory buildKeyManagerFactory() throws GeneralSecurityException, IOException {
        KeyManagerFactory factory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        String pass = getKeyStorePassword();
        factory.init(buildKeyStore(getKeyStore(), pass), pass == null ? null : pass.toCharArray());
        return factory;
    }

    private static String getKeyStorePassword() {
        return System.getProperty("javax.net.ssl.keyStorePassword");
    }

    private static KeyStore buildKeyStore(String storeFileName, String pass) throws GeneralSecurityException, IOException {
        FileInputStream storeInputStream = storeFileName != null && (new File(storeFileName)).exists() ? new FileInputStream(storeFileName) : null;
        KeyStore store = KeyStore.getInstance(KeyStore.getDefaultType());
        store.load(storeInputStream, pass == null ? null : pass.toCharArray());
        return store;
    }

    private static String getKeyStore() {
        return System.getProperty("javax.net.ssl.keyStore");
    }

    private static TrustManagerFactory buildTrustManagerFactory() throws GeneralSecurityException, IOException {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        String trustStore = getTrustStore();
        factory.init(trustStore == null ? null : buildKeyStore(trustStore, getTrustStorePassword()));
        return factory;
    }

    private static String getTrustStore() {
        return System.getProperty("javax.net.ssl.trustStore");
    }

    private static String getTrustStorePassword() {
        return System.getProperty("javax.net.ssl.trustStorePassword");
    }


}
