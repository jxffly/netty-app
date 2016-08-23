// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: any.proto

package com.seeplant.protobuf;

/**
 * Protobuf type {@code seeplant.protobuf.Ping}
 */
public  final class Ping extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:seeplant.protobuf.Ping)
    PingOrBuilder {
  // Use Ping.newBuilder() to construct.
  private Ping(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private Ping() {
    msgType_ = 0;
    userType_ = "";
    uid_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private Ping(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry) {
    this();

    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {
            int rawValue = input.readEnum();

            msgType_ = rawValue;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            userType_ = s;
            break;
          }
          case 24: {

            uid_ = input.readInt64();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw new RuntimeException(e.setUnfinishedMessage(this));
    } catch (java.io.IOException e) {
      throw new RuntimeException(
          new com.google.protobuf.InvalidProtocolBufferException(
              e.getMessage()).setUnfinishedMessage(this));
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.seeplant.protobuf.ProtoMsg.internal_static_seeplant_protobuf_Ping_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.seeplant.protobuf.ProtoMsg.internal_static_seeplant_protobuf_Ping_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.seeplant.protobuf.Ping.class, com.seeplant.protobuf.Ping.Builder.class);
  }

  public static final int MSGTYPE_FIELD_NUMBER = 1;
  private int msgType_;
  /**
   * <code>optional .seeplant.protobuf.MsgType msgType = 1;</code>
   */
  public int getMsgTypeValue() {
    return msgType_;
  }
  /**
   * <code>optional .seeplant.protobuf.MsgType msgType = 1;</code>
   */
  public com.seeplant.protobuf.MsgType getMsgType() {
    com.seeplant.protobuf.MsgType result = com.seeplant.protobuf.MsgType.valueOf(msgType_);
    return result == null ? com.seeplant.protobuf.MsgType.UNRECOGNIZED : result;
  }

  public static final int USERTYPE_FIELD_NUMBER = 2;
  private volatile java.lang.Object userType_;
  /**
   * <code>optional string userType = 2;</code>
   */
  public java.lang.String getUserType() {
    java.lang.Object ref = userType_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      userType_ = s;
      return s;
    }
  }
  /**
   * <code>optional string userType = 2;</code>
   */
  public com.google.protobuf.ByteString
      getUserTypeBytes() {
    java.lang.Object ref = userType_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      userType_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int UID_FIELD_NUMBER = 3;
  private long uid_;
  /**
   * <code>optional int64 uid = 3;</code>
   */
  public long getUid() {
    return uid_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (msgType_ != com.seeplant.protobuf.MsgType.LOGIN.getNumber()) {
      output.writeEnum(1, msgType_);
    }
    if (!getUserTypeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, userType_);
    }
    if (uid_ != 0L) {
      output.writeInt64(3, uid_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (msgType_ != com.seeplant.protobuf.MsgType.LOGIN.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, msgType_);
    }
    if (!getUserTypeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, userType_);
    }
    if (uid_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, uid_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.seeplant.protobuf.Ping)) {
      return super.equals(obj);
    }
    com.seeplant.protobuf.Ping other = (com.seeplant.protobuf.Ping) obj;

    boolean result = true;
    result = result && msgType_ == other.msgType_;
    result = result && getUserType()
        .equals(other.getUserType());
    result = result && (getUid()
        == other.getUid());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + MSGTYPE_FIELD_NUMBER;
    hash = (53 * hash) + msgType_;
    hash = (37 * hash) + USERTYPE_FIELD_NUMBER;
    hash = (53 * hash) + getUserType().hashCode();
    hash = (37 * hash) + UID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getUid());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.seeplant.protobuf.Ping parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.seeplant.protobuf.Ping parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.seeplant.protobuf.Ping parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.seeplant.protobuf.Ping parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.seeplant.protobuf.Ping parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static com.seeplant.protobuf.Ping parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static com.seeplant.protobuf.Ping parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static com.seeplant.protobuf.Ping parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static com.seeplant.protobuf.Ping parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static com.seeplant.protobuf.Ping parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.seeplant.protobuf.Ping prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code seeplant.protobuf.Ping}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:seeplant.protobuf.Ping)
      com.seeplant.protobuf.PingOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.seeplant.protobuf.ProtoMsg.internal_static_seeplant_protobuf_Ping_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.seeplant.protobuf.ProtoMsg.internal_static_seeplant_protobuf_Ping_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.seeplant.protobuf.Ping.class, com.seeplant.protobuf.Ping.Builder.class);
    }

    // Construct using com.seeplant.protobuf.Ping.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      msgType_ = 0;

      userType_ = "";

      uid_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.seeplant.protobuf.ProtoMsg.internal_static_seeplant_protobuf_Ping_descriptor;
    }

    public com.seeplant.protobuf.Ping getDefaultInstanceForType() {
      return com.seeplant.protobuf.Ping.getDefaultInstance();
    }

    public com.seeplant.protobuf.Ping build() {
      com.seeplant.protobuf.Ping result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.seeplant.protobuf.Ping buildPartial() {
      com.seeplant.protobuf.Ping result = new com.seeplant.protobuf.Ping(this);
      result.msgType_ = msgType_;
      result.userType_ = userType_;
      result.uid_ = uid_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.seeplant.protobuf.Ping) {
        return mergeFrom((com.seeplant.protobuf.Ping)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.seeplant.protobuf.Ping other) {
      if (other == com.seeplant.protobuf.Ping.getDefaultInstance()) return this;
      if (other.msgType_ != 0) {
        setMsgTypeValue(other.getMsgTypeValue());
      }
      if (!other.getUserType().isEmpty()) {
        userType_ = other.userType_;
        onChanged();
      }
      if (other.getUid() != 0L) {
        setUid(other.getUid());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.seeplant.protobuf.Ping parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.seeplant.protobuf.Ping) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int msgType_ = 0;
    /**
     * <code>optional .seeplant.protobuf.MsgType msgType = 1;</code>
     */
    public int getMsgTypeValue() {
      return msgType_;
    }
    /**
     * <code>optional .seeplant.protobuf.MsgType msgType = 1;</code>
     */
    public Builder setMsgTypeValue(int value) {
      msgType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional .seeplant.protobuf.MsgType msgType = 1;</code>
     */
    public com.seeplant.protobuf.MsgType getMsgType() {
      com.seeplant.protobuf.MsgType result = com.seeplant.protobuf.MsgType.valueOf(msgType_);
      return result == null ? com.seeplant.protobuf.MsgType.UNRECOGNIZED : result;
    }
    /**
     * <code>optional .seeplant.protobuf.MsgType msgType = 1;</code>
     */
    public Builder setMsgType(com.seeplant.protobuf.MsgType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      msgType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional .seeplant.protobuf.MsgType msgType = 1;</code>
     */
    public Builder clearMsgType() {
      
      msgType_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object userType_ = "";
    /**
     * <code>optional string userType = 2;</code>
     */
    public java.lang.String getUserType() {
      java.lang.Object ref = userType_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        userType_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string userType = 2;</code>
     */
    public com.google.protobuf.ByteString
        getUserTypeBytes() {
      java.lang.Object ref = userType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        userType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string userType = 2;</code>
     */
    public Builder setUserType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      userType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string userType = 2;</code>
     */
    public Builder clearUserType() {
      
      userType_ = getDefaultInstance().getUserType();
      onChanged();
      return this;
    }
    /**
     * <code>optional string userType = 2;</code>
     */
    public Builder setUserTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      userType_ = value;
      onChanged();
      return this;
    }

    private long uid_ ;
    /**
     * <code>optional int64 uid = 3;</code>
     */
    public long getUid() {
      return uid_;
    }
    /**
     * <code>optional int64 uid = 3;</code>
     */
    public Builder setUid(long value) {
      
      uid_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 uid = 3;</code>
     */
    public Builder clearUid() {
      
      uid_ = 0L;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:seeplant.protobuf.Ping)
  }

  // @@protoc_insertion_point(class_scope:seeplant.protobuf.Ping)
  private static final com.seeplant.protobuf.Ping DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.seeplant.protobuf.Ping();
  }

  public static com.seeplant.protobuf.Ping getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Ping>
      PARSER = new com.google.protobuf.AbstractParser<Ping>() {
    public Ping parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      try {
        return new Ping(input, extensionRegistry);
      } catch (RuntimeException e) {
        if (e.getCause() instanceof
            com.google.protobuf.InvalidProtocolBufferException) {
          throw (com.google.protobuf.InvalidProtocolBufferException)
              e.getCause();
        }
        throw e;
      }
    }
  };

  public static com.google.protobuf.Parser<Ping> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Ping> getParserForType() {
    return PARSER;
  }

  public com.seeplant.protobuf.Ping getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

