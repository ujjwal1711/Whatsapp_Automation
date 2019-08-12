package com.clicdirectory.global;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class UrlDataDecoder {
    final static String userDataUrlSeparater = "#@#"; //#@# unescape
    final static int FOURBYTE = 4;
    final static byte PAD = (byte) '=';

    /**
     * Api to decode byte array to it decoded byte array
     *
     * @param base64Data
     * @return
     */

    public static byte[] decode(byte[] base64Data) {
        // Should we throw away anything not in base64Data ?

        /** The alphabet */
        byte[] BASE64_ALPHABET = new byte[255];

        for (int i = 0; i < 255; i++) {
            BASE64_ALPHABET[i] = -1;
        }
        for (int i = 'Z'; i >= 'A'; i--) {
            BASE64_ALPHABET[i] = (byte) (i - 'A');
        }
        for (int i = 'z'; i >= 'a'; i--) {
            BASE64_ALPHABET[i] = (byte) (i - 'a' + 26);
        }

        for (int i = '9'; i >= '0'; i--) {
            BASE64_ALPHABET[i] = (byte) (i - '0' + 52);
        }

        BASE64_ALPHABET['+'] = 62;
        BASE64_ALPHABET['/'] = 63;


        // handle the edge case, so we don't have to worry about it later
        if (base64Data.length == 0) {
            return new byte[0];
        }

        int numberQuadruple = base64Data.length / FOURBYTE;
        byte decodedData[] = null;
        byte b1 = 0, b2 = 0, b3 = 0, b4 = 0, marker0 = 0, marker1 = 0;

        int encodedIndex = 0;
        int dataIndex = 0;
        {
            // this block sizes the output array properly - rlw
            int lastData = base64Data.length;
            // ignore the '=' padding
            while (base64Data[lastData - 1] == PAD) {
                if (--lastData == 0) {
                    return new byte[0];
                }
            }
            decodedData = new byte[lastData - numberQuadruple];
        }

        for (int i = 0; i < numberQuadruple; i++) {
            dataIndex = i * 4;
            marker0 = base64Data[dataIndex + 2];
            marker1 = base64Data[dataIndex + 3];

            b1 = BASE64_ALPHABET[base64Data[dataIndex]];
            b2 = BASE64_ALPHABET[base64Data[dataIndex + 1]];

            if (marker0 != PAD && marker1 != PAD) {     //No PAD e.g 3cQl
                b3 = BASE64_ALPHABET[marker0];
                b4 = BASE64_ALPHABET[marker1];

                decodedData[encodedIndex] = (byte) (b1 << 2 | b2 >> 4);
                decodedData[encodedIndex + 1] = (byte) (((b2 & 0xf) << 4)
                        | ((b3 >> 2) & 0xf));
                decodedData[encodedIndex + 2] = (byte) (b3 << 6 | b4);
            } else if (marker0 == PAD) {    //Two PAD e.g. 3c[Pad][Pad]
                decodedData[encodedIndex] = (byte) (b1 << 2 | b2 >> 4);
            } else if (marker1 == PAD) {    //One PAD e.g. 3cQ[Pad]
                b3 = BASE64_ALPHABET[marker0];
                decodedData[encodedIndex] = (byte) (b1 << 2 | b2 >> 4);
                decodedData[encodedIndex + 1] = (byte) (((b2 & 0xf) << 4)
                        | ((b3 >> 2) & 0xf));
            }
            encodedIndex += 3;
        }
        return decodedData;
    }

    /**
     * decodes the string in base64 encoded form
     *
     * @param encoded String to be encoded in base64 format.
     * @return base64 decoded conversion of string
     */
    public static String decodeBase64(String encoded) throws UnsupportedEncodingException {
        byte[] bytes = decode(encoded.getBytes());
        String str = new String(bytes, "UTF-8");
        return str;
    }

    public static String[] getUserDataUrls(String encodeddata) throws UnsupportedEncodingException {

        String doubleDecodeData = URLDecoder.decode(URLDecoder.decode(encodeddata, "UTF-8"), "UTF-8");
        String data = decodeBase64(doubleDecodeData);
        String[] userDataContentUrls = data.split(userDataUrlSeparater);

        return userDataContentUrls;
    }

}
