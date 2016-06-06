//
//  ========================================================================
//  Copyright (c) 1995-2016 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.websocket.jsr356.function;

import java.lang.reflect.Method;
import java.util.function.Function;

import javax.websocket.OnMessage;
import javax.websocket.Session;

import org.eclipse.jetty.websocket.common.util.ReflectUtils;

/**
 * javax.websocket {@link OnMessage} method {@link Function} for TEXT/{@link String} types
 */
@Deprecated
public class JsrOnTextFunction implements Function<String, Void>
{
/*    private static final DynamicArgs.Builder ARGBUILDER;
    private static final int SESSION = 1;
    private static final int TEXT = 2;

    static
    {
        ARGBUILDER = new DynamicArgs.Builder();
        ARGBUILDER.addSignature(new ExactSignature(String.class).indexedAs(TEXT));
        ARGBUILDER.addSignature(new ExactSignature(Session.class,String.class).indexedAs(SESSION,TEXT));
    }
    
    public static DynamicArgs.Builder getDynamicArgsBuilder()
    {
        return ARGBUILDER;
    }
    
    public static boolean hasMatchingSignature(Method method)
    {
        return ARGBUILDER.hasMatchingSignature(method);
    }*/

    private final Session session;
    private final Object endpoint;
    private final Method method;

    public JsrOnTextFunction(Session session, Object endpoint, Method method)
    {
        this.session = session;
        this.endpoint = endpoint;
        this.method = method;

        ReflectUtils.assertIsAnnotated(method,OnMessage.class);
        ReflectUtils.assertIsPublicNonStatic(method);
        ReflectUtils.assertIsReturn(method,Void.TYPE);

        /*this.callable = ARGBUILDER.build(method);
        if (this.callable == null)
        {
            throw InvalidSignatureException.build(method,OnMessage.class,ARGBUILDER);
        }
        this.callable.setArgReferences(SESSION,TEXT);*/
    }

    @Override
    public Void apply(String text)
    {
        /*Object args[] = this.callable.toArgs(session,text);
        try
        {
            method.invoke(endpoint,args);
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
        {
            throw new WebSocketException("Unable to call text message method " + ReflectUtils.toString(endpoint.getClass(),method),e);
        }*/
        return null;
    }
}
