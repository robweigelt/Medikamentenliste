package r.w;

public class Encryption {
    private byte masterkey;
    private byte CreateKey(){
        masterkey = 111;
        return masterkey;
    }
    private void SimpleEncryption(byte MasterKey, byte[] bytes) {
        for(int i=0; i<bytes.length; i++)
            bytes[i] = (byte) (bytes[i]^MasterKey);
    }
}
