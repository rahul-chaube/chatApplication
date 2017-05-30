package chaube.rahul.com.chatapplication.model;

/**
 * Created by rahul on 29/5/17.
 */

public class Message {
    private String content;
    private String displayName;
    private String to;
    private String from;
    private long timestamp;
    private String messageType;
    private long fileLength;

    public String getContent() {
        return content;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getMessageType() {
        return messageType;
    }

    public long getFileLength() {
        return fileLength;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public long getMessageStatus() {
        return messageStatus;
    }

    public boolean isRead() {
        return isRead;
    }

    private String downloadLink;
    private long messageStatus;
    private boolean isRead;
   public Message()
    {

    }
    public Message(String content, String displayName, String to, String from,long timestamp,String messageType,
            long fileLength,String downloadLink,long messageStatus,boolean isRead )
    {
        this.content=content;
        this.displayName=displayName;
        this.to=to;
        this.from=from;
        this.timestamp=timestamp;
        this.messageType=messageType;
        this.fileLength=fileLength;
        this.downloadLink=downloadLink;
        this.messageStatus=messageStatus;
        this.isRead=isRead;

    }
}
