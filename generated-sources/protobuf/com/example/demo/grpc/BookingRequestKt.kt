//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: FlightService.proto

package com.example.demo.grpc;

@kotlin.jvm.JvmName("-initializebookingRequest")
public inline fun bookingRequest(block: com.example.demo.grpc.BookingRequestKt.Dsl.() -> kotlin.Unit): com.example.demo.grpc.BookingRequest =
  com.example.demo.grpc.BookingRequestKt.Dsl._create(com.example.demo.grpc.BookingRequest.newBuilder()).apply { block() }._build()
public object BookingRequestKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.example.demo.grpc.BookingRequest.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.example.demo.grpc.BookingRequest.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.example.demo.grpc.BookingRequest = _builder.build()

    /**
     * <code>string userId = 1;</code>
     */
    public var userId: kotlin.String
      @JvmName("getUserId")
      get() = _builder.getUserId()
      @JvmName("setUserId")
      set(value) {
        _builder.setUserId(value)
      }
    /**
     * <code>string userId = 1;</code>
     */
    public fun clearUserId() {
      _builder.clearUserId()
    }

    /**
     * <code>string flightId = 2;</code>
     */
    public var flightId: kotlin.String
      @JvmName("getFlightId")
      get() = _builder.getFlightId()
      @JvmName("setFlightId")
      set(value) {
        _builder.setFlightId(value)
      }
    /**
     * <code>string flightId = 2;</code>
     */
    public fun clearFlightId() {
      _builder.clearFlightId()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.example.demo.grpc.BookingRequest.copy(block: com.example.demo.grpc.BookingRequestKt.Dsl.() -> kotlin.Unit): com.example.demo.grpc.BookingRequest =
  com.example.demo.grpc.BookingRequestKt.Dsl._create(this.toBuilder()).apply { block() }._build()

