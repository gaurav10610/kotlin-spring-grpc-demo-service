//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: calculator.proto

package com.example.demo.grpc;

@kotlin.jvm.JvmName("-initializenumber")
public inline fun number(block: com.example.demo.grpc.NumberKt.Dsl.() -> kotlin.Unit): com.example.demo.grpc.Number =
  com.example.demo.grpc.NumberKt.Dsl._create(com.example.demo.grpc.Number.newBuilder()).apply { block() }._build()
public object NumberKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.example.demo.grpc.Number.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.example.demo.grpc.Number.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.example.demo.grpc.Number = _builder.build()

    /**
     * <code>double value = 1;</code>
     */
    public var value: kotlin.Double
      @JvmName("getValue")
      get() = _builder.getValue()
      @JvmName("setValue")
      set(value) {
        _builder.setValue(value)
      }
    /**
     * <code>double value = 1;</code>
     */
    public fun clearValue() {
      _builder.clearValue()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.example.demo.grpc.Number.copy(block: com.example.demo.grpc.NumberKt.Dsl.() -> kotlin.Unit): com.example.demo.grpc.Number =
  com.example.demo.grpc.NumberKt.Dsl._create(this.toBuilder()).apply { block() }._build()

