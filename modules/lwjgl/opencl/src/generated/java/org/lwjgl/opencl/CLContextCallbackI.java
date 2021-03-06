/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.opencl;

import org.lwjgl.system.*;

import static org.lwjgl.system.dyncall.DynCallback.*;

/**
 * Instances of this interface may be passed to the {@link CL10#clCreateContext CreateContext} and {@link CL10#clCreateContextFromType CreateContextFromType} methods.
 * 
 * <h3>Type</h3>
 * 
 * <pre><code>
 * void (*) (
 *     cl_char const *errinfo,
 *     void const *private_info,
 *     size_t cb,
 *     void *user_data
 * )</code></pre>
 */
@FunctionalInterface
@NativeType("void (*) (cl_char const *, void const *, size_t, void *)")
public interface CLContextCallbackI extends CallbackI.V {

    String SIGNATURE = Callback.__stdcall("(pppp)v");

    @Override
    default String getSignature() { return SIGNATURE; }

    @Override
    default void callback(long args) {
        invoke(
            dcbArgPointer(args),
            dcbArgPointer(args),
            dcbArgPointer(args),
            dcbArgPointer(args)
        );
    }

    /**
     * Will be called when a debug message is generated.
     *
     * @param errinfo      a pointer to the message string representation
     * @param private_info a pointer to binary data that is returned by the OpenCL implementation that can be used to log additional information helpful in debugging the error
     * @param cb           the number of bytes in the {@code private_info} pointer
     * @param user_data    the user-specified value that was passed when calling {@link CL10#clCreateContext CreateContext} or {@link CL10#clCreateContextFromType CreateContextFromType}
     */
    void invoke(@NativeType("cl_char const *") long errinfo, @NativeType("void const *") long private_info, @NativeType("size_t") long cb, @NativeType("void *") long user_data);

}