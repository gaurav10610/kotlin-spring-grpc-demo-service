//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: FlightService.proto

package com.example.demo.grpc;

@kotlin.jvm.JvmName("-initializesearchResponse")
public inline fun searchResponse(block: com.example.demo.grpc.SearchResponseKt.Dsl.() -> kotlin.Unit): com.example.demo.grpc.SearchResponse =
  com.example.demo.grpc.SearchResponseKt.Dsl._create(com.example.demo.grpc.SearchResponse.newBuilder()).apply { block() }._build()
public object SearchResponseKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.example.demo.grpc.SearchResponse.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.example.demo.grpc.SearchResponse.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.example.demo.grpc.SearchResponse = _builder.build()

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class FlightsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <code>repeated .com.example.demo.grpc.Flight flights = 1;</code>
     */
     public val flights: com.google.protobuf.kotlin.DslList<com.example.demo.grpc.Flight, FlightsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getFlightsList()
      )
    /**
     * <code>repeated .com.example.demo.grpc.Flight flights = 1;</code>
     * @param value The flights to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addFlights")
    public fun com.google.protobuf.kotlin.DslList<com.example.demo.grpc.Flight, FlightsProxy>.add(value: com.example.demo.grpc.Flight) {
      _builder.addFlights(value)
    }
    /**
     * <code>repeated .com.example.demo.grpc.Flight flights = 1;</code>
     * @param value The flights to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignFlights")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<com.example.demo.grpc.Flight, FlightsProxy>.plusAssign(value: com.example.demo.grpc.Flight) {
      add(value)
    }
    /**
     * <code>repeated .com.example.demo.grpc.Flight flights = 1;</code>
     * @param values The flights to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllFlights")
    public fun com.google.protobuf.kotlin.DslList<com.example.demo.grpc.Flight, FlightsProxy>.addAll(values: kotlin.collections.Iterable<com.example.demo.grpc.Flight>) {
      _builder.addAllFlights(values)
    }
    /**
     * <code>repeated .com.example.demo.grpc.Flight flights = 1;</code>
     * @param values The flights to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllFlights")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<com.example.demo.grpc.Flight, FlightsProxy>.plusAssign(values: kotlin.collections.Iterable<com.example.demo.grpc.Flight>) {
      addAll(values)
    }
    /**
     * <code>repeated .com.example.demo.grpc.Flight flights = 1;</code>
     * @param index The index to set the value at.
     * @param value The flights to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setFlights")
    public operator fun com.google.protobuf.kotlin.DslList<com.example.demo.grpc.Flight, FlightsProxy>.set(index: kotlin.Int, value: com.example.demo.grpc.Flight) {
      _builder.setFlights(index, value)
    }
    /**
     * <code>repeated .com.example.demo.grpc.Flight flights = 1;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearFlights")
    public fun com.google.protobuf.kotlin.DslList<com.example.demo.grpc.Flight, FlightsProxy>.clear() {
      _builder.clearFlights()
    }

  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.example.demo.grpc.SearchResponse.copy(block: com.example.demo.grpc.SearchResponseKt.Dsl.() -> kotlin.Unit): com.example.demo.grpc.SearchResponse =
  com.example.demo.grpc.SearchResponseKt.Dsl._create(this.toBuilder()).apply { block() }._build()
