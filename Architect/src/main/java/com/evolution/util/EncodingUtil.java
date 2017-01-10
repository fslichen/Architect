package com.evolution.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.codec.binary.Base64OutputStream;

public class EncodingUtil {
    public static String encodeEcgSignal(short[] ecg) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, true, 0, null);
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new GZIPOutputStream(base64OutputStream));
            dataOutputStream.writeInt(ecg.length);
            for(short v : ecg) {
            	dataOutputStream.writeShort(v);
            }
            dataOutputStream.close();
            byteArrayOutputStream.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return byteArrayOutputStream.toString();
    }

    public static float[] decodeEcgSignal(String encoded) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(encoded.getBytes());
        Base64InputStream base64InputStream = new Base64InputStream(byteArrayInputStream);
        try {
            DataInputStream dataInputStream = new DataInputStream(new GZIPInputStream(base64InputStream));
            int length = dataInputStream.readInt();
            float ecg[] = new float[length];
            for(int i = 0; i < length; i++) {
                ecg[i] = dataInputStream.readShort() / 2048f;
            }
            dataInputStream.close();
            return ecg;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
