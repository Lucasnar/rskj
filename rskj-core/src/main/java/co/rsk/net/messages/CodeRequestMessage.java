package co.rsk.net.messages;

import org.ethereum.util.RLP;

public class CodeRequestMessage extends MessageWithId {
    private long id;
    private byte[] blockHash;
    private byte[] codeHash;

    public CodeRequestMessage(long id, byte[] blockHash, byte[] codeHash) {
        this.id = id;
        this.blockHash = blockHash;
        this.codeHash = codeHash;
    }

    @Override
    public long getId() {
        return this.id;
    }

    public byte[] getBlockHash() {
        return blockHash;
    }

    public byte[] getCodeHash() {
        return codeHash;
    }

    @Override
    protected byte[] getEncodedMessageWithoutId() {
        byte[] rlpBlockHash = RLP.encodeElement(this.blockHash);
        byte[] rlpCodeHash = RLP.encodeElement(this.codeHash);
        return RLP.encodeList(rlpBlockHash, rlpCodeHash);
    }

    @Override
    public MessageType getMessageType() {
        return MessageType.CODE_REQUEST_MESSAGE;
    }

    @Override
    public void accept(MessageVisitor v) {

    }
}
