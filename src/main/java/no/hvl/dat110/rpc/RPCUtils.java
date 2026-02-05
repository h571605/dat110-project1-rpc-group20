package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		// TODO - START
		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format
		int length = 0;
		if(payload != null){
			length = payload.length;
		}
		byte[] rpcmsg = null;
		rpcmsg = new byte[1 + length];
		rpcmsg[0] = rpcid;
		if (payload != null) {
			System.arraycopy(payload, 0, rpcmsg, 1, length);
		}
		// TODO - END
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = null;
		// TODO - START
		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
		if (rpcmsg.length <= 1) {
			return new byte[0];
		}
		payload = Arrays.copyOfRange(rpcmsg, 1, rpcmsg.length);
		
		// TODO - END
		
		return payload;
		
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {
		
		byte[] encoded = null;
		// TODO - START 
		if(str != null){
			encoded = str.getBytes();
		} else{
			encoded = new byte[0];
		}
		
		// TODO - END
		
		return encoded;
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		
		String decoded = null;
		// TODO - START
		decoded = new String(data);

		// TODO - END
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		
		byte[] encoded = null;
		// TODO - START 
		encoded = new byte[0];

		// TODO - END
		
		return encoded;
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
		// TODO
		// nothing
		
	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded = null;
		// TODO - START 
		encoded = ByteBuffer.allocate(4).putInt(x).array();
		
		// TODO - END
		
		return encoded;
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		int decoded = 0;
		// TODO - START 
		decoded = ByteBuffer.wrap(data).getInt();

		
		// TODO - END
		
		return decoded;
		
	}
}
