package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class DisplayStub extends RPCLocalStub {

	public DisplayStub(RPCClient rpcclient) {
		super(rpcclient);
	}
	
	public void write (String message) {
		// TODO - START
		// implement marshalling, call and unmarshalling for write RPC method
		byte[] param = RPCUtils.marshallString(message);
		byte rpcid = 1;
		byte[] reply = rpcclient.call(rpcid, param);
		RPCUtils.unmarshallVoid(reply);

		// TODO - END
		
	}
}
