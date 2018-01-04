package MagicStay;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Message {
  private Account sender;
  private Account receiver;
  private String content;
  private Message inReplyTo;

  public void cg_init_Message_1(final Account s, final Account r, final String c, final Message m) {

    sender = s;
    receiver = r;
    content = c;
    inReplyTo = m;
    receiver.addMessage(this);
  }

  public Message(final Account s, final Account r, final String c, final Message m) {

    cg_init_Message_1(s, r, c, m);
  }

  public VDMSeq getConversation() {

    if (!(Utils.equals(inReplyTo, null))) {
      return SeqUtil.conc(inReplyTo.getConversation(), SeqUtil.seq(this));

    } else {
      return SeqUtil.seq(this);
    }
  }

  public Account getSender() {

    return sender;
  }

  public Account getReceiver() {

    return receiver;
  }

  public String getContent() {

    return content;
  }

  public Message() {}

  public String toString() {

    return "Message{"
        + "sender := "
        + Utils.toString(sender)
        + ", receiver := "
        + Utils.toString(receiver)
        + ", content := "
        + Utils.toString(content)
        + ", inReplyTo := "
        + Utils.toString(inReplyTo)
        + "}";
  }
}
