package com.sun.corba.se.PortableActivationIDL;

/**
* com/sun/corba/se/PortableActivationIDL/InitialNameServiceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from d:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u25/1677/corba/src/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
* Tuesday, October 7, 2014 2:27:05 PM PDT
*/


/** Interface used to support binding references in the bootstrap name
    * service.
    */
public final class InitialNameServiceHolder implements org.omg.CORBA.portable.Streamable
{
  public InitialNameService value = null;

  public InitialNameServiceHolder ()
  {
  }

  public InitialNameServiceHolder (InitialNameService initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = InitialNameServiceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    InitialNameServiceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return InitialNameServiceHelper.type ();
  }

}
