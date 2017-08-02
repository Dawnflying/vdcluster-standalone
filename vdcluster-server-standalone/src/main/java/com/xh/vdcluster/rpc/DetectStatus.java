/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.xh.vdcluster.rpc;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-07-29")
public class DetectStatus implements org.apache.thrift.TBase<DetectStatus, DetectStatus._Fields>, java.io.Serializable, Cloneable, Comparable<DetectStatus> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DetectStatus");

  private static final org.apache.thrift.protocol.TField SERVICE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("serviceId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField STREAM_STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("streamStatus", org.apache.thrift.protocol.TType.I32, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new DetectStatusStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new DetectStatusTupleSchemeFactory();

  public String serviceId; // required
  /**
   * 
   * @see SeviceStatusType
   */
  public SeviceStatusType streamStatus; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SERVICE_ID((short)1, "serviceId"),
    /**
     * 
     * @see SeviceStatusType
     */
    STREAM_STATUS((short)2, "streamStatus");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SERVICE_ID
          return SERVICE_ID;
        case 2: // STREAM_STATUS
          return STREAM_STATUS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SERVICE_ID, new org.apache.thrift.meta_data.FieldMetaData("serviceId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STREAM_STATUS, new org.apache.thrift.meta_data.FieldMetaData("streamStatus", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, SeviceStatusType.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DetectStatus.class, metaDataMap);
  }

  public DetectStatus() {
  }

  public DetectStatus(
    String serviceId,
    SeviceStatusType streamStatus)
  {
    this();
    this.serviceId = serviceId;
    this.streamStatus = streamStatus;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DetectStatus(DetectStatus other) {
    if (other.isSetServiceId()) {
      this.serviceId = other.serviceId;
    }
    if (other.isSetStreamStatus()) {
      this.streamStatus = other.streamStatus;
    }
  }

  public DetectStatus deepCopy() {
    return new DetectStatus(this);
  }

  @Override
  public void clear() {
    this.serviceId = null;
    this.streamStatus = null;
  }

  public String getServiceId() {
    return this.serviceId;
  }

  public DetectStatus setServiceId(String serviceId) {
    this.serviceId = serviceId;
    return this;
  }

  public void unsetServiceId() {
    this.serviceId = null;
  }

  /** Returns true if field serviceId is set (has been assigned a value) and false otherwise */
  public boolean isSetServiceId() {
    return this.serviceId != null;
  }

  public void setServiceIdIsSet(boolean value) {
    if (!value) {
      this.serviceId = null;
    }
  }

  /**
   * 
   * @see SeviceStatusType
   */
  public SeviceStatusType getStreamStatus() {
    return this.streamStatus;
  }

  /**
   * 
   * @see SeviceStatusType
   */
  public DetectStatus setStreamStatus(SeviceStatusType streamStatus) {
    this.streamStatus = streamStatus;
    return this;
  }

  public void unsetStreamStatus() {
    this.streamStatus = null;
  }

  /** Returns true if field streamStatus is set (has been assigned a value) and false otherwise */
  public boolean isSetStreamStatus() {
    return this.streamStatus != null;
  }

  public void setStreamStatusIsSet(boolean value) {
    if (!value) {
      this.streamStatus = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SERVICE_ID:
      if (value == null) {
        unsetServiceId();
      } else {
        setServiceId((String)value);
      }
      break;

    case STREAM_STATUS:
      if (value == null) {
        unsetStreamStatus();
      } else {
        setStreamStatus((SeviceStatusType)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SERVICE_ID:
      return getServiceId();

    case STREAM_STATUS:
      return getStreamStatus();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SERVICE_ID:
      return isSetServiceId();
    case STREAM_STATUS:
      return isSetStreamStatus();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DetectStatus)
      return this.equals((DetectStatus)that);
    return false;
  }

  public boolean equals(DetectStatus that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_serviceId = true && this.isSetServiceId();
    boolean that_present_serviceId = true && that.isSetServiceId();
    if (this_present_serviceId || that_present_serviceId) {
      if (!(this_present_serviceId && that_present_serviceId))
        return false;
      if (!this.serviceId.equals(that.serviceId))
        return false;
    }

    boolean this_present_streamStatus = true && this.isSetStreamStatus();
    boolean that_present_streamStatus = true && that.isSetStreamStatus();
    if (this_present_streamStatus || that_present_streamStatus) {
      if (!(this_present_streamStatus && that_present_streamStatus))
        return false;
      if (!this.streamStatus.equals(that.streamStatus))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetServiceId()) ? 131071 : 524287);
    if (isSetServiceId())
      hashCode = hashCode * 8191 + serviceId.hashCode();

    hashCode = hashCode * 8191 + ((isSetStreamStatus()) ? 131071 : 524287);
    if (isSetStreamStatus())
      hashCode = hashCode * 8191 + streamStatus.getValue();

    return hashCode;
  }

  @Override
  public int compareTo(DetectStatus other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetServiceId()).compareTo(other.isSetServiceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetServiceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.serviceId, other.serviceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStreamStatus()).compareTo(other.isSetStreamStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStreamStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.streamStatus, other.streamStatus);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("DetectStatus(");
    boolean first = true;

    sb.append("serviceId:");
    if (this.serviceId == null) {
      sb.append("null");
    } else {
      sb.append(this.serviceId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("streamStatus:");
    if (this.streamStatus == null) {
      sb.append("null");
    } else {
      sb.append(this.streamStatus);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (serviceId == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'serviceId' was not present! Struct: " + toString());
    }
    if (streamStatus == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'streamStatus' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class DetectStatusStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DetectStatusStandardScheme getScheme() {
      return new DetectStatusStandardScheme();
    }
  }

  private static class DetectStatusStandardScheme extends org.apache.thrift.scheme.StandardScheme<DetectStatus> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DetectStatus struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SERVICE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.serviceId = iprot.readString();
              struct.setServiceIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // STREAM_STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.streamStatus = SeviceStatusType.findByValue(iprot.readI32());
              struct.setStreamStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, DetectStatus struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.serviceId != null) {
        oprot.writeFieldBegin(SERVICE_ID_FIELD_DESC);
        oprot.writeString(struct.serviceId);
        oprot.writeFieldEnd();
      }
      if (struct.streamStatus != null) {
        oprot.writeFieldBegin(STREAM_STATUS_FIELD_DESC);
        oprot.writeI32(struct.streamStatus.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DetectStatusTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DetectStatusTupleScheme getScheme() {
      return new DetectStatusTupleScheme();
    }
  }

  private static class DetectStatusTupleScheme extends org.apache.thrift.scheme.TupleScheme<DetectStatus> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DetectStatus struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.serviceId);
      oprot.writeI32(struct.streamStatus.getValue());
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DetectStatus struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.serviceId = iprot.readString();
      struct.setServiceIdIsSet(true);
      struct.streamStatus = SeviceStatusType.findByValue(iprot.readI32());
      struct.setStreamStatusIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

