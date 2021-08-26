import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Yihuotest {
   public static final BASE64Encoder encoder = new BASE64Encoder();
   public static final BASE64Decoder decoder = new BASE64Decoder();
   public static byte KEY=0X66;
   public static String I="扲}";
    public static void main(String[] args) throws IOException {
        String i2 = encoder.encode(I.getBytes("gbk"));
        System.out.println(i2);
        System.out.println(Encode(i2, KEY));
        System.out.println(Encode("\u001E))P\u0011\u0011[[", KEY));
        System.out.println(new String(decoder.decodeBuffer(Encode(Encode(i2, KEY), KEY)), "gbk"));

        System.out.println(Encode(I,KEY));


    }
    public static String Encode(String s,byte c){
        int code = c; // 密钥
        char[] charArray = s.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            if(!(charArray[i]==0x13||charArray[i]==0x10||charArray[i]==0x20||charArray[i]==0x9)) {


                charArray[i] = (char) (charArray[i] ^ code);
            }
        }            return new String(charArray);

    }


//        public static String decode (String dec){
//            byte[] e = dec.getBytes(StandardCharsets.US_ASCII);
//            byte[] dee = e;
//            for (int i = 0, size = e.length; i < size; i++) {
//                for (byte keyBytes0 : keyBytes) {
//                    e[i] = (byte) (dee[i] ^ keyBytes0);
//                }
//            }
//            return new String(e);
//        }


    }