package co.rsk.net.messages;

import org.ethereum.util.RLP;

public class CodeRequestMessage extends MessageWithId {
    private long id;
    private byte[] blockHash;
    private byte[] address;

    public CodeRequestMessage(long id, byte[] blockHash, byte[] address) {
        this.id = id;
        this.blockHash = blockHash;
        this.address = address;
    }

    @Override
    public long getId() {
        return this.id;
    }

    public byte[] getBlockHash() {
        return blockHash;
    }

    public byte[] getAddress() {
        return address;
    }

    @Override
    protected byte[] getEncodedMessageWithoutId() {
        byte[] rlpBlockHash = RLP.encodeElement(this.blockHash);
        byte[] rlpCodeHash = RLP.encodeElement(this.address);
        return RLP.encodeList(rlpBlockHash, rlpCodeHash);
    }

    @Override
    public MessageType getMessageType() {
        return MessageType.CODE_REQUEST_MESSAGE;
    }

    @Override
    public void accept(MessageVisitor v) {
        v.apply(this);
    }
}
